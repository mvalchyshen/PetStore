package ua.goit.petstore.service.user;

import com.google.common.graph.AbstractValueGraph;
import ua.goit.petstore.model.User;
import ua.goit.petstore.service.AbstractCommand;
import ua.goit.petstore.service.Command;
import ua.goit.petstore.view.View;

import java.util.Map;

public class LogoutUserCommand extends AbstractCommand<User,Long> {
    public LogoutUserCommand(View view, Map<String, Command> commands) {
        super(view, commands, User.class);
    }

    @Override
    public void proceed() {
        super.execute(client.logoutUser());
    }

    @Override
    public String commandName() {
        return "logout";
    }

    @Override
    public String description() {
        return "logout_user";
    }
}
