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
 * Last Date of Modification: 28-Jul-2013 6:17:33 PM
 * Comments: 
 * Version: 1.0
 * 
 */

package com.test.redis.domain;

import java.io.Serializable;

public class TestDomain<T> implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -4856474899316197714L;
	int age;
	String name;
	String address;
	private T response;
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	
	public T getResponse() {
		return response;
	}
	public void setResponse(T response) {
		this.response = response;
	}
	@Override
	public String toString()
	{
		return "[age="+age+",name="+name+",address="+address+",response="+response.toString()+"]";
	}

}

