package com.zequs.learn.se.base;

import java.util.Calendar;
import java.util.Scanner;

public class ScannerDemo {
    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        System.out.println("What is you name?");
        String name = in.nextLine();
        System.out.println("you name is " + name);
        System.out.println("How old are you");
        int age = in.nextInt();
        System.out.println("you old is " + age);
    }
}
