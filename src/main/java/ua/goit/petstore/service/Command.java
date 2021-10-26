package ua.goit.petstore.service;

import lombok.SneakyThrows;
import org.reflections.Reflections;
import ua.goit.petstore.view.View;

import java.lang.reflect.Modifier;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public interface Command {

    void proceed();
    String commandName();
    String description();

    @SneakyThrows
    static Map<String, Command> of(View view){
        Set<Class<? extends Command>> commandClasses = new Reflections("ua.goit").getSubTypesOf(Command.class);
        Map<String, Command> commands = new HashMap<>(commandClasses.size());
        for (Class<? extends Command> commandClass: commandClasses) {
            if (Modifier.isInterface(commandClass.getModifiers()) || Modifier.isAbstract(commandClass.getModifiers())) continue;
            Command command = commandClass.getConstructor(View.class, Map.class).newInstance(view,commands);
            commands.put(command.commandName(),command);
        }
        return commands;
    }
}
