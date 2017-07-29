package com.cc.service.impl;

import com.cc.entity.Dota2Heros;
import com.cc.mapper.Dota2HerosMapper;
import com.cc.service.Dota2HerosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * dota2_heros
 */
@Service
public class Dota2HerosServiceImpl implements Dota2HerosService {
    @Autowired
    private Dota2HerosMapper dota2HerosMapper;

    @Override
    public List<Dota2Heros> listPageDota2Heros(Dota2Heros dota2Heros) {
        return dota2HerosMapper.listPageDota2Heros(dota2Heros);
    }

    @Override
    public Integer getDota2HerosCount() {
        return dota2HerosMapper.getDota2HerosCount();
    }

    @Override
    public void insert(Dota2Heros dota2Heros) {
        dota2HerosMapper.insert(dota2Heros);
    }

    @Override
    public Dota2Heros getDota2HerosById(Integer id) {
        return dota2HerosMapper.getDota2HerosById(id);
    }

    @Override
    public List<Dota2Heros> listDota2Heros(Dota2Heros dota2Heros) {
        return dota2HerosMapper.listDota2Heros(dota2Heros);
    }

    @Override
    public void updateDota2Heros(Dota2Heros dota2Heros) {
        dota2HerosMapper.updateDota2Heros(dota2Heros);
    }

    @Override
    public void deleteDota2Heros(Dota2Heros dota2Heros) {
        dota2HerosMapper.deleteDota2Heros(dota2Heros);
    }

    @Override
    public void deleteDota2HerosByIds(String[] ids) {
        dota2HerosMapper.deleteDota2HerosByIds(ids);
    }

    @Override
    @Async
    public void insertSelective(Dota2Heros dota2Heros) {
        dota2HerosMapper.insertSelective(dota2Heros);
    }

    @Override
    public void updateByPrimaryKeySelective(Dota2Heros dota2Heros) {
        dota2HerosMapper.updateByPrimaryKeySelective(dota2Heros);
    }

}