package ua.goit.petstore.service;

import ua.goit.petstore.view.View;

import java.util.Map;

public class DeletePetByIdCommand extends AbstractCommand{
    public DeletePetByIdCommand(View view, Map<String, Command> commands) {
        super(view, commands);
    }

    @Override
    public void proceed() {
        view.write("type in id:");
        Long id = Long.parseLong(view.read());
        super.execute(client.deletePetById(id));
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
