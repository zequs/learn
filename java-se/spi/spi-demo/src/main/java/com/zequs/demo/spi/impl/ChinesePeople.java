package com.zequs.demo.spi.impl;

import com.zequs.demo.spi.server.People;

/**
 * @author zequs
 * @version $Id: spi-demo, v0.1 2019 07 23 Exp $
 */
public class ChinesePeople implements People {

    @Override
    public void say() {
        System.out.println("普通话");
    }
}
