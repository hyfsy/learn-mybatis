package com.hyf.mybatis.plugin;

import org.apache.ibatis.executor.resultset.ResultSetHandler;
import org.apache.ibatis.executor.statement.StatementHandler;
import org.apache.ibatis.plugin.*;

import java.sql.Connection;
import java.sql.Statement;
import java.util.Properties;
@Intercepts({@Signature(type = StatementHandler.class, method = "prepare", args = {Connection.class, Integer.class})})

//@Intercepts({@Signature(type = ResultSetHandler.class, method = "handleResultSets", args = {Statement.class})})
public class TestInterceptor implements Interceptor {

    @Override
    public Object intercept(Invocation invocation) throws Throwable {
        System.out.println("TestInterceptor invocation执行前...");
        Object proceed = invocation.proceed();
        System.out.println("TestInterceptor invocation执行后...");
        return proceed;
    }

    @Override
    public Object plugin(Object target) {
        System.out.println("TestInterceptor plugin 执行前......");
        Object wrap = Plugin.wrap(target, this);
        System.out.println("TestInterceptor 返回包装后的对象......");
        return wrap;
    }

    @Override
    public void setProperties(Properties properties) {
        System.out.println("TestInterceptor 设置properties: " + properties);
    }
}
