package ua.goit.petstore.service.store;

import ua.goit.petstore.model.Order;
import ua.goit.petstore.service.AbstractCommand;
import ua.goit.petstore.service.Command;
import ua.goit.petstore.view.View;

import java.lang.reflect.Field;
import java.util.Map;

public class CreateOrderCommand extends AbstractCommand<Order,Long> {
    public CreateOrderCommand(View view, Map<String, Command> commands) {
        super(view, commands,Order.class);
    }

    @Override
    public void proceed() {
        super.execute(client.createOrder(super.createEntity()));
    }

    @Override
    public String commandName() {
        return "create_order";
    }

    @Override
    public String description() {
        return "order placed for purchasing the pet";
    }
}
