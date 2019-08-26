package pers.gradle.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pers.gradle.dao.UserDao;
import pers.gradle.model.User;

import java.util.List;

/**
 * 用户信息service实现
 * @author Leo
 * @date 13:25 2019/5/22
**/
@Service("userService")
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;
    @Override
    public List<User> getUserList() {
        return userDao.getUserList();
    }
}
