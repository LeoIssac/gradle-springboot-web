package pers.gradle.service;

import pers.gradle.model.User;

import java.util.List;

/**
 * 用户信息service
 * @author Leo
 * @date 10:37 2019/5/22
**/
public interface UserService {
    /**
     * getUserList() 获取User列表
     * @author Leo
     * @date 10:27 2019/5/22
     * @return java.util.List<pers.gradle.model.User>
    **/
    List<User> getUserList();
}
