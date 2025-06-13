package com.example.apt_java_project.asm.kotlin.inject


@Target(AnnotationTarget.FIELD)
@Retention(AnnotationRetention.RUNTIME)
annotation class MyLjz(
    val value: String = ""
)
