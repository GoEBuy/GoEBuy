package com.goebuy.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DemoTask implements Runnable {
	
    private static final Logger logger = LoggerFactory.getLogger(DemoTask.class);

    @Override
    public void run() {
        logger.info("call DemoTask.run");
    }
} 