package com.codingwithaya.route;

import org.apache.camel.ExchangePattern;
import org.apache.camel.builder.RouteBuilder;

public class AMQRoute extends RouteBuilder {
    public void configure() throws Exception {

        from("direct:sendToAyaQueue")
                .log("Entering the route")
                // Below line sends the message to AMQ queue AyaQueue
                .to(ExchangePattern.InOnly, "activemq:queue:AyaQueue")
                .log("Messsage sent to AMQ Queue :: ${body}");

        // Below line reads the message from the AMQ queue AyaQueue
        from("activemq:queue:AyaQueue")
                .log("Messsage read from AMQ Queue : ${body}")
                .transform(simple("Hello ${body}, Welcome to CodingWithAya Team"))
                .convertBodyTo(String.class, "UTF-8");
    }
}
