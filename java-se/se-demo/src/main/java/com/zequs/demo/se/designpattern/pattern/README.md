### 设计模式

#### 单例

所谓类的单例设计模式，就是采用一定的方法保证在整个的软件系统中，对某个类只能存在一个对象实例，并且该类只提供一个取得其对象实例的方法（静态方法）。

单例模式八种方式

- 饿汉式（静态常量）
  - 优缺点说明：
    - 优点：
      - 这种写法比较简单，就是在类的装载的时候就完成了实例化，避免了线程同步问题
    - 缺点：
      - 在类装载的时候就完成了实例化，没有达到懒加载效果，如果从始至终从来没有使用过这个实例，则会造成内存的浪费
    - 这种方式基于`classloder`机制避免了多线程的同步问题，不过，instance在类装载是就实例化，在单例模式中大多数都是调用getInstance()，但是导致类装载的原因有很多种，因此不能确定有其他的方式导致类装载，这时候初始化instance就没有达到懒加载的效果。
    - 结论：这种单例方式可用，但会造成内存浪费。
- 饿汉式（静态代码块）
- 懒汉式（线程不安全）
- 懒汉式（线程安全，同步方法）
- 懒汉式（线程安全，同步代码块）
- 双重检查
- 静态内部类
- 枚举

#### 建造者模式

基本介绍

