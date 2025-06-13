package com.example.apt_java_project.asm.kotlin.delegate

// 委托 ==  代理

interface DB {
    fun save()
}


class SqlDB : DB {
    override fun save() = println("SqlDB 实现")
}

class MySqlDB : DB {
    override fun save() = println("MySqlDB 实现")
}

class OracleDB : DB {
    override fun save() = println("OracleDB 实现")
}

// 委托含义解释: 把接口实现  委托给了参数db
class CreateDBAction(db: DB) : DB by db


fun main() {
    CreateDBAction(MySqlDB()).save()
    CreateDBAction(OracleDB()).save()
    CreateDBAction(SqlDB()).save()
}
