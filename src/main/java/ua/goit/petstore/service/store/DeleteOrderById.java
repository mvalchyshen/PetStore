package ua.goit.petstore.service.store;

import ua.goit.petstore.model.Order;
import ua.goit.petstore.service.AbstractCommand;
import ua.goit.petstore.service.Command;
import ua.goit.petstore.view.View;

import java.util.Map;

public class DeleteOrderById extends AbstractCommand<Order> {

    public DeleteOrderById(View view, Map<String, Command> commands) {
        super(view, commands,Order.class);
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
