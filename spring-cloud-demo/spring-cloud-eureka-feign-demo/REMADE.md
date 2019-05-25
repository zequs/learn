## feign

### 测试项目中坑

- api包中如果有多个service接口，除了一个在接口上配置@FeignClient外其他service必须走Configuration配置。

  ```java
  @Configuration
  public class FeignClientConfig {
  	/**
  	* FeignClientFactoryBean 该工厂类中 设置builder属性时就是通过该对象，源码中可看到
  	*/
      @Autowired
      private FeignContext feignContext;
  
  	/**
  	* 通过注入Eureka实例对象，就不用手动指定url，只需要指定服务名即可
  	*/
      @Autowired
      private EurekaClient eurekaClient;
  
  
      private <T> T create(Class<T> clazz,String serverId){
          InstanceInfo nextServerFromEureka = eurekaClient.getNextServerFromEureka(serverId,false);
          return Feign.builder()
                  .encoder(feignContext.getInstance(serverId,feign.codec.Encoder.class))
                  .decoder(feignContext.getInstance(serverId,feign.codec.Decoder.class))
                  .contract(feignContext.getInstance(serverId, Contract.class))
                  .target(clazz, nextServerFromEureka.getHomePageUrl());
  
      }
  
      //PersonService.class service接口，user-service是eureka server服务器的spring.application.name
  	  @Bean
  	   public PersonService getOperationFeignClient(){
  	       return create(PersonService.class,"user-service");
  	   }
  }
  ```

- service类上不能配置@RequestMapping，post方式的话，最好是写明requestMethod，因为不写明的话默认是走get方式。如果provider用的是post的话就找不到了。或者直接用@Postmapping

  ```java
  //@RequestMapping 这个上面不能配置@RequestMapping，feign不会帮忙跟方法一起拼接。
  public interface UserService {
  	//
      @Postmapping(value = "/user/hello")
      String save(@RequestBody Person person);
  }
  ```

  

