package com.lxq.gmall.service;

import com.lxq.gmall.bean.UserAddress;
import com.lxq.gmall.bean.UserInfo;

import java.util.List;

public interface UserService {
    /**
     * 查询所有数据
     * @return
     */
    List<UserInfo> findAll();

    /**
     * 根据用户id查询用户地址
     * @param userId
     * @return
     */
    List<UserAddress> getUserAddressList(String userId);
}
