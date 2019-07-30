package com.zequs.demo.springboot.demo.jar;

import org.springframework.boot.loader.JarLauncher;
import org.springframework.boot.loader.jar.JarFile;

/**
 * JarLauncher 启动 spring boot 项目jar 包
 * @author zequs
 * @version $Id: springboot-jar-demo, v0.1 2019 07 17 Exp $
 */
public class Test extends JarLauncher {

    protected void launch(String[] args) throws Exception {
        JarFile.registerUrlProtocolHandler();
        ClassLoader classLoader = createClassLoader(getClassPathArchives());
        launch(args, getMainClass(), classLoader);
    }

    /**
     * @param args
     * @throws Exception
     */
    public static void main(String[] args) throws Exception {
        new Test().launch(args);
    }
}
