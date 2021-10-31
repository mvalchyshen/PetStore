package ua.goit.petstore.model;

import com.google.gson.annotations.SerializedName;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ApiResponse implements Serializable {

    @SerializedName("code")
    private Integer code;
    @SerializedName("type")
    private String type;
    @SerializedName("message")
    private String message;

}
