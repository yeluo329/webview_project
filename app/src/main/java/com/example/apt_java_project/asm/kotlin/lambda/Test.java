package com.example.apt_java_project.asm.kotlin.lambda;

public class Test {
    //val method1: () -> Unit
    public void method1() {
    }

    //    val method2: (Int,Int) -> Int
    public void method2(int n1, int n2) {
    }


    //声明+实现
    // val method01 = { println("我是method01函数") }
    void method01() {
        System.out.println("我是method01函数");
    }

    String method03(String str) {
        return str + "哈哈";
    }
}
