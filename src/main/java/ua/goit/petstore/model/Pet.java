package ua.goit.petstore.model;

import lombok.Data;

import java.util.List;

@Data
public class Pet implements BaseEntity<Integer> {

    private Integer id;
    private Category category;
    private String name;
    private List<String> photoUrls;
    private List<Tag> tags;
    private PetStatus status;
}
