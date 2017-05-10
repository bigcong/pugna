package com.cc.service;

import java.util.List;

import com.cc.entity.Comments;

/**
 * comments
 */
public interface CommentsService {

    List<Comments> listPageComments(Comments comments);

    Integer getCommentsCount();

    void insert(Comments comments);

    Comments getCommentsById(Integer id);

    List<Comments> getComments(Comments comments);

    void updateComments(Comments comments);

    void deleteComments(Comments comments);

    void deleteCommentsByIds(String[] ids);

}