package models;

public class PaymentMethod {
    
    private PaymentMethodType methodType;
    private Invoice invoice;

    PaymentMethod(PaymentMethodType methodType, Invoice invoice) {
        this.methodType = methodType;
        this.invoice = invoice;
    }

}
