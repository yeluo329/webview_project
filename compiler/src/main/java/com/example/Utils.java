package com.example;

import java.io.File;

public class Utils {
    public static String getClassFilePath(Class clazz) {
        // 获得绝对路径
        String buildDir = clazz.getProtectionDomain().getCodeSource().getLocation().getFile();
        String fileName = clazz.getSimpleName() + ".class";
        File file = new File(buildDir + clazz.getPackage().getName().replaceAll("[.]", "/") + "/", fileName);
        return file.getAbsolutePath();
    }



}
