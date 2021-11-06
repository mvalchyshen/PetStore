package ua.goit.petstore.util;

import ua.goit.petstore.model.Category;
import ua.goit.petstore.model.Pet;
import ua.goit.petstore.model.PetStatus;
import ua.goit.petstore.model.Tag;
import ua.goit.petstore.view.View;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CreatePet {
    public static Pet createPet(View view){
        view.write("type in id:");
        Long id = Long.parseLong(view.read());
        view.write("fill in category:");
        view.write("type in category id:");
        Long categoryId = Long.parseLong(view.read());
        view.write("type in category name:");
        String categoryName = view.read();
        Category category = Category.builder()
                .id(categoryId)
                .name(categoryName)
                .build();
        view.write("type in pet name:");
        String petName = view.read();
        view.write("type in  photourls:");
        List<String> photoUrls = new ArrayList<>();
        while (!(view.read().isEmpty() || view.read().isBlank() || view.read() == null)) {
            photoUrls.add(view.read());
        }
        view.write("type in tags");
        List<Tag> tags = new ArrayList<>();
        view.write("write \"stop\" when want to stop");
        while (!view.read().equalsIgnoreCase("stop")) {
            view.write("type in tag id:");
            Long tagId = Long.parseLong(view.read());
            view.write("type in tag name:");
            String tagName = view.read();
            Tag tag = Tag.builder()
                    .id(tagId).name(tagName).build();
            tags.add(tag);
        }
        view.write("choose status:");
        Arrays.stream(PetStatus.values()).forEach(System.out::println);
        PetStatus status = PetStatus.valueOf(view.read().toUpperCase());
        return Pet.builder()
                .id(id)
                .category(category)
                .photoUrls(photoUrls)
                .name(petName)
                .tags(tags)
                .status(status)
                .build();
    }
}
