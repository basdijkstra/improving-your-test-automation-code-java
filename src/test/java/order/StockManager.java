package order;

import java.util.HashMap;

public class StockManager {

    private HashMap<OrderItem, Integer> stock;

    public StockManager(HashMap<OrderItem, Integer> stock) {

        this.stock = stock;
    }

    public boolean removeFromStock(OrderItem item, int quantity) {

        if (!this.stock.containsKey(item)) {
            return false;
        }

        if (this.stock.get(item) == 0) {
            return false;
        }

        if (quantity > this.stock.get(item)) {
            return false;
        }

        this.stock.put(item, this.stock.get(item) - quantity);
        return true;
    }

    public void addStockForItem(OrderItem item, int quantity) {

        if (!this.stock.containsKey(item)) {
            throw new IllegalArgumentException("Item does not exist");
        }

        if (quantity <= 0) {
            throw new IllegalArgumentException("Quantity must be greater than 0");
        }

        this.stock.put(item, this.stock.get(item) + quantity);
    }

    public int getStockForItem(OrderItem item) {

        return this.stock.get(item);
    }
}
