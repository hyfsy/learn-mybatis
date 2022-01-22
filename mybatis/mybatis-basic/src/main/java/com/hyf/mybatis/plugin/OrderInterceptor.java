package com.hyf.mybatis.plugin;

import org.apache.ibatis.executor.statement.StatementHandler;
import org.apache.ibatis.plugin.*;

import java.sql.Connection;
import java.util.Properties;

/**
 * # @Intercepts注解用来注册多个拦截方法
 * # @Signature注解用来指定四大对象中的某一个方法
 *          type 指定拦截哪一个对象
 *          method 字符串，指定拦截对象的哪个方法
 *          args 指定方法的参数类型，确定拦截对象的哪个方法
 */
@Intercepts({@Signature(type = StatementHandler.class, method = "prepare", args = {Connection.class, Integer.class})})
public class OrderInterceptor implements Interceptor {

    /**
     * 在方法执行前后进行一些操作
     *
     * @param invocation 内部有代理对象，方法，参数
     * @return invocation对象调用内部方法返回的结果
     * @throws Throwable
     */
    @Override
    public Object intercept(Invocation invocation) throws Throwable {
        System.out.println("OrderInterceptor 执行 intercept方法前输出......");
        Object proceed = invocation.proceed();
        System.out.println("OrderInterceptor 执行 intercept方法后输出......");
        return proceed;
    }

    /**
     * 通过动态代理进一步包装对象，才能调用到上面的方法
     *
     * @param target （动态代理/普通）包装对象
     * @return （代理）四大对象的代理对象
     */
    @Override
    public Object plugin(Object target) {
        System.out.println("OrderInterceptor 返回包装对象前.....");
        Object wrap = Plugin.wrap(target, this);
        System.out.println("OrderInterceptor 返回包装对象后.....");
        return wrap;
    }

    /**
     * 可用来增加插件的属性
     *
     * @param properties 有plugin标签中自定义的属性的属性对象 或一个空的Properties对象
     */
    @Override
    public void setProperties(Properties properties) {
        System.out.println("\n当前插件的所有属性：" + properties);
    }

}
