package ua.goit.petstore.service;

import ua.goit.petstore.model.User;
import ua.goit.petstore.view.View;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class CreateUsersWithListCommand extends AbstractCommand{
    public CreateUsersWithListCommand(View view, Map<String, Command> commands) {
        super(view, commands);
    }

    @Override
    public void proceed() {
        view.write("type in users. when stop type stop");
        List<User> users = new ArrayList<>();
        do {
            User user = super.createEntity(User.class);
            users.add(user);
        } while (!view.read().equals("stop"));
    }

    @Override
    public String commandName() {
        return "create_users_with_list";
    }

    @Override
    public String description() {
        return "create users with list";
    }
}
