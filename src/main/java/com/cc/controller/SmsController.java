package com.cc.controller;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.cc.entity.CallRecords;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import com.cc.entity.Sms;
import com.cc.service.SmsService;
import sun.rmi.runtime.Log;

@RestController
@RequestMapping(value = "/sms")
public class SmsController {

    @Autowired
    private SmsService smsService;

    @InitBinder
    public void initBinder(WebDataBinder binder) {
        DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        binder.registerCustomEditor(Date.class, new CustomDateEditor(format, true));
    }

    /**
     * 显示列表
     *
     * @param sms
     * @return
     */
    @RequestMapping("list")
    public Map<String, Object> list(Sms sms) {
        Map<String, Object> map = new HashMap<String, Object>();
        List<Sms> smsList = smsService.listPageSms(sms);

        map.put("list", smsList);
        map.put("page", sms);
        return map;
    }

    /**
     * 请求编辑页面
     *
     * @param smsId
     * @return
     */
    @RequestMapping(value = "/load")
    public Sms load(Sms sms) {
        sms = smsService.getSmsById(sms.getSmsId());

        return sms;
    }

    /**
     * 保存店铺信息
     *
     * @param Equipment
     * @return
     */
    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public Sms save(Sms sms) {
        try {
            if (sms.getSmsId() == null || sms.getSmsId().intValue() == 0) {
                smsService.insertSelective(sms);
            } else {
                smsService.updateByPrimaryKeySelective(sms);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return sms;
    }

    @RequestMapping(value = "/upload", method = RequestMethod.POST)
    public Map<String, Object> uploadMap(@RequestBody List<Sms> list) {
        for (Sms s : list) {
            try {
                List<Sms> db = smsService.listPageSms(s);
                if (db != null && db.size() > 0) {

                } else {
                    smsService.insertSelective(s);


                }
            } catch (Exception e) {
                e.printStackTrace();

                continue;
            }
        }
        Map<String, Object> map = new HashMap<String, Object>();


        map.put("message", "成功！");
        map.put("status", 200);
        return map;

    }

    /**
     * 查看详情
     *
     * @param smsId
     */
    @RequestMapping(value = "/delete")
    @ResponseBody
    public String delete(Sms sms) {
        smsService.deleteSms(sms);
        return "success";
    }
}
