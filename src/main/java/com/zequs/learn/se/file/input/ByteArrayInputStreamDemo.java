package com.zequs.learn.se.file.input;

import java.io.File;
import java.io.IOException;

public class ByteArrayInputStreamDemo {
    public static void main(String[] args) {
        String filePath = "D:\\source\\a.txt";
        String folderPath = "D:\\source";
        File file = new File(filePath);
        File folder = new File(folderPath);
        try {
            //是否存在
            if (!file.exists()) {
                file.createNewFile();
            }
            //是否为文件夹
            if (folder.isDirectory()) {
              File[]  fileArray = folder.listFiles();
                for (int i = 0; i < fileArray.length; i++) {
                    System.out.println(fileArray[i].getName());
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
