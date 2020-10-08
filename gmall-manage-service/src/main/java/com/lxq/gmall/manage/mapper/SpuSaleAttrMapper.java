package com.lxq.gmall.manage.mapper;

import com.lxq.gmall.bean.SpuSaleAttr;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

public interface SpuSaleAttrMapper extends Mapper<SpuSaleAttr> {

    /**
     * 根据销售属性id自动查处难销售属性集合
     * 需要使用mapper.xml
     * @param spuid
     * @return
     */
    List<SpuSaleAttr> selectAttrList(String spuid);

    /**
     *
     * @param skuId
     * @param spuId
     * @return
     */
    List<SpuSaleAttr> selectSpuAttrListCheckBySku(String skuId, String spuId);


}
