package com.simple.generator.util;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.*;

import freemarker.template.Configuration;
import freemarker.template.Template;

/**
 * @program: cyhospital
 * @description: freemarker测试类
 * @author: shen tao tao
 * @create: 2020-05-26 12:43
 */
public class FreemarkerDemo {
    private static final String TEMPLATE_PATH = "E:\\hospital_server_springcloud\\cyhospital-console\\src\\main\\resources\\freemarker";
    private static final String CONTROLLER_CLASS_PATH = "E:\\hospital_server_springcloud\\cyhospital-console\\src\\main\\java\\com\\hzcytech\\console\\controller";
    private static final String SERVICE_CLASS_PATH = "E:\\hospital_server_springcloud\\cyhospital-console\\src\\main\\java\\com\\hzcytech\\console\\service";
    private static final String SERVICE_IMPL_CLASS_PATH = "E:\\hospital_server_springcloud\\cyhospital-console\\src\\main\\java\\com\\hzcytech\\console\\service\\impl";
    private static final String DAO_CLASS_PATH = "E:\\hospital_server_springcloud\\cyhospital-console\\src\\main\\java\\com\\hzcytech\\console\\dao";
    private static final String DAO_IMPL_CLASS_PATH = "E:\\hospital_server_springcloud\\cyhospital-console\\src\\main\\java\\com\\hzcytech\\console\\dao\\impl";

    private static final String CONTROLLER_URL = "com.hzcytech.console.controller";
    private static final String ENTITY_URL = "com.hzcytech.common.entity.core";
    private static final String MAPPER_URL = "com.hzcytech.console.mapper";
    private static final String SERVICE_URL = "com.hzcytech.console.service";
    private static final String SERVICE_IMPL_URL = "com.hzcytech.console.service.impl";
    private static final String DAO_URL = "com.hzcytech.console.dao";
    private static final String DAO_IMPL_URL = "com.hzcytech.console.dao.impl";


    public static void main(String[] args) {
        List<Object> list = new ArrayList<>();
        for (Object object : list) {
            createGenerator(object,CONTROLLER_URL,ENTITY_URL,MAPPER_URL,SERVICE_URL,SERVICE_IMPL_URL,DAO_URL,
                    DAO_IMPL_URL);
        }

    }

    private static void createGenerator(Object obj,String controllerUrl, String entityUrl, String mapperUrl,
                                String serviceUrl, String serviceImplUrl, String daoUrl, String daoImplUrl) {
        String entityName = obj.getClass().getName();
        int index = entityName.lastIndexOf(".");
        entityName = entityName.substring(index + 1);
        String objectName = StringUtils.toLowerCaseFirstOne(entityName);
        String createTime = DateUtils.formatDate(new Date(), "yyyy-MM-dd HH:mm:ss");
        // step3 创建数据模型
        Map<String, Object> dataMap = new HashMap<String, Object>();
        dataMap.put("entityName", entityName);
        dataMap.put("createTime", createTime);
        dataMap.put("project", "cyhospital");
        dataMap.put("version", "1.0");
        dataMap.put("author","shen tao tao");
        dataMap.put("controllerUrl",controllerUrl);
        dataMap.put("entityUrl",entityUrl);
        dataMap.put("mapperUrl",mapperUrl);
        dataMap.put("serviceUrl",serviceUrl);
        dataMap.put("serviceImplUrl",serviceImplUrl);
        dataMap.put("daoUrl",daoUrl);
        dataMap.put("daoImplUrl",daoImplUrl);
        dataMap.put("isSwagger","true");
        dataMap.put("entityComment",entityName);
        dataMap.put("objectName",objectName);
        generatorInit(dataMap,"controller");
        generatorInit(dataMap,"service");
        generatorInit(dataMap,"serviceImpl");
        generatorInit(dataMap,"dao");
        generatorInit(dataMap,"daoImpl");
    }

    private static void generatorInit(Map<String, Object> dataMap, String ftlName) {
        String entityName = (String) dataMap.get("entityName");
        String toUpperCaseFirstOneFtlName = StringUtils.toUpperCaseFirstOne(ftlName);
        // step1 创建freeMarker配置实例
        Configuration configuration = new Configuration();
        Writer out = null;
        try {
            // step2 获取模版路径
            configuration.setDirectoryForTemplateLoading(new File(TEMPLATE_PATH));
            // step3 创建数据模型

            // step4 加载模版文件
            Template template = configuration.getTemplate(ftlName + ".ftl");
            // step5 生成数据
            String filePath = getFilePath(ftlName);
            File docFile = new File(filePath + "\\" + entityName + toUpperCaseFirstOneFtlName + ".java");
            out = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(docFile)));
            // step6 输出文件
            template.process(dataMap, out);
            System.out.println("^^^^^^^^^^^^^^^^^^^^^^^^"+ entityName + toUpperCaseFirstOneFtlName + ".java 文件创建成功 !");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (null != out) {
                    out.flush();
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    private static String getFilePath(String ftlName) {
        String filePath = "";
        if ("controller".equals(ftlName)) {
            filePath = CONTROLLER_CLASS_PATH;
        } else if ("service".equals(ftlName)) {
            filePath = SERVICE_CLASS_PATH;
        } else if ("serviceImpl".equals(ftlName)) {
            filePath = SERVICE_IMPL_CLASS_PATH;
        } else if ("dao".equals(ftlName)) {
            filePath = DAO_CLASS_PATH;
        } else if ("daoImpl".equals(ftlName)) {
            filePath = DAO_IMPL_CLASS_PATH;
        } else {
            filePath = "";
        }
        return filePath;
    }
}
