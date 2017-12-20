package cn.wxb.service;

import cn.wxb.domain.User;
import cn.wxb.mapper.LogMapper;
import cn.wxb.mapper.UserInterfaceMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserService {
    //    @Autowired
//    UserMapper userMapper;
    @Autowired
    UserInterfaceMapper userInterfaceMapper;
    @Autowired
    LogMapper logMapper;

    /*public User getUser(String id) {
        return userMapper.getUser(id);
    }

    @Transactional
    public void insertUser() throws Exception {
        User user = new User();
        user.setName("ceshi");
        userMapper.insertUser(user);
        throw new RuntimeException("测试错误");
    }*/

    @Transactional
    public void insertMulti() throws Exception {
        User user = new User();
        user.setName("ceshi");
        insertYKC(user);
        insertXX(user);
        throw new RuntimeException("测试多数据库错误");
    }

    public void insertXX(User user) {
        userInterfaceMapper.insertUser(user);
    }

    public void insertYKC(User user) {
        logMapper.insertLog(user);
    }

}
