package order;

public interface PaymentProcessor {

    boolean payFor(OrderItem orderItem, int quantity);
}
