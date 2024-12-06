package order;

public class StripeProcessor implements PaymentProcessor {

    public boolean payFor(OrderItem orderItem, int quantity) {

        return true;
    }
}
