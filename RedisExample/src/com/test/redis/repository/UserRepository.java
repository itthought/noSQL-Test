package com.test.redis.repository;
 
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;

import com.test.redis.domain.User;
 
public class UserRepository implements Repository<User>{
 
 @Autowired
 private RedisTemplate<String,User> redisTemplate;
  
 public RedisTemplate<String,User> getRedisTemplate() {
  return redisTemplate;
 }
 
 public void setRedisTemplate(RedisTemplate<String,User> redisTemplate) {
  this.redisTemplate = redisTemplate;
 }
 
 @Override
 public void put(User user) {
  redisTemplate.opsForHash()
    .put(user.getObjectKey(), user.getKey(), user);
 }
 
 public void leftPush(User user) {
	  redisTemplate.opsForList()
	    .leftPush(user.getKey(), user);
	 }

 public User rightPop(String key) {
	 return (User) redisTemplate.opsForList()
	    .rightPop(key);
	 }

 @Override
 public void delete(User key) {
  redisTemplate.opsForHash().delete(key.getObjectKey(), key.getKey());
 }
 
 @Override
 public User get(User key) {
  return (User) redisTemplate.opsForHash().get(key.getObjectKey(),
    key.getKey());
 }
 
 
 
 @Override
 public List<User> getObjects() {
  List<User> users = new ArrayList<User>();
  for (Object user : redisTemplate.opsForHash().values(User.OBJECT_KEY) ){
   users.add((User) user);
  }
  return users;
 }
}