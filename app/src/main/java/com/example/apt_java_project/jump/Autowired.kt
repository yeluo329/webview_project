package com.example.apt_java_project.jump


@Retention(AnnotationRetention.RUNTIME)
@Target(AnnotationTarget.FIELD)
annotation class Autowired(val value: String = "")
