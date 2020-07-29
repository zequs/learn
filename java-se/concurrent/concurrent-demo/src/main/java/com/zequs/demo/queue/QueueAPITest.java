package com.zequs.demo.queue;

import com.zequs.demo.model.Person;

import java.util.concurrent.LinkedBlockingQueue;

/**  方法\处理方式   抛出异常------- 返回特殊值        一直阻塞     超时退出
 *   插入方式        add(e)         offer(e)        put(e)      offer(e,time,unit)
 *   移除方式       remove()        poll()          take()      poll(time,unit)
 *   检查方式       element()       peek()          不可用       不可用
 * @author zequs
 * @version : concurrent-demo, v0.1 2020 07 21 Exp $
 */
public class QueueAPITest {
    LinkedBlockingQueue<Person> queue = new LinkedBlockingQueue(10);

    /**
     * 如果没有可用空间（满了），则抛出异常IllegalStateException
     */
    public void add() {
        boolean result = queue.add(new Person("zhangsan", 18));
        System.out.println(result);
        for (int i = 0; i < 9; i++) {
            result = queue.add(new Person("zhangsan", 18));
            System.out.println(result);
        }
        result = queue.add(new Person("zhangsan", 18));
        System.out.println(result);
    }

    /**
     * 从尾部加入元素，如果没有可用空间（满了） 返回false
     */
    public void offer() {
        boolean result = queue.offer(new Person("zhangsan", 18));
        for (int i = 0; i < 9; i++) {
            result = queue.offer(new Person("zhangsan", 18));
            System.out.println(result);
        }
        result = queue.offer(new Person("zhangsan", 18));
        System.out.println(result);

    }


    /**
     * 如果没有可用空间（满了） 会一直阻塞，没有返回值，知道空了位置
     */
    public void put() {
        for (int i = 0; i < 10; i++) {
            try {
                queue.put(new Person("zhangsan", 18));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        try {
            System.out.println(1);
            queue.put(new Person("zhangsan", 18));
            System.out.println(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    /**
     * 检索并删除此队列的头,如果此队列为空，它将抛出异常, 有返回值 QUEUE类方法
     */
    public void remove() {
        Object remove = queue.remove();
    }
    /**
     * 从该队列中删除指定元素的单个实例（如果存在）,删除元素e使o.equals(e)
     * 如果此队列包含指定的元素则返回true。存在的话每次只会删除一个
     */
    public void remove(Person person) {
        Person person2 = new Person("zhangsan", 18);
        Person person3 = new Person("zhangsan", 19);
//        queue.add(person);
        queue.add(person2);
        queue.add(person3);
        boolean remove = queue.remove(person);
        System.out.println(remove);
        Integer age = queue.poll().getAge();
        System.out.println("age:" + age);
        System.out.println(queue.size());
        boolean remove2 = queue.remove(person);
        System.out.println(queue.size());
        System.out.println(remove2);
    }

    /**
     *  队列为空时，poll返回null
     */
    public void  poll() {
        Object poll = queue.poll();
        System.out.println(poll);
    }

    /**
     * 检索并删除此队列的头。队列空的时候，会一直阻塞。
     */
    public void  take() {
        try {
            Person take = queue.take();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    public static void main(String[] args) {
        QueueAPITest test = new QueueAPITest();
        test.take();
    }
}
