package ua.goit.petstore;

import ua.goit.petstore.controller.Controller;
import ua.goit.petstore.model.Pet;
import ua.goit.petstore.model.Tag;
import ua.goit.petstore.view.ViewImpl;

import java.lang.reflect.Field;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        Field[] declaredFields = Pet.class.getDeclaredFields();

        for (Field field : declaredFields) {
            field.setAccessible(true);
            String s = field.toGenericString();
            Type genericType = field.getGenericType();
            Class<?> type = field.getType();
            System.out.println("---------------------------------");
            System.out.println("s="+s);
            System.out.println("genericType="+genericType.getTypeName());
            System.out.println("type="+type.getTypeName());
            System.out.println("---------------------------------");
        }
//        new Controller(new ViewImpl()).proceed();
    }
}
