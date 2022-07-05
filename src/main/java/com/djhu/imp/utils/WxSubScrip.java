package com.djhu.imp.utils;

import net.sf.json.JSONObject;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.config.Registry;
import org.apache.http.config.RegistryBuilder;
import org.apache.http.conn.socket.ConnectionSocketFactory;
import org.apache.http.conn.socket.PlainConnectionSocketFactory;
import org.apache.http.conn.ssl.NoopHostnameVerifier;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.conn.ssl.TrustSelfSignedStrategy;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.DefaultHttpRequestRetryHandler;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;
import org.apache.http.ssl.SSLContextBuilder;
import org.apache.http.util.EntityUtils;

import javax.annotation.PostConstruct;
import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;

/**
 * @Author mazq
 * @Date 2020/12/15 14:59
 */
public class WxSubScrip {

    /*public static void main(String[] args) throws Exception{
       *//*  CloseableHttpClient httpClient;
         PoolingHttpClientConnectionManager poolConnManager;

         Integer maxTotal = 200;

         Integer defaultMaxPerRoute = 50;


                SSLContextBuilder builder = new SSLContextBuilder();
                builder.loadTrustMaterial(null, new TrustSelfSignedStrategy());
                // 不进行主机名验证
                SSLConnectionSocketFactory sslConnectionSocketFactory = new SSLConnectionSocketFactory(builder.build(),
                        NoopHostnameVerifier.INSTANCE);
                Registry<ConnectionSocketFactory> socketFactoryRegistry = RegistryBuilder.<ConnectionSocketFactory>create()
                        .register("http", PlainConnectionSocketFactory.getSocketFactory())
                        .register("https", sslConnectionSocketFactory).build();
                // 初始化连接管理器
                poolConnManager = new PoolingHttpClientConnectionManager(socketFactoryRegistry);
                poolConnManager.setMaxTotal(maxTotal);// 同时最多连接数
                // 设置最大路由
                poolConnManager.setDefaultMaxPerRoute(defaultMaxPerRoute);
                // 此处解释下MaxtTotal和DefaultMaxPerRoute的区别：
                // 1、MaxtTotal是整个池子的大小；
                // 2、DefaultMaxPerRoute是根据连接到的主机对MaxTotal的一个细分；比如：
                // MaxtTotal=400 DefaultMaxPerRoute=200
                // 而我只连接到http://www.abc.com时，到这个主机的并发最多只有200；而不是400；
                // 而我连接到http://www.bac.com 和
                // http://www.ccd.com时，到每个主机的并发最多只有200；即加起来是400（但不能超过400）；所以起作用的设置是DefaultMaxPerRoute
                // 初始化httpClient

                RequestConfig config = RequestConfig.custom().setConnectTimeout(5000).setConnectionRequestTimeout(5000)
                        .setSocketTimeout(5000).build();
                httpClient = HttpClients.custom()
                        // 设置连接池管理
                        .setConnectionManager(poolConnManager).setDefaultRequestConfig(config)
                        // 设置重试次数
                        .setRetryHandler(new DefaultHttpRequestRetryHandler(2, false)).build();
//                String access_token = getAccessToken("wx674f3d662bb5dd68","2191173fc92d6fba1b849176e7333c26");
        String code = "071EbUIa1giW8A0omPFa1yDZI72EbUIX";
        String openIdUrl = "https://api.weixin.qq.com/sns/oauth2/access_token?appid=" + "wx674f3d662bb5dd68" + "&secret=" + "2191173fc92d6fba1b849176e7333c26" + "&code=" + code + "&grant_type=authorization_code";
        HttpGet httpGet = new HttpGet(openIdUrl);
        HttpResponse httpResponse = httpClient.execute(httpGet);
        String strResponse = EntityUtils.toString(httpResponse.getEntity());
        com.alibaba.fastjson.JSONObject obj = com.alibaba.fastjson.JSONObject.parseObject(strResponse);
        String access_token = obj.getString("access_token");
        String openid = obj.getString("openid");*//*

        String access_token = getAccessToken("wx674f3d662bb5dd68","2191173fc92d6fba1b849176e7333c26");
        System.out.println("========access_token====="+access_token);
//        if (obj.containsKey("openid") && obj.containsKey("access_token")) {
//            WechatUser wechatUser = new WechatUser();
//            wechatUser.setOpenId(obj.getString("openid"));
                //推送订阅模板消息url
//                String sendMsgUrl = "https://api.weixin.qq.com/cgi-bin/message/template/subscribe?access_token=access_token";
                String sendMsgUrl = "https://api.weixin.qq.com/cgi-bin/message/template/subscribe?access_token="+access_token;
               *//* JSONObject json = new JSONObject();
                json.put("touser","otqe0wBFDVDNbablW34X-Mk3LqxM");
//                json.put("touser","otqe0wOisXIHNjkFyrz0UOii5u5g");
//                json.put("touser","otqe0wBFDVDNbablW34X-Mk3LqxM");
//订阅消息模板ID，登录公众平台后台，在接口权限列表处可查看订阅模板ID
//                json.put("template_id","");
                json.put("template_id","B0B9ujEaG6JX0B8VU-vAFsFLA_zO1mVPSuzNJY3t8bg");
//                json.put("url","https%3A%2F%2Fpreh5.hanyuan.vip%2Fwxlogin");
                json.put("url","https://www.baidu.com/\"");*//*
//消息体
//                String msgStr = "{\"touser\":\"" + openid + "\",\"data\":{\"content\":{\"color\":\"#173177\",\"value\":\"通知内容\"}},\"template_id\":\"template_id\",\"title\":\"中奖通知\",\"scene\":\"1000\",\"url\":\"https://\"}";
                String msgStr = "{\"touser\":\"" + "otqe0wBFDVDNbablW34X-Mk3LqxM" + "\",\"data\":{\"content\":{\"color\":\"#173177\",\"value\":\"通知内容\"}},\"template_id\":\"B0B9ujEaG6JX0B8VU-vAFsFLA_zO1mVPSuzNJY3t8bg\",\"title\":\"中奖通知\",\"scene\":\"1000\",\"url\":\"https://www.baidu.com/\"}";
//                logger.info(msgStr);
                System.out.println("========="+msgStr);
                System.out.println("========="+sendMsgUrl);
//                logger.info(msgStr);
//通过API推送订阅模板消息给到授权微信用户
//                String noticeResult= HttpClientUtil.sendPost(sendMsgUrl,msgStr);
                String noticeResult = HttpUtils.sendPost(sendMsgUrl, msgStr);
//            } catch (Exception ex) {
//                System.out.println(ex.getMessage());
//            }





    }*/



