package com.cc.mapper;

import java.util.List;

import com.cc.entity.Blog;

/**
 * blog
 */
public interface BlogMapper {
    List<Blog> listPageBlog(Blog blog);

    Integer getBlogCount();

    void insert(Blog blog);

    Blog getBlogById(Integer id);

    List<Blog> getBlog(Blog blog);

    void updateBlog(Blog blog);

    void deleteBlog(Blog blog);

    void deleteBlogByIds(String[] id);

}