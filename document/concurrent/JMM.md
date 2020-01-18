## JMM-JAVA内存模型

### 基础

#### 概念

`同步`

- 是指程序用于控制不同线程之间操作发生相对顺序的机制。

#### 并发编程分类

- 问题
  - 线程之间如何通信
    - 共享内存或消息传递
  - 线程之间如何同步
- 回答
  - 共享内存的并发模型
    - 线程之间通过写-读内存中的公共状态来隐式进行通信
  - 消息传递的并发模型
    - 明确的发送消息来显式进行通信
- `java`
  - `java`采用的共享内存模型，java线程之间的通信是隐式进行的（通过共享内存状态进行通信）。

#### java内存模型（JMM）的抽象

共享变量

- java中，所有实例域、静态域和数组元素在堆内存中，堆内存在线程之间共享，统称为共享变量

`JMM`

- JMM是一个抽象的概念，表示的是多个线程访问内存的规范，屏蔽操作系统和硬件的差异，它覆盖了缓存，写缓冲区，寄存器以及其他的硬件和编译器优化。最终实现java在各个平台都能达到一致性的内存访问效果

- java线程之间的通信是由java 内存模型（JMM）控制，JMM决定了一个线程共享变量的写入何时对另一个线程可见。

- JMM决定了线程和主存之间的抽象关系

  - 线程之间的共享变量存储在主内存中，每个线程都有一个私有的本地内存，本地内存中存储了该线程以读/写共享变量的副本。

  

#### 重排序和内存屏障

​		在执行程序时为了提高性能，编译期和处理器常常会对指令做重排序

分类：

- 编译器优化的重排序
  - 编译器重排序
  - 编译器在不改变单线程程序语义的前提下，可以重新安排语句的执行顺序
- 指令并行的重排序
  - 处理器重排序
  - 现代处理器采用了指令级并行技术来将多条指令重叠执行。如果不存在数据依赖性，处理器可以改变语句对鹰机器指令的执行顺序
- 内存系统的重排序
  - 处理器重排序
  - 由于处理器使用缓存和读/写缓冲区，这使得加载和存储操作看上去可能是在乱序执行
  - 理解
    - x是共享变量，r是局部变量，A，B是线程，①，②是执行顺序，x,r初始值都为0
      - ①A：x=1，②B：r=x
      - 线程A执行x=1时，可能X可能还在写缓冲区，还没刷新为主内存（x=0）时，线程B执行r=x了，但此时x还是0，看起来就像②比①先执行一样。看起来就像是乱序执行一样。

JMM控制

- 对于编译器
  - 会禁止特定类型的编译器重排序（不是所有编译器重排序都禁止）
- 对于处理器
  - 会要求java编译器在生成指令序列时，插入特定类型的内存屏障指令，通过内存屏障指令来禁止特定类型的处理器重排序
- JMM属于语言级别内存模型，它确保在不同的编译器和不容的处理器平台之上，通过禁止特定类型的编译器重排序和处理器重排序，为程序员提供一致的内存可见性保证。
- 不同处理器对重排序的处理
  - ![](C:\Users\admin\Desktop\文档\md\JMM\picture\20160507142016867.jpg)

    - store=>写，load=>读。一般处理器对写-读都会进行重排序，一般我们使用的处理器是x86
    - Y：允许重排序，N：不允许重排序

#### happens-before

- 概念
  - 阐述操作之间的可见性
- 规则
  - 程序顺序规则
    - 一个线程中的每个操作，happens-before与线程中的任意后续操作
  - 监视器锁规则
    - 对一个监视器的解锁，happens-before于随后对这个监视器的加锁
  - volatile变量规则
    - 对一个volatile的写，happens-before于任意后续对这个volatile的读
  - 传递性
    - A happens-before B，且B happens-before C，那么A happens-before C。
- 注意
  - 两个操作之间具有happens-before关系，并不意味着前一个操作必须要在后一个操作之前执行，happens-before仅仅要求前一个操作对后一个操作可见，且前一个操作按顺序排在第二个操作之前
- 作用
  - 一个happens-before规则对应于一个或多个编译器和处理器排序规则。
  - 对于程序员来说，happens-before规则简单易懂，它避免java程序员为了理解JMM提供的内存可见性保证而去学习复杂的重排序规则以及这些规则的具体表现。

### 重排序

#### 数据依赖性

两个操作访问同一个变量，且这两个操作中有一个是写操作，此时这 两个操作存在依赖性。

