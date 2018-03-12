package cn.mn;

import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.config.*;
import com.baomidou.mybatisplus.generator.config.rules.DbType;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;
import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * code generator
 * read templates from /resources/template
 */
public class CodeSimpleGenerator {

    private static List<String> tables = new ArrayList<>();

    private static void input() {
        while (true) {
            System.out.println("[please input : y or yes]");
            Scanner scan = new Scanner(System.in);
            String read = scan.nextLine();
            if ("yes".equalsIgnoreCase(read) || "y".equalsIgnoreCase(read)) {
                return;
            }
        }

    }
    /**
     * MySQL generator
     * input y or yes in console to continue
     */
    public static void main(String[] args) {
        input();
        // name on the doc
        String name = "menfajin";
        // db config
        String driverName = "com.mysql.jdbc.Driver";
        String userName = "men";
        String password = "@Men941204";
        String url = "jdbc:mysql://39.106.129.123/MN?useUnicode=true";

        // parent package
        String parentPackage = "cn.mn.information";

        // tables to generate
        tables.add("information");
        tables.add("information_file");
        tables.add("information_label");
        tables.add("information_label_relation");
        tables.add("information_type_relation");

        // generate files without the prefix
        String ignorePrefix = "";


        boolean entity = true;
        boolean xml = true;
        boolean dao = true;
        boolean service = true;
        boolean controller = true;

        boolean createBaseResultMap = true;


        // ---------------- start generator -----------------
        if(tables.isEmpty()){
            System.out.println("[not table]");
        }
        AutoGenerator mpg = new AutoGenerator();
        String path = System.getProperty("user.dir");
        path = path + "/src/main/java";

        // 全局配置
        GlobalConfig gc = new GlobalConfig();
        gc.setOutputDir(path);
        gc.setFileOverride(true);
        gc.setActiveRecord(false);
        gc.setEnableCache(false);
        gc.setBaseResultMap(createBaseResultMap);
        gc.setBaseColumnList(true);
        gc.setAuthor(name);
        gc.setOpen(false);
        gc.setServiceName("%sService");
        mpg.setGlobalConfig(gc);
        // 数据源配置
        DataSourceConfig dsc = new DataSourceConfig();
        dsc.setDbType(DbType.MYSQL);
        dsc.setDriverName(driverName);
        dsc.setUsername(userName);
        dsc.setPassword(password);
        dsc.setUrl(url);
        mpg.setDataSource(dsc);
        // 策略配置
        StrategyConfig strategy = new StrategyConfig();
        strategy.setNaming(NamingStrategy.underline_to_camel);// 表名生成策略
        strategy.setRestControllerStyle(true);
        strategy.setEntityLombokModel(true);
        strategy.setInclude(tables.stream().toArray(String[]::new)); // 需要生成的表
        if(StringUtils.isNotBlank(ignorePrefix)) {
            strategy.setTablePrefix(new String[]{ignorePrefix});
        }
         /*strategy.setSuperServiceClass("com.test.demo.TestService");
        // 自定义 service 实现类父类
         strategy.setSuperServiceImplClass("com.test.demo.TestServiceImpl");
        // 自定义 controller 父类
         strategy.setSuperControllerClass("com.test.demo.TestController");*/
        mpg.setStrategy(strategy);

        // 包配置
        PackageConfig pc = new PackageConfig();
        pc.setParent(parentPackage);
        pc.setController("controller");
        pc.setMapper("dao");
        pc.setXml("mapper");
        pc.setEntity("entity");
        mpg.setPackageInfo(pc);

        TemplateConfig tc = new TemplateConfig();
        tc.setController("/template/simple/controller.java.vm");
        tc.setEntity("/template/simple/entity.java.vm");
        tc.setMapper("/template/simple/mapper.java.vm");
        tc.setXml("/template/simple/mapper.xml.vm");
        tc.setService("/template/simple/service.java.vm");

        if(!entity){
            tc.setEntity(null);
        }
           if(!controller)
            tc.setController(null);
        if(!dao)
            tc.setMapper(null);
        if(!xml)
            tc.setXml(null);
        if(!service)
            tc.setService(null);

        tc.setServiceImpl(null);
        mpg.setTemplate(tc);
        // 执行生成
        mpg.execute();
        System.out.println("[generate success]");
    }

}