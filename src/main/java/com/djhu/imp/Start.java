package com.djhu.imp;

import com.djhu.imp.service.SaveTemplateServiceImpl;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.ConfigurableApplicationContext;

/**
 * @Author:mzq
 * @DATE:2019/8/818:19
 * @VERSION:1.0.0
 */
@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
public class Start {
    public static void main(String[] args) {
        ConfigurableApplicationContext configurableApplicationContext = SpringApplication.run(Start.class,args);
        SaveTemplateServiceImpl saveTemplateService= configurableApplicationContext.getBean(SaveTemplateServiceImpl.class);
        saveTemplateService.importData();

    }
}
