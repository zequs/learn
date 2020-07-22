package com.zequs.netty.netty.demo;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.util.AttributeKey;
import io.netty.util.NettyRuntime;

/**
 * @author zequs
 * @version $Id: netty-demo, v0.1 2019 10 18 Exp $
 */
public class NettyTest {
    public void openServer(int port) throws Exception {
        TestInterface[] testInterface = new TestInterface[5];

        EventLoopGroup bossGroup = new NioEventLoopGroup(1);// parent group
        EventLoopGroup workGroup = new NioEventLoopGroup();// child group
        try {
            ServerBootstrap serverBoot = new ServerBootstrap();
            serverBoot.group(bossGroup, workGroup)
                    .channel(NioServerSocketChannel.class)// 设置服务端Channel
                    .childOption(ChannelOption.TCP_NODELAY, true)// 设置TCP的基本属性
                    .childAttr(AttributeKey.newInstance("childAttr"), "childAttrValue")
                    .handler(new ServerHandler())// 服务端启动过程中有什么逻辑
                    .childHandler(new ChannelInitializer<SocketChannel>() {
                        @Override
                        protected void initChannel(SocketChannel ch) throws Exception {
                            //ch.pipeline().addLast();
                        }
                    });
            ChannelFuture future = serverBoot.bind(port).sync();
            future.channel().closeFuture().sync();
        } finally {
            bossGroup.shutdownGracefully();
            workGroup.shutdownGracefully();
        }
    }

    public static void main(String[] args) throws Exception {
        System.out.println(NettyRuntime.availableProcessors());
        NettyTest test = new NettyTest();
//        test.openServer(8084);
    }
}
