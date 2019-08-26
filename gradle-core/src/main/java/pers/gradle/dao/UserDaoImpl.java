package pers.gradle.dao;

import org.springframework.stereotype.Component;
import pers.gradle.model.User;

import java.util.ArrayList;
import java.util.List;

/**
 * 用户信息dao实现类
 * @author Leo
 * @date 13:23 2019/5/22
 * @param
 * @return
**/
@Component
public class UserDaoImpl implements UserDao {


    @Override
    public List<User> getUserList() {
        List<User> userList=new ArrayList<>();
        User userZs=new User().setId(1L).setName("张三").setAge(18);
        userList.add(userZs);
        User userLs=new User().setId(2L).setName("李四").setAge(20);
        userList.add(userLs);
        User userWw=new User().setId(3L).setName("王五").setAge(30);
        userList.add(userWw);
        return userList;
    }
}
