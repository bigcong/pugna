package com.cc.service;

import com.cc.entity.Currency;
import org.springframework.scheduling.annotation.Scheduled;

import java.util.Date;
import java.util.List;

/**
 * currency
 */
public interface CurrencyService {


    /**
     * 根据条件 查询全部listPageAccount
     */

    public List<Currency> listPageCurrency(Currency currency);

    /**
     * 获取Currency的数量
     */
    public Integer getCurrencyCount();

    /**
     * 插入
     */
    public void insert(Currency currency);

    /**
     * 根据主键查询(唯一)
     */
    public Currency getCurrencyById(Integer id);

    /**
     * 根据根据条件查询Currency
     */
    public List<Currency> listCurrency(Currency currency);

    /**
     * 更新Currency
     */
    public void updateCurrency(Currency currency);

    /**
     * 很据实体类删除
     */

    public void deleteCurrency(Currency currency);

    /**
     * 根据主键删除
     */
    public void deleteCurrencyByIds(String[] ids);

    /**
     * 有条件的更新
     */

    public void insertSelective(Currency currency);

    /**
     * 根据主键有条件的更新
     */

    public void updateByPrimaryKeySelective(Currency currency);



    void autoInsert() throws Exception;


}