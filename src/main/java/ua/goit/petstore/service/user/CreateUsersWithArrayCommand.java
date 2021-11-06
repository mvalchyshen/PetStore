package ua.goit.petstore.service.user;

import ua.goit.petstore.model.User;
import ua.goit.petstore.service.AbstractCommand;
import ua.goit.petstore.service.Command;
import ua.goit.petstore.view.View;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class CreateUsersWithArrayCommand extends AbstractCommand<User,Long> {

    public CreateUsersWithArrayCommand(View view, Map<String, Command> commands) {
        super(view, commands,User.class);
    }

    @Override
    public void proceed() {
        view.write("type in users. when you want to stop type \"stop\"");
        List<User> users = new ArrayList<>();
        do {
            User user = super.createEntity();
            users.add(user);
        } while (!view.read().equals("stop"));
        super.execute(client.createUsersWithArray((User[]) users.toArray()));
    }

    @Override
    public String commandName() {
        return "create_user_with_array";
    }

    @Override
    public String description() {
        return "create user with array";
    }
}
