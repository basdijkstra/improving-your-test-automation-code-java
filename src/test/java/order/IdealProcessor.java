package order;

public class IdealProcessor implements PaymentProcessor {

    public boolean payFor(OrderItem orderItem, int quantity) {

        return true;
    }
}
