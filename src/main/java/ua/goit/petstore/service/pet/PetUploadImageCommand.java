package ua.goit.petstore.service.pet;

import ua.goit.petstore.model.Pet;
import ua.goit.petstore.service.AbstractCommand;
import ua.goit.petstore.service.Command;
import ua.goit.petstore.view.View;

import java.io.File;
import java.util.Map;

public class PetUploadImageCommand extends AbstractCommand<Pet> {

    public PetUploadImageCommand( View view, Map<String, Command> commands) {
        super(view, commands,Pet.class);
    }

    @Override
    public void proceed() {
        view.write("write id:");
        Long id = Long.parseLong(view.read());
        view.write("add additionalMetadata:");
        String additionalMetadata = view.read();
        view.write("write link to image:");
        String link = view.read();
        File file = new File(link);
        super.execute(client.uploadImage(id, additionalMetadata, file));
    }

    @Override
    public String commandName() {
        return "upload_image";
    }

    @Override
    public String description() {
        return "upload image of pet";
    }
}
