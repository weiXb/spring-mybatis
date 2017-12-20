package cn.wxb.aop;

import cn.wxb.dynamic.DynamicDataSourceHolder;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

@Aspect
@Component
@Order(1)
public class DataSourceAop {

    /**
     * 用在userMapper接口上会失效，service上正常
     *
     * @param dataSource
     */
    @Before("@annotation(dataSource)")
    public void beforeMethod(DataSource dataSource) {
        DynamicDataSourceHolder.setDatasource(dataSource.value());
    }

    /**
     * 通用
     *
     * @param joinPoint
     */
    @Before("execution(* cn.wxb.mapper..*.*(..))")
    public void beforeMethod2(JoinPoint joinPoint) {
        MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();
        Method method = methodSignature.getMethod();
        DataSource dataSource = method.getAnnotation(DataSource.class);
        if (null == dataSource) return;
        DynamicDataSourceHolder.setDatasource(dataSource.value());

    }
}
