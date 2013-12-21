/*
 * Author: radhey
 * Date: 21-Dec-2013
 * Last Date of Modification: 21-Dec-2013 3:11:26 PM
 * Comments: 
 * Version: 1.0
 * 
 */

package com.redis.service.impl;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.redis.service.TempService;

@Service("TempService")
public class TempServiceImpl implements TempService {

	 /**
     * Using SpEL for conditional caching - only cache method executions when
     * the name is equal to "Radhey"
     */
    @Cacheable(value="messageCache", condition="'Radhey'.equals(#name)")
    public String getMessage(String name) {
        System.out.println("Executing TempServiceImpl" +
                        ".getHelloMessage(\"" + name + "\")");
        return "Hello " + name + "!";
    }

}

