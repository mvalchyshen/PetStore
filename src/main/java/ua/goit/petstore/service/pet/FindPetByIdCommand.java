package ua.goit.petstore.service.pet;

import ua.goit.petstore.model.Pet;
import ua.goit.petstore.service.AbstractCommand;
import ua.goit.petstore.service.Command;
import ua.goit.petstore.view.View;

import java.util.Map;

public class FindPetByIdCommand extends AbstractCommand<Pet> {

    public FindPetByIdCommand(View view, Map<String, Command> commands) {
        super(view, commands, Pet.class);
    }

    @Override
    public void proceed() {
        view.write("Type in id");
        Long id = Long.parseLong(view.read());
        super.execute(client.getPetById(id));
    }

    @Override
    public String commandName() {
        return "find_pet_by_id";
    }

    @Override
    public String description() {
        return "find pet by id";
    }
}
