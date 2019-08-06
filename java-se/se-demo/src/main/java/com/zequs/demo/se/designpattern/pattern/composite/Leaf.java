package com.zequs.demo.se.designpattern.pattern.composite;

/**
 * @author zequs
 * @version $Id: se-demo, v0.1 2019 08 05 Exp $
 */
public class Leaf extends Component {

    public Leaf(String name, String desc) {
        super(name, desc);
    }

    @Override
    public void operation() {
        System.out.println("----");
    }

    @Override
    public void add(Component c) {
        System.out.println("不能添加节点");
    }

    @Override
    public void remove(Component c) {
        System.out.println("删除失败，叶子节点没有子节点");
    }

    @Override
    public void print() {

    }
}
