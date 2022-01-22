package com.hyf.mybatis.config;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.boot.autoconfigure.ConfigurationCustomizer;
import org.mybatis.spring.boot.autoconfigure.SpringBootVFS;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

/**
 * @author baB_hyf
 * @date 2022/01/22
 */
@Configuration
public class MyBatisConfiguration {

    @Bean
    public ConfigurationCustomizer customerConfiguration() {
        return new ConfigurationCustomizer() {
            @Override
            public void customize(org.apache.ibatis.session.Configuration configuration) {
                // xxx
            }
        };
    }

    @Bean
    public SqlSessionFactory sqlSessionFactory(DataSource dataSource) throws Exception {
        SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();

        // 指定动态数据源的情况
        sqlSessionFactoryBean.setDataSource(dataSource);

        // SpringBoot executable jar need to use this VFS
        sqlSessionFactoryBean.setVfs(SpringBootVFS.class);

        return sqlSessionFactoryBean.getObject();
    }

    // 扫描其他组件

    // Interceptor
    // TypeHandler
    // LanguageDriver
    // VendorDatabaseIdProvider
}
