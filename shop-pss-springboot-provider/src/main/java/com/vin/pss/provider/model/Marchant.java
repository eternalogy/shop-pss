package com.vin.pss.provider.model;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * biz_marchant
 * @author Vincent Chiu
 */
@Data
public class Marchant implements Serializable {
    private Integer id;

    private String merchantName;

    private String tel;

    private String address;

    private Date createTime;

    private Date updateTime;

    private Integer deleted;

    private static final long serialVersionUID = 1L;
}
