package com.zequs.demo.se.designpattern.pattern.composite;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zequs
 * @version $Id: se-demo, v0.1 2019 08 05 Exp $
 */
public class Composite extends Component {

    List<Component> components = new ArrayList<>();
    @Override
    public void operation() {

    }
    public  Composite(String name, String desc) {
        super(name,desc);
    }

    @Override
    public void add(Component c) {
        components.add(c);
    }

    @Override
    public void remove(Component c) {
        components.remove(c);
    }

    @Override
    public void print() {
        System.out.println(getName());
        if (!components.isEmpty()) {
            for (Component component: components) {
                component.print();
            }
        }
    }
}
