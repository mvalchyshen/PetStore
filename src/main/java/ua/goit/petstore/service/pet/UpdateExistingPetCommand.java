package ua.goit.petstore.service.pet;

import lombok.SneakyThrows;
import ua.goit.petstore.model.Pet;
import ua.goit.petstore.service.AbstractCommand;
import ua.goit.petstore.service.Command;
import ua.goit.petstore.view.View;

import java.util.Map;

public class UpdateExistingPetCommand extends AbstractCommand<Pet> {
    public UpdateExistingPetCommand(View view, Map<String, Command> commands) {
        super(view, commands,Pet.class);
    }
    @SneakyThrows
    @Override
    public void proceed() {
        view.write("type in pet's info to update:");
        Pet pet = super.createEntity();
        super.execute(client.updatePet(pet));
    }

    @Override
    public String commandName() {
        return "update_pet";
    }

    @Override
    public String description() {
        return "update pet int the store";
    }
}
