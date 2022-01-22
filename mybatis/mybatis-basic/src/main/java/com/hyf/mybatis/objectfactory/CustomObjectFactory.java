package com.hyf.mybatis.objectfactory;

import org.apache.ibatis.reflection.factory.DefaultObjectFactory;

import java.util.Collection;
import java.util.List;
import java.util.Properties;

/**
 * 自定义对象工厂
 */
public class CustomObjectFactory extends DefaultObjectFactory {

    @Override
    public void setProperties(Properties properties) {
        super.setProperties(properties);
    }

    /**
     * 无参构造函数创建对象
     *
     * @param type
     * @param <T>
     * @return
     */
    @Override
    public <T> T create(Class<T> type) {
        return super.create(type);
    }

    /**
     * 有参构造函数创建对象
     *
     * @param type
     * @param constructorArgTypes
     * @param constructorArgs
     * @param <T>
     * @return
     */
    @Override
    public <T> T create(Class<T> type, List<Class<?>> constructorArgTypes, List<Object> constructorArgs) {
        return super.create(type, constructorArgTypes, constructorArgs);
    }

    /**
     * 判断是否为集合类型
     *
     * @param type
     * @param <T>
     * @return
     */
    @Override
    public <T> boolean isCollection(Class<T> type) {
        return Collection.class.isAssignableFrom(type);
    }
}
