package ua.goit.petstore.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.SneakyThrows;
import org.jetbrains.annotations.NotNull;
import retrofit2.Call;
import ua.goit.petstore.model.BaseEntity;
import ua.goit.petstore.model.Pet;
import ua.goit.petstore.retrofit.RetrofitClient;
import ua.goit.petstore.retrofit.Config;
import ua.goit.petstore.view.View;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Field;
import java.lang.reflect.Type;
import java.util.*;

import static ua.goit.petstore.controller.EndPoints.HOST;

public abstract class AbstractCommand<E extends BaseEntity<ID>,ID> implements Command {

    protected final RetrofitClient client;
    private final ObjectMapper mapper;
    protected final View view;
    protected final Map<String, Command> commands;
    private final Class<E> modelClass;

    public AbstractCommand(View view, Map<String, Command> commands, Class<E> modelClass) {
        this.client = Config.createClient(HOST, RetrofitClient.class);
        this.view = view;
        this.commands = commands;
        this.mapper = new ObjectMapper();
        this.modelClass = modelClass;
    }

    protected <T> void execute(Call<T> call) {
        T result = Config.execute(call);
        System.out.println(result.toString());
    }

    @SneakyThrows
    protected E createEntity() {
        view.write("To create " + modelClass.getSimpleName() + " type in");
        Field[] declaredFields = modelClass.getDeclaredFields();
        Map<String, Object> objectMap = new HashMap<>();
        for (Field field : declaredFields) {
            field.setAccessible(true);
            Object result = view.read();
            objectMap.put(field.getName(), result);
        }
        return mapper.convertValue(objectMap, modelClass);
    }

}
