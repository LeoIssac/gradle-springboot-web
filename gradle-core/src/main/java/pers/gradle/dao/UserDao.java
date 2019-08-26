package pers.gradle.dao;

import org.springframework.stereotype.Repository;
import pers.gradle.model.User;

import java.util.List;

/**
 * 用户信息dao
 * @author Leo
 * @date 13:25 2019/5/22
**/
@Repository
public interface UserDao {
    /**
     * getUserList() 获取用户信息列表
     * @author Leo
     * @date  2019/5/22
     * @return java.util.List<pers.gradle.model.User>
     **/
    List<User> getUserList();
}
