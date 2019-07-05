### spring-boot 任务调度系统

#### spring-boot，quartz 模式

步骤

- pom.xml中加入依赖包

  ```xml
  <!-- quartz -->
  <dependency>
      <groupId>org.springframework.boot</groupId>
      <artifactId>spring-boot-starter-quartz</artifactId>
  </dependency>
  
  ```

-  需要调度的任务，必须继承`QuartzJobBean`

  ```java
  public class TestTask1 extends QuartzJobBean{
  
      @Override
      protected void executeInternal(JobExecutionContext context) throws JobExecutionException {
          SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
          System.out.println("TestQuartz01----" + sdf.format(new Date()));
      }
  }
  ```

- 配置定时器属性

  ```java
  @Configuration
  public class QuartzConfig {
  
      @Bean
      public JobDetail testQuartz1() {
          return JobBuilder.newJob(TestTask1.class)
              .withIdentity("testTask1").storeDurably().build();
      }
  
      @Bean
      public Trigger testQuartzTrigger1() {
          //5秒执行一次
          SimpleScheduleBuilder scheduleBuilder = 
              	SimpleScheduleBuilder.simpleSchedule()
                  .withIntervalInSeconds(5)
                  .repeatForever();
          return TriggerBuilder.newTrigger().forJob(testQuartz1())
                  .withIdentity("testTask1")
                  .withSchedule(scheduleBuilder)
                  .build();
      }
  
      @Bean
      public JobDetail testQuartz2() {
          return JobBuilder.newJob(TestTask2.class)
              .withIdentity("testTask2").storeDurably().build();
      }
  
      @Bean
      public Trigger testQuartzTrigger2() {
          //cron方式，每隔5秒执行一次
          return TriggerBuilder.newTrigger().forJob(testQuartz2())
                  .withIdentity("testTask2")
                  .withSchedule(CronScheduleBuilder.cronSchedule("*/5 * * * * ?"))
                  .build();
      }
  }
  ```

- 直接运行`DemoApplication`

#### spring-boot 自带调度器

​		使用spring的注解@Schedule。定时任务比较简单，执行时间比较短可以使用。

步骤

- `DemoApplication`类上添加`@EnableScheduling`

  ```java
  @SpringBootApplication
  @EnableScheduling
  public class DemoApplication {
  
  	public static void main(String[] args) {
  		SpringApplication.run(DemoApplication.class, args);
  	}
  	...
  }
  
  ```

- 创建一个类，类上添加`@Component`，写一个方法，方法中写执行逻辑。

  ```java
  @Component
  public class ScheduledConfig {
  
      @Scheduled(cron = "*/2 * * * * ?") // 设置为两秒启动一次
      public void scheduledMethod(){
          System.out.println("定时器被触发"+new Date());
      }
      //...
  }
  ```

- 直接运行`DemoApplication`

#### 参考

​		[SpringBoot的定时任务（分别有Quartz和Scheduled）](https://blog.csdn.net/qq1021979964/article/details/88764277)

​		[Spring Boot使用Quartz定时任务](https://blog.csdn.net/gnail_oug/article/details/80825302)