package com.yc;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

/**
 * @program: reflectAndAnnotation
 * @description:
 * @author: 作者 :林木木
 * @create: 2021-03-31 20:09
 */
public class MyJunitRunner {
    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException, InvocationTargetException {
        //因为没得idea插件，只能先做class加载
        Class cls = Class.forName("com.yc.MyCalkulatorTest");
            //
        //1.获取这个类的所有方法
        Method[] ms = cls.getDeclaredMethods();
        List<Method> testMethods = new ArrayList<Method>();
        Method beforeMethod = null;
        Method afterMethod = null;
        Method afterClassMethod = null;
        Method beforeClassMethod = null;
        //2.循环这些方法，判断上面加了哪个注解
        for(Method m:ms){
            //3.将这些方法分别存好 @Test对应的方法有多个，存到一个集合中，其他注解对应的方法只有一个，直接存
            if(m.isAnnotationPresent(MyTest.class)){
                testMethods.add(m);
            }
            if(m.isAnnotationPresent(MyBefore.class)){
                beforeMethod = m;
            }
            if(m.isAnnotationPresent(MyAfter.class)){
                afterMethod = m;
            }
            if(m.isAnnotationPresent(MyBeforeClass.class)){
                beforeClassMethod = m;
            }
            if(m.isAnnotationPresent(MyAfterClass.class)){
                afterClassMethod = m;
            }
        }

        if(testMethods ==null || testMethods.size() <=0){
            throw new RuntimeException("没有要测试的方法");
        }
        Object o = cls.newInstance();//实例化，测试类
        beforeClassMethod.invoke(o,null);//@BeforeClass
        for(Method m:testMethods){
            if(beforeMethod !=null){
                beforeMethod.invoke(o,null);//@Before
            }
            m.invoke(o,null);
            if(afterMethod !=null){
                afterMethod.invoke(o,null);//@After
            }
        }
        afterClassMethod.invoke(o,null);//@AfterClass
    }



}
