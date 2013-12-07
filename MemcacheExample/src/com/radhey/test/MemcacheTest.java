package com.radhey.test;
 
import java.util.logging.Logger;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.radhey.memcache.service.CacheService;
 
public class MemcacheTest {
 static Logger log = Logger.getLogger(MemcacheTest.class.getName());
 public static void main(String[] args) {
  ApplicationContext applicationContext = new ClassPathXmlApplicationContext("memcacheConfig.xml");
  CacheService cacheService=new CacheService();
  cacheService.loadCache();
  cacheService.updateCatchValue("Key1", "Shyam");
  cacheService.fetchValue();
 }
}