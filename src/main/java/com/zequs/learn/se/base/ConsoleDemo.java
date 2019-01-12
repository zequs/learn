package com.zequs.learn.se.base;

import java.io.Console;

public class ConsoleDemo {
    public static void main(String args[]) {
        Console cons = System.console();

        String name = cons.readLine("User name:");
        char[] passwd = cons.readPassword("Password:");
    }
}
