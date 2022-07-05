package com.hy.message.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.time.LocalDateTime;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 助力活动信息
 * </p>
 *
 * @author mzq
 * @since 2021-04-22
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class OmoActiveSupport implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 助力活动编号
     */
    @TableId(value = "active_support_id", type = IdType.AUTO)
    private Long activeSupportId;

    /**
     * 助力活动头图
     */
    private String activeImg;

    /**
     * 背景颜色
     */
    private String backgroundColor;

    /**
     * 活动开始时间
     */
    private LocalDateTime activeStartTime;

    /**
     * 活动结束时间
     */
    private LocalDateTime activeEndTime;

    /**
     * 活动状态(1:正常, 2:已过期)
     */
    private Integer activeStatus;

    /**
     * 到期有效期（小时)
     */
    private Integer supportExprieHour;

    /**
     * 赠送的商品标题
     */
    private String goodsTitle;

    /**
     * 赠送商品的子标题
     */
    private String goodsSubTitle;

    /**
     * 赠送商品图片
     */
    private String goodsImg;

    /**
     * 赠送商品描述
     */
    private String goodsDesc;

    /**
     * 活动引导文案
     */
    private String activeGuideContent;

    /**
     * 已成功领取人数
     */
    private Integer receiveNumber;

    /**
     * 需要助力人数
     */
    private Integer supportNumber;

    /**
     * 联系人二维码
     */
    private String qrCode;

    private Integer sort;

    private Boolean isDeleted;

    /**
     * 创建时间
     */
    private LocalDateTime createTime;

    private Long createBy;

    private LocalDateTime updateTime;

    private Long updateBy;


}
