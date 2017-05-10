package com.cc.service;

import java.util.List;

import com.cc.entity.CallRecords;
import com.cc.entity.ChartCallRecordsData;

/**
 * call_records
 */
public interface CallRecordsService {

    /**
     * 根据条件 查询全部listPageAccount
     */

    List<CallRecords> listPageCallRecords(CallRecords callRecords);

    /**
     * 获取CallRecords的数量
     */
    Integer getCallRecordsCount();

    /**
     * 插入
     */
    void insert(CallRecords callRecords);

    /**
     * 根据主键查询(唯一)
     */
    CallRecords getCallRecordsById(Integer id);

    /**
     * 根据根据条件查询CallRecords
     */
    List<CallRecords> listCallRecords(CallRecords callRecords);

    /**
     * 更新CallRecords
     */
    void updateCallRecords(CallRecords callRecords);

    /**
     * 很据实体类删除
     */

    void deleteCallRecords(CallRecords callRecords);

    /**
     * 根据主键删除
     */
    void deleteCallRecordsByIds(String[] ids);

    /**
     * 有条件的更新
     */

    void insertSelective(CallRecords callRecords);

    /**
     * 根据主键有条件的更新
     */

    void updateByPrimaryKeySelective(CallRecords callRecords);

    /**
     * 批量上传通话记录
     *
     * @param list
     * @author: cuicong
     */

    void uploadRecord(CallRecords callRecords);

    List<ChartCallRecordsData> countByDate(ChartCallRecordsData chartCallRecordsData);

    List<ChartCallRecordsData> countByName(ChartCallRecordsData chartCallRecordsData);

}