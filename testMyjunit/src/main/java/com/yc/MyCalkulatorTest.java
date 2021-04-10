package com.yc;

import biz.Calkulator;

public class MyCalkulatorTest {

    private Calkulator cal;

    @MyBeforeClass
    public static void bc(){
        System.out.println("BeforeClass");
    }
    @MyAfterClass
    public static void ac(){
        System.out.println("AfterClass");
    }

    @MyBefore
    public void setUp() throws Exception {

        System.out.println("Before");
        cal = new Calkulator();
    }

    @MyAfter
    public void tearDown() throws Exception {
        System.out.println("After");
    }

    @MyTest
    public void add() {
        System.out.println("add测试");
        //Assert.assertEquals(3,cal.add(2,1));
    }

    @MyTest
    public void sub() {
        System.out.println("sub");
        //Assert.assertEquals(1,cal.sub(2,1));
    }
}