/*
 * Copyright (C) One97 Communications Ltd. - All Rights Reserved
 * 
 * NOTICE:  All information contained herein is, and remains
 * the property of One97 Communications Ltd. Incorporated and its suppliers,
 * if any.  The intellectual and technical concepts contained
 * herein are proprietary to One97 Communications Ltd.
 * and its suppliers and may be covered by India, U.S. and Foreign Patents,
 * patents in process, and are protected by trade secret or copyright law.
 * Dissemination of this information or reproduction of this material
 * is strictly forbidden unless prior written permission is obtained
 * from One97 Communications Ltd. Unauthorized copying of this file, via any medium
 * is strictly prohibited
 * Author: radhey
 * Date: 28-Jul-2013
 * Last Date of Modification: 28-Jul-2013 6:22:14 PM
 * Comments: 
 * Version: 1.0
 * 
 */

package com.test.redis.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;

import com.test.redis.domain.TestDomain;
import com.test.redis.domain.User;

public class Repo {
	@Autowired
	 private RedisTemplate<String,TestDomain<User>> redisTemplate;

	
	public void setRedisTemplate(RedisTemplate<String, TestDomain<User>> redisTemplate1) {
		this.redisTemplate = redisTemplate1;
	}
	
	public void putLeft(TestDomain<User> obj)
	{
		redisTemplate.opsForList().leftPush("test", obj);
	}
	
	public TestDomain pushRight(String key)
	{
		return (TestDomain)redisTemplate.opsForList().rightPop("test");
	}
	
	public TestDomain getData(String key)
	{
		return (TestDomain)redisTemplate.opsForList().rightPop("test");
	}
}

