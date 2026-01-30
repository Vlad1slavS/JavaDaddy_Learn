package io.github.vladislav.Testing.topic2_Mockito.task1_OrderService.forTest;

public class Order {
    private final String productId;
    private final int quantity;
    private final double pricePerUnit;

    public Order(String productId, int quantity, double pricePerUnit) {
        this.productId = productId;
        this.quantity = quantity;
        this.pricePerUnit = pricePerUnit;
    }

    public String getProductId() {
        return productId;
    }

    public int getQuantity() {
        return quantity;
    }

    public double getPricePerUnit() {
        return pricePerUnit;
    }

    public double calculateTotalPrice() {
        return quantity * pricePerUnit;
    }
}
