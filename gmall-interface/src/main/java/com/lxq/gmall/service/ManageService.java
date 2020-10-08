package com.lxq.gmall.service;

import com.lxq.gmall.bean.*;

import java.util.List;

public interface ManageService {

    /**
     * 获取所有的第一级分类数据
     * @return
     */
    List<BaseCatalog1> getBaseCatalog1();


    /**
     * 获取所有的第二级分类数据
     * @return
     */
    List<BaseCatalog2> getBaseCatalog2(String catalog1);



    /**
     * 获取所有的第三级分类数据
     * @return
     */
    List<BaseCatalog3> getBaseCatalog3(String catalog2);

    /**
     * 根据三级查询平台属性集合
     * @param catalog3Id
     * @return
     */
    List<BaseAttrInfo> getAttrList(String catalog3Id);

    /***
     * 根据平台属性id获取AttrValue
     * @param attrId
     * @return
     */
    List<BaseAttrValue> getAttrValueList(String attrId);

    /**
     * 保存前台页面传来的json数据
     * @param baseAttrInfo
     */
    void saveAttrInfo(BaseAttrInfo baseAttrInfo);

    /**
     * 根据平台属性Id查询平台属性
     * @param attrId
     * @return
     */
    BaseAttrInfo getAttrInfo(String attrId);

    /**
     *根据catalog3Id属性获取spuInfo集合
     * @param catalog3Id
     * @return
     */
    List<SpuInfo> getSpuList(String catalog3Id);

    /**
     * 根据spuInfo对象属性获取spuInfo集合
     * @param spuInfo
     * @return
     */
    List<SpuInfo> getSpuList(SpuInfo spuInfo);

    /**
     * 查询所有销售属性
     * @return
     */
    List<BaseSaleAttr> getbaseSaleAttrList();

    /**
     * 保存SpuINFO
     * @param spuInfo
     */
    void saveSpuInfo(SpuInfo spuInfo);

    /**
     * 得到image  list
     * @param spuImage
     * @return
     */
    List<SpuImage> getSpuImageList(SpuImage spuImage);

    /**
     * 根据spuid获取销售属性集合
     * @param spuid
     * @return
     */
    List<SpuSaleAttr> getSpuSaleAttrList(String spuid);

    /**
     * 根据SkuInfo保存信息
     * @param skuInfo
     */
    void saveSkuInfo(SkuInfo skuInfo);

    /**
     * 获取skuInfo
     * @param skuId
     * @return
     */
    SkuInfo getSkuInfo(String skuId);

    /**
     * 根据id获取去imageList
     * @param id
     * @return
     */
    List<SkuImage> getSkuImage(String id);

    /**
     * 根据skuid和spuId查询销售属性值
     * @param skuInfo
     * @return
     */
    List<SpuSaleAttr> getSpuSaleAttrListCheckBySku(SkuInfo skuInfo);

    /**
     * 根据spuId查询销售属性值
     * @param spuId
     * @return
     */
    List<SkuSaleAttrValue> getSkuSaleAttrValueListBySpu(String spuId);
}
