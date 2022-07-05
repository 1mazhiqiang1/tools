package com.djhu.imp.utils;

import me.chanjar.weixin.mp.api.WxMpInMemoryConfigStorage;
import me.chanjar.weixin.mp.api.WxMpService;
import me.chanjar.weixin.mp.api.impl.WxMpServiceImpl;
import me.chanjar.weixin.mp.bean.template.WxMpTemplateData;
import me.chanjar.weixin.mp.bean.template.WxMpTemplateMessage;

import java.io.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static java.util.regex.Pattern.*;

/**
 * @Author mazq
 * @Date 2020/12/11 10:06
 */
public class WxUtil {

    public static void main(String[] args) {
        //1，配置
       /* WxMpInMemoryConfigStorage wxStorage = new WxMpInMemoryConfigStorage();
        wxStorage.setAppId("wx77bb69292323a000");//appid
        wxStorage.setSecret("29bd368145806115ad6820133e62806e");//appsecret
        WxMpService wxMpService = new WxMpServiceImpl();
        wxMpService.setWxMpConfigStorage(wxStorage);*/
        WxMpInMemoryConfigStorage wxStorage = new WxMpInMemoryConfigStorage();
        wxStorage.setAppId("wx674f3d662bb5dd68");//appid
        wxStorage.setSecret("2191173fc92d6fba1b849176e7333c26");//appsecret
        WxMpService wxMpService = new WxMpServiceImpl();
        wxMpService.setWxMpConfigStorage(wxStorage);


        //2,推送消息
      /*  WxMpTemplateMessage templateMessage = WxMpTemplateMessage.builder()
                .toUser("o5kho6DgC7SDry8zCmXuvHJGvrgI")//要推送的用户openid
                .templateId("Tpln-Eue2obJ0B-8JNkgkiRJaDMPgVeIgGxna982xrg")//模版id
                .url("https://30paotui.com/")//点击模版消息要访问的网址
                .build();*/
        WxMpTemplateMessage templateMessage = WxMpTemplateMessage.builder()
//                .toUser("otqe0wKZG1bZWmrCxZSlOxtZ0KDk")//要推送的用户openid
                .toUser("otqe0wOisXIHNjkFyrz0UOii5u5g")//要推送的用户openid
                .templateId("kCTiR4bdnmXrC1e2OAaaP3Pm32XPNWsCb5J3JXfaMfY")//模版id
                .url("https://www.baidu.com/")//点击模版消息要访问的网址
                .build();
//        3,如果是正式版发送模版消息，这里需要配置你的信息
        templateMessage.addData(new WxMpTemplateData("first", "valueoooooooo33333", "#FF00FF"));

        //发起推送
        try {
            String msg = wxMpService.getTemplateMsgService().sendTemplateMsg(templateMessage);
            System.out.println("推送成功：" + msg);
        } catch (Exception e) {
            System.out.println("推送失败：" + e.getMessage());
            e.printStackTrace();
        }


    }





}
