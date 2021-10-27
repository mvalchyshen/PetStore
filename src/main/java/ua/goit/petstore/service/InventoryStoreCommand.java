package ua.goit.petstore.service;

import ua.goit.petstore.view.View;

import java.util.Map;

public class InventoryStoreCommand extends AbstractCommand{

    public InventoryStoreCommand(View view, Map<String, Command> commands) {
        super(view, commands);
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
