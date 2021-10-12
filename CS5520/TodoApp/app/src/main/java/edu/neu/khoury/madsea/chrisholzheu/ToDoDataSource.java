package edu.neu.khoury.madsea.chrisholzheu;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;

public final class ToDoDataSource {
    private static ToDoDataSource instance = new ToDoDataSource();
    private HashMap<String, String> todoStorage = new HashMap<String, String>();
    private ToDoDataSource() {}

    public static ToDoDataSource getInstance(String taskTitle, String taskDescription) {
        if (instance == null) {
            instance = new ToDoDataSource();
        }
        return instance;
    }

    public void put(String todoTitle) {
        todoStorage.put(todoTitle, "");
    }

    public String getHashMap() {
        return String.valueOf(Collections.singletonList(Arrays.asList(todoStorage)));
    }
}
