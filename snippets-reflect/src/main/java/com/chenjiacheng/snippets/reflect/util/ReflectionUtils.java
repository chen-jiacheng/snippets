package com.chenjiacheng.snippets.reflect.util;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;

public class ReflectionUtils {

    /**
     * 获取包下所有的类
     *
     * @param packageName 包名
     * @return 类的列表
     */
    public static List<Class<?>> getClasses(String packageName) {
        return getClasses(packageName,false);
    }

    /**
     * 获取包下所有的类
     *
     * @param packageName 包名
     * @param deepSearch 递归查找
     * @return 类的列表
     */
    public static List<Class<?>> getClasses(String packageName,boolean deepSearch) {
        List<Class<?>> classes = new ArrayList<>();
        String path = packageName.replace('.', '/');
        Enumeration<URL> resources;
        try {
            resources = Thread.currentThread().getContextClassLoader().getResources(path);
            while (resources.hasMoreElements()) {
                URL resource = resources.nextElement();
                String filePath = resource.getFile();
                classes.addAll(findClasses(packageName, new File(filePath),deepSearch));
            }
        } catch (IOException e) {
            e.printStackTrace();
            // Handle the exception
        }
        return classes;
    }

    /**
     * 递归搜索指定目录下的所有类
     *
     * @param packageName 包名
     * @param directory   目录
     * @return 类的列表
     */
    private static List<Class<?>> findClasses(String packageName, File directory,boolean deepSearch) {
        List<Class<?>> classes = new ArrayList<>();
        if (directory.exists()) {
            File[] files = directory.listFiles();
            for (File file : files) {
                if (file.isDirectory()) {
                    if(deepSearch){
                        classes.addAll(findClasses(packageName + "." + file.getName(), file,deepSearch));
                    }else {
                        continue;
                    }
                } else {
                    if (file.getName().endsWith(".class")) {
                        try {
                            Class<?> clazz = Class.forName(packageName + "." + file.getName().substring(0, file.getName().length() - 6));
                            classes.add(clazz);
                        } catch (ClassNotFoundException e) {
                            e.printStackTrace();
                            // Handle the exception
                        }
                    }
                }
            }
        }
        return classes;
    }

    public static void main(String[] args) {
        // 测试代码，获取指定包下的所有类
        String packageName = "com.chenjiacheng.snippets.reflect"; // 请替换为你的包名
        List<Class<?>> classList = getClasses(packageName,true);
        for (Class<?> clazz : classList) {
            System.out.println(clazz.getName());
        }
    }
}