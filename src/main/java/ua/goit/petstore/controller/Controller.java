package ua.goit.petstore.controller;

import ua.goit.petstore.service.Command;
import ua.goit.petstore.view.View;

import java.util.Map;
import java.util.Optional;

public class Controller {
    private final View view;
    private final Map<String, Command> commands;

    public Controller(View view) {
        this.view = view;
        commands = Command.of(view);
    }

    public void proceed(){
        view.write("write help for list of commands");
        while (true) Optional.ofNullable(commands.get(view.read())).ifPresent(Command::proceed);
    }
}
