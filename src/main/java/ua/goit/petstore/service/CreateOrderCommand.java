package ua.goit.petstore.service;

import ua.goit.petstore.model.Order;
import ua.goit.petstore.view.View;

import java.lang.reflect.Field;
import java.util.Map;

public class CreateOrderCommand extends AbstractCommand{
    public CreateOrderCommand(View view, Map<String, Command> commands) {
        super(view, commands);
    }

    @Override
    public void proceed() {
        Order order = super.createEntity(Order.class);
        super.execute(client.createOrder(order));
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
