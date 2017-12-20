package cn.wxb.mapper;

import cn.wxb.aop.DataSource;
import cn.wxb.domain.User;
import cn.wxb.dynamic.SourcesEnum;
import org.springframework.stereotype.Repository;

@Repository
public interface UserMapper {

    @DataSource(SourcesEnum.read)
    User getUser(String id);

    void insertUser(User user);

    @DataSource(SourcesEnum.write)
    User getLog(String id);

    @DataSource(SourcesEnum.write)
    void insertLog(User user);
}
