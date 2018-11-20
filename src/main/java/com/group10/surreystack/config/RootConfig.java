/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.group10.surreystack.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Controller;

/**
 *
 * @author maddie
 */
@Configuration
@ComponentScan(value = {"com.group10.surreystack"}, excludeFilters = {@ComponentScan.Filter(Controller.class)})
//@Import ({AppProperties.class})
public class RootConfig {
    
}
