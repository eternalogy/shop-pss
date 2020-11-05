package com.vin.pss.provider.model;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * biz_category
 * @author Vincent Chiu
 */
@Data
public class Category implements Serializable {
    private Integer id;

    private String categoryName;

    private Date createTime;

    private Date updateTime;

    private Integer deleted;

    private static final long serialVersionUID = 1L;
}
