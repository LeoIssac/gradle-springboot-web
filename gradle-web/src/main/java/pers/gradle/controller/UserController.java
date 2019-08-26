package pers.gradle.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import pers.gradle.model.User;
import pers.gradle.service.UserService;

import java.util.List;

/**
 * 获取用户列表
 * @author Leo
 * @date 18:48 2019/5/22
**/
@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;
    /**
     * getUserList()
     * @author Leo
     * @date 18:49 2019/5/22
     * @param model
     * @return java.lang.String
    **/
    @RequestMapping("/list")
    public String toList(Model model){
        List<User> users=userService.getUserList();
        model.addAttribute("users",users);
        return "list";
    }
}
