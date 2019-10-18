package com.zequs.netty.nio.demo;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Iterator;

/**
 * 转载：https://blog.csdn.net/qq_22933035/article/details/79967791
 *
 * @version $Id: netty-demo, v0.1 2019 10 14 Exp $
 */
public class NIOServer {

    //选择器
    private Selector selector;

    public void openServer(int port) {
        try {
            // 获得一个ServerSocket通道
            ServerSocketChannel channel = ServerSocketChannel.open();
            // 设置通道为非阻塞
            channel.configureBlocking(false);
            // 将该通道对应的ServerSocket绑定到port端口
            channel.socket().bind(new InetSocketAddress(port));
            // 获得一个选择器
            this.selector = Selector.open();
            // 将通道管理器和该通道绑定，并为该通道注册SelectionKey.OP_ACCEPT事件,注册该事件后，
            // 当该事件到达时，selector.select()会返回，如果该事件没到达selector.select()会一直阻塞。
            channel.register(selector, SelectionKey.OP_ACCEPT);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void listen() throws IOException {
        System.out.println("服务端启动成功！");
        // 轮询访问selector
        while (true) {
            // 当注册的事件到达时，方法返回；否则,该方法会一直阻塞
            selector.select();
            // 获得selector中选中的项的迭代器，选中的项为注册的事件
            Iterator<?> ite = this.selector.selectedKeys().iterator();
            while (ite.hasNext()) {
                SelectionKey key = (SelectionKey) ite.next();
                // 删除已选的key,以防重复处理
                ite.remove();
                handler(key);
            }
        }
    }

    public void handler(SelectionKey key) throws IOException {
        if (key.isAcceptable()) {
            handlerAccept(key);
            // 获得了可读的事件
        } else if (key.isReadable()) {
            handelerRead(key);
        }
    }

    /**
     * 处理连接请求
     *
     * @param key
     * @throws IOException
     */
    public void handlerAccept(SelectionKey key) throws IOException {
        ServerSocketChannel server = (ServerSocketChannel) key.channel();
        // 获得和客户端连接的通道
        SocketChannel channel = server.accept();
        // 设置成非阻塞
        channel.configureBlocking(false);

        // 在这里可以给客户端发送信息哦
        System.out.println("新的客户端连接");
        // 在和客户端连接成功之后，为了可以接收到客户端的信息，需要给通道设置读的权限。
        channel.register(this.selector, SelectionKey.OP_READ);
    }

    /**
     * 处理读的事件
     *
     * @param key
     * @throws IOException
     */
    public void handelerRead(SelectionKey key) throws IOException {
        // 服务器可读取消息:得到事件发生的Socket通道
        SocketChannel channel = (SocketChannel) key.channel();
        // 创建读取的缓冲区
        ByteBuffer buffer = ByteBuffer.allocate(1024);
        int read = channel.read(buffer);
        if (read > 0) {
            byte[] data = buffer.array();
            String msg = new String(data).trim();
            try {
                System.out.println("开始接收数据……");
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            System.out.println("服务端收到信息：" + msg);

            //回写数据
            ByteBuffer outBuffer = ByteBuffer.wrap("OK".getBytes());
            channel.write(outBuffer);// 将消息回送给客户端
        } else {
            System.out.println("客户端关闭");
            key.cancel();
        }
    }

    public static void main(String[] args) throws Exception{
        NIOServer server = new NIOServer();
        server.openServer(8084);
        server.listen();
    }
}
