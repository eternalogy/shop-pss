package com.vin.pss.provider.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import lombok.Data;

/**
 * biz_stock
 * @author
 */
@Data
public class Stock implements Serializable {
    private String productBarCode;

    private Integer stockCount;

    private Date createTime;

    private Date updateTime;

    private Integer deleted;

    private String lockKey;

    private List<Product> products;

    private List<Category> categories;

    private List<Supplier> suppliers;

    private static final long serialVersionUID = 1L;
}
