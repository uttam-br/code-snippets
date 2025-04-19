package com.example.drools;

import com.example.drools.model.Product;
import com.example.drools.service.DiscountService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class DroolsSpringBootApp {

    public static void main(String[] args) {
        SpringApplication.run(DroolsSpringBootApp.class, args);
    }

    @Bean
    public CommandLineRunner run(DiscountService discountService) {
        return args -> {
            Product product = new Product("Smartphone", "electronics", 1200);
            discountService.applyDiscount(product);
            System.out.println("Discount: " + product.getDiscount() + "%");
        };
    }
}
