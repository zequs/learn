### 自定义starter包

#### 依赖

- 继承依赖

```xml
<parent>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-parent</artifactId>
    <version>2.1.7.RELEASE</version>
</parent>
```

- 依赖
  - spring-boot-autoconfigure包：依赖了springboot包

```xml
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-autoconfigure</artifactId>
</dependency>

<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-configuration-processor</artifactId>
    <!--两个项目之间依赖不传递-->
    <optional>true</optional>
</dependency>
```

#### AutoConfiguration配置类

- 这个类用于自动装配，`@EnableConfigurationProperties`注解会把`@ConfigurationProperties`注解的类注册为bean。

```java
@EnableConfigurationProperties(DBProperties.class)
@Import(ZequsDao.class)
public class ZequsDaoAutoConfiguration {
}
```

- 在META-INF/spring.factories文件中加入自动装配的设置,sprongboot项目启动的时候会读取此目录，`org.springframework.boot.autoconfigure.EnableAutoConfiguration`配置会被自动装配

```pro
org.springframework.boot.autoconfigure.EnableAutoConfiguration=\
    pers.zequs.springboot.starter.demo.configuration.ZequsDaoAutoConfiguration
```

#### DBProperties类

```java
@ConfigurationProperties("db")
@Data
public class DBProperties {
    private String driver;
    private String url;
    private String userName;
    private String password;
}
```

- `@data`：使用的lombok

- `@ConfigurationProperties("db")`：通过`@EnableConfigurationProperties`注解注册为bean，能把properties文件的设置转化为类属性

  - db：配置属性前缀

    ```properties
    db.driver=com.mysql.cj.jdbc.Driver
    db.url=jdbc:mysql://localhost:3306/test?characterEncoding=utf-8&serverTimezone=GMT%2B8
    db.userName=root
    db.password=123456
    ```

#### ZequsDao

- 业务类：此starter包相应的功能。