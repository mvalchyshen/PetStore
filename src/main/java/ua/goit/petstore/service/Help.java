package ua.goit.petstore.service;

import retrofit2.http.Headers;
import ua.goit.petstore.view.View;

import java.util.Map;

public class Help implements Command{
    private View view;
    private Map<String, Command> commands;
    public Help(View view, Map<String, Command> commands){
        this.view = view;
        this.commands = commands;
    }

    @Override
    public void proceed() {
        commands.values().forEach(command ->
                view.write(command.commandName()+ " -> "+command.description()));
    }

    @Override
    public String commandName() {
        return "help";
    }

    @Override
    public String description() {
        return "list of commands";
    }
}
