package cn.wxb.mapper;

import cn.wxb.domain.User;
import org.springframework.stereotype.Repository;

@Repository
public interface UserMapper {
    User selectUser(String id);

    void insertUser(User user);
}
