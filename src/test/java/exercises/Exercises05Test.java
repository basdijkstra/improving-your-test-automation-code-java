package exercises;

import order.OrderHandler;
import order.OrderItem;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Exercises05Test {

    @Test
    public void order1CopyOfFC25_ShouldLeave9CopiesRemaining() {

        OrderHandler orderHandler = new OrderHandler();

        boolean result = orderHandler.handleOrder(OrderItem.FC_25, 1);

        Assertions.assertTrue(result);
        Assertions.assertEquals(9, orderHandler.getStockForItem(OrderItem.FC_25));
    }

    @Test
    public void order101CopiesOfFortnite_ShouldFail() {

        OrderHandler orderHandler = new OrderHandler();

        boolean result = orderHandler.handleOrder(OrderItem.FORTNITE, 101);

        Assertions.assertFalse(result);
        Assertions.assertEquals(100, orderHandler.getStockForItem(OrderItem.FORTNITE));
    }

    @Test
    public void addStockForDOTT_ShouldThrowExpectedException() {

        OrderHandler orderHandler = new OrderHandler();

        Assertions.assertThrows(IllegalArgumentException.class,
                () -> orderHandler.addStockForItem(OrderItem.DAY_OF_THE_TENTACLE, 10));
    }

    @Test
    public void orderOutOfStockItem_ShouldFail() {

        /**
         * So, can we write a test that verifies the behaviour of our OrderHandler
         * when the stock for an item is equal to 0? If so, how? And is this the most
         * efficient way to test this? If not, what do we need to improve?
         */
    }

    @Test
    public void orderMoreThanFiveItemsUsingPayPal_ShouldFail() {

        /**
         * Next, can we write a test that verifies that we cannot pay for an order
         * with more than five copies of a game in it using PayPal? Why not?
         * What can we (should we) do to improve our code?
         */
    }

    /**
     * As a final comment, what do you think about the fact you will always need to
     * process a payment when you want to test placing an order, and you will always need to place
     * an order when you want to test processing a payment?
     */
}
