package com.example.compiler;

import org.objectweb.asm.Handle;
import org.objectweb.asm.MethodVisitor;
import org.objectweb.asm.Opcodes;
import org.objectweb.asm.Type;
import org.objectweb.asm.commons.AdviceAdapter;
import org.objectweb.asm.commons.Method;


public class OwnMethodVisitor extends AdviceAdapter {
    /**
     * Constructs a new {@link AdviceAdapter}.
     *
     * @param api           the ASM API version implemented by this visitor. Must be one of the {@code
     *                      ASM}<i>x</i> values in {@link Opcodes}.
     * @param methodVisitor the method visitor to which this adapter delegates calls.
     * @param access        the method's access flags (see {@link Opcodes}).
     * @param name          the method's name.
     * @param descriptor    the method's descriptor (see {@link Type Type}).
     */
    protected OwnMethodVisitor(int api, MethodVisitor methodVisitor, int access, String name, String descriptor) {
        super(api, methodVisitor, access, name, descriptor);
    }


    @Override
    protected void onMethodEnter() {
        super.onMethodEnter();

        invokeStatic(Type.getType("Ljava/lang/System;"), new Method("currentTimeMillis", "()J"));
        invokeStatic(Type.getType("Ljava/lang/Long;"), new Method("valueOf", "(J)Ljava/lang/Long"));
        //创建局部变量
        int start = newLocal(Type.LONG_TYPE);
        //压入局部变量表
        storeLocal(start);

        //基于LDC、LDC_W和LDC2_W，将一个常量加载到操作栈用
        visitLdcInsn(1000L);
        invokeStatic(Type.getType("Ljava/lang/Thread;"), new Method("sleep", "(J)V"));

        invokeStatic(Type.getType("Ljava/lang/System;"), new Method("currentTimeMillis", "()J"));
        invokeStatic(Type.getType("Ljava/lang/Long;"), new Method("valueOf", "(J)Ljava/lang/Long"));

        int end = newLocal(Type.LONG_TYPE);
        //压入局部变量表
        storeLocal(end);

        getStatic(Type.getType("Ljava/lang/System;"), "out", Type.getType("Ljava/io/PrintStream"));

        loadLocal(end);
        invokeStatic(Type.getType("Ljava/lang/Long;"), new Method("valueOf", "(J)Ljava/lang/Long"));

        loadLocal(start);
        invokeStatic(Type.getType("Ljava/lang/Long;"), new Method("valueOf", "(J)Ljava/lang/Long"));

        math(SUB, Type.LONG_TYPE);

        //方法名, 方法描述符
//        invokeDynamic("makeConcatWithConstants", "(J)Ljava/lang/String",
//                new Handle(
//                        Opcodes.H_INVOKESTATIC,
//                        "java/lang/invoke/StringConcatFactory",
//                        "makeConcatWithConstants",
//                        "(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite;",
//                        false
//                ));


        invokeVirtual(Type.getType("Ljava/io/PrintStream;"), new Method("println", "(Ljava/lang/String;)V"));
    }


}
