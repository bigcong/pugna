package com.cc.mapper;

import java.util.List;
import java.util.Map;

import com.cc.entity.CallRecords;
import com.cc.entity.ChartCallRecordsData;
import com.cc.entity.Day7Chart;

/**
 * call_records
 */
public interface CallRecordsMapper {

    /**
     * 根据条件 查询全部listPageAccount
     */

    List<CallRecords> listPageCallRecords(CallRecords callRecords);

    /**
     * 获取CallRecords的数量
     */
    Integer getCallRecordsCount();

    void insert(CallRecords callRecords);

    /**
     * 有条件的更新
     */

    void insertSelective(CallRecords callRecords);

    /**
     * 根据主键有条件的更新
     */

    void updateByPrimaryKeySelective(CallRecords callRecords);

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
    void deleteCallRecordsByIds(String[] id);

    List<ChartCallRecordsData> countByDate(ChartCallRecordsData chartCallRecordsData);

    List<ChartCallRecordsData> countByName(ChartCallRecordsData chartCallRecordsData);

}