package com.radhey.memcache.manager;

import org.springframework.stereotype.Component;

import com.danga.MemCached.MemCachedClient;

@Component
public class TestMemcachedManager extends MemcachedManager {
	public TestMemcachedManager(){
		super(); 
		MemCachedClient memCachedClient = new MemCachedClient("POOL");
		super.setMemCachedClient(memCachedClient);
	}
}

