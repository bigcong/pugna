package com.cc.controller;

import com.cc.entity.Bills;
import com.cc.service.BillsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.lang.reflect.Field;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;

import static java.util.stream.Collectors.*;

@RestController
@RequestMapping(value = "/bills")
public class BillsController {

    @Autowired
    private BillsService billsService;

    @InitBinder
    public void initBinder(WebDataBinder binder) {
        DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        binder.registerCustomEditor(Date.class, new CustomDateEditor(format, true));
    }

    /**
     * 显示列表
     *
     * @param bills
     * @return
     */
    @RequestMapping("list")
    public Map<String, Object> list(Bills bills) {

        List<Bills> billsList = billsService.listPageBills(bills);
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("list", billsList);
        map.put("page", bills);
        return map;
    }

    @RequestMapping("chart")
    public Map chart(Bills bills) {

        List<Bills> billsList = billsService.listPageBills(bills);


        Map<Boolean, Double> collect = billsList.stream().collect(partitioningBy(e -> e.get金额() > 10000, summingDouble(Bills::get金额)));


        return collect;
    }


    /**
     * curl -F "file=@/Users/cong/Downloads/1.txt" http://localhost:8090/pugna/bills/upload
     *
     * @param file
     * @return
     * @throws Exception
     */
    @RequestMapping("upload")
    public String uplaod(@RequestParam("file") MultipartFile file) throws Exception {


        InputStreamReader read = new InputStreamReader(
                file.getInputStream(), "GBK");//考虑到编码格式
        BufferedReader bufferedReader = new BufferedReader(read);
        String lineTxt = null;
        int i = 0;
        String account = "";
        String keys[] = null;
        while ((lineTxt = bufferedReader.readLine()) != null) {
            i++;
            String values[] = lineTxt.split(",");

            Bills bills = new Bills();
            if (keys == null || keys.length != values.length) {
                if (i == 2) {
                    String a = lineTxt.split(":")[1];
                    account = a.substring(1, a.length() - 1);

                } else if (i == 5) {
                    keys = lineTxt.split(",");

                }


                continue;
            }
            bills.set账户(account);
            System.out.println(lineTxt);


            for (int j = 0; j < keys.length; j++) {


                String filename = keys[j].trim().replace("（元）", "").replace("/", "");
                Field field = bills.getClass().getDeclaredField(filename);


                String value = values[j].trim();
                if (value.equals("")) {
                    continue;
                }


                field.setAccessible(true);
                String typeName = field.getAnnotatedType().getType().getTypeName();


                if (typeName.equals("java.lang.Double")) {
                    field.set(bills, Double.valueOf(value));

                } else {
                    field.set(bills, value);
                }


            }

            try {
                billsService.insert(bills);

            } catch (Exception e) {
                if (e instanceof DuplicateKeyException) {

                } else {
                    e.printStackTrace();
                }

            }


            System.out.println(lineTxt);


        }
        read.close();

        return "成功";
    }

    /**
     * 请求编辑页面
     *
     * @param bills
     * @return
     */
    @RequestMapping(value = "/load")
    public Bills load(Bills bills) {
        //bills = billsService.getBillsById(bills.get交易号());
        return bills;
    }

    /**
     * 保存
     *
     * @param bills
     * @return
     */
    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public Bills save(Bills bills) {
        try {
            if (bills.get交易号() == null || bills.get交易号().equals("")) {
                billsService.insertSelective(bills);
            } else {
                billsService.updateByPrimaryKeySelective(bills);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return bills;
    }


    /**
     * 查看详情
     *
     * @param bills
     */
    @RequestMapping(value = "/delete")
    public String delete(Bills bills, ModelMap modelMap) {
        billsService.deleteBills(bills);
        return "success";
    }
}