数据的依赖性，只针对单个处理器中执行的指令序列和单个线程中执行的操作，不同处理器，不同线程之间不做考虑。

#### as-if-serial

定义

- 不管怎么排序（编译器重排序，处理器重排序），（单线程）程序的执行结果不能被改变。

#### 程序顺序规则

​		根据happens-before的传递性，A happens-before B ，B happens-before C  则A happens-before C 

#### 重排序对多线程的影响

```java
class ReadExample{
    int a = 0;
    boolean flag = false;
    
    public void write() {
        a = 1;				//1
        flag = true;		//2
    }
    
    public void read() {
        if(flag) {			//3
            int i =  a*a;	//4
        }
    }
}
```

flag是一个标记，标识变量a是否被写入，线程A首先执行write()，线程B接着执行read()。

多线程的情况下，步骤1,2可能会发生重排序。从而会导致步骤3,4的结果。

#### 顺序一致性

### volatile

#### volatile的特性

- 可见性。volatile变量的读，总是能看到（任意线程）对这个volatile变量最后的写入
- 一定的原子性。对于任何单个volatile变量的读/写具有原子性，但类似于volatile++这周种复合操作无效
  - double类型是64位，在32位计算机中需要2个槽来表示double类型的变量。

#### volatile写-读建立的happens-before关系

- volatile的写中是before于volatile的读，再加上happens-before的传递性

#### volatile写-读的内存语义

volatile内存含义

- volatile写内存含义
  - 当写一个volatile变量时，JMM会把该线程对应的本地内存中的共享变量刷新到主内存
- volatile读内存含义
  - 当读一个volatile变量时，JMM会把该线程对应的本地内存置为无效，线程接下来将从主内存读取共享变量

#### volatile内存语义的实现 

- ![1567476669218](C:\Users\admin\Desktop\文档\md\JMM\picture\1567476669218.png)
  - 当第二个操作是volatile写，不管第一个操作是什么，都不能重排序。这个规则确保volatile写之前的操作不会被编译器重排序到volatile写之后。
  - 当第一个操作是volatile读时，不管第二个操作是什么，也不能重排序。这个规则确保volatile读之后的操作不会被编译器重排序到volatile读之前。
  - 当一个操作是volatile写，第二个操作是volatile读时，不能重排序。
- 为了实现volatile的内存含义，编译器在生成字节码时，会在指令序列中插入内存屏障来禁止特定类型的处理器重排序。
  - 保守的策略的JMM内存屏障插入策略
    - 在每一个volatile写操作的前面插入一个StoreStore屏障
    - 在每一个volatile写操作的后面插入一个StoreLoad屏障
    - 在每一个volatile读操作的后面插入一个LoadLoad屏障（注意都是后面）
    - 在每一个volatile读操作的后面插入一个LoadStore屏障（注意都是后面）
  - X86处理器内存屏障插入策略
    - 因为X86处理器只对写-读操作做重排序，所以只会在volatile写之后插入一个StoreLoad屏障

#### jsr-133为什么要增强volatile的内存语义

​		在jsr-133之前的旧java内存模型中，虽然不允许volatile变量之间重排序，但旧的java内存模型允许volatile变量与普通变量重排序。即例子中①跟②可以重排序，从而会导致①=>③=>④=>②这样的情况。

### 锁

#### 锁的释放-获取建立的happens-before关系

- 锁的释放befor于锁的获取

#### 锁释放和获取的内存含义

- 释放锁
  - 当线程释放锁时，JMM会把该线程对应的本地内存中的共享变量刷新到主内存中。
- 获取锁
  - 当现场获取锁时，JMM会把该线程对应的本地内存置为无效。从而使得被监视器保护的临界区代码必须要从内存中去读取共享变量

#### 锁内存语义的实现

锁java中锁的实现类大部分用的是ReetrantLock

公平锁与非公平锁

```java
public ReentrantLock(boolean fair) {
    sync = fair ? new FairSync() : new NonfairSync();
}
```

