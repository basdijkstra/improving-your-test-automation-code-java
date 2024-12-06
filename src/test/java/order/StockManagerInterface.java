package order;

public interface StockManagerInterface {
    boolean removeFromStock(OrderItem item, int quantity);

    void addStockForItem(OrderItem item, int quantity);

    int getStockForItem(OrderItem item);
}
