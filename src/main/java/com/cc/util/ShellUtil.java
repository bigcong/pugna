package com.cc.util;

import com.cc.entity.Currency;
import com.google.gson.Gson;

import java.io.InputStreamReader;
import java.io.LineNumberReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by cong on 2017/8/22.
 */
public class ShellUtil {


    public static List<String> runShell(String shStr) throws Exception {


        String ssh = "";

        List<String> strList = new ArrayList();

        String shell = String.format(ssh, shStr);
        System.out.println(shell);

        Process process;
        process = Runtime.getRuntime().exec(new String[]{"/bin/sh", "-c", shell}, null, null);
        InputStreamReader ir = new InputStreamReader(process
                .getInputStream());
        LineNumberReader input = new LineNumberReader(ir);
        String line;
        process.waitFor();
        while ((line = input.readLine()) != null) {
            strList.add(line);
        }

        return strList;
    }

    public static void main(String[] args) throws Exception {
        //select currency_id,  SUM(amount),sum(prepare_sub_amount),SUM(freeze_cash_amount),sum(cash_amount) from ct_customer_account_ctb  group by currency_id;

        String str1 = "select currency_id,  SUM(amount) amount,sum(prepare_sub_amount) prepare_sub_amount,SUM(freeze_cash_amount) freeze_cash_amount, sum(cash_amount) cash_amount from ct_customer_account_ctb  group by currency_id";

        String str2 = "select   SUM(amount) amount,sum(prepare_sub_amount) prepare_sub_amount,SUM(freeze_cash_amount) freeze_cash_amount, sum(cash_amount)  cash_amount from ca_customer_account;";

        String str3 = "select  coin_code,current_amount from qt_current_quote;";

        Map<String, Currency> map = new HashMap<>();

        for (String str : runShell(str1)) {
            System.out.println(str);
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
            currency.setCreateTime(DateUtil.nowDate());

            map.put(split[0].trim(), currency);

        }


        for (String str : runShell(str2)) {
            System.out.println(str);

            Currency currency = new Currency();

            String[] split = str.split("\t");
            if (split[0].equals("amount")) {
                continue;
            }
            currency.setCurrencyId((short) 1);
            currency.setAmount(Double.valueOf(split[0]));
            currency.setPrepareSubAmount(Double.valueOf(split[1]));
            currency.setFreezeCashAmount(Double.valueOf(split[2]));
            currency.setCashAmount(Double.valueOf(split[3]));
            currency.setCreateTime(DateUtil.nowDate());
            currency.setPrice(Double.valueOf(1));
            map.put("1", currency);
        }


        for (String str : runShell(str3)) {
            System.out.println(str);

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


    }


}
