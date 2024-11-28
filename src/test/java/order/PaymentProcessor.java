package order;

public class PaymentProcessor {

    private final PaymentProcessorType paymentProcessorType;

    public PaymentProcessor(PaymentProcessorType paymentProcessorType) {
        this.paymentProcessorType = paymentProcessorType;
    }

    public boolean payFor(OrderItem orderItem, int quantity) {

        // With Stripe or iDeal, you can pay for every order
        if (this.paymentProcessorType.equals(PaymentProcessorType.STRIPE) || this.paymentProcessorType.equals(PaymentProcessorType.IDEAL)) {
            return true;
        }

        // With PayPal, you can only pay for small orders
        return quantity <= 5;
    }
}
