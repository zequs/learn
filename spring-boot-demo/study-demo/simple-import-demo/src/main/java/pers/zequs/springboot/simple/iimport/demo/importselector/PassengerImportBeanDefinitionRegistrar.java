package pers.zequs.springboot.simple.iimport.demo.importselector;

import org.springframework.beans.factory.support.AbstractBeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.BeanDefinitionReaderUtils;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.context.annotation.ImportBeanDefinitionRegistrar;
import org.springframework.core.type.AnnotationMetadata;
import org.springframework.util.MultiValueMap;
import pers.zequs.springboot.simple.iimport.demo.annotation.PersonType;
import pers.zequs.springboot.simple.iimport.demo.model.Passenger;
import pers.zequs.springboot.simple.iimport.demo.model.Student;
import pers.zequs.springboot.simple.iimport.demo.model.User;

import java.util.List;

public class PassengerImportBeanDefinitionRegistrar implements ImportBeanDefinitionRegistrar {
    @Override
    public void registerBeanDefinitions(AnnotationMetadata importingClassMetadata, BeanDefinitionRegistry registry) {

        MultiValueMap<String, Object> allAnnotationAttributes = importingClassMetadata.getAllAnnotationAttributes(PersonType.class.getName());
        List<Object> value = allAnnotationAttributes.get("value");
        String type = (String) value.get(0);
        String beanName = "";
        if (type.equals("user")) {
            beanName = User.class.getName();
        } else if (type.equals("student")) {
            beanName = Student.class.getName();
        } else if (type.equals("passenger")) {
            beanName = Passenger.class.getName();
        } else {
            beanName = User.class.getName();
        }
        BeanDefinitionBuilder builder = BeanDefinitionBuilder.genericBeanDefinition(beanName);
        AbstractBeanDefinition beanDefinition = builder.getBeanDefinition();
        //注册bean
        BeanDefinitionReaderUtils.registerWithGeneratedName(beanDefinition, registry);
    }
}
