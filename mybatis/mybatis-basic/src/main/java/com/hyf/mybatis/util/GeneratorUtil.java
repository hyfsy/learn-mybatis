package com.hyf.mybatis.util;

import org.junit.jupiter.api.Test;
import org.mybatis.generator.api.MyBatisGenerator;
import org.mybatis.generator.config.Configuration;
import org.mybatis.generator.config.xml.ConfigurationParser;
import org.mybatis.generator.internal.DefaultShellCallback;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class GeneratorUtil {

    @Test
    public void testGenerate () {
        // 路径必须要全路径
        new GeneratorUtil().generate("e:/study/idea2/learn-mybatis/src/main/resources/conf/generator.xml",true);
    }

    /**
     * 逆向工程生成文件，前提要引入 generator-core包
     *
     * @param path
     * @param overwrite
     */
    public void generate(String path, boolean overwrite) {

        // 存放文件生成的警告相关信息
        List<String> warnings = new ArrayList<>();
        File file = new File(path);

        ConfigurationParser parser = new ConfigurationParser(warnings);
        try {
            Configuration config = parser.parseConfiguration(file);
            // 是否覆盖原本的文件
            DefaultShellCallback callback = new DefaultShellCallback(overwrite);
            MyBatisGenerator generator = new MyBatisGenerator(config, callback, warnings);
            // 生成文件
            generator.generate(null);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
