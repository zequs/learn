package com.zequs.demo.se.designpattern.philosophy.segregation;

/**
 * 设计模式-接口隔离原则
 * 设计错误例子：
 * 类A只需要使用接口I的方法1,4,5就行
 * 类B只需要使用接口I的方法2,3就行
 * 类C只需要使用接口I的方法4,5就行
 * 但是因为接口I中有5个方法，他的实现都必须实现全部方法，但有些方法对实现类来说没用处。
 *
 * @author zequs
 * @version $Id: se-demo, v0.1 2019 07 30 Exp $
 */
public class Segregation1 {

    public static void main(String[] args) {
        //类A只需要使用接口I的方法1,2,3就行
        A a = new A();
        a.depend1(new B());
        a.depend2(new B());
        a.depend3(new B());

        //类C只需要使用接口I的方法4,5就行
        C c = new C();
        c.depend1(new D());
        c.depend4(new D());
        c.depend5(new D());
    }
}

interface I {
    public void method1();

    public void method2();

    public void method3();

    public void method4();

    public void method5();
}

class A {

    public void depend1(I i) {
        i.method1();
    }

    public void depend2(I i) {
        i.method2();
    }

    public void depend3(I i) {
        i.method3();
    }
}

class B implements I {

    @Override
    public void method1() {
        System.out.println("类A实现了接口I的method1方法");
    }

    @Override
    public void method2() {
        System.out.println("类A实现了接口I的method2方法");
    }

    @Override
    public void method3() {
        System.out.println("类A实现了接口I的method3方法");
    }

    //对类A来说method4没用，
    @Override
    public void method4() {
    }
    //对类A来说method=5没用，
    @Override
    public void method5() {
    }
}


class C {

    public void depend1(I i) {
        i.method1();
    }

    public void depend4(I i) {
        i.method4();
    }

    public void depend5(I i) {
        i.method5();
    }
}

class D implements I {

    @Override
    public void method1() {
        System.out.println("类D实现了接口I的method1方法");
    }
    //对类C来说method2没用，
    @Override
    public void method2() {

    }
    //对类C来说method3没用，
    @Override
    public void method3() {

    }

    @Override
    public void method4() {
        System.out.println("类D实现了接口I的method4方法");
    }

    @Override
    public void method5() {
        System.out.println("类D实现了接口I的method5方法");
    }
}