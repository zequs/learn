package pers.zequs.springboot.simple.iimport.demo;

import java.lang.annotation.*;

/**
 * @author zequs
 * @version $Id: study-demo-parent, v0.1 2019 08 28 Exp $
 */
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface PersonType {
    String value() default "";
}
