package com.example.apt_java_project.asm.java;

import org.jetbrains.annotations.NotNull;

public interface GetResult {
    void upload();
}


class OkHttp implements GetResult {

    @Override
    public void upload() {
        System.out.println("okhttp:完成下载");
    }
}

class ljz implements GetResult {

    @Override
    public void upload() {
        System.out.println("ljz:完成下载");
    }
}


class Agent implements GetResult {
    private final GetResult result;

    public Agent(@NotNull GetResult result) {
        this.result = result;
    }

    @Override
    public void upload() {
        this.result.upload();
    }
}

class My {
    public static void main(String[] args) {
        new Agent(new OkHttp()).upload();
    }
}