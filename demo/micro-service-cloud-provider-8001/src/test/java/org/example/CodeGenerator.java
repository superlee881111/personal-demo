package org.example;

import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.config.GlobalConfig;
import org.junit.Test;

/**
 * @description: CodeGenerator
 * @Date: 2024/05/10
 * @author: lichao
 * @version: 1.0
 */
public class CodeGenerator {

    @Test
    public void run() {

//        //  1、创建代码生成器
//        AutoGenerator mpg = new AutoGenerator();
//        // 2、全局配置
//        GlobalConfig gc = new GlobalConfig();
//        //获取当前项目的路径
//        String projectPath = System.getProperty("user.dir");
//        //拼接代码生成以后存放的目录
//        gc.setOutputDir(projectPath + "/src/main/java");
//        gc.setAuthor("lichao");
//        //生成后是否打开资源管理器
//        gc.setOpen(false);
//        //重新生成时文件是否覆盖
//        gc.setFileOverride(true);
//        //去掉Service接口的首字母I
//        gc.setServiceName("%sService");
//        //主键策略
//        gc.setIdType(IdType.AUTO);
//        //定义生成的实体类中日期类型
//        gc.setDateType(DateType.ONLY_DATE);
//        //开启Swagger2模式
//        gc.setSwagger2(true);
//        mpg.setGlobalConfig(gc);
//
//        // 3、数据源配置
//        DataSourceConfig dsc = new DataSourceConfig();
//        dsc.setUrl("jdbc:postgresql://192.168.10.81:5432/springboot8001");
//        dsc.setDriverName("org.postgresql.Driver");
//        dsc.setUsername("postgres");
//        dsc.setPassword("postgres");
//        dsc.setDbType(DbType.POSTGRE_SQL);
//        mpg.setDataSource(dsc);
//
//        // 4、包配置
//        PackageConfig pc = new PackageConfig();
//        pc.setParent("org.example.dept");
//        //pc.setModuleName("user"); //模块名,多模块开发,或者微服务模块使用,也可以配置接口版本号,例如:v1
//        pc.setController("controller");
//        pc.setEntity("entity");
//        pc.setService("service");
//        pc.setMapper("mapper");
//        mpg.setPackageInfo(pc);
//
//        // 5、策略配置
//        StrategyConfig strategy = new StrategyConfig();
//        //需要逆向的表名
//        strategy.setInclude("dept");
//        strategy.setNaming(NamingStrategy.underline_to_camel);//数据库表映射到实体的命名策略
//        //strategy.setTablePrefix(pc.getModuleName() + "_"); //生成实体时去掉表前缀
//        strategy.setColumnNaming(NamingStrategy.underline_to_camel);//数据库表字段映射到实体的命名策略
//        strategy.setEntityLombokModel(true); // lombok 模型 @Accessors(chain = true) setter链式操作
//        strategy.setRestControllerStyle(true); //restful api风格控制器
//        strategy.setControllerMappingHyphenStyle(true); //url中驼峰转连字符
//        mpg.setStrategy(strategy);
//
//
//        // 6、执行
//        mpg.execute();
    }
}
