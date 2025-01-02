
package com.example.webservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.core.env.Environment;

@SpringBootApplication
public class WebServiceApplication {
    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(WebServiceApplication.class, args);

        // Retrieve the assigned port
       // Environment env = context.getEnvironment();
       // String port = env.getProperty("local.server.port");
       // System.out.println("Web UI Service is running on port: " + port);
    }
}



