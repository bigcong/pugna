package com.cc.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cc.entity.Sms;
import com.cc.mapper.SmsMapper;
import com.cc.service.SmsService;
import com.google.gson.Gson;

/**
 * sms
 */
@Service
public class SmsServiceImpl implements SmsService {
    @Autowired
    private SmsMapper smsMapper;

    @Override
    public List<Sms> listPageSms(Sms sms) {
        return smsMapper.listPageSms(sms);
    }

    @Override
    public Integer getSmsCount() {
        return smsMapper.getSmsCount();
    }

    @Override
    public void insert(Sms sms) {
        smsMapper.insert(sms);
    }

    @Override
    public Sms getSmsById(Integer id) {
        return smsMapper.getSmsById(id);
    }

    @Override
    public List<Sms> listSms(Sms sms) {
        return smsMapper.listSms(sms);
    }

    @Override
    public void updateSms(Sms sms) {
        smsMapper.updateSms(sms);
    }

    @Override
    public void deleteSms(Sms sms) {
        smsMapper.deleteSms(sms);
    }

    @Override
    public void deleteSmsByIds(String[] ids) {
        smsMapper.deleteSmsByIds(ids);
    }

    @Override
    public void insertSelective(Sms sms) {
        smsMapper.insertSelective(sms);
    }

    @Override
    public void updateByPrimaryKeySelective(Sms sms) {
        smsMapper.updateByPrimaryKeySelective(sms);
    }

    @Override
    public void upload(String json) {
        Gson g = new Gson();
        List<?> list = g.fromJson(json, List.class);
        for (Object o : list) {
            Sms s = g.fromJson(g.toJson(o), Sms.class);
            List<Sms> checkList = this.smsMapper.listPageSms(s);//检查是否存在
            if (checkList != null && checkList.size() == 0) {
                this.smsMapper.insertSelective(s);
            }

        }

    }
}