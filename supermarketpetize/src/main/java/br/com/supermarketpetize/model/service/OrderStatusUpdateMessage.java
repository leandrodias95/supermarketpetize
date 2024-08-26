package br.com.supermarketpetize.model.service;

public class OrderStatusUpdateMessage {
    private Long orderId;
    private String newStatus;

    public OrderStatusUpdateMessage(Long orderId, String newStatus) {
        this.orderId = orderId;
        this.newStatus = newStatus;
    }

    public Long getOrderId() {
        return orderId;
    }

    public String getNewStatus() {
        return newStatus;
    }
}



