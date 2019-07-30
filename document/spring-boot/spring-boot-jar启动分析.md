### spring boot 包启动分析

​		spring boot 项目一般都是打成jar包，后直接使用java -jar 命令运行

```shell
java -jar spring-boot-demo.jar
```

#### java -jar命令

​		此命令的执行源码，暂不清楚，未找到相应资料。只查到，此命令会去执行META-INF/MANIFEST.MF文件中的Main-Class。

​		资料空缺，后期补充（不用等了，以后肯定忘记了）

- 猜测：
  - java -jar file.jar命令会去找`META-INF/MANIFEST.MF`文件中Main-class的类，直接运行这个类的main方法

#### spring boot 打包插件

- `spring-boot-maven-plugin`打包

  ```xml
   <plugin>
       <groupId>org.springframework.boot</groupId>
       <artifactId>spring-boot-maven-plugin</artifactId>
  </plugin>
  ```

  spring boot 它有一套自己的打包插件，可以在pom中引用。既能打包成war,有能打包成jar。

- 打成war包的话

  ```properties
  Manifest-Version: 1.0
  Implementation-Title: zequs-demo
  Implementation-Version: 0.0.1-SNAPSHOT
  Start-Class: com.zequs.demo.zequsdemo.ZequsDemoApplication
  Spring-Boot-Classes: WEB-INF/classes/
  Spring-Boot-Lib: WEB-INF/lib/
  Build-Jdk-Spec: 1.8
  Spring-Boot-Version: 2.1.6.RELEASE
  Created-By: Maven Archiver 3.4.0
  Main-Class: org.springframework.boot.loader.WarLauncher
  ```

- 打成jar包

  ```properties
  Manifest-Version: 1.0
  Implementation-Title: zequs-demo
  Implementation-Version: 0.0.1-SNAPSHOT
  Start-Class: com.zequs.demo.zequsdemo.ZequsDemoApplication
  Spring-Boot-Classes: BOOT-INF/classes/
  Spring-Boot-Lib: BOOT-INF/lib/
  Build-Jdk-Spec: 1.8
  Spring-Boot-Version: 2.1.6.RELEASE
  Created-By: Maven Archiver 3.4.0
  Main-Class: org.springframework.boot.loader.JarLauncher
  ```

- 差异
  - `org/springframework/boot/loader`文件夹下放的Launcher实现类不一样
  - META-INF/MANIFEST.MF文件中Main-class不一样。
  
- Launcher实现类
  - PropertiesLauncher
  - JarLauncher
  - WarLauncher

#### JarLauncher

