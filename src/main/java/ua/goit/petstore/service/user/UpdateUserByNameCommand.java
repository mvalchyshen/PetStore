package ua.goit.petstore.service.user;

import ua.goit.petstore.model.User;
import ua.goit.petstore.service.AbstractCommand;
import ua.goit.petstore.service.Command;
import ua.goit.petstore.view.View;

import java.util.Map;

public class UpdateUserByNameCommand extends AbstractCommand<User,Long> {
    public UpdateUserByNameCommand(View view, Map<String, Command> commands) {
        super(view, commands,User.class);
    }

    @Override
    public void proceed() {
        User user = super.createEntity();
        super.execute(client.updateUserByName(user.getUsername(), user));
    }

    @Override
    public String commandName() {
        return "update_user_by_name";
    }

    @Override
    public String description() {
        return "update user by name";
    }
}
