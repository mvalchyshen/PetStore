package ua.goit.petstore.service.pet;

import lombok.SneakyThrows;
import ua.goit.petstore.model.Category;
import ua.goit.petstore.model.Pet;
import ua.goit.petstore.model.PetStatus;
import ua.goit.petstore.model.Tag;
import ua.goit.petstore.service.AbstractCommand;
import ua.goit.petstore.service.Command;
import ua.goit.petstore.util.CreatePet;
import ua.goit.petstore.view.View;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import static ua.goit.petstore.util.CreatePet.createPet;

public class UpdateExistingPetCommand extends AbstractCommand<Pet,Long> {
    public UpdateExistingPetCommand(View view, Map<String, Command> commands) {
        super(view, commands,Pet.class);
    }
    @SneakyThrows
    @Override
    public void proceed() {
        view.write("type in pet's info to update:");
        Pet pet = createPet(view);
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
