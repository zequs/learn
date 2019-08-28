package pers.zequs.springboot.simple.iimport.demo.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import pers.zequs.springboot.simple.iimport.demo.PersonType;

/**
 * @author zequs
 * @version $Id: study-demo-parent, v0.1 2019 08 28 Exp $
 */
@Configuration
@Import(StudentConfigurationSelector.class)
@PersonType("user")
public class StudentImportSelectorConfig {

}
