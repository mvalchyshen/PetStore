package ua.goit.petstore.service;

import lombok.SneakyThrows;
import ua.goit.petstore.model.Pet;
import ua.goit.petstore.view.View;

import java.lang.reflect.Field;
import java.util.Map;

public class UpdateExistingPetCommand extends AbstractCommand{
    public UpdateExistingPetCommand(View view, Map<String, Command> commands) {
        super(view, commands);
    }
    @SneakyThrows
    @Override
    public void proceed() {
        view.write("type in pet's info to update:");
        Field[] declaredFields = Pet.class.getDeclaredFields();
        Pet pet = new Pet();
        for (Field field : declaredFields) {
            view.write(field.getName()+":");
            field.setAccessible(true);
            field.set(pet,view.read());
        }
        super.execute(client.createPet(pet));
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
