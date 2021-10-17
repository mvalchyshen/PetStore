package ua.goit.petstore.retrofit;

import retrofit2.Call;
import retrofit2.http.*;
import ua.goit.petstore.model.ApiResponse;
import ua.goit.petstore.model.Pet;
import ua.goit.petstore.model.PetStatus;
import ua.goit.petstore.model.User;

import java.util.List;

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
    Call<List<Pet>> getPetByStatus(@Query("status") PetStatus petStatus);

    @GET(PET_BY_ID)
    @Headers({HEADERS})
    Call<Pet> getPetById(@Path("petId") Long id);

    @POST(PET_BY_ID)
    @Headers({HEADERS})
    Call<ApiResponse> updatePetById(@Path("petId") Long id,
                                    @Field("name") String name,
                                    @Field("status") PetStatus status);
}
