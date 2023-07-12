package com.ivoyant.customerjourney.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenAPIConfig {

    @Bean
    public OpenAPI myOpenAPI() {
        Contact contact = new Contact();
        contact.setEmail("test@test.com");
        contact.setName("test");
        contact.setUrl("test.com");

        Info info = new Info()
                .title("Customer Search Journey Dashboard")
                .version("1.0")
                .contact(contact)
                .description("Customer Search");


        return new OpenAPI().info(info);

    }
}
