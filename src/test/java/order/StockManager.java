package order;

import java.util.HashMap;
import java.util.Map;

import static java.util.Map.entry;

public class StockManager {

    private HashMap<OrderItem, Integer> stock;

    public StockManager() {

        stock = new HashMap<>();
        stock.put(OrderItem.FC_25, 10);
        stock.put(OrderItem.FORTNITE, 100);
        stock.put(OrderItem.SUPER_MARIO_BROS_3, 5);
    }

    public boolean removeFromStock(OrderItem item, int quantity) {

        if (!stock.containsKey(item)) {
            return false;
        }

        if (stock.get(item) == 0) {
            return false;
        }

        if (quantity > stock.get(item)) {
            return false;
        }

        stock.put(item, stock.get(item) - quantity);
        return true;
    }

    public void addStockForItem(OrderItem item, int quantity) {

        if (!stock.containsKey(item)) {
            throw new IllegalArgumentException("Item does not exist");
        }

        if (quantity <= 0) {
            throw new IllegalArgumentException("Quantity must be greater than 0");
        }

        stock.put(item, stock.get(item) + quantity);
    }

    public int getStockForItem(OrderItem item) {

        return stock.get(item);
    }
}
