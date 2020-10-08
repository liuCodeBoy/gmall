package com.lxq.gmall.order.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.lxq.gmall.bean.UserAddress;
import com.lxq.gmall.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class OrderController {

    @Reference
    private UserService service;

    //htttp
    @RequestMapping("trade")
    @ResponseBody //第一个返回json字符串，底层调用fastJson 第二直接将数据显示到页面上
    public List<UserAddress> trade(String userId){
        //返回一个视图名称为index.html
        return service.getUserAddressList(userId);
    }
}
