package com.zequs.learn.NIO;

import org.springframework.expression.spel.ast.Selection;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.SocketChannel;
import java.util.Iterator;

public class Client {
   static ByteBuffer byteBuffer = ByteBuffer.allocate(64);
    public static void main(String args[]) {
        try {
            Selector selector = Selector.open();
            SocketChannel clientChannel = SocketChannel.open();
            clientChannel.configureBlocking(false);
            clientChannel.connect(new InetSocketAddress(8686));

            while (true) {
                selector.select();
                Iterator<SelectionKey> iterator = selector.selectedKeys().iterator();
                while (iterator.hasNext()) {
                    SelectionKey key = iterator.next();
                    iterator.remove();
                    if (key.isWritable()) {
                        
                    } else if (key.isConnectable()) {
                        doConnect(key);
                    } else if (key.isReadable()) {
                        doRead(key);
                    }
                }

            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private static void doRead(SelectionKey key) {

    }

    private static void doConnect(SelectionKey key) {
        SocketChannel clientChannel = (SocketChannel) key.channel();
        if (clientChannel.isConnectionPending()) {
            try {
                clientChannel.finishConnect();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        try {
            clientChannel.configureBlocking(false);
        } catch (IOException e) {
            e.printStackTrace();
        }
        String  info = "你好，服务端";
        byteBuffer.clear();
        byteBuffer.put(info.getBytes());
        byteBuffer.flip();
        try {
            clientChannel.write(byteBuffer);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                clientChannel.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
