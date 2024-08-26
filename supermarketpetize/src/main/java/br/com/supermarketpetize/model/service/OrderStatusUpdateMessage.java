package br.com.supermarketpetize.model.service;

import java.io.Serializable;

public class OrderStatusUpdateMessage implements Serializable{

	private static final long serialVersionUID = 1L;
	
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



