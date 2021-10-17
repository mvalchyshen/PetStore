package ua.goit.petstore.model;

import lombok.Data;

@Data
public class Category implements BaseEntity<Integer> {
    private Integer id;
    private String name;
}
