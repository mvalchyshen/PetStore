package ua.goit.petstore.model;

import lombok.Data;

@Data
public class Order implements BaseEntity<Integer> {
    private Integer id;
    private Integer petId;
    private Integer quantity;
    private String shipDate;
    private OrderStatus status;
    private boolean complete;
}
