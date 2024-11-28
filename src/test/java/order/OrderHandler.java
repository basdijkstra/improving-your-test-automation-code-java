package order;

public class OrderHandler {

    private final StockManager stockManager;
    private final PaymentProcessor paymentProcessor;

    public OrderHandler() {

        this.stockManager = new StockManager();
        this.paymentProcessor = new PaymentProcessor(PaymentProcessorType.IDEAL);
    }

    public boolean handleOrder(OrderItem item, int quantity) {

        if (this.stockManager.removeFromStock(item, quantity)) {
            return this.paymentProcessor.payFor(item, quantity);
        }

        return false;
    }

    public int getStockForItem(OrderItem item) {

        return this.stockManager.getStockForItem(item);
    }

    public void addStockForItem(OrderItem item, int quantity) {

        this.stockManager.addStockForItem(item, quantity);
    }
}
