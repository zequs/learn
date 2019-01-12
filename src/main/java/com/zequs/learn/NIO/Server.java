package com.zequs.learn.NIO;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.SocketAddress;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.Set;

public class Server {
    public static void main(String args[]) {
        try {

            ServerSocketChannel channel = ServerSocketChannel.open();
            channel.configureBlocking(false);
            channel.bind(new InetSocketAddress(8686));
            Selector selector = Selector.open();
            SelectionKey selectionkey = channel.register(selector,SelectionKey.OP_ACCEPT);
            while (true) {
                selector.select();
                Set set = selector.selectedKeys();
                Iterator<SelectionKey> iterator = set.iterator();
                while (iterator.hasNext()) {
                    SelectionKey key = iterator.next();
                    iterator.remove();
                    if (key.isAcceptable()) {
                        //accept(key)
                    } else if (key.isConnectable()) {
                        //connection()
                    } else if (key.isReadable()) {
                        //read()
                    } else if (key.isWritable()) {
                        //write()
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
