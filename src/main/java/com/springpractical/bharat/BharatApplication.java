package com.springpractical.bharat;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author : Bharat Padhiyar
 */
@SpringBootApplication
@OpenAPIDefinition(
        info = @Info(
                contact = @Contact(
                        name = "Bharat Padhiyar",
                        email = "bpadhiyar4@gmail.com"
                ),
                title = "Spring API Project",
                description = "Spring practical test project",
                version = "V1"
        )
)
public class BharatApplication {

    public static void main(String[] args) {
        SpringApplication.run(BharatApplication.class, args);
    }
}
