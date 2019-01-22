package com.zequs.learn.se.filesystem;

import com.zequs.learn.model.Person;
import org.springframework.util.CollectionUtils;

import java.io.IOException;
import java.io.InputStream;

/**
 * @author admin
 * @version $Id: learn, v0.1 2019 01 17 Exp $
 */
public class Test {
    public static void main(String[] args) throws IOException, Exception {
        aa();
    }

    public static  void  aa() throws Exception {
        String name = "张三";//这里默认是utf-8传输的

//传输过来的时候是什么编码格式这里就用什么编码格式取，如果是浏览器发过来的那默认是iso-8859-1，其他看发送方式什么编码格式发送的。
        byte[] b1 = name.getBytes("UTF-8");
//在转换成utf-8的字符串
        String name1 = new String(b1, "UTF-8"); //编码解码相同，正常显示
        System.out.println(name1);
        String name2 = new String(b1, "GBK"); //编码解码不同，乱码
        System.out.println(name2);


        byte[] b2 = name.getBytes("GBK");
        String name3 = new String(b2, "GBK"); //编码解码相同，正常显示
        System.out.println(name3);
        String name4 = new String(b2, "UTF-8"); //编码解码不同，乱码
        System.out.println(name4);
    }
}
