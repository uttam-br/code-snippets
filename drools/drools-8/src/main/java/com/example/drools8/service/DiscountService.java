package com.example.drools8.service;

import com.example.drools8.model.Product;
import org.kie.api.runtime.KieSession;
import org.springframework.stereotype.Service;

@Service
public class DiscountService {

    private final KieSession kieSession;

    public DiscountService(KieSession kieSession) {
        this.kieSession = kieSession;
    }

    public void applyRules(Product product) {
        kieSession.insert(product);
        kieSession.fireAllRules();
    }
}
