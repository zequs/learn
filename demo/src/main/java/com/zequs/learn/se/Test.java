package com.zequs.learn.se;

import com.alibaba.dubbo.common.Extension;
import com.alibaba.dubbo.common.extension.Adaptive;
import com.alibaba.dubbo.common.extension.ExtensionLoader;
import com.alibaba.dubbo.config.spring.ServiceBean;
import com.alibaba.dubbo.rpc.Protocol;
import com.alibaba.dubbo.rpc.protocol.dubbo.DubboProtocol;

import java.lang.reflect.Method;
import java.net.InetAddress;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.TreeSet;
import java.util.concurrent.ThreadPoolExecutor;

public class Test {
    public static void main(String args[]) throws Exception {
        System.out.println(A.NAME);
        TreeSet set = new TreeSet();
        for (int i = 0; i < 5; i = i + 2) {
            set.add(i);
        }
        System.out.println(set.lower(4));
        String host = InetAddress.getLocalHost().getHostAddress();
        System.out.println("host:" + host);
        HashMap hashMap = new HashMap();

        Protocol protocol = ExtensionLoader.getExtensionLoader(Protocol.class).getAdaptiveExtension();
        boolean flag = DubboProtocol.class.isAnnotationPresent(Adaptive.class);
        System.out.println(flag);
    }

    static class A {
        public static String NAME = "hello world!!";
    }
}
