package com.cc.util;

import org.springframework.stereotype.Component;

import java.io.InputStreamReader;
import java.io.LineNumberReader;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by cong on 2017/8/22.
 */
@Component
public class ShellUtil {


    public static List<String> runShell(String ssh, String shStr) throws Exception {


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


}
