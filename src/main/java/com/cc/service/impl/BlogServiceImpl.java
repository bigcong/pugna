package com.cc.service.impl;

import java.util.*;

import com.cc.mapper.BlogMapper;
import com.cc.entity.Blog;
import com.cc.service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * blog
 */
@Service
public class BlogServiceImpl implements BlogService {
    @Autowired
    private BlogMapper blogMapper;

    @Override
    public List<Blog> listPageBlog(Blog blog) {
        return blogMapper.listPageBlog(blog);
    }

    @Override
    public Integer getBlogCount() {
        return blogMapper.getBlogCount();
    }

    @Override
    public void insert(Blog blog) {
        blogMapper.insert(blog);
    }

    @Override
    public Blog getBlogById(Integer id) {
        return blogMapper.getBlogById(id);
    }

    @Override
    public List<Blog> getBlog(Blog blog) {
        return blogMapper.getBlog(blog);
    }

    @Override
    public void updateBlog(Blog blog) {
        blogMapper.updateBlog(blog);
    }

    @Override
    public void deleteBlog(Blog blog) {
        blogMapper.deleteBlog(blog);
    }

    @Override
    public void deleteBlogByIds(String[] ids) {
        blogMapper.deleteBlogByIds(ids);
    }

}