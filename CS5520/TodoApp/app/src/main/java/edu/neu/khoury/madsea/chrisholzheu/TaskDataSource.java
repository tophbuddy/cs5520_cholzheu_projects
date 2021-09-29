package edu.neu.khoury.madsea.chrisholzheu;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;

public final class TaskDataSource {
    private static TaskDataSource instance = new TaskDataSource();
    private HashMap<String, String> todoStorage = new HashMap<String, String>();
    private TaskDataSource() {}

    public static TaskDataSource getInstance(String taskTitle, String taskDescription) {
        if (instance == null) {
            instance = new TaskDataSource();
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
