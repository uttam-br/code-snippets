package com.example.drools8;

import com.example.drools8.model.Product;
import com.example.drools8.service.DiscountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.CommandLineRunner;

@SpringBootApplication
public class DroolsApp implements CommandLineRunner {

    @Autowired
    private DiscountService discountService;

    public static void main(String[] args) {
        SpringApplication.run(DroolsApp.class, args);
    }

    @Override
    public void run(String... args) {
        Product product = new Product("Gaming Laptop", "electronics", 1500);
        discountService.applyRules(product);
        System.out.println("Final Discount: " + product.getDiscount() + "%");
    }
}
