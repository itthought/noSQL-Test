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
 * Date: 26-Jul-2013
 * Last Date of Modification: 26-Jul-2013 11:54:50 AM
 * Comments: 
 * Version: 1.0
 * 
 */

package Server;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import Server.RedisManager;

public class ContainerStartup implements ServletContextListener {
    public void contextInitialized(ServletContextEvent event) {
        // Do your thing during webapp's startup.
		//create and configure a RedisPool.
		RedisManager.getInstance().connect();
    }
    public void contextDestroyed(ServletContextEvent event) {
        // Do your thing during webapp's shutdown.
		//destroy a RedisPool.
		RedisManager.getInstance().release();
    }
}

