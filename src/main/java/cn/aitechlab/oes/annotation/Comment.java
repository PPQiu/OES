package cn.aitechlab.oes.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @Description: 定义GraphQL类型、字段、操作、操作参数的备注说明
 * @Author: 李洪文
 * @Date: Created on 2018/12/30
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.METHOD, ElementType.TYPE, ElementType.PARAMETER, ElementType.FIELD})
public @interface Comment {
    /**
     * 备注内容，任意字符串
     *
     * @return
     */
    String value() default "";

    boolean required() default false;
}