- 获取锁

  - 公平锁获取锁实现

    - ```java
      final void lock() {
          acquire(1);
      }
      public final void acquire(int arg) {
          if (!tryAcquire(arg) &&
              acquireQueued(addWaiter(Node.EXCLUSIVE), arg))
              selfInterrupt();
      }
      protected final boolean tryAcquire(int acquires) {
          final Thread current = Thread.currentThread();
          int c = getState();		//获取锁前使用volatile读获取state状态
          if (c == 0) {
              if (!hasQueuedPredecessors() &&
                  compareAndSetState(0, acquires)) {  	//获取锁
                  setExclusiveOwnerThread(current);
                  return true;
              }
          }
          else if (current == getExclusiveOwnerThread()) {
              int nextc = c + acquires;
              if (nextc < 0)
                  throw new Error("Maximum lock count exceeded");
              setState(nextc);
              return true;
          }
          return false;
      }
      ```

  - 非公平锁获取锁

    - ```java
      final void lock() {
          if (compareAndSetState(0, 1))		//CAS获取锁
              setExclusiveOwnerThread(Thread.currentThread());
          else
              acquire(1);
      }
      ```

    - CAS同时具有volatile读和volatile写的内存含义

- 释放锁

  - 公平锁与非公平锁释放锁都是一样的

  - ```java
    public void unlock() {
        sync.release(1);
    }
     public final boolean release(int arg) {
         if (tryRelease(arg)) {   //释放锁
             Node h = head;
             if (h != null && h.waitStatus != 0)
                 unparkSuccessor(h);
             return true;
         }
         return false;
     }
    protected final boolean tryRelease(int releases) {
        int c = getState() - releases;
        if (Thread.currentThread() != getExclusiveOwnerThread())
            throw new IllegalMonitorStateException();
        boolean free = false;
        if (c == 0) {
            free = true;
            setExclusiveOwnerThread(null);
        }
        setState(c); //释放锁最后一步，volatile写操作
        return free;
    }
    ```

  - volatile的happens-before规则，释放锁的线程在写volatile变量之前可见的共享变量，在获取锁的线程读取同一个volatile变量后将立即变的对获取锁的线程可见。

- 总结
  - 公平锁和非公平锁释放时，最后都要写一个volatile变量state
  - 公平锁获取锁时，首先会去读这个volatile变量
  - 非公平锁获取时，首先会用CAS更新这个volatile变量，这个操作同时具有volatile读和volatile写操作的内存含义
- 实现方式
  - 利用volatile变量的写-读所具有的内存含义
  - 利用CAS所附带的volatile读和volatile写的内存含义

#### concurrent包的实现

​		由于java的CAS同时具有volatile读和volatile写的内存含义，因此java线程之间的通信现在有下面四种方式

- 四种通信方式
  - A线程写volatile变量，随后B线程读这个volatile变量
  - A线程写volatile变量，随后B线程用CAS更新这个volatile变量
  - A线程CAS更新一个volatile变量，随后B线程利用CAS更新这个volatile变量
  - A线程用CAS更新一个volatile变量，随后B线程读这个volatile变量
- 通用化实现模式
  - 首先，声明共享变量为volatile
  - 然后，使用CAS的原子条件更新来实现线程之间的同步
  - 同时，配合以volatile的读/写和CAS所具有的volatile读和写的内存含义来实现线程之间的通信

### final

对于final域，编译器和处理器要遵循两个重排序规则

- 在构造器内对一个final域的写入，与随后把这个被构造对象的引用域值给一个引用变量，这两个操作之间不能重排序
- 初次读一个包含final域的对象的引用，与随后初次读这个final域，这两个操作之间不能重排序

#### 写final域的重排序规则

- JMM禁止编译器把final域的写重排序到构造函数之外
- 编译器会在final域写之后，构造器结束之前插入一个StoreStore屏障。这个屏障禁止final域的写重排序到构造函数之外

#### 读final域的重排序规则

- 在一个线程中，初次读对象引用与初次读该对象包含的final域，JMM禁止处理器重排序这两个操作。编译器会在读final域操作的前面插入一个LoadLoad屏障。

#### 如果final域是引用对象

- 对于final的引用类型约束
  - 在构造器函数内对一个final引用的对象的成员域的写入，与随后在构造函数外把这个构造对象的引用域值给一个引用变量，这两个操作之间不能重排序

#### 为什么final引用不能从构造函数逸出

#### final语义在处理器中的实现

- 写final域的重排序规则会要求编译器在final域的写之后，构造函数return之前，插入一个StoreStore屏障。读final域的重排序要求编译器在读final域的操作前面插入一个LoadLoad屏障。
- x86处理器只会对写-读做重排序，所以final域的读/写不会插入任何内存屏障。

#### JSR-133为什么要增强final的语义