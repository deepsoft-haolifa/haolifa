package com.deepsoft.haolifa.util;

import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.config.*;
import com.baomidou.mybatisplus.generator.config.converts.MySqlTypeConvert;
import com.baomidou.mybatisplus.generator.config.rules.DateType;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;
import com.baomidou.mybatisplus.generator.engine.BeetlTemplateEngine;

/**
 * @className: MysqlGenerator
 * @description:
 * @author: murphy.he
 * @date: 2019-05-20 15:28
 **/
public class MyBatisPlusGenerator {
    /**
     * <p>
     * MySQL 生成演示
     * </p>
     */
    public static void main(String[] args) {
        /* 获取 JDBC 配置文件 */
        AutoGenerator mpg = new AutoGenerator();

        // 全局配置
        GlobalConfig gc = new GlobalConfig();
        gc.setOutputDir(getOutputDir());
        gc.setFileOverride(true);
        gc.setActiveRecord(false);// 开启 activeRecord 模式
        gc.setEnableCache(false);// XML 二级缓存
        gc.setBaseResultMap(true);// XML ResultMap
        gc.setBaseColumnList(true);// XML columList
        gc.setSwagger2(true);
        gc.setAuthor(System.getProperty("user.name"));

        // 自定义文件命名，注意 %s 会自动填充表实体属性！
        gc.setMapperName("%sMapper");
        gc.setXmlName("%sMapper");
        gc.setServiceName("%sService");
        gc.setServiceImplName("%sServiceImpl");
        gc.setDateType(DateType.ONLY_DATE);
        mpg.setGlobalConfig(gc);

        // 数据源配置
        DataSourceConfig dsc = new DataSourceConfig();
        dsc.setTypeConvert(new MySqlTypeConvert());
        dsc.setUrl(
            "jdbc:mysql://47.105.36.56:3306/haolifa?useUnicode=true&characterEncoding=utf8&allowMultiQueries=true&autoReconnect=true");
        dsc.setDriverName("com.mysql.jdbc.Driver");
        dsc.setUsername("haolifa");
        dsc.setPassword("haolifa3306");
        mpg.setDataSource(dsc);

        // 策略配置
        StrategyConfig strategy = new StrategyConfig();
        // strategy.setCapitalMode(true);// 全局大写命名
        // strategy.setDbColumnUnderline(true);//全局下划线命名
//        strategy.setTablePrefix("crm_");// 此处可以修改为您的表前缀
        strategy.setNaming(NamingStrategy.underline_to_camel);// 表名生成策略

        strategy.setEntityBuilderModel(false);
        strategy.setEntityLombokModel(true);
        strategy.setRestControllerStyle(true);
        // 设置表名（多个表用逗号分割）
        strategy.setInclude("material_requisition");
        mpg.setStrategy(strategy);

        // 包配置
        PackageConfig pc = new PackageConfig();
        // 所属模块
        pc.setModuleName(null);
        // 自定义包路径，为了让 sqlMapperXml 单独生成目录设置成了 null
        pc.setParent(null);
        // 这里是控制器包名，默认 web
        pc.setService("com.deepsoft.haolifa.service");
        pc.setServiceImpl("com.deepsoft.haolifa.service.impl");
        pc.setEntity("com.deepsoft.haolifa.model.domain");
        pc.setMapper("com.deepsoft.haolifa.dao.mapper");
        pc.setXml("mapperXml");
        mpg.setPackageInfo(pc);

        mpg.setTemplateEngine(new BeetlTemplateEngine());

        // 不生成的代码
        TemplateConfig templateConfig = new TemplateConfig();
        templateConfig.setController(null);
//        templateConfig.setServiceImpl(null);
//        templateConfig.setService(null);
        // 执行生成
        mpg.setTemplate(templateConfig);
        mpg.execute();
    }


    /**
     * 生成到项目中
     *
     * @return outputDir
     */
    private static String getOutputDir() {
        return System.getProperty("user.dir") + "/gen_code";
    }

}
