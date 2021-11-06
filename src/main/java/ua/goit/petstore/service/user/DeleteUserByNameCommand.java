package ua.goit.petstore.service.user;

import ua.goit.petstore.model.User;
import ua.goit.petstore.service.AbstractCommand;
import ua.goit.petstore.service.Command;
import ua.goit.petstore.view.View;

import java.util.Map;

public class DeleteUserByNameCommand extends AbstractCommand<User,Long> {

    public DeleteUserByNameCommand(View view, Map<String, Command> commands) {
        super(view, commands,User.class);
    }

    @Override
    public void proceed() {
        view.write("type in username to delete");
        super.execute(client.deleteUserByName(view.read()));
    }

    @Override
    public String commandName() {
        return "delete_user";
    }

    @Override
    public String description() {
        return "delete user by name";
    }
}