- 建造者模式又叫生成器模式，是一种对象构建模式。它可以将复杂的对象的建造过程抽象出来。使这个抽象过程的不同实现方法可以构造出不同表现的对象
- 建造者模式是一步一步创建一个复杂的对象，它允许用户只通过指定复杂对象的类型和内容就可以构建它们，用户不需要知道内部的具体构建细节。
- 四个角色
  - product(产品角色)：一个具体的产品对象
  - builder(抽象建造者)：创建有一个product对象的各个部件指定接口
  - concreteBuilder(具体建造者）：实现接口，构建和装配各个部件
  - Director(指挥者)：构建一个使用build接口的对象。它主要是用于创建一个复杂的对象。他只要有两个作用，
    - 隔离客户与生产的过程 
    - 复制制造产品对象的生产过程
- 注意事项
  - 客户端不必知道产品内部组成的细节，讲产品本身与产品的创建解耦，使得相同的创建过程可以创建不同的产品对象
  - 每一个具体建造者都相对独立，而与其他的具体建造者无关，因此可以很方便地替换具体建造者或增加新的建造者。用户使用不同的具体建造者可以得到不同的产品。
  - 可以更加精细的控制产品的创建过程。讲复杂产品的创建步骤分解在不同的方法中，使得创建过程更加清晰，也更方便使用程序来控制创建过程。
  - 增加新的具体创建者无须修改原有类库的代码，指挥者类针对抽象建造者类编程，系统扩展方便，符合开闭原则。
  - 建造者模式所创建的产品一般都较多的共同点，其组成部分相识，产品之间的差异很大的，则不适合此模式。因此使用范围受到一定的限制。
  - 如果产品内部变化复杂，可能会导致需要定义很多具体建造者来实现这种变化，导致系统变得很庞大，因此在这这种情况下，要考虑是否选择建造模式。
- 抽象工厂与建造者比较
  - 抽象工厂模式实现对产品家族的创建，一个产品家族是这样的一系列产品：具有不同分类维度的组合，采用抽象工厂模式不需要关心创建过程，只关系什么产品由什么工厂创建。而建造者模式则是要求按照指定的蓝图创建产品，它的主要目的是通过组装零配件而产生一个新产品。

#### 适配器模式 （adapter pattern）

基本介绍

- 适配器模式将某个类的接口转换成客户端期望的另一个接口表示，主要目的是兼容性，让原本接口不匹配不能一起工作的两个类可以协同工作，其别名是包装器（Wrapper）
- 适配器模式属于结构型模式
- 主要分三类：类适配器模式、对象适配器模式、接口适配器模式
  - 类适配器
    - adapter类，通过继承src（适配）类，实现dst（目标）类接口，完成src->dst的适配
- 工作原理
  - 适配器模式：将一个类的接口转换成另一个类的接口，让原本接口不兼容的类可以兼容
  - 从用户的角度看不到被适配者，是解耦的
  - 用户调用适配器转化出来的目标接口方法，适配器再调用被适配者的相关接口方法。
  - 用户收到反馈结果，感觉只是跟目标接口交互

#### 桥接模式

基本介绍

- 桥接模式是指：将实现与抽象放在两个不同的层次中，使两个层次可以独立改变
- 是一种结构设计模式
- 桥接模式基于类的最小设计原则，通过使用封装、聚合及继承等行为让不同的类承担不同的职能，它的主要特点是把抽象与实现分离开来，从而可以保持各部分的独立性以及应对他们的功能扩展

#### 装饰者模式(Decorator)

基本介绍

- 装饰者模式：动态的将新功能附件到对象上，在对象功能扩展方面，它比继承更有弹性，装饰者模式也遵守了开闭原则。

装饰者模式原理

- 装饰者模式就像打包一个快递
  - 主体（Component）：比如：陶瓷，衣服。被装饰者
  - 包装（Decorator）：比如报纸填充，塑料泡沫，纸板，木板。
- 如果ConcreteComponent（Component的实现）类很多，还可以设计一个缓冲层，将共有的部分提取出来。

类图

- 结构说明
  - decorator：装饰者，比如各种调料
  - component：主体
  - coffer：缓冲层

- ![1564994394140](picture\decorator.png)

#### 组合模式(Composite)

基本介绍

-  组合模式，又叫部分整体模式，它创建了对象组的树形结构，将对象组合成树状结构以表示“整体-部分”的层次部分
- 组合模式依据树形结构来组合对象，用来表示部分以及整体的层次。
- 这种类型的设计模式属于结构模式
- 组合模式使得用户对单个对象和组合对象的访问具有一致性，即：组合能让客户以一致的方式处理个别对象以及组合对象。

类图结构

- leaf：在组合中表示叶子节点，最后一个节点，叶子节点没有子节点
- composite：非叶子节点，用于存储子部件。
- component：为所有对象定义一个类，不管是叶子节点（最后一个节点）还是节点

解决的问题

- 当我们的要处理的对象可以生成一颗树形结构，而我们要对树上的节点和叶子节点进行操作时，它能够提供一致的方式，而不用考虑是叶子节点还是一般节点。

#### 外观模式（Facade）

基本介绍

- 外观模式也叫，过程模式，外观模式为子系统中的一组接口提供一个一致的界面，此模式定义一个高层接口，这个接口使得这一子系统更加容易使用
- 外观模式通过定义一个一致的接口，用以屏蔽内部子系统的细节，使得调用端只需跟这个接口发生调用，而无需关心这个子系统的内部细节

类图

- ![外观模式](picture\facade.png)

外观模式的注意事项与细节

- 外观模式对外屏蔽了子系统的细节，因此降低了客户端对子系统的复杂性
- 外观模式对客户端与子系统的耦合关系，让子系统的内部模块更易维护和扩展
- 通过合理的外观模式，可以帮我们更好的划分访问层次
- 当系统考虑使用分成设计时，可以考虑外观模式
- 在维护一个遗留的大型项目时，可能这个系统已经变得非常难以维护和扩展，此时可以考虑为新系统开发一个facade类，来提供遗留系统的比较清晰简单的接口，让新系统与facade类交互，提高复用性
- 不能过多的不合理的使用外观模式，使用外观模式好，还是直接调用模块好，要以让系统有层次，利于维护为目的。

#### 享元模式（Flyweight）

基本介绍 

- 享元模式：也叫蝇量模式，运用共享技术有效的支持大量细粒度的对象
- 常用于系统底层开发，解决系统的性能问题。像连接池技术，里面就是创建好的连接对象，在这些连接对象中有我们需要的则直接拿来用，避免重新创建，如果没有我们需要的，则创建一个
- 享元模式能够解决重复对象的内存浪费的问题，当系统中有大量相识对象，需要缓冲池时。不需要总是创建对象，可以从缓冲池中拿。这样可以提高系统内存，提高性能
- 享元模式经典的场景应用就是池技术，String常量池，数据库连接池，包装类等。享元模式是池技术的重要实现方式。

类图

- ![1565072953578](picture\flyweight.png)
  - Flyweight：是抽象的享元角色，他是产品的抽象类，产品外部状态，内部状态的抽象接口
  - ConcreteFlyweight：具体享元角色，内部状态，里面的数据是可以共享的。
  - UnConcreteFlyweight：具体享元角色，外部状态，里面的内部是不共享
  - FlyweightFactory:享元工厂，用于构建一个池容器，同时提供从池中获取相应对象方法

注意事项和细节

- 在享元模式这样理解，享表示共享，元表示对象
- 系统中有大量的 对象，这些对象需要很大内存，并且对象的状态大部分可以外部分时，我们就可以考虑选用享元模式
- 用唯一标识码判断，如果在内存中有，则返回一个唯一标识的对象，用容器（map）存储
- 享元模式大大减少了对象的创建，降低了程序内存的占用，提高效率
- 享元模式提高了系统的复杂度，需要分离出内部状态和外部状态，外部状态具有固化特性，不应该随着内部状态的改变而改变，这是我们使用享元模式需要注意的地方
- 使用享元模式时，需要分离出内部状态和外部状态，并且需要有一个工厂类加以控制
- 享元模式经典的应用场景就是缓冲池的场景。比如，String常量池，数据库连接池等

#### 代理模式（Proxy）

基本介绍

- 代理模式：为一个对象提供一个替身，以控制对这个对象的访问，即通过代理对象访问目标对象。这样的好处就是，可以在目标对象实现的基础上，增强额外的功能操作，即扩展目标的功能
- 代理模式分为静态代理和动态代理，动态代理按实现分又可分为JDK代理，cglib代理。

静态代理类图

![1565086411505](picture\proxy.png)

#### 模板模式（Template）

基本介绍

- 模板方法模式（Template method pattern）：又叫模板模式，在一个抽象类公开定义了执行它的方法模板。它的子类可以按需重写方法实现，但调用将以抽象类中定义的方法进行
- 简单来说，模板方法模式定义了一个操作中的算法的骨架，而将一些步骤延迟到子类中，使得子类可以不改变一个算法的结构，就可以重定义改算法的某些特定步骤
- 属于行为型模式

#### 命令模式（Command）

基本介绍

- 在软件设计中，我们经常需要向某些对象返送请求，但是不知道请求的接收者是谁，也不知道被请求的操作时哪个，我们只需在程序运行时指定具体的接收者即可，此时，可以用使用命令模式来进行设计
- 命令模式使得请求发送者与请求接收者消除彼此之间的耦合，然对象之间的调用关系更加灵活， 实现耦合
- 在命令模式中，会降一个请求封装成对象，以便使用不同的参数表示不同的请求。同时命令模式也支持撤销的操作（撤销也是一个命令）
- 通俗的理解，将军发布命令，士兵去执行，其中有几个角色，将军（命令发布者）、士兵（命令具体执行者）、通讯兵（连接将军与士兵）
  - Invoker:调用者（将军）
  - Receiver：被调用者，具体执行者（士兵）
  - Command：命令

注意事项与细节

- 将发起请求的对象与执行请求的对象解耦。发起请求的对象是调用者，调用者只要调用命令对象的execute()方法就可以让接收者工作，而不必知道具体的接收者对象是谁，是如何实现的，命令对象会负责让接收者执行请求的动作，也就是说“强求发起者”与“请求执行者”之间的解耦是通过命令对象实现的，命令对象起到了纽带桥梁的作用。
- 容易设计一个命令队列。只要把命令对象放入队列中，就可以多线程执行命令
- 容易实现对请求的撤销和重做
- 命令模式不足：可能导致某些系统有过多的具体命令类，增加了系统的复杂度，这点在使用的时候要注意。
- 命令模式的经典场景：界面的一个按钮就是一条命令。模拟CMD订单的撤销和恢复、触发-反馈机制。

#### 访问者模式（Visitor）

基本介绍

- 访问者模式：封装一些作用于某种数据结构的各元素的操作，它可以在不改变数据结构的前提下定义作用于这些元素的操作
- 主要将数据结构于数据操作分离，解决数据结构和操作耦合性问题
- 访问者模式的基本工作原理是：在被访问的类里面加一个对外提供接待访问者的接口
- 访问者应用场景：对于某个对象或者一组对象，不同的访问者，产生的结果不同，执行操作也不同。在这种场景下就可以使用访问者模式了.

类图

- 

注意事项与细节

- 优点
  - 访问者模式符合单一智能原则、让程序具有优秀的扩展性、灵活性
  - 访问者模式可以对功能进行统一，可以做报表、拦截器与过滤器，适用于数据结构相对稳定的系统
- 缺点
  - 具体元素对访问者公布细节，访问者关注了其他类的内部细节，这是迪米特法则所不建议的，这样造成了具体元素变更比较困难
  - 违背了依赖倒置原则，访问者依赖的是具体元素，而不是抽象元素
- 因此，如果一个系统有比较稳定的数据结构，又有经常变化的功能需求，那么访问者模式就比较合适

参考：

- [访问者模式-Visitor(Java实现)](https://www.cnblogs.com/noKing/p/9094354.html)

#### 迭代器模式（Iterator）

基本介绍

- 迭代器模式，是常用的设计模式。属于行为模式
- 如果我们的集合元素是用不同的方式实现的，有数组，java的集合类，或者其他方式，放客户端要遍历这些集合元素的时候要使用多种遍历方式，而且还会暴露元素的内部结构，可以考虑使用迭代器模式解决
- 迭代器模式，提供一种遍历集合元素的的统一接口，用一致的方法遍历集合元素，不需要知道集合对象的底层表示，既：不暴露其内部结构。

注意属性与细节

- 优点
  - 提供一个统一的方法遍历对象，客户不用再考虑集合的类型，使用一种方法就可以遍历对象了
  - 隐藏了聚合的内部结构，客户端要遍历聚合的时候只能取到迭代器，而不会知道聚合的具体组成
  - 提供了一种设计思想，就是一个类应该只有一个引起变化的原因（叫做单一职责原则）。在聚合类中，我们把迭代器分开，就是要把管理对象集合和遍历对象集合的责任分开，这样一来，集合改变的话，只影响到聚合对象，则如果遍历方式改变的话，只影响到迭代器。
  - 当要展示一组相识对象，或者遍历一组相同对象的时候，适合使用迭代器
- 缺点
  - 每个聚合对象都要一个迭代器，会生成多个迭代器不好管理

#### 观察者模式（Observer）

基本介绍

- 观察者模式对象之间多对一依赖的一种设计模式，被依赖的对象为Subject，依赖的对象为Observer，Subject通知Observer变化，比如Subject,是1的一方，Observer是多的一方

#### 中介者模式（Mediator）

基本介绍

- 用一个中介对象来封装一系列的对象交互。中介者使各个对象不需要显式地相互引用，从而使其耦合松散，而且可以独立的改变它们之间的交互

- 中介者属于行为模式，使代码易于维护

- 比如MVC模式，C（controller）是M（model）和V（view）的中介者，在前后端交互中起到中间人的作用。

#### 备忘录模式（memento）

基本介绍

- 备忘录模式在不破坏封装性的情况下，捕获一个类的内部状态， 并在该对象之外保存这个状态。这样以后就可将该对象恢复到原来保存的状态
- 可以这样理解备忘录模式：现实生活中的备忘录是用来记录将要去做的事情，或者是记录共同达成的某件事情，以防忘记，而在软件层面，备忘录有相同的含义，备忘录对象主要用来记录一个对象的某种状态，或者某些数据，当要做回退时，可以从备忘录对象里获取原来的数据进行恢复操作
- 备忘录属于行为型模式

注意事项与细节

- 给用户提供了一个可以恢复状态的机制，可以使用户比较方便的回导历史某一状态
- 实现了信息的封装，使用户不需要关系状态保存的细节
- 如果类的成员变量很多，势必会占用比较大的内存，而且每一次保存都会消耗一定的内存。
- 适用场景：
  - 后悔药。
  - 打游戏时存档。
  - Windows的ctrl+z
  - IE中的后退
  - 数据库的事物管理
- 为了节约内存，备忘录模式可以和原型模式配合使用

#### 解释器模式（Interpreter）

基本介绍

- 在编译原理中，一个算术表达式通过词法分析器形成词法单元，而后这些词法单元再通过语法分析器构建语法分析树，最终形成一颗抽象的语法分析树，这里的词法分析器和语法分析器都可以看成解释器
- 解释器模式：是指给定一个语言，定义它的文法一种表示，并定义一个解释器，使用该解释器来解释语言中的句子
- 应用场景
  - 一些重复出现的问题可以用一种简单的语言来表达
  - 一个简单语法需要解释的场景
  - 这样的例子还有，比如解释器、运算表达式计算、正则表达式、机器人等

#### 状态模式（state）

基本介绍

- 状态模式：它只要是用来解决对象在多种状态转换时需要对外输出不同的行为的问题。状态很行为是一一对应的，状态之间是可以相互转换
- 当一个对象的内在状态改变时，允许改变其行为，这个对象看起来就像是改变了其类

类图

- 

注意事项与细节

- 代码有很强的可读性，状态模块将每个行为封装到对应的类中
- 方便维护，将容易产生问题的if-else语句删除了，如果把每个状态的行为都放到一个类中，每次调用方法时都要判断当前是什么状态，不但会产生很多if-else语句，很容易出错
- 符合开闭原则，容易增删状态
- 会产生很多类，每个状态都会创建一个类，当状态很多是会创建很多类， 加大维护难度
- 当一个事件或者对象有很多状态，状态之间相互转换，对不同状态要求有不同的行为。可以考虑使用状态模式

#### 策略模式（Strategy）

基本介绍

- 策略模式：定义算法族，分别封装起来，让他们之间可以互相替换，此模式让算法的变化独立于使用算法的客户
- 这算法体现了几个设计原则
  - 把变化的代码从不变的代码中分离出来。
  - 针对接口编程而不是具体类（定义策略接口）。
  - 多用组合/聚合,少用继承。

类图

- ![策略模式](picture/strategy.png)
  - FlyBehavior：抽象特征策略，这里是鸭子能不要飞的策略
  - BadFlyBehavior：具体策略的实现，表示策略的某一种形式。
  - NoFlyBehavior：具体策略的实现，表示策略的另一种表示形式。
  - Duck：策略载体,每一种策略行为都要进行组合，如鸭子飞，鸭子叫等

注意事项与 细节

-  策略模式的关键是：分析项目的变化部分与不变部分
- 策略模式的核心思想是：多用组合/聚合，少用继承：用行为类组合，而不是行为的继承。更有弹性
- 体现了“对修改关闭，对扩展开放”原则，客户端增加行为不用修改原有代码，只要添加一种策略（或者行为）即可，避免了使用多重转移语句（if...else...）
- 提供了可以替换继承关系的办法：策略模式将算法封装在独立的Stratery类中使得你可以独立于其Context改变它，使它易于切换、易于理解、易于扩展
- 需要注意的是：每添加一个策略就要添加一个类，当策略过多时会导致类数目庞大。

#### 职责链模式（responsibility）

基本介绍

- 职责链模式又叫责任链模式，为请求创建一个接收者对象的链。这种模式对请求的发送者和接收者进行解耦
- 职责链模式通常每个接收者都包含对另一个接收者的引用。如果一个对象不能处理该请求，那么它会把相同的请求吃传给下一个接收者，依此类推
- 职责链属于行为模式

类图

- ![责任链模式](picture/responsibility.png)
  - Approver：`Handler`角色职责链处理职责的地方
  - DepartmentApprover：ComcreteHandler具体的处理类其中的一个链条
  - PurchaseRequest：需求载体。

注意事项与细节

- 将请求与事例分开，实现解耦，提高系统的灵活性
- 简化了对象，使对象不需要知道链的存在
- 性能会受到影响，特别是链比较长的时候，一次需控制链的最大节点数量。一般通过在handdler中设置一个最大节点数，在`setNext()`方法中判断是否已超过阈值，超过则不允许该链建立，避免出现超长链无意识的破坏系统性能
- 调试不方便，采用了类似递归的方式，调试时可能逻辑比较复杂
- 最佳应用场景：有多个对象处理同一个请求，比如：多级请求、请假/加薪等审批流程、java web中Tomcat对Encoding的处理、拦截器

源码地址：[职责链模式源码地址](https://github.com/zequs/learn/tree/master/java-se/se-demo/src/main/java/com/zequs/demo/se/designpattern/pattern/responsibility)