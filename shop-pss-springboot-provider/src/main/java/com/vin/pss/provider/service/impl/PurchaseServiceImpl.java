package com.vin.pss.provider.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.vin.pss.provider.dao.ProductDao;
import com.vin.pss.provider.dao.PurchaseDao;
import com.vin.pss.provider.dao.StockDao;
import com.vin.pss.provider.dao.StockModifyRecordDao;
import com.vin.pss.provider.model.Product;
import com.vin.pss.provider.model.Purchase;
import com.vin.pss.provider.model.Stock;
import com.vin.pss.provider.model.StockModifyRecord;
import com.vin.pss.provider.service.PurchaseService;
import lombok.extern.slf4j.Slf4j;
import org.apache.dubbo.config.annotation.DubboService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 * @Description 进货Service实现类
 * @Author Vincent Chiu
 * @Date 2020-10-21 15:21
 */
@DubboService
@Service
public class PurchaseServiceImpl implements PurchaseService {
    @Override
    public PageInfo<Purchase> getAll(Integer pageNo, Integer pageSize) {
        PageHelper.startPage(pageNo, pageSize);
        List<Purchase> purchases = purchaseDao.selectAll();
        return new PageInfo<>(purchases);
    }

    @Override
    public PageInfo<Purchase> getPurchasesByProductName(String productName, Integer pageNo, Integer pageSize) {
        PageHelper.startPage(pageNo, pageSize);
        List<Purchase> purchases = purchaseDao.selectByProductName(productName);
        return new PageInfo<>(purchases);
    }

    @Override
    public Integer addPurchase(Purchase purchase) {
        return null;
    }

    @Override
    @Transactional(rollbackFor = {Exception.class, Error.class})
    public Integer purchase(Purchase purchase, Product product) {
        try {
            //当商品条码不存在的时候
            if (productDao.selectProductByBarCode(product.getBarCode()) == null) {
                // 添加商品
                productDao.insert(product);
                // 添加完之后，通过条码查询商品信息,查出商品编号，方便写入进货信息表
                Product product1 = productDao.selectProductByBarCode(product.getBarCode());
                Integer productId = product1.getId();
                // 计算进货总金额
                BigDecimal purchaseAmount = purchase.getPurchasePrice().multiply(BigDecimal.valueOf(purchase.getPurchaseCount()));
                // 添加进货记录
                Purchase purchase1 = new Purchase();
                purchase1.setProductId(productId);
                purchase1.setPurchaseDate(purchase.getPurchaseDate());
                purchase1.setProDate(purchase.getProDate());
                purchase1.setExpDate(purchase.getExpDate());
                purchase1.setPurchasePrice(purchase.getPurchasePrice());
                purchase1.setPurchaseCount(purchase.getPurchaseCount());
                purchase1.setPurchaseAmount(purchaseAmount);
                //图片上传功能待添加
                purchase1.setReceiptImg("https://www.vincentqu.cn");
                purchaseDao.insert(purchase1);
                // 添加库存修改记录
                StockModifyRecord stockModifyRecord = new StockModifyRecord();
                stockModifyRecord.setProductBarCode(product.getBarCode());
                stockModifyRecord.setOperatorId(1);
                //库存修改数量即为进货数量
                stockModifyRecord.setModifyCount(purchase.getPurchaseCount());
                stockModifyRecord.setModifyType("进货");
                stockModifyRecordDao.insert(stockModifyRecord);
                // 因为这条商品是新的，所以要在库存表新增一条记录
                Stock stock = new Stock();
                stock.setProductBarCode(product.getBarCode());
                stock.setStockCount(purchase.getPurchaseCount());
                stockDao.insert(stock);
            } else {
                //当根据条码到数据库查询，商品已经存在的时候，执行进货操作，只需要改库存
                // 当商品条码对应的商品品类和输入的商品品类对应时，才允许添加！
                if (product.getCategoryId().equals(productDao.selectProductByBarCode(product.getBarCode()).getCategoryId())) {
                    // 根据barCode查出productId
                    Product product1 = productDao.selectProductByBarCode(product.getBarCode());
                    Integer productId = product1.getId();
                    // 计算进货总金额
                    BigDecimal purchaseAmount = purchase.getPurchasePrice().multiply(BigDecimal.valueOf(purchase.getPurchaseCount()));
                    // 添加进货记录
                    Purchase purchase1 = new Purchase();
                    purchase1.setProductId(productId);
                    purchase1.setPurchaseDate(purchase.getPurchaseDate());
                    purchase1.setProDate(purchase.getProDate());
                    purchase1.setExpDate(purchase.getExpDate());
                    purchase1.setPurchasePrice(purchase.getPurchasePrice());
                    purchase1.setPurchaseCount(purchase.getPurchaseCount());
                    purchase1.setPurchaseAmount(purchaseAmount);
                    //图片上传功能待添加
                    purchase1.setReceiptImg("https://www.vincentqu.cn");
                    purchaseDao.insert(purchase1);
                    // 添加库存修改记录
                    StockModifyRecord stockModifyRecord = new StockModifyRecord();
                    stockModifyRecord.setProductBarCode(product.getBarCode());
                    stockModifyRecord.setOperatorId(1);
                    //库存修改数量即为进货数量
                    stockModifyRecord.setModifyCount(purchase.getPurchaseCount());
                    stockModifyRecord.setModifyType("进货");
                    stockModifyRecordDao.insert(stockModifyRecord);
                    // 根据条码查出商品原来的库存数量（旧库存）
                    Integer oldStockCount = stockDao.selectByPrimaryKey(product.getBarCode()).getStockCount();
                    // 新库存数量 = 旧库存数量 + 进货数量
                    Integer newStockCount = oldStockCount + purchase.getPurchaseCount();
                    // 修改库存表，将旧库存改为新库存
                    Stock newStock = new Stock();
                    newStock.setProductBarCode(product.getBarCode());
                    newStock.setStockCount(newStockCount);
                    stockDao.updateByPrimaryKey(newStock);
                } else {
                    //如果商品条码和品类不对应，则报错
                    return 0;
                }
            }
            //提交事务
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 1;
    }

    @Autowired
    private PurchaseDao purchaseDao;
    @Autowired
    private ProductDao productDao;
    @Autowired
    private StockModifyRecordDao stockModifyRecordDao;
    @Autowired
    private StockDao stockDao;

}
