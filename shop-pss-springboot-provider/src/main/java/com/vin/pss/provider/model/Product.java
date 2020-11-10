package com.vin.pss.provider.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import lombok.Data;

/**
 * biz_product
 * @author Vincent Chiu
 */
@Data
public class Product implements Serializable {
    private Integer id;

    private String barCode;

    private Integer supplierId;

    private Integer categoryId;

    private String productName;

    private BigDecimal salePrice;
    
    private String netContent;

    private String placeOfOrigin;

    private String storageCondition;

    private Date createTime;

    private Date updateTime;

    private Integer deleted;

    private Category category;

    private Supplier supplier;

    private static final long serialVersionUID = 1L;
}
