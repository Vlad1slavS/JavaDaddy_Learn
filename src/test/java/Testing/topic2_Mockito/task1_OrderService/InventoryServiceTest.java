package Testing.topic2_Mockito.task1_OrderService;

import io.github.vladislav.Testing.topic2_Mockito.task1_OrderService.forTest.InventoryService;
import io.github.vladislav.Testing.topic2_Mockito.task1_OrderService.forTest.Order;
import io.github.vladislav.Testing.topic2_Mockito.task1_OrderService.forTest.OrderRepository;
import io.github.vladislav.Testing.topic2_Mockito.task1_OrderService.forTest.OrderService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/**
 * Тест для сервиса в сервисе для Управления заказами в интернет-магазине
 * @author Владислав Степанов
 */
@ExtendWith(MockitoExtension.class)
public class InventoryServiceTest {

    @InjectMocks
    private OrderService orderService;

    @Mock
    private InventoryService inventoryService;

    @Mock
    private OrderRepository orderRepository;

    private final Order order = new Order("P123", 2, 50.0);

    @Test
    void processOrder_success(){
        when(inventoryService.isProductAvailable("P123", 2)).thenReturn(true);
        assertTrue(orderService.processOrder(order));

        verify(orderRepository).saveOrder(order);
    }

    @Test
    void processOrder_fail(){
        when(inventoryService.isProductAvailable("P123", 2)).thenReturn(false);
        assertFalse(orderService.processOrder(order));

        verify(orderRepository, never()).saveOrder(order);
    }



}
