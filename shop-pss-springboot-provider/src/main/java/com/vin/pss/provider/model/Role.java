package com.vin.pss.provider.model;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * sys_role
 * @author Vincent Chiu
 */
@Data
public class Role implements Serializable {
    private Integer id;

    private String roleName;

    private Date createTime;

    private Date updateTime;

    private Boolean deleted;

    private static final long serialVersionUID = 1L;
}