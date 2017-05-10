package com.cc.controller;

import com.cc.entity.Day7Chart;
import com.cc.entity.SystemLog;
import com.cc.mapper.SystemLogMapper;
import com.cc.service.SystemLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@RestController
@RequestMapping(value = "/systemLog")
public class SystemLogController {

    @Autowired
    private SystemLogService systemLogService;
    @Autowired
    private SystemLogMapper systemLogMapper;


    @InitBinder
    public void initBinder(WebDataBinder binder) {
        DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        binder.registerCustomEditor(Date.class, new CustomDateEditor(format, true));
    }

    /**
     * 显示列表
     *
     * @param systemLog
     * @return
     */
    @RequestMapping("list")
    public Map<String, Object> list(SystemLog systemLog) {
        Map<String, Object> map = new HashMap<String, Object>();

        List<SystemLog> systemLogList = systemLogService.listPageSystemLog(systemLog);
        map.put("list", systemLogList);
        map.put("page", systemLog);

        return map;
    }

    /**
     * 请求编辑页面
     *
     * @param systemLog
     * @return
     */
    @RequestMapping(value = "/load")
    public SystemLog load(SystemLog systemLog) {
        systemLog = systemLogService.getSystemLogById(systemLog.getLogId());


        return systemLog;
    }

    /**
     * 保存店铺信息
     *
     * @param systemLog
     * @return
     */
    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public SystemLog save(SystemLog systemLog) {
        try {
            if (systemLog.getLogId() == null || systemLog.getLogId().intValue() == 0) {
                systemLogService.insertSelective(systemLog);
            } else {
                systemLogService.updateByPrimaryKeySelective(systemLog);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return systemLog;
    }


    /**
     * 查看详情
     *
     * @param systemLog
     */
    @RequestMapping(value = "/delete")
    public String delete(SystemLog systemLog) {
        systemLogService.deleteSystemLog(systemLog);
        return "success";
    }

    /**
     * 查看详情
     *
     * @param systemLog
     */
    @RequestMapping(value = "/day7Chart")
    public List<Day7Chart> day7Chart(SystemLog systemLog) {
        return this.systemLogMapper.count7Day();
    }


}
