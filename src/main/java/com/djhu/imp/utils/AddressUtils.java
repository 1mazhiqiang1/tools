package com.djhu.imp.utils;

import net.sf.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

/**
 * @Author mazq
 * @Date 2021/3/2 16:08
 */
public class AddressUtils {

    public static void main(String[] args) {
        try {
            String strIP = "101.80.201.152";
//            URL url = new URL("http://ip.qq.com/cgi-bin/searchip?searchip1=" + strIP);
            URL url = new URL("http://ip.ws.126.net/ipquery?ip=101.80.201.152");
            URLConnection conn = url.openConnection();
            BufferedReader reader = new BufferedReader(new InputStreamReader(conn.getInputStream(), "GBK"));
            String line = null;
            StringBuffer result = new StringBuffer();
            while ((line = reader.readLine()) != null) {
                result.append(line);
            }
            reader.close();
            System.out.println(result.substring(result.indexOf("localAddress=")+13));
            JSONObject json = JSONObject.fromObject(result.substring(result.indexOf("localAddress=")+13));
            System.out.println("json数据： " + json);
            String city = json.get("city").toString();
            String province = json.get("province").toString();
//            String country = JSONObject.fromObject(json.get("data")).get("country").toString();

//            strIP = result.substring(result.indexOf("该IP所在地为："));
//            strIP = strIP.substring(strIP.indexOf("：") + 1);
//            String province = strIP.substring(6, strIP.indexOf("省"));
//            String city = strIP.substring(strIP.indexOf("省") + 1, strIP.indexOf("市"));
            System.out.println(province+city);
        } catch (IOException e) {
            System.out.println(e);
        }

    }

}
