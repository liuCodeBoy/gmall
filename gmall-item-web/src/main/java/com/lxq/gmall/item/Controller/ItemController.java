package com.lxq.gmall.item.Controller;


import com.alibaba.dubbo.config.annotation.Reference;
import com.alibaba.fastjson.JSON;
import com.lxq.gmall.bean.SkuImage;
import com.lxq.gmall.bean.SkuInfo;
import com.lxq.gmall.bean.SkuSaleAttrValue;
import com.lxq.gmall.bean.SpuSaleAttr;
import com.lxq.gmall.service.ManageService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.sound.midi.Soundbank;
import java.util.HashMap;
import java.util.List;

@Controller
public class ItemController {
    @Reference
    private ManageService manageService;

    //控制器
    @RequestMapping("{skuId}.html")
    public String item(@PathVariable String skuId, HttpServletRequest request){
        //根据skuId获取数据
        SkuInfo skuInfo  = manageService.getSkuInfo(skuId);

        //显示图片列表
        List<SkuImage> skuImageList = manageService.getSkuImage(skuInfo.getId());

        //查询销售属性和销售属性值
        List<SpuSaleAttr> spuSaleAttrList = manageService.getSpuSaleAttrListCheckBySku(skuInfo);
        //获取销售属性值ID
        List<SkuSaleAttrValue> skuSaleAttrValueList =  manageService.getSkuSaleAttrValueListBySpu(skuInfo.getSpuId());
        //遍历集合拼接字符串
        String key = "";
        HashMap<String,Object> map = new HashMap<>();
        for (int i=0; i<skuSaleAttrValueList.size();i++) {
            SkuSaleAttrValue skuSaleAttrValue = skuSaleAttrValueList.get(i);
            if (key.length() > 0){
                key += "|";
            }
            key += skuSaleAttrValue.getSaleAttrValueId();
            if(i == skuSaleAttrValueList.size() -1 || !skuSaleAttrValue.getSkuId().equals(skuSaleAttrValueList.get(i+1).getSkuId())){
                map.put(key,skuSaleAttrValue.getSkuId());
                key = "";
            }
        }
        //将map转换成字符串
        String valuesSkuJson = JSON.toJSONString(map);
        System.out.println("拼接Json="+valuesSkuJson);
        //保存到作用域
        request.setAttribute("valuesSkuJson",valuesSkuJson);
        request.setAttribute("skuInfo",skuInfo);
        request.setAttribute("spuSaleAttrList",spuSaleAttrList);
        return "item";
    }
}
