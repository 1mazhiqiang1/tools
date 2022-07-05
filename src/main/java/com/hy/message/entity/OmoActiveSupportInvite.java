package com.hy.message.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.time.LocalDateTime;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 助力活动邀请记录
 * </p>
 *
 * @author mzq
 * @since 2021-04-22
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class OmoActiveSupportInvite implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 记录编号
     */
    @TableId(value = "invite_id", type = IdType.AUTO)
    private Long inviteId;

    /**
     * 助力活动编号
     */
    private Long activeSupportId;

    /**
     * 用户编号
     */
    private Long userId;

    /**
     * 需助力人数
     */
    private Integer supportNumber;

    /**
     * 参与人数
     */
    private Integer participantNumber;

    /**
     * 助力开始时间
     */
    private LocalDateTime startTime;

    /**
     * 助力截止时间
     */
    private LocalDateTime endTime;

    /**
     * 助力状态（1：待助力 2：助力成功   3：已关联地址  4：已过期)
     */
    private Integer inviteStatus;

    /**
     * 收货人姓名
     */
    private String consigneeName;

    /**
     * 收货人手机号
     */
    private String consigneePhone;

    /**
     * 收货人性别(1-男, 2-女)
     */
    private Integer consigneeGender;

    /**
     * 收货地址
     */
    private String consigneeAddress;

    /**
     * 物流公司
     */
    private String expressCompany;

    /**
     * 物流单号
     */
    private String expressNumber;

    private Boolean isDeleted;

    /**
     * 创建时间
     */
    private LocalDateTime createTime;

    private Long createBy;

    /**
     * 修改时间
     */
    private LocalDateTime updateTime;

    private Long updateBy;


}
