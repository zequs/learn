package pers.zequs.springboot.starter.demo.properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

/**
 * @author zequs
 * @version $Id: starter, v0.1 2019 08 20 Exp $
 */
@ConfigurationProperties("db")
@Data
public class DBProperties {
    private String driver;
    private String url;
    private String userName;
    private String password;
}
