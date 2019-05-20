## 注解

### **1、定义**：

> ​		 注解(Annotation)相当于一种标记，在程序中加入注解就等于为程序打上某种标记，没有加，则等于没有任何标记。以后，`javac`编译器、开发工具和其他程序可以通过反射来了解你的类及各种元素上有无何种标记，看你的程序有什么标记，就去干相应的事。

注解与其他任何`java`接口一样，也会编译成class文件

@Target：用来定义你的注解讲应用于什么地方。

@Retention：用来定义该注解在哪个级别可用

- source：源代码
- class：类文件
- runtime：运行时

### 2、基本注解

​		三种基本注解，`java SE5`中内置的，存放在`java.lang`包中

| 注解                 | 说明                                                         |
| -------------------- | ------------------------------------------------------------ |
| @Override            | 表示当前的方法定义讲覆盖超类中的方法，如果不小心拼写错误，或者方法签名对不上被覆盖的方法，编译器就会发出错误提示。 |
| @Deprecated          | 如果程序员使用了注解为它的元素，那么编译器会发出警告信息     |
| @SuppressWarnings    | 关闭不当的编译器警告信息。在java SE5之前版本中，有可以使用该注解，不过会忽略不起作用。 |
| @SafeVarargs         | 参数安全类型注解。它的目的是提醒开发者不要用参数做一些不安全的操作,它的存在会阻止编译器产生 unchecked 这样的警告(`JDK7`) |
| @FunctionalInterface | 函数式接口注解，函数式接口可以很容易转换为 Lambda 表达式（`JDK8`） |

### 3、元注解

​		元注解专职负责注解其他注解。

| 注解        | 枚举类                           | 说明                                                         |
| ----------- | -------------------------------- | ------------------------------------------------------------ |
| @Target     | `ElemenetType`                   | 表示该注解可以用于什么地方                                   |
|             | CONSTRUCTOR(constructor)         | 构造器声明                                                   |
|             | FIELD(field)                     | 域声明（包括`enum`实例）                                     |
|             | LOCAL_VARIABLE（local_variable） | 局部变量声明                                                 |
|             | METHOD(method)                   | 方法声明                                                     |
|             | PACKAGE(package)                 | 包声明                                                       |
|             | PARAMETER(parameter)             | 参数声明                                                     |
|             | TYPE(type)                       | 类，接口（包括注解类型）或`enum`声明                         |
| @Retention  | `RetentionPolicy`                | 表示在什么级别保存该注解信息                                 |
|             | SOURCE                           | 注解将被编译器丢弃                                           |
|             | CLASS                            | 注解在class文件中可用，但会被`JVM`丢弃                       |
|             | RUNTIME                          | `JVM`将在运行期也保留注释，因此可以通过反射机制读取注解的信息 |
| @Documented | 无                               | 将此注解包含在 `javadoc `中 ，它代表着此注解会被`javadoc`工具提取成文档。在doc文档中的内容会因为此注解的信息内容不同而不同。相当与@see,`@param` 等 |
| @Inherited  | 无                               | 允许子类继承父类中的注解                                     |
| @Repeatable | 无                               | `Java 1.8`才加进来的自然是可重复的意思                       |

### 4、参数成员类型

​		只能用基本类型**byte，short，char，int，long，float，double，boolean**八种基本数据类型和**String**、**Enum**、**Class**、**annotations**等数据类型，以及这一些类型的**数组**

### 5、注解的提取

​		注解的提取都是通过反射进行的。

**Class：**

```java
public final class Class<T> {
    
	public <A extends Annotation> A getAnnotation(Class<A> annotationClass) {
        ...
    }
    //如果指定类型的注释存在于此元素上,则返回 true，否则返回 false
    public boolean isAnnotationPresent(Class<? extends Annotation> annotationClass) {
        ...
    }
    public Annotation[] getAnnotations() {
     	...
    }
    //返回直接存在于此元素上的所有注释。与此接口中的其他方法不同，该方法将忽略继承的注释
    public Annotation[] getDeclaredAnnotations()  {
       	...
    }
    boolean casAnnotationType(AnnotationType oldType, AnnotationType newType) {
       ...
    }
}
```

**Method：**

```java
public final class Method extends Executable { 
	// 如果存在该元素的指定类型的注释，则返回这些注释，否则返回 null。
    public <T extends Annotation> T getAnnotation(Class<T> annotationClass) {
        ...
    }

    //返回直接存在于此元素上的所有注释。
    public Annotation[] getDeclaredAnnotations()  {
      	...
    }

    // 返回表示按照声明顺序对此 Method 对象所表示方法的形参进行注释的那个数组的数组
    @Override
    public Annotation[][] getParameterAnnotations() {
        ...
    }
    /**
     * {@inheritDoc}
     * @since java1.8
     */
    @Override
    public AnnotatedType getAnnotatedReturnType() {
        ...
    }
    @Override
    byte[] getAnnotationBytes() {
        ...
    }
}
```



### 6、组合注解

​		注解上面有其他直接springboot中此注解比较多

```java
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@RequestMapping(method = RequestMethod.GET)
public @interface GetMapping {
    ...
}
```

​		`@GetMapping`中含有`@RequestMapping`注解`@GetMapping`就叫组合注解，其中`@GetMapping`注解必须有`@Inherited`标注，不然不能继承

组合注解可以使用spring的工具类`AnnotationUtils.findAnnotation()`获取，或者使用`annotationData()`它所有头部注解。

```java
public static void main(String[] args) throws Exception{
        TestController testController = new TestController(); 
    	//获取方法
        Method method = testController.getClass().getMethod("find");
        RequestMapping requestMapping = AnnotationUtils.findAnnotation(method,RequestMapping.class);
    //返回PostMapping的所有头部注解信息，其中就包含RequestMapping注解
    //method.getAnnotation(PostMapping.class).annotationType().annotationData()
}
```

### 7、value属性

​		此属性比较特殊，与其他定义的属性不同点就是，如果value有默认值或者只有value一个属性，那么`value=`就可以省略

```java
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Component
public @interface Service {
	String value() default "";
}
```

```java
@Service("userManager") //等价于 @Service(value="userManager")
public class UserManagerImpl implements UserManager {
    ...
}
```



**8、参考：**

[孤傲苍狼-Java基础加强总结(一)——注解(Annotation)](https://www.cnblogs.com/xdp-gacl/p/3622275.html)

