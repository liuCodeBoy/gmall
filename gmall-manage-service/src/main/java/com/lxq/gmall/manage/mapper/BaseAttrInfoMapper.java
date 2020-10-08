package com.lxq.gmall.manage.mapper;


import com.lxq.gmall.bean.BaseAttrInfo;
import com.lxq.gmall.bean.BaseCatalog3;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

public interface BaseAttrInfoMapper extends Mapper<BaseAttrInfo> {
    /**
     * 根据三级分类查询平台属性
     * @param catalog3Id
     * @return
     */
    List<BaseAttrInfo> getBaseAttrInfoListByCatalog3Id(String catalog3Id);
}
