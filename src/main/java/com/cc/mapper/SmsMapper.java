package com.cc.mapper;

import java.util.*;

import com.cc.entity.Sms;

/**
 * sms
 */
public interface SmsMapper {


    /**
     * 根据条件 查询全部listPageAccount
     */

    List<Sms> listPageSms(Sms sms);

    /**
     * 获取Sms的数量
     */
    Integer getSmsCount();


    void insert(Sms sms);

    /**
     * 有条件的更新
     */

    void insertSelective(Sms sms);

    /**
     * 根据主键有条件的更新
     */

    void updateByPrimaryKeySelective(Sms sms);

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
    void deleteSmsByIds(String[] id);

}