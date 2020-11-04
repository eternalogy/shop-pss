package com.vin.pss.provider.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import lombok.Data;

/**
 * biz_stock_modify_record
 * @author
 */
@Data
public class StockModifyRecord implements Serializable {
    private Integer id;

    private String productBarCode;

    private Integer operatorId;

    private Integer modifyCount;

    private String modifyType;

    private Date createTime;

    private Date updateTime;

    private Integer deleted;

    private List<Product> products;

    private List<Category> categories;

    private static final long serialVersionUID = 1L;
}
