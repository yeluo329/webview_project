package com.example.compiler;

import com.example.Utils;

import org.objectweb.asm.ClassReader;
import org.objectweb.asm.ClassVisitor;
import org.objectweb.asm.ClassWriter;
import org.objectweb.asm.FieldVisitor;
import org.objectweb.asm.MethodVisitor;
import org.objectweb.asm.Opcodes;
import org.objectweb.asm.Type;
import org.objectweb.asm.commons.AdviceAdapter;
import org.objectweb.asm.commons.Method;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class ASMUnitTest {

    public static void main(String[] args) throws IOException {
        String clazzFilePath = Utils.getClassFilePath(InjectTest.class);
        FileInputStream fis = new FileInputStream(clazzFilePath);
        ClassReader cr = new ClassReader(fis);
        ClassWriter cw = new ClassWriter(ClassWriter.COMPUTE_FRAMES);

        /**
         *  2.执行插桩
         */
        ClassVisitor classVisitor = new ClassVisitor(Opcodes.ASM8, cw) {
            // access 作用域 public ,name 方法名
            @Override
            public MethodVisitor visitMethod(int access, String name, String descriptor, String signature, String[] exceptions) {
                MethodVisitor methodVisitor = super.visitMethod(access, name, descriptor, signature, exceptions);
                return new OwnMethodVisitor(Opcodes.ASM8, methodVisitor, access, name, descriptor);
            }

            @Override
            public FieldVisitor visitField(int access, String name, String descriptor, String signature, Object value) {
                return super.visitField(access, name, descriptor, signature, value);
            }
        };
        cr.accept(classVisitor, 0);


        byte[] bytes = cw.toByteArray();
        FileOutputStream fos = new FileOutputStream("/Users/heihei/AndroidStudioProjects/apt_java_project/compiler/src/main/java/com/example/test/InjectTest.class");
        fos.write(bytes);
        fos.close();
    }


    static class MyMethodVisitor extends AdviceAdapter {
        int start;

        /**
         * Constructs a new {@link AdviceAdapter}.
         *
         * @param api           the ASM API version implemented by this visitor. Must be one of {@link
         *                      Opcodes#ASM4}, {@link Opcodes#ASM5}, {@link Opcodes#ASM6} or {@link Opcodes#ASM7}.
         * @param methodVisitor the method visitor to which this adapter delegates calls.
         * @param access        the method's access flags (see {@link Opcodes}).
         * @param name          the method's name.
         * @param descriptor    the method's descriptor (see {@link Type Type}).
         */
        protected MyMethodVisitor(int api, MethodVisitor methodVisitor, int access, String name, String descriptor) {
            super(api, methodVisitor, access, name, descriptor);
        }

        @Override
        protected void onMethodEnter() {
            //  方法名 和 方法签名
            //   new Method("currentTimeMillis", "()J")
            super.onMethodEnter();
            //   Long l = System.currentTimeMillis();
            //     System.currentTimeMillis()
            //     invokestatic 'java/lang/System.currentTimeMillis','()J'
            invokeStatic(Type.getType("Ljava/lang/System;"),
                    new Method("currentTimeMillis", "()J"));

            //创建局部变量
            start = newLocal(Type.LONG_TYPE);

            storeLocal(start);


        }

        @Override
        protected void onMethodExit(int opcode) {
            super.onMethodExit(opcode);
            //Long e = System.currentTimeMillis();
            invokeStatic(Type.getType("Ljava/lang/System;"),
                    new Method("currentTimeMillis", "()J"));
            int end = newLocal(Type.LONG_TYPE);
            storeLocal(end);

            getStatic(Type.getType("Ljava/lang/System;"), "out", Type.getType("Ljava/io/PrintStream;"));

            newInstance(Type.getType("Ljava/lang/StringBuilder;"));
            // dup指令
            dup();

            invokeConstructor(Type.getType("Ljava/lang/StringBuilder"), new Method("<init>", "()V"));

            visitLdcInsn("execute");

            invokeVirtual(Type.getType("Ljava/lang/StringBuilder;"), new Method("append", "(Ljava/lang/String;)Ljava/lang/StringBuilder;"));
            loadLocal(end);
//            invokeVirtual(Type.getType("Ljava/lang/Long;"), new Method("longValue", "()J"));
            loadLocal(start);
//            invokeVirtual(Type.getType("Ljava/lang/Long;"), new Method("longValue", "()J"));
            math(SUB, Type.LONG_TYPE);


            invokeVirtual(Type.getType("Ljava/lang/StringBuilder;"), new Method("append", "(J)Ljava/lang/StringBuilder;"));
            invokeVirtual(Type.getType("Ljava/lang/StringBuilder;"), new Method("toString", "()Ljava/lang/String;"));
            invokeVirtual(Type.getType("Ljava/io/PrintStream;"), new Method("println", "(Ljava/lang/String;)V"));

//        System.out.println("execute:" + (e - l));
        }
    }
}
