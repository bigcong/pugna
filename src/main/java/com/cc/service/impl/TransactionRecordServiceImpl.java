package com.cc.service.impl;

import java.util.*;

import com.cc.mapper.TransactionRecordMapper;
import com.cc.entity.TransactionRecord;
import com.cc.service.TransactionRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * transaction_record
 */
@Service
public class TransactionRecordServiceImpl implements TransactionRecordService {
    @Autowired
    private TransactionRecordMapper transactionRecordMapper;

    @Override
    public List<TransactionRecord> listPageTransactionRecord(TransactionRecord transactionRecord) {
        return transactionRecordMapper.listPageTransactionRecord(transactionRecord);
    }

    @Override
    public Integer getTransactionRecordCount() {
        return transactionRecordMapper.getTransactionRecordCount();
    }

    @Override
    public void insert(TransactionRecord transactionRecord) {
        transactionRecordMapper.insert(transactionRecord);
    }

    @Override
    public TransactionRecord getTransactionRecordById(String id) {
        return transactionRecordMapper.getTransactionRecordById(id);
    }

    @Override
    public List<TransactionRecord> listTransactionRecord(TransactionRecord transactionRecord) {
        return transactionRecordMapper.listTransactionRecord(transactionRecord);
    }

    @Override
    public void updateTransactionRecord(TransactionRecord transactionRecord) {
        transactionRecordMapper.updateTransactionRecord(transactionRecord);
    }

    @Override
    public void deleteTransactionRecord(TransactionRecord transactionRecord) {
        transactionRecordMapper.deleteTransactionRecord(transactionRecord);
    }

    @Override
    public void deleteTransactionRecordByIds(String[] ids) {
        transactionRecordMapper.deleteTransactionRecordByIds(ids);
    }

    @Override
    public void insertSelective(TransactionRecord transactionRecord) {
        transactionRecordMapper.insertSelective(transactionRecord);
    }

    @Override
    public void updateByPrimaryKeySelective(TransactionRecord transactionRecord) {
        transactionRecordMapper.updateByPrimaryKeySelective(transactionRecord);
    }

}