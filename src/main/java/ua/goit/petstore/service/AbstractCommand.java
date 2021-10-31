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

public abstract class AbstractCommand<E> implements Command {

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
        T execute = Config.execute(call);
        System.out.println(execute.toString());
    }

    @SneakyThrows
    protected E createEntity() {
        view.write("To create " + modelClass.getSimpleName() + " type in");
        Field[] declaredFields = modelClass.getDeclaredFields();
        Map<String, Object> objectMap = new HashMap<>();
        for (Field field : declaredFields) {
            field.setAccessible(true);
            if (BaseEntity.class.isAssignableFrom(field.getType())) {
                Class<?> type = field.getType();
                objectMap.put(field.getName(), createEntity(type,mapper,view));
            } if (field.getType().isEnum()) {
                view.write("type in on of" +field.getType().getName()+":");
                view.write((Object[]) field.getType().getEnumConstants());
                Object result = view.read();
                objectMap.put(field.getName(), result);
            } if (List.class.isAssignableFrom(field.getType())) {
                List<?> list = new ArrayList<>();
                do {
                    view.write("type in "+field.getName());


                } while (true);
            }
            view.write(field.getName() + ":");
            String result = view.read();
            objectMap.put(field.getName(), result);
        }
        return mapper.convertValue(objectMap, modelClass);
    }

    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            ObjectMapper objectMapper = new ObjectMapper();

            Field[] declaredFields = Pet.class.getDeclaredFields();
            Map<String, Object> objectMap = getStringObjectMap
                    (br, objectMapper, declaredFields);
            Pet pet = objectMapper.convertValue(objectMap, Pet.class);
            System.out.println(pet);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    @NotNull
    private static Map<String, Object> getStringObjectMap(BufferedReader br, ObjectMapper objectMapper, Field[] declaredFields) throws IOException {
        Map<String, Object> objectMap = new HashMap<>();
        for (Field field : declaredFields) {
            field.setAccessible(true);
            System.out.println(field.getName() + ":");
            Class<?> type = field.getType();
            if (type.isEnum()) {
                Object[] enumConstants = type.getEnumConstants();
                System.out.println(Arrays.toString(enumConstants));
            } else if (BaseEntity.class.isAssignableFrom(type)) {
//                Object entity = createEntity(type, objectMapper, );
            }
            System.out.println(type);
            String result = br.readLine();
            objectMap.put(field.getName(), result);
        }
        return objectMap;
    }

    @SneakyThrows
    private static Object createEntity(Class<?> type, ObjectMapper objectMapper, View view) {
        System.out.println("To create " + type.getSimpleName() + " type in");
        Field[] declaredFields = type.getDeclaredFields();
        Map<String, Object> objectMap = new HashMap<>();
        for (Field field : declaredFields) {
            field.setAccessible(true);
            System.out.println(field.getName() + ":");
            String result = view.read();
            objectMap.put(field.getName(), result);
        }
        return objectMapper.convertValue(objectMap, type);
    }

}
