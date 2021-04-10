package com.yc;

import java.lang.annotation.*;

/**
 * @program: reflectAndAnnotation
 * @description: MyTest
 * @author: 作者 :林木木
 * @create: 2021-03-31 20:04
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.METHOD})
public @interface MyTest {
}
