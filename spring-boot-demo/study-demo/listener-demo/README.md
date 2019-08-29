### springboot 监听器

springboot监听器本质上是使用了spring Framework事件/监听机制，使用了观察者模式，回调机制。

 有四种监听机制

#### 方式一：ApplicationContext中添加监听器

```java
GenericApplicationContext context = new GenericApplicationContext();
context.addApplicationListener(new ApplicationListener<ApplicationEvent>() {

    @Override
    public void onApplicationEvent(ApplicationEvent event) {
        System.err.println("监听事件：" + event);
    }
});
```

#### 方式二：将监听器装载入spring容器

```java
@Component
public class MyListener2 implements ApplicationListener<MyEvent>
{

    public void onApplicationEvent(MyEvent event)
    {
        System.out.println("监听事件：");
    }
}
```



#### 方式三：@EventListener事件

- 被修饰的方法必须是public的
- 支持返回值为非void的情况
- 当监听一个或多个applicationEvent时，参数可为零个或一个ApplicationEvent
- 被 @EventListener修饰的类必须注册为spring的bean
- @Async修饰时监听方法可以设置为异步，此时最好把返回值设置为void。可以为引用类型，不能是基础类型（可以是包装类）

```java
@Component
public class MyListener3 {

    /**
     * @param event
     * @Async监听方法可以设置为异步
     */
    @EventListener
    @Async
    public void listenerEvent(TestEvent event) {
        System.out.println("监听事件1:" + event.getSource());
    }

    @EventListener
    @Async
    public void listenerEventUser(User user) {
        System.out.println("监听事件2:" + user.getName());
    }
}
```

发布事件

```java
context.publishEvent(new MyEvent());
context.publishEvent(new User());
```

#### 方式四：在application.properties中配置监听器

```java
public class MyListener4 implements ApplicationListener<MyEvent>
{

    public void onApplicationEvent(MyEvent event)
    {
        System.out.println("监听事件4：");
    }
}
```

```properties
context.listener.classes=pers.zequs.springboot.listener.demo.listener.MyListener4
```

#### springboot时间发布

#### 方式一：上下文发布事件

```java
ConfigurableApplicationContext context = application.run(args);
context.publishEvent(new MyEvent("发布事件"));
```

#### 方式二：SimpleApplicationEventMulticaster发布事件

```java
SimpleApplicationEventMulticaster multicaster = new SimpleApplicationEventMulticaster();
multicaster.multicastEvent(new MyEvent("hello world"));
```

