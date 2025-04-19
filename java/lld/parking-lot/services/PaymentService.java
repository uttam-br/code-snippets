package services;

import models.Invoice;
import models.Payment;
import models.PaymentMethod;
import models.constants.PaymentMethodType;

import java.util.List;

public class PaymentService {

    public Payment makePayment(Invoice invoice) {
        Payment payment = new Payment();

        PaymentMethod ccPayment = new PaymentMethod();
        ccPayment.setAmount(200);
        ccPayment.setPaymentMethodType(PaymentMethodType.CC);
        ccPayment.setReferenceId("CC-PAYMENT");

        PaymentMethod cashPayment = new PaymentMethod();
        cashPayment.setAmount(invoice.getTotalAmount() - 200);
        cashPayment.setReferenceId("CASH-PAYMENT");
        cashPayment.setPaymentMethodType(PaymentMethodType.CASH);

        payment.setPaymentMethods(List.of(ccPayment, cashPayment));
        payment.setSuccess(true);

        return payment;
    }

}
