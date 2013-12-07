package com.radhey.memcache.manager;

import java.util.Date;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.danga.MemCached.MemCachedClient;

@Component
@Scope("prototype")
public class MemcachedManager {
	private MemCachedClient memCachedClient;
	
	public MemCachedClient getMemCachedClient() {
		return memCachedClient;
	}
	
	public void setMemCachedClient(MemCachedClient memCachedClient) {
		this.memCachedClient = memCachedClient;
	}


	protected Object get(String key){
		if ((key == null) || (key.trim().equals(""))){
			System.out.println("Get attempt against null or empty key.Returning null value.");
			return null;
		}
		System.out.println("Memcache key = " + key);
		return memCachedClient.get(key);
	}
	
	protected boolean add(String key, Object value){
		boolean status = false;
		if ((key == null) || (key.trim().equals(""))){
			System.out.println("Add attempt against null or empty key.");
			return status;
		}
		
		if (value == null){
			System.out.println("Add attempt of null value against key = " + key);
			return status;
		}
		
		System.out.println("Memcache key = " + key);
		
		if (get(key) != null){
			System.out.println("Add attempt of value which is already present in memcache against key = " + key);
			status = replace(key, value);
			return status;
		}else	
			status = memCachedClient.add(key, value);
		
		if (status){
			System.out.println("Successfully added value against key = " + key);
			//addMemcacheKeyToMaster(key);
		}else {
			System.out.println("Failed to add value against key = " + key);
		}
		return status;
	}
	
	protected boolean add(String key, Object value, Date date){
		boolean status = false;
		if ((key == null) || (key.trim().equals(""))){
			System.out.println("Add attempt against null or empty key.");
			return status;
		}
		
		if (value == null){
			System.out.println("Add attempt of null value against key = " + key);
			return status;
		}
		
		System.out.println("Memcache key = " + key);
		
		if (get(key) != null){
			System.out.println("Add attempt of value which is already present in memcache against key = " + key);
			System.out.println("Call delete or replace");
			return status;
		}
		
		status = memCachedClient.add(key, value, date);
		
		if (status){
			System.out.println("Successfully added value against key = " + key);
			//addMemcacheKeyToMaster(key);
		}else {
			System.out.println("Failed to add value against key = " + key);
		}
		return status;
	}
	
	protected boolean delete(String key){
		boolean status = false;
		if ((key == null) || (key.trim().equals(""))){
			System.out.println("Delete attempt against null or empty key.");
			return status;
		}
		
		if (get(key) == null){
			System.out.println("Delete attempt of value which is not present in memcache against key = " + key);
			return status;
		}
		
		System.out.println("Memcache key = " + key);
		
		status = memCachedClient.delete(key);
		if (status){
			System.out.println("Successfully deleted value against key = " + key);
			//deleteMemcacheKeyFromMaster(key);
		}else {
			System.out.println("Failed to delete value against key = " + key);
		}
		return status;
	}
	
	protected boolean replace(String key, Object value){
		boolean status = false;
		if ((key == null) || (key.trim().equals(""))){
			System.out.println("Replace attempt against null or empty key.");
			return status;
		}
		
		System.out.println("Memcache key = " + key);
		
		status = memCachedClient.replace(key, value);
		if (status){
			System.out.println("Successfully replaced value against key = " + key);
		}else {
			System.out.println("Failed to replace value against key = " + key);
		}
		return status;
	}
	
	protected boolean replace(String key, Object value, Date date){
		boolean status = false;
		if ((key == null) || (key.trim().equals(""))){
			System.out.println("Replace attempt against null or empty key.");
			return status;
		}
		
		System.out.println("Memcache key = " + key);
		
		status = memCachedClient.replace(key, value, date);
		if (status){
			System.out.println("Successfully replaced value against key = " + key);
		}else {
			System.out.println("Failed to replace value against key = " + key);
		}
		return status;
	}
	
	public boolean flushAll(){
		boolean status = false;
		status = memCachedClient.flushAll();
		if (status){
			System.out.println("Successfully flushed all memcached data");
		}else {
			System.out.println("Failed to flush all memcached data");
		}
		return status;
	}
	
	/**
	 * Returns the running statistics for MemCache.
	 * @return Map
	 */
	public Map showStats(){
		Map statsMap = memCachedClient.stats();
		Map stats = null;
		if(statsMap != null && statsMap.keySet().size() > 0) {
			Set keys = statsMap.keySet();
			Iterator ite = keys.iterator();
			while(ite.hasNext()){
				String key = (String)ite.next();
				stats = (Map)statsMap.get(key);
			}
			return stats;
		}else
			return null;
	}
	
	protected Object getMulti(String[] keyList){
		if ((keyList == null) || keyList.length==0){
			System.out.println("Get attempt against null or empty key.Returning null value.");
			return null;
		}
		System.out.println("Memcache key = " + keyList);
		return (Object)memCachedClient.getMulti(keyList);
	}

}
