# OpenApi(swagger)

#### swagger是什么

​		Swagger是一个功能强大且易于使用的API开发人员工具套件，适用于团队和个人，支持从整个API生命周期（从设计和文档到测试和部署）的开发。

#### swagger历史

​		Swagger最初是作为2010年设计RESTful API的简单开源规范开发的。开源工具如`Swagger UI`，`Swagger Editor`和`Swagger Codegen`也被开发用于更好地实现和可视化规范中定义的API。Swagger项目由规范和开源工具组成

​		2015年，Swagger项目被SmartBear Software收购。Swagger规范被捐赠给Linux基金会并重命名为**OpenAPI**

​		规范以正式标准化REST API的描述方式。建立OpenAPI倡议是为了以公开和透明的方式指导美洲国家组织的发展。

#### swagger生态使用图

![swagger生态图](C:\Users\admin\Desktop\swagger-ecological.png)

- swagger-editor：是一个开源编辑器，用于在Swagger规范中设计，定义和记录RESTful API。[github地址](https://github.com/swagger-api/swagger-editor)
- swagger-ui：在交互式UI中可视化swagger。[github地址](https://github.com/swagger-api/swagger-ui)
- swagger-codegen：可直接从Swagger定义的RESTful API构建服务器存根和客户端SDK。[github地址](https://github.com/swagger-api/swagger-codegen)

#### 缺点

​		对于许多开发来说，编写这个yml或json格式的描述文件（swagger-editor中编辑），本身也是有一定负担的工作，特别是在后面持续迭代开发的时候，往往会忽略更新这个描述文件，直接更改代码。久而久之，这个描述文件也和实际项目渐行渐远，基于该描述文件生成的接口文档也失去了参考意义

### Springfox

​		Springfox Swagger： Spring 基于swagger规范，可以将基于SpringMVC和Spring Boot项目的项目代码，自动生成JSON格式的描述文件。本身不是属于Swagger官网提供的。通过在项目中引入Springfox，可以扫描相关的代码，生成该描述文件，进而生成与代码一致的接口文档和客户端代码。这种通过代码生成接口文档的形式，在后面需求持续迭代的项目中，显得尤为重要和高效。



[github地址](https://github.com/springfox/springfox)

#### 参考

- [5分钟了解swagger](https://blog.csdn.net/i6448038/article/details/77622977)

- [Swagger介绍及使用](https://www.jianshu.com/p/349e130e40d5)

- [swagger官网](https://swagger.io)

- [Springfox github地址](https://github.com/springfox/springfox)

  