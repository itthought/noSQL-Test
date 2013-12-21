package com.test.redis;

import java.net.MalformedURLException;
import java.net.URL;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class HelloWorld {

	public static void main(String[] args) {
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext(
				"redisConfig.xml");
		Example eg = (Example) applicationContext.getBean("example");
		try {
			URL url = new URL("http://localhost:8888");
			eg.addLink("local", url);
			URL url1 = eg.getLink("local");
			System.out.println(url1.toString());

		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}