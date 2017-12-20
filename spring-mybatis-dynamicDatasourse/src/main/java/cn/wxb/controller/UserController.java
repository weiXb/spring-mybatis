package cn.wxb.controller;

import cn.wxb.domain.User;
import cn.wxb.mapper.UserMapper;
import cn.wxb.service.UserService;
import com.google.common.collect.Lists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController {
    @Autowired
    UserService userService;
    @Autowired
    UserMapper userMapper;

    /*@RequestMapping("/get/{id}")
    public User getUser(@PathVariable String id) {
        return userService.getUser(id);
    }

    @RequestMapping("/insert")
    public void insertUser() {
        try {
            userService.insertUser();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }*/

    @RequestMapping("/insertMulti")
    public void insertMulti() {
        try {
            userService.insertMulti();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @RequestMapping("/getLog/{id}")
    public User getLog(@PathVariable String id) {
        return userMapper.getLog(id);
    }

    @RequestMapping("/getList")
    public List<User> getList() {
        List<User> list = Lists.newArrayList();
        list.add(userMapper.getUser("1"));
        list.add(userMapper.getLog("248744811367104512"));
        return list;
    }
}
