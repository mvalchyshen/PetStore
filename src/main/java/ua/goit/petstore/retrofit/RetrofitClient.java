package ua.goit.petstore.retrofit;

import lombok.Getter;
import retrofit2.Call;
import retrofit2.http.*;
import ua.goit.petstore.model.*;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import static ua.goit.petstore.controller.EndPoints.*;

public interface RetrofitClient {

    @GET(USERNAME_ENDPOINT)
    @Headers({HEADERS})
    Call<User> getUserByName(@Path("username") String username);

    @POST(UPLOAD_IMAGE_BY_ID)
    @Headers({HEADERS})
    Call<ApiResponse> uploadImage(@Path("petId") Long id, String filePath);

    @POST(PET)
    @Headers({HEADERS})
    Call<Pet> createPet(@Body Pet pet);

    @PUT(PET)
    @Headers({HEADERS})
    Call<Pet> updatePet(@Body Pet pet);

    @GET(FIND_PET_BY_STATUS)
    @Headers({HEADERS})
    Call<List<Pet>> getPetByStatus(@Query("status") String petStatusName);

    @GET(PET_BY_ID)
    @Headers({HEADERS})
    Call<Pet> getPetById(@Path("petId") Long id);

    @POST(PET_BY_ID)
    @Headers({HEADERS})
    Call<ApiResponse> updatePetById(@Path("petId") Long id,
                                    @Field("name") String name,
                                    @Field("status") PetStatus status);

    @DELETE(PET_BY_ID)
    @Headers({HEADERS})
    Call<ApiResponse> deletePetById(@Path("petId") Long id);

    @GET(STORE_INVENTORY)
    @Headers({HEADERS})
    Call<Map<String, Long>> getStatusWithQuantity();

    @POST(STORE_ORDER)
    @Headers({HEADERS})
    Call<Order> createOrder(@Body Order order);

    @GET(STORE_ORDER_WITH_ID)
    @Headers({HEADERS})
    Call<Order> getOrderById(@Path("orderId") Long id);

    @DELETE(STORE_ORDER_WITH_ID)
    @Headers({HEADERS})
    Call<Order> deleteOrderById(@Path("orderId") Long id);

    @POST(CREATE_USERS_WITH_LIST)
    @Headers({HEADERS})
    Call<ApiResponse> createUsersWithList(@Body List<User> users);

    @PUT(USERNAME_ENDPOINT)
    @Headers({HEADERS})
    Call<ApiResponse> updateUserByName(@Path("username") String username, @Body User user);

    @DELETE(USERNAME_ENDPOINT)
    @Headers({HEADERS})
    Call<User> deleteUserByName(@Path("username") String username);

    @GET(USER_LOGIN)
    @Headers({HEADERS})
    Call<ApiResponse> loginUser(@Query("username") String username, @Query("password") String password);

    @GET(USER_LOGOUT)
    @Headers({HEADERS})
    Call<ApiResponse> logoutUser();

    @POST(CREATE_USERS_WITH_ARRAY)
    @Headers({HEADERS})
    default Call<ApiResponse> createUsersWithArray(@Body User[] users){
        return createUsersWithList(Arrays.asList(users));
    }

    @POST(USER_END_POINT)
    @Headers({HEADERS})
    Call<ApiResponse> createUser(@Body User user);

}
