package pers.zequs.springboot.simple.enable.demo.annotation;

import org.springframework.context.annotation.Import;
import pers.zequs.springboot.simple.enable.demo.importselector.StudentConfigurationSelector;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author zequs
 * @version $Id: study-demo-parent, v0.1 2019 08 28 Exp $
 */
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Import(StudentConfigurationSelector.class)
//@Import(PassengerImportBeanDefinitionRegistrar.class)
//@Import(Student.class)
public @interface EnablePersonType {
    String value();
}
