package com.zequs.demo.se.designpattern.philosophy.segregation;

/**
 * 设计模式-接口隔离原则
 * 接口设计修改
 *
 * @author zequs
 * @version $Id: se-demo, v0.1 2019 07 30 Exp $
 */
public class Segregation2 {
    public static void main(String[] args) {
        //类A只需要使用接口I的方法1,2,3就行
        A1 a1 = new A1();
        a1.depend1(new B());
        a1.depend2(new B());
        a1.depend3(new B());

        //类C只需要使用接口I的方法1,4,5就行
        C1 c1 = new C1();
        c1.depend1(new D());
        c1.depend4(new D());
        c1.depend5(new D());
    }
}

interface I1 {
    public void method1();
}

interface I2 {
    public void method2();

    public void method3();
}

interface I3 {
    public void method4();

    public void method5();
}

class A1 {

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

class B1 implements I1, I2 {

    @Override
    public void method1() {
        System.out.println("类B1实现了接口I的method1方法");
    }
    @Override
    public void method2() {
        System.out.println("类B1实现了接口I的method2方法");
    }

    @Override
    public void method3() {
        System.out.println("类B1实现了接口I的method3方法");
    }
}

class C1 {
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

class D1 implements I1,I3 {

    @Override
    public void method1() {
        System.out.println("类D1实现了接口I的method3方法");
    }

    @Override
    public void method4() {
        System.out.println("类D1实现了接口I的method4方法");
    }

    @Override
    public void method5() {
        System.out.println("类D1实现了接口I的method5方法");
    }
}