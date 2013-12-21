
package com.redis.manager;
 
/*
 * Author: radhey
 * Date: 21-Dec-2013
 * Last Date of Modification: 21-Dec-2013 1:36:37 PM
 * Comments: 
 * Version: 1.0
 * 
 */
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;
 
public class RedisManager {
    private static final RedisManager instance = new RedisManager();
    private static JedisPool pool;
    private RedisManager() {}
    public final static RedisManager getInstance() {
        return instance;
    }
    public void connect() {
        // Create and set a JedisPoolConfig
        JedisPoolConfig poolConfig = new JedisPoolConfig();
        // Maximum active connections to Redis instance
        poolConfig.setMaxActive(20);
        // Tests whether connection is dead when connection
        // retrieval method is called
        poolConfig.setTestOnBorrow(true);
        /* Some extra configuration */
        // Tests whether connection is dead when returning a
        // connection to the pool
        poolConfig.setTestOnReturn(true);
        // Number of connections to Redis that just sit there
        // and do nothing
        poolConfig.setMaxIdle(5);
        // Minimum number of idle connections to Redis
        // These can be seen as always open and ready to serve
        poolConfig.setMinIdle(1);
        // Tests whether connections are dead during idle periods
        poolConfig.setTestWhileIdle(true);
        // Maximum number of connections to test in each idle check
        poolConfig.setNumTestsPerEvictionRun(10);
        // Idle connection checking period
        poolConfig.setTimeBetweenEvictionRunsMillis(60000);
        // Create the jedisPool
        pool = new JedisPool(poolConfig, "localhost", 6379);
    }
    public void release() {
        pool.destroy();
    }
    public Jedis getJedis() {
        return pool.getResource();
    }
    public void returnJedis(Jedis jedis) {
        pool.returnResource(jedis);
    }
}