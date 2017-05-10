package com.cc.service;

import java.util.List;

import com.cc.entity.Sms;

/**
 * sms
 */
public interface SmsService {

    /**
     * 根据条件 查询全部listPageAccount
     */

    List<Sms> listPageSms(Sms sms);

    /**
     * 获取Sms的数量
     */
    Integer getSmsCount();

    /**
     * 插入
     */
    void insert(Sms sms);

    /**
     * 根据主键查询(唯一)
     */
    Sms getSmsById(Integer id);

    /**
     * 根据根据条件查询Sms
     */
    List<Sms> listSms(Sms sms);

    /**
     * 更新Sms
     */
    void updateSms(Sms sms);

    /**
     * 很据实体类删除
     */

    void deleteSms(Sms sms);

    /**
     * 根据主键删除
     */
    void deleteSmsByIds(String[] ids);

    /**
     * 有条件的更新
     */

    void insertSelective(Sms sms);

    /**
     * 根据主键有条件的更新
     */

    void updateByPrimaryKeySelective(Sms sms);

    /**
     * 批量上传短信记录
     *
     * @param json
     * @author: cuicong
     * @datetime:2015年9月6日下午5:27:33
     */
    void upload(String json);

}