package com.lxq.gmall.manage.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.lxq.gmall.bean.*;
import com.lxq.gmall.service.ManageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@CrossOrigin
public class ManagerController {

    @Reference
    private ManageService manageService;

    @RequestMapping("getCatalog1")
    @ResponseBody
    public List<BaseCatalog1> getCatalog1(){
        return manageService.getBaseCatalog1();
    }


    @RequestMapping("getCatalog2")
    @ResponseBody
    public List<BaseCatalog2> getCatalog2(String catalog1Id){
        return manageService.getBaseCatalog2(catalog1Id);
    }

    @RequestMapping("getCatalog3")
    @ResponseBody
    public List<BaseCatalog3> getCatalog3(String catalog2Id){
        return manageService.getBaseCatalog3(catalog2Id);
    }


    @RequestMapping("attrInfoList")
    @ResponseBody
    public List<BaseAttrInfo> attrInfoList(String catalog3Id){
        return manageService.getAttrList(catalog3Id);
    }

//    getAttrValueList?attrId=23
    @RequestMapping("getAttrValueList")
    @ResponseBody
    public List<BaseAttrValue> getAttrValueList(String attrId) {
        //先通过attrId查询平台属性
        BaseAttrInfo baseAttrInfo =  manageService.getAttrInfo(attrId);
        //返回平台属性中的平台属性值集合
        //select * from baseAttrValue where attrId = ?
        return baseAttrInfo.getAttrValueList();
    }


    //saveAttrInfo
    @RequestMapping("saveAttrInfo")
    @ResponseBody
    public  void saveAttrInfo(@RequestBody BaseAttrInfo baseAttrInfo){
         manageService.saveAttrInfo(baseAttrInfo);
    }


    //http://localhost:8082/baseSaleAttrList
    @RequestMapping("baseSaleAttrList")
    @ResponseBody
    public List<BaseSaleAttr> baseSaleAttrList(){
        return  manageService.getbaseSaleAttrList();
    }


}
