package com.hy.message.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.time.LocalDateTime;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 参与活动助力
 * </p>
 *
 * @author mzq
 * @since 2021-04-22
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class OmoActiveSupportInviteParticipant implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "participant_id", type = IdType.AUTO)
    private Long participantId;

    /**
     * 助力邀请编号
     */
    private Long inviteId;

    /**
     * 助力用户编号
     */
    private Long userId;

    /**
     * 助力时间
     */
    private LocalDateTime participantTime;

    private Boolean isDeleted;

    /**
     * 创建时间
     */
    private LocalDateTime createTime;

    private Long createBy;

    private LocalDateTime updateTime;

    private Long updateBy;


}
