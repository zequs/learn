package com.zequs.netty.bio.demo;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.util.Scanner;

/**
 * @author zequs
 * @version $Id: netty-demo, v0.1 2019 10 14 Exp $
 */
public class BIOClient {

    public static void main(String[] args) throws IOException {
        Socket socket = new Socket();
        socket.connect(new InetSocketAddress("127.0.0.1", 8084));
        OutputStream outputStream = socket.getOutputStream();
        InputStream read = socket.getInputStream();
        //BufferedReader reader=new BufferedReader(new InputStreamReader(read));
        Scanner scanner = new Scanner(System.in);
        scanner.useDelimiter("\n");
        while (scanner.hasNext()) {
            String nextLine = scanner.nextLine();
            //System.out.println(nextLine);
            outputStream.write((nextLine + "\n").getBytes());
            outputStream.flush();
            byte[] bytes = new byte[1024];
            int num = read.read(bytes);
            System.out.println("Reci   " + new String(bytes, 0, num));
        }
        read.close();
        outputStream.close();
        socket.close();
    }
}
