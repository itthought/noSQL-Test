/*
 * Author: radhey
 * Date: 21-Dec-2013
 * Last Date of Modification: 21-Dec-2013 1:36:37 PM
 * Comments: 
 * Version: 1.0
 * 
 */

package com.redis.test;

import redis.clients.jedis.Jedis;

import com.redis.manager.RedisManager;

public class RedisTest {

	public static void main(String[] args) {
		RedisManager.getInstance().connect();
		Jedis jedis = RedisManager.getInstance().getJedis();
		jedis.set("foo", "bar");
		String foobar = jedis.get("foo");
		System.out.println(foobar);
		RedisManager.getInstance().release();

	}

}

