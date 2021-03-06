package com.lxq.gmall.manage.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.lxq.gmall.bean.SkuInfo;
import com.lxq.gmall.bean.SpuImage;
import com.lxq.gmall.bean.SpuSaleAttr;
import com.lxq.gmall.service.ManageService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin
public class SkuManageController {

    @Reference
    private ManageService manageService;

    //spuImageList?spuId=58
    @RequestMapping("spuImageList")
    public List<SpuImage> spuImageList(SpuImage spuImage){
        return  manageService.getSpuImageList(spuImage);
    }

    @RequestMapping("spuSaleAttrList")
    public List<SpuSaleAttr> spuSaleAttrList(String spuId){
        //调用Service层
        return manageService.getSpuSaleAttrList(spuId);
    }
    @RequestMapping("saveSkuInfo")
    public  void saveSkuInfo(@RequestBody SkuInfo skuInfo){
        if(skuInfo != null){
            manageService.saveSkuInfo(skuInfo);
        }
    }



}
