package com.vin.pss.provider.model;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * sys_user
 * @author Vincent Chiu
 */
@Data
public class User implements Serializable {
    private Integer id;

    private Integer roleId;

    private String userName;

    private String loginAccount;

    private String password;

    private String tel;

    private String wxAccount;

    private String idNo;

    private String address;

    private Date createTime;

    private Date updateTime;

    private Integer deleted;

    private Role role;

    private static final long serialVersionUID = 1L;
}
