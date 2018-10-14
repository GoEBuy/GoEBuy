package com.goebuy.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by luodejin on 2018/10/8.
 */
@RestController
@RequestMapping("/health")
public class HealthCheckController {

    @RequestMapping("/check")
    public String check() {
        return "OK";
    }

}
