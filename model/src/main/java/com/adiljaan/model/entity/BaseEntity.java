package com.adiljaan.model.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;

import java.io.Serializable;
import java.util.Date;

public class BaseEntity implements Serializable {

    @TableId(value = "id")
    private Long id;

    @TableField(value = "is_deleted")
    private byte isDeleted;

    @TableField(value = "create_time")
    private Date createTime;

    @TableField(value = "update_time")
    private Date updateTime;
}