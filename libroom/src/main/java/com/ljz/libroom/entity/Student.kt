package com.ljz.libroom.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.Index
import androidx.room.PrimaryKey

@Entity(tableName = "student", indices = [Index("id", unique = true), Index("name")])
class Student {

    // 主键，唯一
    var id: String = ""

    //主键 SQL 唯一
    @PrimaryKey(autoGenerate = true)
    var uid: Int = 0

    //写了就是注解为名字，不写就是用name为名字
    @ColumnInfo(name = "student_name")
    var name: String = ""

    @ColumnInfo(name = "pwd")
    var pwd: String = ""

    @ColumnInfo(name = "address")
    var address: String = ""

}