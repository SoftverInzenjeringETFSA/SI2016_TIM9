package com.ws1001;

import org.resthub.web.springmvc.router.RouterConfigurationSupport;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;

import java.util.ArrayList;
import java.util.List;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = "com.ws1001.controllers")
public class WebAppConfig extends RouterConfigurationSupport {
    @Override
    public List<String> listRouteFiles() {

        List<String> routeFiles = new ArrayList<String>();
        routeFiles.add("classpath:routes.conf");
        return routeFiles;
    }
}