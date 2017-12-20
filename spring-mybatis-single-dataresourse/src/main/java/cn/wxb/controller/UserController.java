package cn.wxb.controller;

import cn.wxb.domain.User;
import cn.wxb.mapper.UserMapper;
import cn.wxb.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private UserService userService;


    @RequestMapping("/getUser/{id}")
    public User getUser(@PathVariable String id) {
        return userMapper.selectUser(id);
    }


    @RequestMapping("/insertUser")
    public void insertUser() {
        try {
            userService.testTrans();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
