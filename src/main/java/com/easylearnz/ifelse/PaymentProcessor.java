package com.easylearnz.ifelse;

import java.util.HashMap;
import java.util.Map;

public class PaymentProcessor {
    private Map<String, Runnable> paymentMethodMap = new HashMap<>();

    public void processPayment(String paymentMethod) {
        Runnable actions = paymentMethodMap.getOrDefault(paymentMethod, this::processDefaultPayment);
        actions.run();
    }

    public PaymentProcessor() {
        paymentMethodMap.put("UPI", this::processUPIPayment);
        paymentMethodMap.put("PAYPAL", this::processPaypalPayment);
        paymentMethodMap.put("NET_BANKING", this::processNetBankingPayment);
        paymentMethodMap.put("CREDIT_CARD", this::processCreditCardPayment);
    }

    private void processDefaultPayment() {
        // process default payment
    }

    private void processNetBankingPayment() {
    }

    private void processCreditCardPayment() {
        // process credit card payment
    }

    private void processPaypalPayment() {
        // process paypal payment
    }

    private void processUPIPayment() {
        // process UPI payment
    }
}
