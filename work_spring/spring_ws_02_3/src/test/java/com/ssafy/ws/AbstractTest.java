package com.ssafy.ws;

import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import com.ssafy.ws.config.ApplicationConfig;

@RunWith(SpringRunner.class)
//@ContextConfiguration(locations = "/application.xml")
@ContextConfiguration(classes = ApplicationConfig.class)
public class AbstractTest {}
