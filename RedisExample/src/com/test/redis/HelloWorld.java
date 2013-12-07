package com.test.redis;
 
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.test.redis.domain.TestDomain;
import com.test.redis.domain.User;
import com.test.redis.repository.Repo;
import com.test.redis.repository.UserRepository;
 
public class HelloWorld {
 
 public static void main(String[] args) {
  ApplicationContext applicationContext = new ClassPathXmlApplicationContext("redisConfig.xml");
  UserRepository userRepository = (UserRepository) applicationContext.getBean("userRepository");
  
  Repo repo = (Repo) applicationContext.getBean("repo");
  
  TestDomain obj1=new TestDomain();
  obj1.setAge(10);obj1.setAddress("dada");obj1.setName("radhey");
  
  TestDomain obj2=new TestDomain();
  obj2.setAge(11);obj2.setAddress("dasda");obj2.setName("shyam");
  
  TestDomain obj3=new TestDomain();
  obj3.setAge(14);obj3.setAddress("dadfwsda");obj3.setName("sdaaradhey");
  
  
  //System.out.println(repo.pushRight("test").toString());
  User user1 = new User("1", "user 1");
  User user2 = new User("2","user 2");
  User user3 = new User("2","user 2");
  User user4 = new User("2","user 2");
  User user5 = new User("2","user 2");
  obj1.setResponse(user1);
  repo.putLeft(obj1);
  obj2.setResponse(user2);
  repo.putLeft(obj2);
  System.out.println(repo.pushRight("test").toString());
  System.out.println(repo.pushRight("test").toString());
 // System.out.println(repo.pushRight("test").toString());
  obj3.setResponse(user3);
  repo.putLeft(obj3);
  System.out.println(repo.pushRight("test").toString());
  
  
  
//  userRepository.put(user1);
//  System.out.println(" Step 1 output : " + userRepository.getObjects());
//  userRepository.put(user2);
//  System.out.println(" Step 2 output : " + userRepository.getObjects());
//  userRepository.delete(user1);
//  System.out.println(" Step 3 output : " + userRepository.getObjects());
//  
//  userRepository.leftPush(user2);
//  userRepository.leftPush(user3);
//  userRepository.leftPush(user4);
//  System.out.println(" Step 2 output : " + userRepository.rightPop(user2.getKey()));
//  System.out.println(" Step 2 output : " + userRepository.rightPop(user2.getKey()));
//  System.out.println(" Step 2 output : " + userRepository.rightPop(user2.getKey()));
//  System.out.println(" Step 2 output : " + userRepository.rightPop(user2.getKey()));
//  System.out.println(" Step 2 output : " + userRepository.rightPop(user2.getKey()));
//  System.out.println(" Step 2 output : " + userRepository.rightPop(user2.getKey()));
//  System.out.println(" Step 2 output : " + userRepository.rightPop(user2.getKey()));
//  System.out.println(" Step 2 output : " + userRepository.rightPop(user2.getKey()));
//  userRepository.leftPush(user5);
//  System.out.println(" Step 2 output : " + userRepository.rightPop(user2.getKey()));
 }
}