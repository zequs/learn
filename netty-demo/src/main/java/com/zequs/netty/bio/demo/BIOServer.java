package com.zequs.netty.bio.demo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 转载：https://blog.csdn.net/qq_22933035/article/details/79967791
 * @version $Id: netty-demo, v0.1 2019 10 14 Exp $
 */
public class BIOServer {

    public void openServer(int port) {
        try {
            ServerSocket server = new ServerSocket(port);
            System.out.println("传统服务器服务器启动！");
            while (true) {
                Socket socket = server.accept();
                //创建一个线程
//                new Thread(() -> handler(socket)) ;
                handler(socket);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void handler(Socket socket) {
        System.out.println("服务器开始处理");
        BufferedReader reader = null;
        PrintWriter out = null;
        try {
            InputStream inputStream = socket.getInputStream();
            reader = new BufferedReader(new InputStreamReader(inputStream));
            out = new PrintWriter(socket.getOutputStream());
            String str;
            while ((str = reader.readLine()) != null) {
                System.out.println(str);
                out.write("hello " + str);
                out.flush();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (out != null) {
                out.close();
            }
        }
    }


    public static void main(String[] args) {
        BIOServer server = new BIOServer();
        server.openServer(8083);
    }
}
