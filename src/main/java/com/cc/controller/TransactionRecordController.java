package com.cc.controller;

import com.cc.entity.TransactionRecord;
import com.cc.service.TransactionRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import static org.yaml.snakeyaml.nodes.NodeId.mapping;

@RestController
@RequestMapping(value = "/transactionRecord")
public class TransactionRecordController {

    @Autowired
    private TransactionRecordService transactionRecordService;

    @InitBinder
    public void initBinder(WebDataBinder binder) {
        DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        binder.registerCustomEditor(Date.class, new CustomDateEditor(format, true));
    }

    /**
     * 显示列表
     *
     * @param transactionRecord
     * @return
     */
    @RequestMapping("list")
    public Map<String, Object> list(TransactionRecord transactionRecord) {

        List<TransactionRecord> transactionRecordList = transactionRecordService.listPageTransactionRecord(transactionRecord);
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("list", transactionRecordList);
        map.put("page", transactionRecord);
        return map;
    }

    /**
     * 最近的一年的数据
     *
     * @param transactionRecord
     * @return
     */
    @RequestMapping("chart")
    public Map<String, Object> chart(TransactionRecord transactionRecord, Integer groupByLength) {
        if (groupByLength == null) {
            groupByLength = 4;
        }

        transactionRecord.setPaymentType("");
        List<TransactionRecord> transactionRecordList = transactionRecordService.listPageTransactionRecord(transactionRecord);
        Integer finalGroupByLength = groupByLength;


        Map<String, Map<String, Double>> collect = transactionRecordList.stream()
                .collect(Collectors.groupingBy(gg -> gg.getPaymentType(),

                        Collectors.groupingBy(it -> it.getTransationCreateTime().substring(0, finalGroupByLength.intValue()), Collectors.summingDouble(
                                TransactionRecord::getAmount
                        ))));
        Map<String, Object> result = new HashMap<>();

        result.put("message", "响应成功");
        result.put("data", collect);
        result.put("status", 200);

        return result;
    }

    /**
     * 请求编辑页面
     *
     * @param transactionRecord
     * @return
     */
    @RequestMapping(value = "/load")
    public TransactionRecord load(TransactionRecord transactionRecord) {
        transactionRecord = transactionRecordService.getTransactionRecordById(transactionRecord.getTransationNo());
        return transactionRecord;
    }

    /**
     * 保存
     *
     * @param transactionRecord
     * @return
     */
    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public TransactionRecord save(TransactionRecord transactionRecord) {
        try {
            if (transactionRecord.getTransationNo() == null || !transactionRecord.getTransationNo().equals("")) {
                transactionRecordService.insertSelective(transactionRecord);
            } else {
                transactionRecordService.updateByPrimaryKeySelective(transactionRecord);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return transactionRecord;
    }


    /**
     * 查看详情
     *
     * @param transactionRecord
     */
    @RequestMapping(value = "/delete")
    public String delete(TransactionRecord transactionRecord, ModelMap modelMap) {
        transactionRecordService.deleteTransactionRecord(transactionRecord);

        return "success";
    }
}
