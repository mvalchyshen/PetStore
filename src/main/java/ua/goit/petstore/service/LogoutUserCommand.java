package ua.goit.petstore.service;

import com.google.common.graph.AbstractValueGraph;
import ua.goit.petstore.view.View;

import java.util.Map;

public class LogoutUserCommand extends AbstractCommand {
    public LogoutUserCommand(View view, Map<String, Command> commands) {
        super(view, commands);
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
