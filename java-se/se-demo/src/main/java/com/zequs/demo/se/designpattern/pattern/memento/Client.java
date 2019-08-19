package com.zequs.demo.se.designpattern.pattern.memento;

/**
 * 备忘录模式：保存一份资料
 * Originator:发起人，真正需要保存的对象,此例子中是state字段
 * Memento:备忘录对象，把需要保存的信息封装在此对象中（本来中是state）
 * Caretaker：管理类，操作备忘录对象
 * @author zequs
 * @version $Id: se-demo, v0.1 2019 08 12 Exp $
 */
public class Client {
    public static void main(String[] args) {
        Originator originator = new Originator();
        Caretaker caretaker = new Caretaker();

        originator.setState("攻击力：20点");
        caretaker.add(originator.saveStateMemento());

        originator.setState("攻击力：50点");
        caretaker.add(originator.saveStateMemento());

        originator.setState("攻击力：70点");
        caretaker.add(originator.saveStateMemento());

        originator.setState("攻击力：70点");
        caretaker.add(originator.saveStateMemento());

        //取第一次保存
        originator.getStateFromMemento(caretaker.getMemento(0));
        System.out.println(originator.getState());
    }

}
