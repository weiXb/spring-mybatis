package cn.wxb.mapper;

import cn.wxb.domain.User;
import org.springframework.stereotype.Repository;

public interface LogMapper {

    void insertLog(User user);
}
