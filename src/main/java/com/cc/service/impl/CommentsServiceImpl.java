package com.cc.service.impl;

import java.util.*;

import com.cc.mapper.CommentsMapper;
import com.cc.entity.Comments;
import com.cc.service.CommentsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * comments
 */
@Service
public class CommentsServiceImpl implements CommentsService {
    @Autowired
    private CommentsMapper commentsMapper;

    @Override
    public List<Comments> listPageComments(Comments comments) {
        return commentsMapper.listPageComments(comments);
    }

    @Override
    public Integer getCommentsCount() {
        return commentsMapper.getCommentsCount();
    }

    @Override
    public void insert(Comments comments) {
        commentsMapper.insert(comments);
    }

    @Override
    public Comments getCommentsById(Integer id) {
        return commentsMapper.getCommentsById(id);
    }

    @Override
    public List<Comments> getComments(Comments comments) {
        return commentsMapper.getComments(comments);
    }

    @Override
    public void updateComments(Comments comments) {
        commentsMapper.updateComments(comments);
    }

    @Override
    public void deleteComments(Comments comments) {
        commentsMapper.deleteComments(comments);
    }

    @Override
    public void deleteCommentsByIds(String[] ids) {
        commentsMapper.deleteCommentsByIds(ids);
    }

}