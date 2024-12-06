package order;

public class PayPalProcessor implements PaymentProcessor {

    public boolean payFor(OrderItem orderItem, int quantity) {

        return quantity <= 5;
    }
}
