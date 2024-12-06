package order;

public class OrderHandler {

    private final StockManager stockManager;
    private final PaymentProcessor paymentProcessor;

    public OrderHandler(StockManager stockManager, PaymentProcessor paymentProcessor) {

        this.stockManager = stockManager;
        this.paymentProcessor = paymentProcessor;
    }

    public boolean handleRemoveFromStock(OrderItem item, int quantity) {

        return this.stockManager.removeFromStock(item, quantity);
    }

    public boolean handleOrderPayment(OrderItem item, int quantity) {

        return this.paymentProcessor.payFor(item, quantity);
    }

    public int getStockForItem(OrderItem item) {

        return this.stockManager.getStockForItem(item);
    }

    public void addStockForItem(OrderItem item, int quantity) {

        this.stockManager.addStockForItem(item, quantity);
    }
}
