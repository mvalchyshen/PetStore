package ua.goit.petstore.service.pet;

import ua.goit.petstore.model.Pet;
import ua.goit.petstore.model.PetStatus;
import ua.goit.petstore.service.AbstractCommand;
import ua.goit.petstore.service.Command;
import ua.goit.petstore.view.View;

import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;

public class FIndPetByStatusCommand extends AbstractCommand<Pet,Long> {

    public FIndPetByStatusCommand(View view, Map<String, Command> commands) {
        super(view, commands,Pet.class);
    }

    @Override
    public void proceed() {
        view.write("Type in one of the status:");
        view.write(Arrays.stream(PetStatus.values())
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
