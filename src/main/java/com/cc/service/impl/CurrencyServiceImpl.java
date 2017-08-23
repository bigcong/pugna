package com.cc.service.impl;

import com.cc.entity.Config;
import com.cc.entity.Currency;
import com.cc.entity.Distance;
import com.cc.mapper.CurrencyMapper;
import com.cc.mapper.DistanceMapper;
import com.cc.service.ConfigService;
import com.cc.service.CurrencyService;
import com.cc.util.DateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.cc.util.ShellUtil.runShell;

/**
 * currency
 */
@Service
public class CurrencyServiceImpl implements CurrencyService {
    @Autowired
    private CurrencyMapper currencyMapper;
    @Autowired
    private ConfigService configService;


    @Autowired
    private DistanceMapper distanceMapper;

    @Override
    public List<Currency> listPageCurrency(Currency currency) {
        return currencyMapper.listPageCurrency(currency);
    }

    @Override
    public Integer getCurrencyCount() {
        return currencyMapper.getCurrencyCount();
    }

    @Override
    public void insert(Currency currency) {
        currencyMapper.insert(currency);
    }

    @Override
    public Currency getCurrencyById(Integer id) {
        return currencyMapper.getCurrencyById(id);
    }

    @Override
    public List<Currency> listCurrency(Currency currency) {
        return currencyMapper.listCurrency(currency);
    }

    @Override
    public void updateCurrency(Currency currency) {
        currencyMapper.updateCurrency(currency);
    }

    @Override
    public void deleteCurrency(Currency currency) {
        currencyMapper.deleteCurrency(currency);
    }

    @Override
    public void deleteCurrencyByIds(String[] ids) {
        currencyMapper.deleteCurrencyByIds(ids);
    }

    @Override
    public void insertSelective(Currency currency) {
        currencyMapper.insertSelective(currency);
    }

    @Override
    public void updateByPrimaryKeySelective(Currency currency) {
        currencyMapper.updateByPrimaryKeySelective(currency);
    }

    @Override
    @Scheduled(cron = "0 0/1 * * * ?")// 每2分钟执行一次
    public void autoInsert() throws Exception {
        Config c = new Config();
        c.setConfigName("ssh");
        c.setConfigType("ssh");

        List<Config> configs = configService.listConfig(c);
        String ssh = configs.get(0).getConfigValue();


        String str1 = "select currency_id,  SUM(amount) amount,sum(prepare_sub_amount) prepare_sub_amount,SUM(freeze_cash_amount) freeze_cash_amount, sum(cash_amount) cash_amount from ct_customer_account_ctb  group by currency_id";

        String str2 = "select   SUM(amount) amount,sum(prepare_sub_amount) prepare_sub_amount,SUM(freeze_cash_amount) freeze_cash_amount, sum(cash_amount)  cash_amount from ca_customer_account;";

        String str3 = "select  coin_code,current_amount from qt_current_quote;";
        String create_time = DateUtil.nowDate();

        Map<String, Currency> map = new HashMap<>();

        for (String str : runShell(ssh, str1)) {
            Currency currency = new Currency();

            String[] split = str.split("\t");
            if (split[0].equals("currency_id")) {
                continue;
            }
            if (map.containsKey(split[0].trim())) {
                currency = map.get(split[0]);
            }

            currency.setCurrencyId(Short.valueOf(split[0].trim()));
            currency.setAmount(Double.valueOf(split[1]));
            currency.setPrepareSubAmount(Double.valueOf(split[2]));
            currency.setFreezeCashAmount(Double.valueOf(split[3]));
            currency.setCashAmount(Double.valueOf(split[4]));
            currency.setCreateTime(create_time);

            map.put(split[0].trim(), currency);

        }


        for (String str : runShell(ssh, str2)) {

            Currency currency = new Currency();
            currency.setCreateTime(create_time);

            String[] split = str.split("\t");
            if (split[0].equals("amount")) {
                continue;
            }
            currency.setCurrencyId((short) 1);
            currency.setAmount(Double.valueOf(split[0]));
            currency.setPrepareSubAmount(Double.valueOf(split[1]));
            currency.setFreezeCashAmount(Double.valueOf(split[2]));
            currency.setCashAmount(Double.valueOf(split[3]));
            currency.setPrice(Double.valueOf(1));
            map.put("1", currency);
        }


        for (String str : runShell(ssh, str3)) {

            Currency currency = new Currency();

            String[] split = str.split("\t");
            if (split[0].equals("coin_code")) {
                continue;
            }
            if (map.containsKey(split[0].trim())) {
                currency = map.get(split[0]);
            }

            currency.setPrice(Double.valueOf(split[1]));
            map.put(split[0], currency);

        }

        double sum = map.values().stream().filter(t -> t.getCurrencyId() != 1).mapToDouble(t -> t.getAmount() * t.getPrice()).sum();
        double sum1 = map.values().stream().filter(t -> t.getCurrencyId() == 1).mapToDouble(t -> t.getAmount() * t.getPrice()).sum();
        System.out.println("----------------------------------");
        System.out.println(BigDecimal.valueOf(sum - sum1).toPlainString());
        Distance distance = new Distance();
        distance.setCreateTime(create_time);
        distance.setAmount(sum - sum1);
        if (distance.getAmount() != 0) {
            distanceMapper.insertSelective(distance);

        }


        map.values().stream().forEach(t -> insertSelective(t));


    }

}