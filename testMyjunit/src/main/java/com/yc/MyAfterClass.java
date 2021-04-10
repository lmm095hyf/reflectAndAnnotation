package com.yc;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @program: reflectAndAnnotation
 * @description: MyAfterClass
 * @author: 作者 :林木木
 * @create: 2021-03-31 20:06
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.METHOD})
public @interface MyAfterClass {
}
