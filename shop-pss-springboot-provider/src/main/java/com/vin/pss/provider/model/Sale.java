package com.vin.pss.provider.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import lombok.Data;

/**
 * biz_sale
 * @author Vincent Chiu
 */
@Data
public class Sale implements Serializable {
    private Integer id;

    private String productBarCode;

    private BigDecimal salePrice;

    private Date saleDate;

    private Integer saleCount;

    private BigDecimal saleAmount;

    private BigDecimal grossProfit;

    private Date createTime;

    private Date updateTime;

    private Integer deleted;

    private List<Product> products;

    private static final long serialVersionUID = 1L;
}
