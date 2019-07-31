#### 单一职责原则

​		**基本介绍：**对类来说的，即一个类只负责一项职责。如类A负责两个不同职责：职责1，职责2。当职责1需求变更二改变A时，可能造成职责2执行错误，所以需要讲类A的粒度分解为A1，A2。 

​		**注意事项：**

- ​	降低类的复杂度，一个类只负责一个职责

- 提高类的可读性，可维护性

- 降低变更引起的风险

- 通常情况下，**我们应当遵守单一职责原则**，只有逻辑足够简单，才可以在代码级违反单一职责原则；只有类中的方法数量足够少时，可以在方法级别上保存单一职责原则。

  **代码地址：**https://github.com/zequs/learn/tree/master/java-se/se-demo/src/main/java/com/zequs/demo/se/designpattern/principle/singleresponsibilityprinciple