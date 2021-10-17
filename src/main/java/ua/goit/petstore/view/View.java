package ua.goit.petstore.view;

import java.util.List;

public interface View {
    String read();
    void write(String message);
    void write(Object...objects);
    default void write(List objects){
        write(objects.toArray());
    }
}
