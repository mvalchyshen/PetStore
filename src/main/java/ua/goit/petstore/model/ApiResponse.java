package ua.goit.petstore.model;

import lombok.Data;

@Data
public class ApiResponse{
    private Integer code;
    private String type;
    private String message;

}
