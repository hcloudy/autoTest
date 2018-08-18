package com.demo.one.group;

import org.testng.annotations.AfterGroups;
import org.testng.annotations.BeforeGroups;
import org.testng.annotations.Test;

public class GroupMethod {

    @Test(groups = "server")
    public void test1() {
        System.out.println("这是服务端测试");
    }
    @Test(groups = "server")
    public void test3() {
        System.out.println("这是服务端测试");
    }

    @Test(groups = "client")
    public void test2() {
        System.out.println("这是客户端测试");
    }
    @Test(groups = "client")
    public void test4() {
        System.out.println("这是客户端测试");
    }

    @BeforeGroups("server")
    public void beforeGroups() {
        System.out.println("这是服务端组运行之前的");
    }
    @AfterGroups("server")
    public void afterGroups() {
        System.out.println("这是服务端组运行之后的");
    }
    @AfterGroups("client")
    public void afterGroups2() {
        System.out.println("这是客户端组之后运行的");
    }
    @BeforeGroups("client")
    public void beforeGroups2() {
        System.out.println("这是客户端组之前运行的");
    }




}