    /**
     * 向指定 URL 发送POST方法的请求
     *
     * @param url
     *            发送请求的 URL
     * @param param
     *            请求参数，请求参数应该是 name1=value1&name2=value2 的形式。
     * @return 所代表远程资源的响应结果
     */
    public static String sendPost(String url, String param) {
        PrintWriter out = null;
        BufferedReader in = null;
        String result = "";
        try {
            URL realUrl = new URL(url);
            // 打开和URL之间的连接
            URLConnection conn = realUrl.openConnection();
            //设置通用的请求属性
            conn.setRequestProperty("user-agent","Mozilla/5.0 (Windows NT 6.1; WOW64; rv:21.0) Gecko/20100101 Firefox/21.0)");
            // 发送POST请求必须设置如下两行
            conn.setDoOutput(true);
            conn.setDoInput(true);
            // 获取URLConnection对象对应的输出流
            OutputStreamWriter outWriter = new OutputStreamWriter(conn.getOutputStream(), "utf-8");
            out = new PrintWriter(outWriter);
            // 发送请求参数
            out.print(param);
            // flush输出流的缓冲
            out.flush();
            // 定义BufferedReader输入流来读取URL的响应
            in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            String line;
            while ((line = in.readLine()) != null) {
                in = new BufferedReader(new InputStreamReader(conn.getInputStream()));result += line;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        //使用finally块来关闭输出流、输入流
        finally{
            try{
                if(out!=null){
                    out.close();
                }
                if(in!=null){
                    in.close();
                }
            }
            catch(IOException ex){
                ex.printStackTrace();
            }
        }
        return result;
    }



    /**
     * 获取access_token
     */
    public static String getAccessToken(String appId, String appSecret) {
        String access_token = "";
        String grant_type = "client_credential";//获取access_token填写client_credential
        //这个url链接地址和参数皆不能变
        String url = "https://api.weixin.qq.com/cgi-bin/token?grant_type=" + grant_type + "&appid=" + appId + "&secret=" + appSecret;

        try {
            URL urlGet = new URL(url);
            HttpURLConnection http = (HttpURLConnection) urlGet.openConnection();
            http.setRequestMethod("GET"); // 必须是get方式请求
            http.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
            http.setDoOutput(true);
            http.setDoInput(true);
            System.setProperty("sun.net.client.defaultConnectTimeout", "30000");// 连接超时30秒
            System.setProperty("sun.net.client.defaultReadTimeout", "30000"); // 读取超时30秒
            http.connect();
            InputStream is = http.getInputStream();
            int size = is.available();
            byte[] jsonBytes = new byte[size];
            is.read(jsonBytes);
            String message = new String(jsonBytes, "UTF-8");
            JSONObject demoJson = JSONObject.fromObject(message);
            access_token = demoJson.getString("access_token");
            is.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return access_token;
    }


    /**
     * 获取用户token
     * @return
     */

    public static String getAccessTokes() {
        String access_token = "";
        String grant_type = "client_credential";// 获取access_token填写client_credential
        String AppId = "**";// 第三方用户唯一凭证
        String secret = "**";// 第三方用户唯一凭证密钥，即appsecret

// 这个url链接地址和参数皆不能变
        String url = "https://api.weixin.qq.com/cgi-bin/token?grant_type=" + grant_type + "&appid=" + AppId + "&secret="
                + secret;
        try {
            URL urlGet = new URL(url);
            HttpURLConnection http = (HttpURLConnection) urlGet.openConnection();
            http.setRequestMethod("GET"); // 必须是get方式请求
            http.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
            http.setDoOutput(true);
            http.setDoInput(true);
            System.setProperty("sun.net.client.defaultConnectTimeout", "30000");// 连接超时30秒
            System.setProperty("sun.net.client.defaultReadTimeout", "30000"); // 读取超时30秒
            http.connect();
            InputStream is = http.getInputStream();
            int size = is.available();
            byte[] jsonBytes = new byte[size];
            is.read(jsonBytes);
            String message = new String(jsonBytes, "UTF-8");
            com.alibaba.fastjson.JSONObject
                    demoJson = com.alibaba.fastjson.JSONObject.parseObject(message);
            access_token = demoJson.getString("access_token");
            System.out.println("getAccessToke------------------JSON字符串：" + demoJson);
            is.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return access_token;
    }

//    二、判断是否关注公众号

    public  boolean judgeIsFollow(String access_token,String openid){
        Integer subscribe = 0;
        String url = "https://api.weixin.qq.com/cgi-bin/user/info?access_token="+access_token+"&openid="+openid+"&lang=zh_CN";
        try {
            URL urlGet = new URL(url);
            HttpURLConnection http = (HttpURLConnection) urlGet.openConnection();
            http.setRequestMethod("GET"); // 必须是get方式请求
            http.setRequestProperty("Content-Type","application/x-www-form-urlencoded");
            http.setDoOutput(true);
            http.setDoInput(true);
            http.connect();
            InputStream is = http.getInputStream();
            int size = is.available();
            byte[] jsonBytes = new byte[size];
            is.read(jsonBytes);
            String message = new String(jsonBytes, "UTF-8");
//            com.alibaba.fastjson.JSONObject
            com.alibaba.fastjson.JSONObject demoJson = com.alibaba.fastjson.JSONObject.parseObject(message);
            System.out.println("JSON字符串："+demoJson);
            subscribe = demoJson.getIntValue("subscribe"); // 此字段为关注字段  关注为1 未关注为0
            is.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 1==subscribe?true:false;
    }

//    String access_token = getAccessToken("wx674f3d662bb5dd68","2191173fc92d6fba1b849176e7333c26");

    public static void main(String[] args) {
        String access_token = getAccessToken("wx674f3d662bb5dd68","2191173fc92d6fba1b849176e7333c26");
        String openid = "otqe0wBFDVDNbablW34X-Mk3LqxM";
        Integer subscribe = 0;
        String url = "https://api.weixin.qq.com/cgi-bin/user/info?access_token="+access_token+"&openid="+openid+"&lang=zh_CN";
        try {
            URL urlGet = new URL(url);
            HttpURLConnection http = (HttpURLConnection) urlGet.openConnection();
            http.setRequestMethod("GET"); // 必须是get方式请求
            http.setRequestProperty("Content-Type","application/x-www-form-urlencoded");
            http.setDoOutput(true);
            http.setDoInput(true);
            http.connect();
            InputStream is = http.getInputStream();
            int size = is.available();
            byte[] jsonBytes = new byte[size];
            is.read(jsonBytes);
            String message = new String(jsonBytes, "UTF-8");
            com.alibaba.fastjson.JSONObject demoJson = com.alibaba.fastjson.JSONObject.parseObject(message);
            System.out.println("JSON字符串："+demoJson);
            subscribe = demoJson.getIntValue("subscribe"); // 此字段为关注字段  关注为1 未关注为0
            is.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println(1==subscribe?true:false);
    }


}
