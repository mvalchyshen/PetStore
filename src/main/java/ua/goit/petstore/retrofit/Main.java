package ua.goit.petstore.retrofit;


import ua.goit.petstore.model.Category;
import ua.goit.petstore.model.Pet;
import ua.goit.petstore.model.PetStatus;
import ua.goit.petstore.model.User;

import java.util.List;

import static ua.goit.petstore.controller.EndPoints.HOST;

public class Main {
    public static void main(String[] args) {
        RetrofitClient client = RetrofitConfig.createClient(HOST, RetrofitClient.class);
//        Pet pet = Pet.builder()
//                .category(Category.builder()
//                        .id(1l)
//                        .name("categorytest")
//                        .build())
//                .name("pettestretrofit")
//                .build();
//        User user1 = RetrofitConfig.execute(client.getUserByName("user1"));
//        Pet execute = RetrofitConfig.execute(client.createPet(pet));
//        System.out.println(execute);
//        System.out.println(user1);
        Pet execute = RetrofitConfig.execute(client.getPetById(1l));
        System.out.println(execute);
    }
}
