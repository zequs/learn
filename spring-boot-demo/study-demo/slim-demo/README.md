### slim-demo

slim-demo：springboot瘦身项目

#### 项目说明：

​		spring boot项目是用spring-boot-maven-plugin插件打包的，此插件打包打成的是fat jar（全部依赖都打成一个jar包）。因为spring boot项目依赖的jar包比较多。自然而然最后打包成项目的jar也比较大。此项目就是给springboot项目瘦身做的demo，把相应不变的jar放到本地目录。项目只打包经常变动的jar包。

#### 原理

- java  命令参数  -Dloader.path：指定资源文件或lib的目录
- spring-boot-maven-plugin插件可配置相应依赖不进行打包

​		

#### java命令

```shell
java -jar  xxx.jar #运行xxx.jar
```

```shell
java -jar -Dloader.path="\lib" xxx.jar  #运行xxx.jar 并指定\lib资源
```

#### spring-boot-maven-plugin

```xml
<plugin>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-maven-plugin</artifactId>
    <version>2.1.6.RELEASE</version>
    <configuration>
        <layout>ZIP</layout>
        <excludeGroupIds>
            org.springframework.boot,
            org.springframework,
            org.springframework.data
        </excludeGroupIds>
    </configuration>
</plugin>
```

如果项目依赖的jar包太多，要剔除很多jar的话，这么一大串，很不优雅，就对`spring-boot-maven-plugin`源码进行了改写，改成用文件的方式，excludeGroupId放在文件中。

[spring-boot-maven-plugin官方源码地址](https://github.com/spring-projects/spring-boot/tree/master/spring-boot-project/spring-boot-tools/spring-boot-maven-plugin)

只修改了源码中的一个类`org.springframework.boot.maven.AbstractDependencyFilterMojo`

[修改后的代码](https://github.com/zequs/learn/blob/master/spring-boot-demo/spring-boot-2.1.6.RELEASE/spring-boot-project/spring-boot-tools/spring-boot-maven-plugin/src/main/java/org/springframework/boot/maven/AbstractDependencyFilterMojo.java)

是在spring-boot-2.1.6.RELEASE基础上修改的。

改动了2项

- 增加配置项

  - ```java
    @Parameter(property = "spring-boot.excludeGroupIdsFile", defaultValue = "")
    	private String excludeGroupIdsFile;
    
    	public void setExcludeGroupIdsFile(String excludeGroupIdsFile) {
    		this.excludeGroupIdsFile = excludeGroupIdsFile;
    	}
    ```

- 增加excludeGroupIdsFile的处理逻辑

  - ```java
    protected final FilterArtifacts getFilters(ArtifactsFilter... additionalFilters) {
    		FilterArtifacts filters = new FilterArtifacts();
    		for (ArtifactsFilter additionalFilter : additionalFilters) {
    			filters.addFilter(additionalFilter);
    		}
    		excludeGroupIdsFileProcess(filters);//文件处理
    		filters.addFilter(new MatchingGroupIdFilter(cleanFilterConfig(this.excludeGroupIds)));
    		...
    		return filters;
    	}
    
    /**
      * 文件处理jar包
      * @param filters
      */
    public void excludeGroupIdsFileProcess(FilterArtifacts filters) {
        if (this.excludeGroupIdsFile != null && this.excludeGroupIdsFile.length() != 0) {
            File file = new File(this.excludeGroupIdsFile);
            if (file != null && file.isFile()) {
                BufferedReader br = null;
                InputStreamReader isr = null;
                FileInputStream fis = null;
                String len = "";
                StringBuilder stringBuilder = new StringBuilder();
                try {
                    fis = new FileInputStream(file);
                    isr = new InputStreamReader(fis);
                    br = new BufferedReader(isr);
                    while ((len = br.readLine()) != null) {
                        if (stringBuilder.length() == 0) {
                            stringBuilder.append(len);
                        }
                        else {
                            stringBuilder.append("," + len);
                        }
                    }
                    getLog().info("excludeGroupIds:" + stringBuilder.toString());
                    filters.addFilter(new MatchingGroupIdFilter(cleanFilterConfig(stringBuilder.toString())));
                }
                catch (FileNotFoundException ex) {
                    ex.printStackTrace();
                }
                catch (IOException ex) {
                    ex.printStackTrace();
                }
                finally {
                    if (br != null) {
                        try {
                            br.close();
                        }
                        catch (IOException ex) {
                            ex.printStackTrace();
                        }
                    }
                    if (isr != null) {
                        try {
                            isr.close();
                        }
                        catch (IOException ex) {
                            ex.printStackTrace();
                        }
                    }
                    if (fis != null) {
                        try {
                            fis.close();
                        }
                        catch (IOException ex) {
                            ex.printStackTrace();
                        }
                    }
                }
            }
        }
    }
    ```

#### 插件修改的坑

​		`spring-boot-maven-plugin`是用checkstyle代码规范，不符合是编译不通过。idea中安装的checkstyle插件时，不符合`spring-boot-maven-plugin`的checkstyle规范。对应不上。应该是版本问题。后通过报错来修改错误规范，修改代码后没有规范上面的问题但是还是说报错 使用 mvn spring-javaformat:apply ，再进行install



