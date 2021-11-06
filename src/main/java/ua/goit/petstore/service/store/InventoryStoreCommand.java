package ua.goit.petstore.service.store;

import ua.goit.petstore.model.Order;
import ua.goit.petstore.service.AbstractCommand;
import ua.goit.petstore.service.Command;
import ua.goit.petstore.view.View;

import java.util.Map;

public class InventoryStoreCommand extends AbstractCommand<Order,Long> {

    public InventoryStoreCommand(View view, Map<String, Command> commands) {
        super(view, commands,Order.class);
    }

    @Override
    public void proceed() {
        super.execute(client.getStatusWithQuantity());
    }

    @Override
    public String commandName() {
        return "get_inventory_by_status";
    }

    @Override
    public String description() {
        return "Returns a map of status codes to quantities";
    }
}
