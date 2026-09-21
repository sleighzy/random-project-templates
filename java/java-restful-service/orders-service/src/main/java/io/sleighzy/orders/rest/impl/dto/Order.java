package io.sleighzy.orders.rest.impl.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Order {

    private String id;
    private String userId;
    private String productId;
    private String status;
    private String createdAt;
    private String updatedAt;

    public Order(final String id) {
        this.id = id;
    }
}
