package models;

import models.enums.PaymentStatus;

import java.util.List;

public class Payment {

    private List<PaymentMethod> paymentMethods;
    private PaymentStatus status;

}