​		JarLauncher类是在[**spring-boot-loader**](https://github.com/spring-projects/spring-boot/tree/v2.1.6.RELEASE/spring-boot-project/spring-boot-tools/spring-boot-loader)项目中，此时版本是**2.1.6.RELEASE**

```java
public class JarLauncher extends ExecutableArchiveLauncher {

	static final String BOOT_INF_CLASSES = "BOOT-INF/classes/";

	static final String BOOT_INF_LIB = "BOOT-INF/lib/";

	public JarLauncher() {
	}

	protected JarLauncher(Archive archive) {
		super(archive);
	}

	@Override
	protected boolean isNestedArchive(Archive.Entry entry) {
		if (entry.isDirectory()) {
			return entry.getName().equals(BOOT_INF_CLASSES);
		}
		return entry.getName().startsWith(BOOT_INF_LIB);
	}

	public static void main(String[] args) throws Exception {
		new JarLauncher().launch(args);
	}

}
```

​	`new JarLauncher().launch(args)`首先会初始化的是`JarLauncher`的父类`ExecutableArchiveLauncher`的构造方法

```java
public abstract class ExecutableArchiveLauncher extends Launcher {

	private final Archive archive;

	public ExecutableArchiveLauncher() {
		try {
			this.archive = createArchive();
		}
		catch (Exception ex) {
			throw new IllegalStateException(ex);
		}
	}
		...
}
```

​		`ExecutableArchiveLauncher#createArchive`调用的是父类`Launcher#createArchive()`方法

```java
public abstract class Launcher {
    	...
    /**
     * Archive是springboot抽象出来的概念，可以是一个文件，也可以是一个jar包，也可以是一个war包
     * 归档（可以认为是一个资源吧），这个方法可以查看
     * https://blog.csdn.net/yfqnihao/article/details/8271415
     * https://www.cnblogs.com/f1194361820/p/4189269.html
     * 这几篇博客了解ProtectionDomain，CodeSource等概念
     * 
     * 判断文件路径和归档文件是否正确
     *
     */
    protected final Archive createArchive() throws Exception {
		ProtectionDomain protectionDomain = getClass().getProtectionDomain();
		CodeSource codeSource = protectionDomain.getCodeSource();
		URI location = (codeSource != null) ? codeSource.getLocation().toURI() : null;
		String path = (location != null) ? location.getSchemeSpecificPart() : null;
		if (path == null) {
			throw new IllegalStateException("Unable to determine code source archive");
		}
		File root = new File(path);
		if (!root.exists()) {
			throw new IllegalStateException("Unable to determine code source archive from " + root);
		}
		return (root.isDirectory() ? new ExplodedArchive(root) : new JarFileArchive(root));
	}
    ...
}
```

​	`JarLauncher#launch()`的是父类`ExecutableArchiveLauncher`的父类`Launcher#launch()`

```java
public abstract class Launcher {

	protected void launch(String[] args) throws Exception {
        //1.注册URL协议并清除应用缓存
		JarFile.registerUrlProtocolHandler();
        //2.归档创建类加载器
		ClassLoader classLoader = createClassLoader(getClassPathArchives());
        //3.执行main方法
		launch(args, getMainClass(), classLoader);
	}
    	...
}
```

​	1：`JarFile#registerUrlProtocolHandler()` 

```java
public class JarFile extends java.util.jar.JarFile {
    	...
    private static final String PROTOCOL_HANDLER = "java.protocol.handler.pkgs";
    
    // 注册URL协议
    public static void registerUrlProtocolHandler() {
        
		String handlers = System.getProperty(PROTOCOL_HANDLER, "");
		System.setProperty(PROTOCOL_HANDLER,
				("".equals(handlers) ? HANDLERS_PACKAGE : handlers + "|" + HANDLERS_PACKAGE));
        // 重置并清除应用缓存
		resetCachedUrlHandlers();
	}
    	...
}

```

2：其中`ExecutableArchiveLauncher#getClassPathArchives()`

```java
public abstract class ExecutableArchiveLauncher extends Launcher {
    @Override
	protected List<Archive> getClassPathArchives() throws Exception {
        //获取归档
		List<Archive> archives = new ArrayList<>(this.archive.getNestedArchives(this::isNestedArchive));
        //归档处理，空方法，扩展设置吧。可以对归档进行后期处理。如修改归档，删除归档，新增归档等
		postProcessClassPathArchives(archives);
		return archives;
	}
    //归档处理，空方法
    protected void postProcessClassPathArchives(List<Archive> archives) throws Exception {
	}
}
```

​	`Launcher#createClassLoader()`方法，为归档创建类加载器`LaunchedURLClassLoader`，

```java
public abstract class Launcher {
    	...
    protected ClassLoader createClassLoader(List<Archive> archives) throws Exception {
		List<URL> urls = new ArrayList<>(archives.size());
		for (Archive archive : archives) {
			urls.add(archive.getUrl());
		}
		return createClassLoader(urls.toArray(new URL[0]));
	}
    
    protected ClassLoader createClassLoader(URL[] urls) throws Exception {
        //创建了LaunchedURLClassLoader类加载器
		return new LaunchedURLClassLoader(urls, getClass().getClassLoader());
	}
    	...
}
```

3：执行main方法。

```java
public abstract class Launcher {
    protected void launch(String[] args, String mainClass, ClassLoader classLoader) throws Exception {
		Thread.currentThread().setContextClassLoader(classLoader);
		createMainMethodRunner(mainClass, args, classLoader).run();
	}
    
    protected MainMethodRunner createMainMethodRunner(String mainClass, String[] args, ClassLoader classLoader) {
		return new MainMethodRunner(mainClass, args);
	}
}

```

 		`MainMethodRunner#run()`

```java
public class MainMethodRunner {
    public MainMethodRunner(String mainClass, String[] args) {
		this.mainClassName = mainClass;
		this.args = (args != null) ? args.clone() : null;
	}

    //运行
	public void run() throws Exception {
        //mainClass 为META-INF/MANIFEST.MF中start-class
		Class<?> mainClass = Thread.currentThread().getContextClassLoader().loadClass(this.mainClassName);
        //反射获取main方法
		Method mainMethod = mainClass.getDeclaredMethod("main", String[].class);
        //执行main，启动spring boot项目
		mainMethod.invoke(null, new Object[] { this.args });
	}
}
```

结束:

#### 参考

[spring-boot-loader项目git地址](https://github.com/spring-projects/spring-boot/tree/v2.1.6.RELEASE/spring-boot-project/spring-boot-tools/spring-boot-loader)

[Thinking In Spring Boot 之 Spring Boot 如何启动—JarLauncher 实现原理（二）](https://blog.csdn.net/qq_38423105/article/details/89433050)

[java之jvm学习笔记十(策略和保护域)](https://blog.csdn.net/yfqnihao/article/details/8271415)

[[Java Se：Java Security](https://www.cnblogs.com/f1194361820/p/4189269.html)](https://www.cnblogs.com/f1194361820/p/4189269.html)

[Thinking In Spring Boot ](https://item.jd.com/12570242.html)