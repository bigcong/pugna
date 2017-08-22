package com.cc.controller;

import com.cc.entity.Currency;
import com.cc.service.CurrencyService;
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
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(value = "/currency")
public class CurrencyController {

    @Autowired
    private CurrencyService currencyService;

    @InitBinder
    public void initBinder(WebDataBinder binder) {
        DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        binder.registerCustomEditor(Date.class, new CustomDateEditor(format, true));
    }

    /**
     * 显示列表
     *
     * @param currency
     * @return
     */
    @RequestMapping("list")
    public Map<String, Object> list(Currency currency) {
        List<Currency> currencyList = currencyService.listPageCurrency(currency);
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("list", currencyList);
        map.put("page", currency);
        return map;
    }

    /**
     * 请求编辑页面
     *
     * @param currency
     * @return
     */
    @RequestMapping(value = "/load")
    public Currency load(Currency currency) {
        currency = currencyService.getCurrencyById(currency.getId().intValue());
        return currency;
    }

    /**
     * 保存
     *
     * @param currency
     * @return
     */
    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public Currency save(Currency currency) {
        try {
            if (currency.getId() == null || currency.getId().intValue() == 0) {
                currencyService.insertSelective(currency);
            } else {
                currencyService.updateByPrimaryKeySelective(currency);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return currency;
    }


    /**
     * 查看详情
     *
     * @param currency
     */
    @RequestMapping(value = "/delete")
    public String delete(Currency currency, ModelMap modelMap) {
        currencyService.deleteCurrency(currency);
        return "success";
    }
}
