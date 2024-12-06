package exercises;

import order.OrderHandler;
import order.OrderItem;
import order.StockManager;
import order.StripeProcessor;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class Exercises06Test {

    @Mock
    StockManager stockManager;

    @Test
    public void useMockedStockManager() {

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

        when(stockManager.removeFromStock(OrderItem.SUPER_MARIO_BROS_3, 1)).thenReturn(false);

        OrderHandler orderHandler = new OrderHandler(stockManager, new StripeProcessor());

        boolean result = orderHandler.handleRemoveFromStock(OrderItem.SUPER_MARIO_BROS_3, 1);

        Assertions.assertFalse(result);

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
