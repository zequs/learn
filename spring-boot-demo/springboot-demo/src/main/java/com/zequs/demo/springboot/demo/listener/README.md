### springboot 监听器

springboot监听器使用了观察者模式，回调机制。



#### @EventListener事件

- 被修饰的方法必须是public的
- 支持返回值为非void的情况
- 当监听一个或多个applicationEvent时，参数可为零个或一个ApplicationEvent
- 被 @EventListener修饰的类必须注册为spring的bean
- @Async修饰时监听方法可以设置为异步，此时最好把返回值设置为void。可以为引用类型，不能是基础类型（可以是包装类）

```java
@Component
public class MyEvent {

    @EventListener
    @Async
    public void listenerEvent(MyEvent event) {
        System.out.println("监听事件MyEvent：" + event);
    }
    @EventListener
    @Async
    public void listenerEvent(User user) {
        System.out.println("监听事件MyEvent：" + user.toString());
    }
}
```

发布事件

```java
context.publishEvent(new MyEvent());
context.publishEvent(new User());
```

