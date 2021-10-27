package ua.goit.petstore.service;

import lombok.SneakyThrows;
import ua.goit.petstore.model.Pet;
import ua.goit.petstore.view.View;

import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;

public class AddPetCommand extends AbstractCommand {
    public AddPetCommand(View view, Map<String, Command> commands) {
        super(view, commands);
    }

    @SneakyThrows
    @Override
    public void proceed() {
        Pet pet = super.createEntity(Pet.class);
        super.execute(client.createPet(pet));
    }

    @Override
    public String commandName() {
        return "add_pet";
    }

    @Override
    public String description() {
        return "add pet to a store";
    }
}
