package com.ljz.libroom.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Update
import com.ljz.libroom.entity.Student

@Dao
interface StudentDao {

    @Insert
    fun insert(students: Array<Student>)

    @Delete
    fun delete(student: Student)




}