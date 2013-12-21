/*
 * Author: radhey
 * Date: 21-Dec-2013
 * Last Date of Modification: 21-Dec-2013 3:15:13 PM
 * Comments: 
 * Version: 1.0
 * 
 */

package com.redis.main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import com.redis.service.TempService;

public class MainClass {
	  public static void main(String[] args) {
		  
	        ApplicationContext ctx = null;
	         ctx = new GenericXmlApplicationContext("redis-spring.xml");
	        TempService helloService = ctx.getBean("TempService", TempService.class);
	 
	        //First method execution using key="Ram", not cached
	        System.out.println("message: " + helloService.getMessage("Ram"));
	 
	        //Second method execution using key="Ram", still not cached
	        System.out.println("message: " + helloService.getMessage("Ram"));
	 
	        //First method execution using key="Radhey", not cached
	        System.out.println("message: " + helloService.getMessage("Radhey"));
	 
	        //Second method execution using key="Radhey", cached
	        System.out.println("message: " + helloService.getMessage("Radhey"));
	 
	        System.out.println("Done.");
	    }
}

