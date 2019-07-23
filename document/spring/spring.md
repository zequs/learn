### spring杂记

#### `DefaultSingletonBeanRegistry`类

​		默认单例注册类。单例bean容器。

- `singletonObjects`：一级缓存

  ​	单例bean总容器，所有的单例bean都在这

- `earlySingletonObjects`：二级缓存
  - 是singletonFactory 制造出来的 singleton 的缓存
  - 能保存beanFactory
    - 把beanFactory提早暴露出来，用于依赖注入
  - 能保存bean(待验证)

- `singletonFactories`：三级缓存

  - 单例bean工厂，工厂类，用来生产bean。
  - `earlySingletonObjects`保存bean工厂的时候，会删除`singletonFactories`中的beanFactory

  

  ​	

