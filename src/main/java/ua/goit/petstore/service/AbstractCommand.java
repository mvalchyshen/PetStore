package ua.goit.petstore.service;

import lombok.SneakyThrows;
import retrofit2.Call;
import ua.goit.petstore.model.Pet;
import ua.goit.petstore.retrofit.RetrofitClient;
import ua.goit.petstore.retrofit.RetrofitConfig;
import ua.goit.petstore.view.View;

import java.lang.reflect.Field;
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

    protected <T> void execute(Call<T> call){
        T execute = RetrofitConfig.execute(call);
        System.out.println(execute.toString());
    }

    @SneakyThrows
    protected <E> E createEntity(Class<E> model){
        view.write("To create"+ model.getSimpleName()+" type in");
        Field[] declaredFields = model.getDeclaredFields();
        E e = model.getConstructor().newInstance();
        for (Field field : declaredFields) {
            view.write(field.getName()+":");
            field.setAccessible(true);
            field.set(e,view.read());
        }
        return e;
    }

}
