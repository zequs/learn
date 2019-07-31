#### 依赖倒置原则(Dependency Inversion Principle)

​		定义：

-  高层模块不应该依赖底层模块，二者都应该其抽象
- 抽象不应该依赖细节，细节应该依赖抽象
- 依赖倒转的中心思想是面向接口编程 
- 依赖倒转原则是基于这样的设计理念：相对于细节的多变性，抽象的东西要稳定的多。以抽象为基础搭建的架构比以细节为基础的架构要稳定的多。在java中，抽象指的就是接口或抽象类，细节指的实现类。
- 使用接口或抽象的目的是为了指定好规范，而不涉及任何具体的操作，把展现细节任务交给他们的实现类去完成。
    [代码地址](https://github.com/zequs/learn/tree/master/java-se/se-demo/src/main/java/com/zequs/demo/se/designpattern/principle/dependencyinversion)