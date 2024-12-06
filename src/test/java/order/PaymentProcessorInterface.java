package order;

public interface PaymentProcessorInterface {

    boolean payFor(OrderItem orderItem, int quantity);
}
