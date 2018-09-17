package com.goebuy.listener;

import java.io.File;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.apache.log4j.PropertyConfigurator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.ContextLoader;

import com.goebuy.utils.ApplicationContextUtil;

@Component
public class InitApplicationListener extends ContextLoader implements ServletContextListener {

	private static Logger logger = LoggerFactory.getLogger(InitApplicationListener.class);
	
    public InitApplicationListener() {
    }

    /** 
     * @see javax.servlet.ServletContextListener#contextInitialized(javax.servlet.ServletContextEvent)
     */
    @Override
    public void contextInitialized(ServletContextEvent sce) {

    	 String log4j_path = "log4j.properties";
         log4j_path = sce.getServletContext().getInitParameter("log4jConfigLocation");
         if(! new File(log4j_path).exists() ) {
         	throw new RuntimeException("log file " + log4j_path+ " not found");
         }
         PropertyConfigurator.configure(log4j_path);
        // 初始化Spring容器
        ApplicationContextUtil.applicationContext = initWebApplicationContext(sce.getServletContext());
        logger.info("contextInitialized");
        String rootpath = sce.getServletContext().getRealPath("/");
        if (rootpath != null) {
         rootpath = rootpath.replaceAll("\\\\", "/");
        } else {
         rootpath = "/";
        }
        if (!rootpath.endsWith("/")) {
         rootpath = rootpath + "/";
        }
        System.out.println("Application Run Path:" + rootpath);
        logger.info("Application Run Path:" + rootpath);
       
    }

    /** 
     * @see javax.servlet.ServletContextListener#contextDestroyed(javax.servlet.ServletContextEvent)
     */
    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        closeWebApplicationContext(sce.getServletContext());
        logger.info("contextDestroyed");
    }

}
