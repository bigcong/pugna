package com.cc.controller;

import com.cc.entity.CallRecords;
import com.cc.entity.ChartCallRecordsData;
import com.cc.service.CallRecordsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/callRecords")
public class CallRecordsController {

    @Autowired
    private CallRecordsService callRecordsService;

    @InitBinder
    public void initBinder(WebDataBinder binder) {
        DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        binder.registerCustomEditor(Date.class, new CustomDateEditor(format, true));
    }

    /**
     * 显示列表
     *
     * @param callRecords
     * @return
     */
    @RequestMapping("list")
    public Map<String, Object> list(CallRecords callRecords) {
        Map<String, Object> map = new HashMap<String, Object>();
        List<CallRecords> callRecordsList = callRecordsService.listPageCallRecords(callRecords);
        map.put("list", callRecordsList);
        map.put("page", callRecords);
        return map;
    }

    /**
     * 请求编辑页面
     *
     * @param callRecords
     * @return
     */
    @RequestMapping(value = "/load")
    public CallRecords load(CallRecords callRecords, ModelMap modelMap) {
        callRecords = callRecordsService.getCallRecordsById(callRecords.getId());
        modelMap.addAttribute("callRecords", callRecords);
        return callRecords;
    }

    /**
     * 保存店铺信息
     *
     * @param callRecords
     * @return
     */
    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public CallRecords save(CallRecords callRecords, ModelMap modelMap) {
        try {
            if (callRecords.getId() == null || callRecords.getId().intValue() == 0) {
                callRecordsService.insert(callRecords);
            } else {
                callRecordsService.updateCallRecords(callRecords);
            }
            modelMap.addAttribute("success", "success");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return callRecords;
    }

    /**
     * 批量上传通话记录
     *
     * @param json
     * @return
     */
    @RequestMapping(value = "/uploadRecord", method = RequestMethod.POST)
    public Map<String, Object> saveMap(@RequestBody List<CallRecords> callRecordss) {
        Map<String, Object> map = new HashMap<String, Object>();


        System.out.println("gggggggggggggggggggggggggggg" + callRecordss.size());

        for (CallRecords c : callRecordss) {
            this.callRecordsService.uploadRecord(c);

        }
        System.out.println("gggggggggggggggggggggggggggg" + callRecordss.size());
        map.put("message", "成功！");
        map.put("status", 200);

        return map;
    }

    /**
     * 查看详情
     *
     * @param callRecords
     */
    @RequestMapping(value = "/delete")
    public String delete(CallRecords callRecords, ModelMap modelMap) {
        callRecordsService.deleteCallRecords(callRecords);
        return "success";
    }

    @RequestMapping(value = "/countByDate")
    public List<ChartCallRecordsData> countByDate(ChartCallRecordsData chartCallRecordsData) {
        System.out.println("---------------------------------------------------");
        return this.callRecordsService.countByDate(chartCallRecordsData);
    }

    @RequestMapping(value = "/chart")
    public Map<Integer, Object> listChart(CallRecords callRecords) {
        DateFormat format = new SimpleDateFormat("yyyy-MM-dd");

        Map<Integer, Object> map = new HashMap<>();
        List<CallRecords> list = callRecordsService.listCallRecords(callRecords);
        Map<Integer, List<CallRecords>> collect = list.stream().collect(Collectors.groupingBy(CallRecords::getType));

        for (Integer key : collect.keySet()) {
            for (CallRecords r : collect.get(key)) {
                r.setDate(r.getDate().split(" ")[0]);
            }
            map.put(key, collect.get(key).stream().collect(Collectors.groupingBy(CallRecords::getDate, Collectors.counting())));
        }

        return map;
    }

    @RequestMapping(value = "/countByName")
    public List<ChartCallRecordsData> countByName(ChartCallRecordsData chartCallRecordsData) {
        return this.callRecordsService.countByName(chartCallRecordsData);
    }
}
