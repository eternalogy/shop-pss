package com.vin.pss.provider.model;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * biz_supplier
 * @author
 */
@Data
public class Supplier implements Serializable {
    private Integer id;

    private String supplierName;

    private String contactsName;

    private String tel;

    private String address;

    private Date createTime;

    private Date updateTime;

    private Integer deleted;

    private static final long serialVersionUID = 1L;
}
