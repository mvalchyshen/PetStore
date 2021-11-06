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
        new Controller(new ViewImpl()).proceed();
    }
}
