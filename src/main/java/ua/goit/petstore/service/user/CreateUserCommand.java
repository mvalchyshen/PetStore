package ua.goit.petstore.service.user;

import ua.goit.petstore.model.User;
import ua.goit.petstore.service.AbstractCommand;
import ua.goit.petstore.service.Command;
import ua.goit.petstore.view.View;

import java.util.Map;

public class CreateUserCommand extends AbstractCommand<User,Long> {
    public CreateUserCommand(View view, Map<String, Command> commands) {
        super(view, commands,User.class);
    }

    @Override
    public void proceed() {
        super.execute(client.createUser(super.createEntity()));
    }

    @Override
    public String commandName() {
        return "create_user";
    }

    @Override
    public String description() {
        return "create user";
    }
}
