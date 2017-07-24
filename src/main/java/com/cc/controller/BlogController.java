package com.cc.controller;

import com.cc.entity.Blog;
import com.cc.entity.SystemLog;
import com.cc.mapper.SystemLogMapper;
import com.cc.service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@RestController
@RequestMapping(value = "/blog")
public class BlogController {


    @Autowired
    private BlogService blogService;
    @Autowired
    private SystemLogMapper systemLogMapper;

    @InitBinder
    public void initBinder(WebDataBinder binder) {
        DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        binder.registerCustomEditor(Date.class, new CustomDateEditor(format, true));
    }

    /**
     * 显示列表
     *
     * @param blog
     * @return
     */
    @RequestMapping("list")
    public Map<String, Object> list(Blog blog, ModelMap modelMap, HttpServletRequest httpRequest) {

        List<Blog> blogList = blogService.listPageBlog(blog);

        Map<String, Object> map = new HashMap<String, Object>();
        map.put("list", blogList);
        map.put("page", blog.getPage());
        SystemLog s = new SystemLog();

        s.setLogUrl(httpRequest.getRequestURI());
        map.put("sum", systemLogMapper.sum(s));
        return map;
    }

    /**
     * 请求编辑页面
     *
     * @param
     * @return
     */
    @RequestMapping(value = "/load")
    public Blog load(Blog blog, ModelMap modelMap) {

        blog = blogService.getBlogById(blog.getBlogId());
        return blog;
    }

    /**
     * 保存店铺信息
     *
     * @param
     * @return
     */
    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public Blog save(@RequestBody Blog blog) {
        try {
            if (blog.getBlogId() == null || blog.getBlogId().intValue() == 0) {
                if (blog.getBlogContent() != null && !blog.getBlogContent().equals("")) {
                    if (blog.getBlogContent().length() > 100) {
                        blog.setBlogDescription(blog.getBlogContent().substring(0, blog.getBlogContent().length() / 2));
                    }
                    blog.setBlogger(1);
                    blog.setBlogType(1);
                    blog.setCreateTime(new Date());
                    blog.setCreateUser(1);
                    blog.setUpdateTime(new Date());
                    blog.setUpdateUser(1);

                    blogService.insert(blog);
                }
            } else {
                blogService.updateBlog(blog);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return blog;
    }

    /**
     * 查看详情
     *
     * @param blog
     */
    @RequestMapping(value = "/delete")
    public String delete(Blog blog, ModelMap modelMap) {
        blogService.deleteBlog(blog);
        return "删除成功";
    }
}
