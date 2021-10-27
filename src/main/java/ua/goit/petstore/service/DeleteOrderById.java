package ua.goit.petstore.service;

import ua.goit.petstore.view.View;

import java.util.Map;

public class DeleteOrderById extends AbstractCommand{

    public DeleteOrderById(View view, Map<String, Command> commands) {
        super(view, commands);
    }

    @Override
    public void proceed() {
        view.write("type in order's id");
        Long id = Long.parseLong(view.read());
        super.execute(client.deleteOrderById(id));
    }

    @Override
    public String commandName() {
        return "delete_order_by_id";
    }

    @Override
    public String description() {
        return "deletes order by id";
    }
}
