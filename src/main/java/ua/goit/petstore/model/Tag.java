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
public class Tag implements BaseEntity<Long>, Serializable {
    @SerializedName("id")
    private Long id;
    @SerializedName("name")
    private String name;
}
