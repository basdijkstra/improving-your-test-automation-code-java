package exercises;

import order.OrderHandler;
import order.OrderItem;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Exercises06Test {

    @Test
    public void useMockedStockManager() {

        /**
         * First, write a test that:
         * - Creates a new OrderHandler
         * - Places 6 orders for OrderItem.SUPER_MARIO_BROS_3, each with quantity = 1
         *   (remember, the original stock is only 5)
         * - Asserts that the 6th order fails
         */

        /**
         * Now that we can inject a StockManager object when creating the OrderHandler,
         * write a test that:
         * - Creates a mock StockManager
         * - Configures the StockManager to always return 'false' when removeFromStock() is called
         *   for OrderItem.SUPER_MARIO_BROS_3 and quantity 1
         * - Injects the mock StockManager into a new OrderHandler
         * - Places 1 order for OrderItem.SUPER_MARIO_BROS_3, with quantity = 1
         *   (remember, the original stock is 5)
         * - Asserts that this fails (so without having to place 5 actual orders first)
         * - Verifies that exactly one call was made to the mocked StockManager method
         */
    }

    @Test
    public void useMockedPaymentProcessor() {

        /**
         * Discuss: assuming that the PaymentProcessor class and its implementation is borrowed
         * from another project (developed either internally or externally), should we mock it in
         * our tests? Why? Why not? Try and find arguments for either side.
         */
    }
}
