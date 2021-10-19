package ua.goit.petstore.retrofit;


import ua.goit.petstore.model.Category;
import ua.goit.petstore.model.Pet;
import ua.goit.petstore.model.PetStatus;
import ua.goit.petstore.model.User;

import java.util.List;
import java.util.Locale;
import java.util.Map;

import static ua.goit.petstore.controller.EndPoints.HOST;

public class Main {
    public static void main(String[] args) {
        RetrofitClient client = RetrofitConfig.createClient(HOST, RetrofitClient.class);

        Category category = Category.builder()
                .id(1l)
                .name("categorytest").build();
        Pet pet = Pet.builder()
                .category(category)
                .name("pettestretrofit")
                .build();
//        User user1 = RetrofitConfig.execute(client.getUserByName("user1"));
        Pet create = RetrofitConfig.execute(client.createPet(pet));
        List<Pet> create1 = RetrofitConfig.execute(client.getPetByStatus(PetStatus.SOLD.name().toLowerCase(Locale.ROOT)));
//        System.out.println(execute);
//        System.out.println(user1);
        Pet execute = RetrofitConfig.execute(client.getPetById(9223372036854775807l));
        Map<String, Long> execute1 = RetrofitConfig.execute(client.getStatusWithQuantity());
        create1.forEach(System.out::println);
        System.out.println(PetStatus.AVAILABLE.name().toLowerCase(Locale.ROOT)+create+"\n"+execute+"\n"+execute1);

    }
}
