package com.foo;

import org.springframework.context.annotation.Bean;

import java.io.File;

/**
 * @author zequs
 * @version $Id: spring, v0.1 2019 06 12 Exp $
 */
public class Test {
	public static void main(String[] args) {
		System.out.println(11);
		File file = new File("");
		file.lastModified();
	}
	@Bean
}
