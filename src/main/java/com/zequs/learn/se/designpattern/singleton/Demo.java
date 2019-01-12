package com.zequs.learn.se.designpattern.singleton;

public class Demo {
    public static void main(String args[]) {
        Singleton s1 = Singleton.getInstance();
        Singleton s2 = Singleton.getInstance();
        s1.a = 11;
        System.out.println(s2.a);
        boolean aa = true;
        boolean bb = false;
        boolean cc = true;
        if (aa && bb || cc) {
            System.out.println(1);
        } else {
            System.out.println(2);
        }

        System.out.println("hello world!");
        byte  bTemp=111;
        System.out.println(bTemp);
// float fTemp=3.3f;
        int iTemp1=1,iTemp2=1;
        boolean bTemp1=(++iTemp1>0)||true&&(++iTemp2>0);   //这个应该是 1 2才对吧 我这输出21
        System.out.println(iTemp1+""+iTemp2);
        System.out.println(false && true || true);    //true 因为 &&比||优先
        System.out.println(true || true && false);    //true 因为 &&比||优先
    }
}
