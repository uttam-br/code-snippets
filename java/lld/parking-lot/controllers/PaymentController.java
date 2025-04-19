package controllers;

import models.Invoice;
import models.Payment;
import services.PaymentService;

public class PaymentController {

    private final PaymentService paymentService = new PaymentService();

    public Payment makePayment(Invoice invoice) {
        return paymentService.makePayment(invoice);
    }

}
