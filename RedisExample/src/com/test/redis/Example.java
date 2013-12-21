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
 * Date: 21-Dec-2013
 * Last Date of Modification: 21-Dec-2013 4:03:28 PM
 * Comments: 
 * Version: 1.0
 * 
 */

package com.test.redis;

import java.net.MalformedURLException;
import java.net.URL;

import org.springframework.data.redis.core.RedisTemplate;

public class Example {

	private RedisTemplate<String, String> redisTemplate;

	public RedisTemplate<String, String> getRedisTemplate() {
		return redisTemplate;
	}

	public void setRedisTemplate(RedisTemplate<String, String> redisTemplate) {
		this.redisTemplate = redisTemplate;
	}

	public void addLink(String userId, URL url) {
		redisTemplate.boundListOps(userId).leftPush(url.toExternalForm());
	}

	public URL getLink(String userId) {
		try {
			URL url = new URL(redisTemplate.boundListOps(userId).rightPop());
			return url;
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

}
