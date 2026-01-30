package io.github.vladislav.Testing.topic2_Mockito.task1_OrderService.forTest;

public class OrderRepository {
    public void saveOrder(Order order) {
        // Заглушка для сохранения заказа в БД
        System.out.println("Заказ сохранен: " + order.getProductId());
    }
}

