package ua.goit.petstore.service.user;

import ua.goit.petstore.model.User;
import ua.goit.petstore.service.AbstractCommand;
import ua.goit.petstore.service.Command;
import ua.goit.petstore.view.View;

import java.util.Map;

public class GetUserByNameCommand extends AbstractCommand<User,Long> {

    public GetUserByNameCommand(View view, Map<String, Command> commands) {
        super(view, commands, User.class);
    }

    @Override
    public void proceed() {
        view.write("type in user id:");
        String name = view.read();
        super.execute(client.getUserByName(name));
    }

    @Override
    public String commandName() {
        return "get_user_by_name";
    }

    @Override
    public String description() {
        return "get user by name";
    }
}
