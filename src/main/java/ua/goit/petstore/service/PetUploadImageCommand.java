package ua.goit.petstore.service;

import ua.goit.petstore.view.View;

import java.util.Map;

public class PetUploadImageCommand extends AbstractCommand{

    public PetUploadImageCommand( View view, Map<String, Command> commands) {
        super(view, commands);
    }

    @Override
    public void proceed() {
        view.write("write id:");
        Long id = Long.parseLong(view.read());
        view.write("write link to image:");
        String link = view.read();
        super.execute(client.uploadImage(id, link));
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
