package com.cc.util;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.beans.PropertyDescriptor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Map;

/**
 * Created by cong on 2017/7/27.
 */
@Component
public class Dota2Utils {
    @Value("${steam.key}")
    String steamKey = "";

    public static Object toBean(String json, Object o) {
        System.out.println(json);
        System.out.println(o);
        Gson g = new Gson();
        JsonObject object = g.fromJson(json, JsonObject.class);
        Field[] fields = o.getClass().getDeclaredFields();


        System.out.println(fields.length);

        try {
            for (Field f : fields) {
                System.out.println(f.getName());
                PropertyDescriptor pd = new PropertyDescriptor(f.getName(), o.getClass());
                Method wM = pd.getWriteMethod();
                String newName = newName(f.getName());
                System.out.println(newName);
                if (object.get(f.getName()) != null) {
                    wM.invoke(o, object.get(f.getName()));
                } else if (object.get(newName) != null) {


                    wM.invoke(o, new Object[]{object.get(newName).getAsShort()});

                }


            }

        } catch (Exception e) {
            e.printStackTrace();
        }


        return o;

    }

    public static final String newTableName(String tableName) {
        String strS[] = tableName.split("_");
        String newStr = "";
        for (String st : strS) {
            newStr += lowerFirst(st);
        }
        return newStr;
    }

    public static final String lowerFirst(String s) {
        int len = s.length();
        if (len <= 0)
            return "";

        StringBuffer sb = new StringBuffer();
        sb.append(s.substring(0, 1).toLowerCase());
        sb.append(s.substring(1, len));
        return sb.toString();
    }


    public static final String newName(String s) {
        StringBuffer stringBuffer = new StringBuffer();


        for (int i = 0; i < s.length(); i++) {

            if (!Character.isLowerCase(s.charAt(i))) {
                stringBuffer.append("_" + s.charAt(i));

            } else {
                stringBuffer.append(s.charAt(i));

            }


        }

        return stringBuffer.toString().toLowerCase();
    }


    public String get(String u, Map<String, Object> map) {
        RestTemplate restTemplate = new RestTemplate();

        String url = "http://api.steampowered.com/" + u + "/v1?key=" + steamKey;
        StringBuilder str = new StringBuilder();
        str.append(url);

        map.entrySet().stream().forEach(t -> str.append("&" + t.getKey() + "=" + t.getValue()));

        return restTemplate.getForObject(str.toString(), String.class);


    }


}
