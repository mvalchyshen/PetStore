package ua.goit.petstore.service.pet;

import ua.goit.petstore.model.Pet;
import ua.goit.petstore.service.AbstractCommand;
import ua.goit.petstore.service.Command;
import ua.goit.petstore.view.View;

import java.util.Map;

public class DeletePetByIdCommand extends AbstractCommand<Pet,Long> {
    public DeletePetByIdCommand(View view, Map<String, Command> commands) {
        super(view, commands,Pet.class);
    }

    @Override
    public void proceed() {
        view.write("type in id:");
        Long id = Long.parseLong(view.read());
        try {
            super.execute(client.deletePetById(id));
        } catch (RuntimeException e) {
            view.write(e.getMessage());
            view.write("type in another ID");
            proceed();
        }
    }

    @Override
    public String commandName() {
        return "delete_pet";
    }

    @Override
    public String description() {
        return "delete pet by id";
    }
}
