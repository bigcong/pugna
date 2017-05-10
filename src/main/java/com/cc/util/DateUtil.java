package com.cc.util;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by bigcong on 15/12/3.
 */
public class DateUtil {
    public static DateFormat format=new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
    public static String nowDate(){
        return format.format(new Date());
    }

}
