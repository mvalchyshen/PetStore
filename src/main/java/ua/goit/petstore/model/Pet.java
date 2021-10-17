package ua.goit.petstore.model;

import com.google.gson.annotations.SerializedName;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Pet implements BaseEntity<Long> {
    @SerializedName("id")
    private Long id;
    @SerializedName("category")
    private Category category;
    @SerializedName("name")
    private String name;
    @SerializedName("photoUrls")
    private List<String> photoUrls;
    @SerializedName("tags")
    private List<Tag> tags;
    @SerializedName("status")
    private PetStatus status;
}
