package com.cc.controller;

import com.cc.entity.MessageBoard;
import com.cc.service.MessageBoardService;
import com.cc.util.DateUtil;
import com.cc.util.HttpUtil;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@RestController
@RequestMapping(value = "/messageBoard")
public class MessageBoardController {

    @Autowired
    private MessageBoardService messageBoardService;

    @InitBinder
    public void initBinder(WebDataBinder binder) {
        DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        binder.registerCustomEditor(Date.class, new CustomDateEditor(format, true));
    }


    @RequestMapping("list")
    public Map<String, Object> list(MessageBoard messageBoard) {
        List<MessageBoard> messageBoardList = messageBoardService.listPageMessageBoard(messageBoard);
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("list", messageBoardList);
        map.put("page", messageBoard.getPage());

        return map;
    }

    @RequestMapping(value = "/load")
    public MessageBoard load(MessageBoard messageBoard) {
        messageBoard = messageBoardService.getMessageBoardById(messageBoard.getBoardId());


        return messageBoard;
    }


    @RequestMapping(value = "/save")
    public MessageBoard save(MessageBoard messageBoard, HttpServletRequest request) {


        try {
            if (messageBoard.getBoardId() == null || messageBoard.getBoardId().intValue() == 0) {
                messageBoardService.insertSelective(messageBoard);
            } else {
                messageBoardService.updateByPrimaryKeySelective(messageBoard);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return messageBoard;
    }

    /**
     * 提交留言版的信息
     *
     * @param messageBoard
     * @param request
     * @return
     */
    @RequestMapping(value = "submitMessage")
    public Map<String, Object> submitMessage(MessageBoard messageBoard, HttpServletRequest request) {
        String ip = HttpUtil.getRemortIP(request);

        String json = HttpUtil.sendGet(HttpUtil.url + ip, "lang=zh-CN");//查询地址来源
        System.out.println(json);
        MessageBoard msg = new Gson().fromJson(json, MessageBoard.class);
        msg.setCreatTime(DateUtil.nowDate());
        msg.setUserId(0);
        msg.setStatusType("messageBoard");
        msg.setMessageContent(messageBoard.getMessageContent());
        messageBoardService.insertSelective(msg);
        MessageBoard search = new MessageBoard();

        //返回数据
        List<MessageBoard> messageBoardList = messageBoardService.listPageMessageBoard(search);
        Map<String, Object> returnMap = new HashMap<String, Object>();
        returnMap.put("list", messageBoardList);
        returnMap.put("page", search);
        return returnMap;

    }


    @RequestMapping(value = "/delete")
    public String delete(MessageBoard messageBoard) {
        messageBoardService.deleteMessageBoard(messageBoard);
        return "success";
    }
}
