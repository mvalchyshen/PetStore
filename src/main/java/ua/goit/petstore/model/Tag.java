package ua.goit.petstore.model;

import lombok.Data;

@Data
public class Tag implements BaseEntity<Integer> {
    private Integer id;
    private String name;
}
