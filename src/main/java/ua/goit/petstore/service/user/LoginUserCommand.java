package ua.goit.petstore.service.user;

import ua.goit.petstore.model.User;
import ua.goit.petstore.service.AbstractCommand;
import ua.goit.petstore.service.Command;
import ua.goit.petstore.view.View;

import java.util.Map;

public class LoginUserCommand extends AbstractCommand<User,Long> {
    public LoginUserCommand(View view, Map<String, Command> commands) {
        super(view, commands, User.class);
    }

    @Override
    public void proceed() {
        view.write("type in username");
        String username = view.read();
        view.write("password:");
        String password = view.read();
        super.execute(client.loginUser(username, password));
    }

    @Override
    public String commandName() {
        return "login";
    }

    @Override
    public String description() {
        return "login_user";
    }
}
