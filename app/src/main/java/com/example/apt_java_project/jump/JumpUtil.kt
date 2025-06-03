package com.example.apt_java_project.jump

import android.app.Activity
import android.os.Bundle
import android.os.Parcelable
import java.lang.reflect.Field
import java.util.Arrays

class JumpUtil {

    companion object {
        fun jump(activity: Activity) {
            val cls: Class<out Activity> = activity.javaClass
            val intent = activity.intent
            val extras: Bundle = intent.extras ?: return

            //获得此类所有的成员
            for (field: Field in cls.declaredFields) {
                if (field.isAnnotationPresent(Autowired::class.java)) {
                    val annotation: Autowired =
                        field.getAnnotation(Autowired::class.java) ?: continue
                    //获得key
                    val key = if (annotation.value == "") field.name else annotation.value
                    if (extras.containsKey(key)) {
                        val obj: Any? = extras.get(key)
                        //获得数组单个元素类型
                        val componentType: Class<*> = field.type.componentType ?: continue
//                        if (field.type.isArray && Parcelable::class.java.isAssignableFrom(
//                                componentType
//                            )
//                        ) {
//                            val objs = obj as Array<Any>
//
//                            val objects =
//                                Arrays.copyOf(objs, objs.size, field.type as Class<out Array<Any>>)
//
//                            obj = objects
//                        }
                        field.isAccessible = true
                        try {
                            field.set(activity, obj)
                        } catch (e: IllegalAccessException) {
                            e.printStackTrace()
                        }
                    }
                }
            }
        }
    }
}