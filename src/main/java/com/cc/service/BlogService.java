package com.cc.service;

import com.cc.entity.Blog;

import java.util.List;

/**
 * blog
 */
public interface BlogService {

    List<Blog> listPageBlog(Blog blog);

    Integer getBlogCount();

    void insert(Blog blog);

    Blog getBlogById(Integer id);

    List<Blog> getBlog(Blog blog);

    void updateBlog(Blog blog);

    void deleteBlog(Blog blog);

    void deleteBlogByIds(String[] ids);


    

}