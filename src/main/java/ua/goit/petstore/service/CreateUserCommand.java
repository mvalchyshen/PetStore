package ua.goit.petstore.service;

import ua.goit.petstore.model.User;
import ua.goit.petstore.view.View;

import java.util.Map;

public class CreateUserCommand extends AbstractCommand{
    public CreateUserCommand(View view, Map<String, Command> commands) {
        super(view, commands);
    }

    @Override
    public void proceed() {
        User user = super.createEntity(User.class);
        super.execute(client.createUser(user));
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
