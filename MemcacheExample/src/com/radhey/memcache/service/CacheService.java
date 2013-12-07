package com.radhey.memcache.service;

import org.springframework.stereotype.Component;

import com.radhey.memcache.manager.TestMemcachedManager;

@Component
public class CacheService extends TestMemcachedManager {

	public void loadCache() {

		loadDataInCatch();
		fetchValue();
		
	}

	
	public void loadDataInCatch() {
		boolean isAdded = add("Key1", "radhey");
		
		if (isAdded)
			System.out.println("Added success fully");
		
		if (!isAdded)
			System.out.println("Error in addition fully");
	}
	
	public void fetchValue() {
		String value = (String) get("Key1");
		if(value!=null && !value.equalsIgnoreCase(""))
		{
			//value fetch from catched
			System.out.println("catched value:" +value);
		}
		else
		{
			// something wrong with catch. Fetch data from db
			System.out.println("something wrong with catch. Fetch data from db");	
		}
		
	}
   public void updateCatchValue(String key,String value) 
   {
	   boolean isAdded = replace(key, "Shyam");
		
		if (isAdded)
			System.out.println("replaced success fully");
		
		if (!isAdded)
			System.out.println("Error in replacing fully");
   }
	
}