package pers.zequs.springboot.simple.iimport.demo.importselector;

import org.springframework.context.annotation.ImportSelector;
import org.springframework.core.type.AnnotationMetadata;
import org.springframework.util.MultiValueMap;
import pers.zequs.springboot.simple.iimport.demo.annotation.PersonType;
import pers.zequs.springboot.simple.iimport.demo.model.Passenger;
import pers.zequs.springboot.simple.iimport.demo.model.Student;
import pers.zequs.springboot.simple.iimport.demo.model.User;

import java.util.List;

/**
 * @author zequs
 * @version $Id: study-demo-parent, v0.1 2019 08 28 Exp $
 */

public class StudentConfigurationSelector implements ImportSelector {
    @Override
    public String[] selectImports(AnnotationMetadata importingClassMetadata) {
        MultiValueMap<String, Object> allAnnotationAttributes = importingClassMetadata.getAllAnnotationAttributes(PersonType.class.getName());
        List<Object> value = allAnnotationAttributes.get("value");
        String type = (String) value.get(0);
        if (type.equals("user")) {
            return new String[]{User.class.getName()};
        } else if (type.equals("student")) {
            return new String[]{Student.class.getName()};
        } else if (type.equals("passenger")) {
            return new String[]{Passenger.class.getName()};
        }
        return null;
    }
}
