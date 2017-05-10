package com.cc.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.cc.entity.Comments;
import com.cc.service.CommentsService;

@RestController
@RequestMapping(value = "/comments")
public class CommentsController {

    @Autowired
    private CommentsService commentsService;

    /**
     * 显示列表
     *
     * @param comments
     * @return
     */
    @RequestMapping("list")
    public List<Comments> list(Comments comments, ModelMap modelMap) {
        List<Comments> commentsList = commentsService
                .listPageComments(comments);
        return commentsList;
    }

    /**
     * 请求编辑页面
     *
     * @param commentsId
     * @return
     */
    @RequestMapping(value = "/load")
    public Comments load(Comments comments, ModelMap modelMap) {
        comments = commentsService.getCommentsById(comments.getCommentsId());
        return comments;
    }

    /**
     * 保存店铺信息
     *
     * @param Equipment
     * @return
     */
    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public Comments save(Comments comments, ModelMap modelMap) {
        try {
            if (comments.getCommentsId() == null
                    || comments.getCommentsId().intValue() == 0) {
                commentsService.insert(comments);
            } else {
                commentsService.updateComments(comments);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return comments;
    }

    /**
     * 查看详情
     *
     * @param commentsId
     */
    @RequestMapping(value = "/delete")
    public String delete(Comments comments, ModelMap modelMap) {
        commentsService.deleteComments(comments);
        return "删除成功";
    }
}
