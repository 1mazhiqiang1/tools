package com.djhu.imp.sortByChinesePinyin;

import lombok.Data;

/**
 * @author cyf
 * @description
 * @create 2019-07-17 10:50
 **/
@Data
public class SearchPathConditionVo {

    private String code;
    private String name;
    private boolean hasNext = false;
    private boolean hasPrev = false;
    private String level; // 查询的菜单级别 供页面使用
    private String relationCode;//关联字段
    private String type;//1-检验 2-检查类型 3-检查部位
}
