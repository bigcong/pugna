package com.cc.util;

import com.cc.entity.Config;
import com.cc.service.ConfigService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import javax.mail.internet.MimeMessage;
import java.io.File;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

@Service
public class MailService {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private JavaMailSenderImpl sender;
    @Autowired
    private ConfigService configService;


    @Autowired
    RedisTemplate redisTemplate;

    private String from;

    /**
     * 发送纯文本的简单邮件
     *
     * @param subject
     * @param content
     */
    public void sendSimpleMail(String subject, String content) {

        String key = "mail";
        Object o = redisTemplate.opsForValue().get(key);

        if (o == null) {


            Config config = new Config();
            config.setConfigType("mail");

            List<Config> configs = configService.listConfig(config);


            String username = configs.stream().filter(t -> t.getConfigName().equals("username")).collect(Collectors.toList()).get(0).getConfigValue();
            String passwd = configs.stream().filter(t -> t.getConfigName().equals("passwd")).collect(Collectors.toList()).get(0).getConfigValue();
            String to = configs.stream().filter(t -> t.getConfigName().equals("to")).collect(Collectors.toList()).get(0).getConfigValue();


            SimpleMailMessage message = new SimpleMailMessage();
            message.setFrom(username);
            message.setTo(to);
            message.setSubject(subject);
            message.setText(content);


            try {
                sender.setPassword(passwd);
                sender.setUsername(username);


                sender.send(message);
                logger.info("简单邮件已经发送。");
                redisTemplate.opsForValue().set(key, 1, 10, TimeUnit.MINUTES);
            } catch (Exception e) {
                logger.error("发送简单邮件时发生异常！", e);
            }
        }
    }

    /**
     * 发送html格式的邮件
     *
     * @param to
     * @param subject
     * @param content
     */
    public void sendHtmlMail(String to, String subject, String content) {
        MimeMessage mimeMessage = sender.createMimeMessage();

        try {

            //true表示需要创建一个multipart message
            MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true);
            helper.setFrom(from);
            helper.setTo(to);
            helper.setSubject(subject);
            helper.setText(content, true);

            sender.send(mimeMessage);
            logger.info("html邮件已经发送。");
        } catch (Exception e) {
            logger.error("发送html邮件时发生异常！", e);
        }
    }

    /**
     * 发送带附件的邮件
     *
     * @param to
     * @param subject
     * @param content
     * @param filePath
     */
    public void sendAttachmentsMail(String to, String subject, String content, String filePath) {
        MimeMessage message = sender.createMimeMessage();

        try {
            //true表示需要创建一个multipart message
            MimeMessageHelper helper = new MimeMessageHelper(message, true);
            helper.setFrom(from);
            helper.setTo(to);
            helper.setSubject(subject);
            helper.setText(content, true);

            FileSystemResource file = new FileSystemResource(new File(filePath));
            String fileName = filePath.substring(filePath.lastIndexOf(File.separator));
            helper.addAttachment(fileName, file);

            sender.send(message);
            logger.info("带附件的邮件已经发送。");
        } catch (Exception e) {
            logger.error("发送带附件的邮件时发生异常！", e);
        }
    }

    /**
     * 发送嵌入静态资源（一般是图片）的邮件
     *
     * @param to
     * @param subject
     * @param content 邮件内容，需要包括一个静态资源的id，比如：<img src=\"cid:rscId01\" >
     * @param rscPath 静态资源路径和文件名
     * @param rscId   静态资源id
     */
    public void sendInlineResourceMail(String to, String subject, String content, String rscPath, String rscId) {
        MimeMessage message = sender.createMimeMessage();

        try {
            //true表示需要创建一个multipart message
            MimeMessageHelper helper = new MimeMessageHelper(message, true);
            helper.setFrom(from);
            helper.setTo(to);
            helper.setSubject(subject);
            helper.setText(content, true);

            FileSystemResource res = new FileSystemResource(new File(rscPath));
            helper.addInline(rscId, res);

            sender.send(message);
            logger.info("嵌入静态资源的邮件已经发送。");
        } catch (Exception e) {
            logger.error("发送嵌入静态资源的邮件时发生异常！", e);
        }
    }
}
