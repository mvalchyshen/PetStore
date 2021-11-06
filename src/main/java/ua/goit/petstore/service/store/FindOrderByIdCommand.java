package ua.goit.petstore.service.store;

import ua.goit.petstore.model.Order;
import ua.goit.petstore.service.AbstractCommand;
import ua.goit.petstore.service.Command;
import ua.goit.petstore.view.View;

import java.util.Map;

public class FindOrderByIdCommand extends AbstractCommand<Order,Long> {

    public FindOrderByIdCommand(View view, Map<String, Command> commands) {
        super(view, commands,Order.class);
    }

    @Override
    public void proceed() {
        view.write("type in order id:");
        Long id = Long.parseLong(view.read());
        try{
            super.execute(client.getOrderById(id));
        } catch (RuntimeException e) {
            view.write(e.getMessage());
            view.write("type in another id");
            proceed();
        }
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
