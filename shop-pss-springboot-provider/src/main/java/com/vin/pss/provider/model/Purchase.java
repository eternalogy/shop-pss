package com.vin.pss.provider.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import lombok.Data;

/**
 * biz_purchase
 * @author Vincent Chiu
 */
@Data
public class Purchase implements Serializable {
    private Integer id;

    private Integer productId;

    private Date purchaseDate;

    private Date proDate;

    private Date expDate;

    private BigDecimal purchasePrice;

    private Integer purchaseCount;

    private BigDecimal purchaseAmount;

    private String receiptImg;

    private Date createTime;

    private Date updateTime;

    private Integer deleted;

    private List<Supplier> suppliers;

    private List<Product> products;

    private List<Category> categories;

    private static final long serialVersionUID = 1L;
}
