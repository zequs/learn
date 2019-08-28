package pers.zequs.springboot.simple.iimport.demo.config;

import org.springframework.context.annotation.ImportSelector;
import org.springframework.core.annotation.AnnotatedElementUtils;
import org.springframework.core.type.AnnotationMetadata;
import org.springframework.util.MultiValueMap;
import pers.zequs.springboot.simple.iimport.demo.PersonType;

import java.util.Set;

/**
 * @author zequs
 * @version $Id: study-demo-parent, v0.1 2019 08 28 Exp $
 */
@PersonType("student")
public class StudentConfigurationSelector implements ImportSelector {
    @Override
    public String[] selectImports(AnnotationMetadata importingClassMetadata) {
        Set<String> annotationTypes = importingClassMetadata.getAnnotationTypes();
        MultiValueMap<String, Object> allAnnotationAttributes = importingClassMetadata.getAllAnnotationAttributes(PersonType.class.getName());
        for (String annotation : annotationTypes) {
            if (annotation.equals(PersonType.class.getName())) {
                System.out.println(annotation);
            }
        }
        for (String key : allAnnotationAttributes.keySet()) {
            System.out.println("------------------");
            System.out.println("------------------");
            System.out.println(key);
            System.out.println("------------------");
            System.out.println("------------------");
        }
        return new String[0];
    }
}
