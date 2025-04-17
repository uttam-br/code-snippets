package com.example.drools.service;

import com.example.drools.model.Product;
import org.kie.api.runtime.KieSession;
import org.springframework.stereotype.Service;

@Service
public class DiscountService {

    private final KieSession kieSession;

    public DiscountService(KieSession kieSession) {
        this.kieSession = kieSession;
    }

    public void applyDiscount(Product product) {
        kieSession.insert(product);
        kieSession.fireAllRules();
    }
}
