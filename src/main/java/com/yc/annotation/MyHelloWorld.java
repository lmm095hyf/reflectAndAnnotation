package com.yc.annotation;

import java.lang.annotation.*;

/**
 * 要声明他的特征  target:表示这个注解加在哪个位置
 *              Retention：表示这个注解什么时候还保留
 *
 *            Target叫元注解，用来描述一个注解的约束
 *
 *
 */
@Target(value={ElementType.TYPE,ElementType.FIELD,ElementType.METHOD,ElementType.PARAMETER})
//这个注解 myHelloWorld
@Retention(value= RetentionPolicy.RUNTIME)
@Documented
@Inherited
public @interface MyHelloWorld {
    public String name();   //这个MyHelloWorld注解一定要有一个属性值
    public int age() default 20; //带默认值
    public String [] ins();
}
