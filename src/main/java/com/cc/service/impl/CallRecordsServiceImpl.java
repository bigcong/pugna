package com.cc.service.impl;

import com.cc.entity.CallRecords;
import com.cc.entity.ChartCallRecordsData;
import com.cc.mapper.CallRecordsMapper;
import com.cc.service.CallRecordsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * call_records
 */
@Service
public class CallRecordsServiceImpl implements CallRecordsService {
    @Autowired
    private CallRecordsMapper callRecordsMapper;

    @Override
    public List<CallRecords> listPageCallRecords(CallRecords callRecords) {
        return callRecordsMapper.listPageCallRecords(callRecords);
    }

    @Override
    public Integer getCallRecordsCount() {
        return callRecordsMapper.getCallRecordsCount();
    }

    @Override
    public void insert(CallRecords callRecords) {
        callRecordsMapper.insert(callRecords);
    }

    @Override
    public CallRecords getCallRecordsById(Integer id) {
        return callRecordsMapper.getCallRecordsById(id);
    }

    @Override
    public List<CallRecords> listCallRecords(CallRecords callRecords) {
        return callRecordsMapper.listCallRecords(callRecords);
    }

    @Override
    public void updateCallRecords(CallRecords callRecords) {
        callRecordsMapper.updateCallRecords(callRecords);
    }

    @Override
    public void deleteCallRecords(CallRecords callRecords) {
        callRecordsMapper.deleteCallRecords(callRecords);
    }

    @Override
    public void deleteCallRecordsByIds(String[] ids) {
        callRecordsMapper.deleteCallRecordsByIds(ids);
    }

    @Override
    public void insertSelective(CallRecords callRecords) {
        callRecordsMapper.insertSelective(callRecords);
    }

    @Override
    public void updateByPrimaryKeySelective(CallRecords callRecords) {
        callRecordsMapper.updateByPrimaryKeySelective(callRecords);
    }

    @Override
    public void uploadRecord(CallRecords callRecords) {

        List<CallRecords> records = this.callRecordsMapper.listCallRecords(callRecords);
        if (records != null && records.size() > 0) {

        } else {

            this.callRecordsMapper.insertSelective(callRecords);
        }

    }

    @Override
    public List<ChartCallRecordsData> countByDate(ChartCallRecordsData chartCallRecordsData) {
        // TODO Auto-generated method stub
        return this.callRecordsMapper.countByDate(chartCallRecordsData);
    }

    @Override
    public List<ChartCallRecordsData> countByName(ChartCallRecordsData chartCallRecordsData) {
        return this.callRecordsMapper.countByName(chartCallRecordsData);
    }

}