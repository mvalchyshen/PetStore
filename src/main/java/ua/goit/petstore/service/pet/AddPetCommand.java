package ua.goit.petstore.service.pet;

import lombok.SneakyThrows;
import ua.goit.petstore.model.Pet;
import ua.goit.petstore.service.AbstractCommand;
import ua.goit.petstore.service.Command;
import ua.goit.petstore.view.View;


import java.util.Map;

public class AddPetCommand extends AbstractCommand<Pet> {
    public AddPetCommand(View view, Map<String, Command> commands) {
        super(view, commands,Pet.class);
    }

    @SneakyThrows
    @Override
    public void proceed() {
        super.execute(client.createPet(super.createEntity()));
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
