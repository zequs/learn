#### 接口隔离原则（Interface Segregation Principle）

​		基本介绍：客户端不应该依赖它不需要的接口，即一个类对另一个类的依赖应该建立在最小的接口上

​		问题由来：类A通过接口I依赖类B，类C通过接口I依赖类D，如果接口I对于类A和类B来说不是最小接口，则类B和类D必须去实现他们不需要的方法。

​		处理：把接口I，拆成几个独立的接口。类各自实现自己需要的接口。

​		[代码地址](https://github.com/zequs/learn/tree/master/java-se/se-demo/src/main/java/com/zequs/demo/se/designpattern/philosophy/segregation)