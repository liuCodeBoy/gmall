package com.lxq.gmall.user.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.lxq.gmall.bean.UserAddress;
import com.lxq.gmall.bean.UserInfo;
import com.lxq.gmall.service.UserService;
import com.lxq.gmall.user.mapper.UserAddressMapper;
import com.lxq.gmall.user.mapper.UserInfoMapper;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
@Service
public class UserServiceImpl implements UserService {
     @Autowired
    private UserInfoMapper userInfoMapper;
    @Autowired
    private UserAddressMapper userAddressMapper;

    @Override
    public List<UserInfo> findAll() {
        return userInfoMapper.selectAll();
    }

    @Override
    public List<UserAddress> getUserAddressList(String userId) {
        UserAddress address = new UserAddress();
        address.setUserId(userId);
        return userAddressMapper.select(address) ;
    }
}
