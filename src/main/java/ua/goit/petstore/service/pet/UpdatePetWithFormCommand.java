package ua.goit.petstore.service.pet;


import ua.goit.petstore.model.Pet;
import ua.goit.petstore.model.PetStatus;
import ua.goit.petstore.service.AbstractCommand;
import ua.goit.petstore.service.Command;
import ua.goit.petstore.view.View;

import java.util.Arrays;
import java.util.Locale;
import java.util.Map;
import java.util.stream.Collectors;

public class UpdatePetWithFormCommand extends AbstractCommand<Pet,Long> {
    public UpdatePetWithFormCommand(View view, Map<String, Command> commands) {
        super(view, commands,Pet.class);
    }

    @Override
    public void proceed() {
        view.write("type in pet's id need to be updated");
        Long id = Long.parseLong(view.read());
        view.write("type in pet's name:");
        String name = view.read();
        view.write("type int pet's status:");
        view.write(Arrays.stream(PetStatus.values())
                .map(e -> e.name())
                .collect(Collectors.joining(",")));
        PetStatus petStatus = PetStatus.valueOf(view.read().toUpperCase(Locale.ROOT));
        super.execute(client.updatePetById(id,name,petStatus));

    }

    @Override
    public String commandName() {
        return "update_pet_with_form";
    }

    @Override
    public String description() {
        return "update pet with form()";
    }
}
