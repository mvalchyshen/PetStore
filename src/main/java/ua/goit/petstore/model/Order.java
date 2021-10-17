package ua.goit.petstore.model;

import com.google.gson.annotations.SerializedName;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Order implements BaseEntity<Long> {
    @SerializedName("id")
    private Long id;
    @SerializedName("petId")
    private Long petId;
    @SerializedName("quantity")
    private Integer quantity;
    @SerializedName("shipDate")
    private String shipDate;
    @SerializedName("status")
    private OrderStatus status;
    @SerializedName("complete")
    private boolean complete;
}
