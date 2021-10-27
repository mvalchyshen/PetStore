package ua.goit.petstore.service;

import ua.goit.petstore.view.View;

import java.util.Map;

public class FindOrderByIdCommand extends AbstractCommand{

    public FindOrderByIdCommand(View view, Map<String, Command> commands) {
        super(view, commands);
    }

    @Override
    public void proceed() {
        view.write("type in order id:");
        Long id = Long.parseLong(view.read());
        super.execute(client.getOrderById(id));
    }

    @Override
    public String commandName() {
        return "get_order_by_id";
    }

    @Override
    public String description() {
        return "get order by id";
    }
}
