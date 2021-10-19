package ua.goit.petstore.retrofit;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import lombok.SneakyThrows;
import okhttp3.OkHttpClient;
import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitConfig {
    public static final Gson GSON = new Gson();
    public static <T> T createClient(String host, Class<T> clientClass) {
        return new Retrofit.Builder()
                .client(new OkHttpClient())
                .baseUrl(host)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(clientClass);
    }

    @SneakyThrows
    public static <T> T execute(Call<T> call) {
        Response<T> response = call.execute();
        if (response.isSuccessful()){
            System.out.println(response.code());
            return response.body();
        }
        else {
            String string = response.errorBody().string();
            System.out.println(string);
            throw new RuntimeException(string);
        }
    }
}
