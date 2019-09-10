package com.codingwithaya;

import org.apache.activemq.camel.component.ActiveMQComponent;
import org.apache.camel.ProducerTemplate;
import org.apache.camel.spring.SpringCamelContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {

    public static void main(String[] args) throws Exception {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("camelContext.xml");
        context.start();
        SpringCamelContext camelContext = SpringCamelContext.springCamelContext(context, false);
        System.out.println("Started routes: " + camelContext.getRoutes());
        ProducerTemplate producerTemplate = camelContext.createProducerTemplate();
        producerTemplate.sendBody("direct:sendToAyaQueue", "yahya");

    }
}
