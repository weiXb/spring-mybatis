package cn.wxb.service;

import cn.wxb.domain.User;
import cn.wxb.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class UserService {

    @Autowired
    private UserMapper userMapper;

//    @Transactional
    public void testTrans() throws Exception {
        User user = new User();
        user.setName("ceshi");
        userMapper.insertUser(user);
        throw new RuntimeException("测试异常");
    }
}
