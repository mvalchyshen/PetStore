package ua.goit.petstore.service;

import ua.goit.petstore.view.View;

import java.util.Map;

public class FindPetByIdCommand extends AbstractCommand{

    public FindPetByIdCommand(View view, Map<String, Command> commands) {
        super(view, commands);
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
