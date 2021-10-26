package ua.goit.petstore.service;

import ua.goit.petstore.retrofit.RetrofitClient;
import ua.goit.petstore.retrofit.RetrofitConfig;
import ua.goit.petstore.view.View;

import java.util.Map;

import static ua.goit.petstore.controller.EndPoints.HOST;

public abstract class AbstractCommand implements Command {

    protected final RetrofitClient client;
    protected final View view;
    protected final Map<String, Command> commands;

    public AbstractCommand(View view, Map<String, Command> commands) {
        this.client = RetrofitConfig.createClient(HOST, RetrofitClient.class);
        this.view = view;
        this.commands = commands;
    }

}
