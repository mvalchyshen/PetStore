package ua.goit.petstore.service;

import ua.goit.petstore.model.PetStatus;
import ua.goit.petstore.view.View;

import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;

public class FIndPetByStatusCommand extends AbstractCommand{

    public FIndPetByStatusCommand(View view, Map<String, Command> commands) {
        super(view, commands);
    }

    @Override
    public void proceed() {
        view.write("Type in one of the status:",
        Arrays.stream(PetStatus.values())
                .map(e -> e.name())
                .collect(Collectors.joining(",")));
        super.execute(client.getPetByStatus(view.read()));
    }

    @Override
    public String commandName() {
        return "find_pet_by_status";
    }

    @Override
    public String description() {
        return "find pet by status in store";
    }
}
