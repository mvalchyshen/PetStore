package ua.goit.petstore.service.user;


import ua.goit.petstore.model.User;
import ua.goit.petstore.service.AbstractCommand;
import ua.goit.petstore.service.Command;
import ua.goit.petstore.view.View;


import java.util.Map;

public class CreateUsersWithListCommand extends AbstractCommand<User> {

    private CreateUsersWithArrayCommand command = new CreateUsersWithArrayCommand(view,commands);
    public CreateUsersWithListCommand(View view, Map<String, Command> commands) {
        super(view, commands, User.class);
    }

    @Override
    public void proceed() {
        command.proceed();

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
