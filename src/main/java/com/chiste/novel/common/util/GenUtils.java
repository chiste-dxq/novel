package com.chiste.novel.common.util;

import org.mybatis.generator.api.MyBatisGenerator;
import org.mybatis.generator.config.Configuration;
import org.mybatis.generator.config.xml.ConfigurationParser;
import org.mybatis.generator.exception.InvalidConfigurationException;
import org.mybatis.generator.exception.XMLParserException;
import org.mybatis.generator.internal.DefaultShellCallback;
import org.springframework.beans.factory.annotation.Value;

import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/*
 * @Author: daixq
 * @Date: 2021/4/20 9:58
 * @Description:
 **/
public class GenUtils {

    @Value("${generate.domainPackage}")
    private String domainPackage;
    @Value("${generate.mapperPackage}")
    private String mapperPackage;
    @Value("${generate.xmlPackage}")
    private String xmlPackage;
    @Value("${generate.tableName}")
    private String tableName;
    @Value("${generate.entityName}")
    private String entityName;

    private static final String mysql = "mysql";

    public static void genCode() {
        List<String> warnings = new ArrayList<String>();
        boolean overwrite = true;
        String genCfg = "/mybatis-generator/generatorConfig.xml";
        File configFile = new File(GenUtils.class.getResource(genCfg).getFile());
        ConfigurationParser cp = new ConfigurationParser(warnings);
        Configuration config = null;
        try {

            config = cp.parseConfiguration(configFile);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (XMLParserException e) {
            e.printStackTrace();
        }
//        config.getContext(mysql).getJavaModelGeneratorConfiguration().setTargetPackage(domainPackage);
//        config.getContext(mysql).getJavaClientGeneratorConfiguration().setTargetPackage(mapperPackage);
//        config.getContext(mysql).getSqlMapGeneratorConfiguration().setTargetPackage(xmlPackage);
//        config.getContext(mysql).getTableConfigurations().get(0).setTableName(tableName);
//        config.getContext(mysql).getTableConfigurations().get(0).setDomainObjectName(entityName);
        DefaultShellCallback callback = new DefaultShellCallback(overwrite);
        MyBatisGenerator myBatisGenerator = null;
        try {
            myBatisGenerator = new MyBatisGenerator(config, callback, warnings);

        } catch (InvalidConfigurationException e) {
            e.printStackTrace();
        }
        try {
            myBatisGenerator.generate(null);

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args){
        genCode();
    }
}
