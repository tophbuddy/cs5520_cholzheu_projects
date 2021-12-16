package edu.neu.khoury.madsea.chrisholzheu.data;

import android.util.Log;

import androidx.lifecycle.LiveData;

import java.util.ArrayList;
import java.util.List;

public class ToDoRepository {

    private ToDoDao toDoDao;
    private static ToDoRepository singleton;
    private LiveData<List<ToDo>> allToDos;
    private final ToDoRoomDatabase toDoDatabase;
    private final LiveData<Integer> toDoId;
    private static final int DEFAULT_ID = 1;
    private static final String REPO_TAG = "ToDoRepository";

    private ToDoRepository(final ToDoRoomDatabase database) {
        toDoDatabase = database;
        toDoDao = database.toDoDao();
        allToDos = toDoDao.getAllToDos();
        toDoId = toDoDao.getToDoId();
        toDoId.observeForever(list -> {});
    }

    public static ToDoRepository getInstance(final ToDoRoomDatabase database) {
        if (singleton == null) {
            singleton = new ToDoRepository(database);
        }
        return singleton;
    }

    public void addToDo(ToDo newToDo) {
        ToDoRoomDatabase.databaseWriteExecutor.execute(() -> {
            toDoDao.insert(newToDo);
        });
    }

    public LiveData<List<ToDo>> getAllToDos() {
        return allToDos;
    }

    public void update(ToDo toDo) {
        ToDoRoomDatabase.databaseWriteExecutor.execute(() -> {
            toDoDao.update(toDo);
        });
    }

    public void updateAll(List<ToDo> updater) {
        ToDoRoomDatabase.databaseWriteExecutor.execute(() -> {
            toDoDao.updateList(updater);
        });
    }

    public void delete(ToDo toDo) {
        ToDoRoomDatabase.databaseWriteExecutor.execute(() -> {
            toDoDao.delete(toDo);
        });
    }

    public void updateListOrder() {
        ToDoRoomDatabase.databaseWriteExecutor.execute(() -> {
            allToDos = toDoDao.sortByOrder();
        });
    }

    public void swapItems(long oldPos, long newPos) {
        Log.d(REPO_TAG, "Repo old position: " + oldPos);
        Log.d(REPO_TAG, "Repo new position: " + newPos);
        ToDoRoomDatabase.databaseWriteExecutor.execute(() -> {
            toDoDao.swapPositions(oldPos, newPos);
        });
    }

    public LiveData<ToDo> getTodoById(long todoId) {
        return toDoDao.getTodo(todoId);
    }

    public long getToDoId() {
        if (toDoId.getValue() == null)
            return DEFAULT_ID;
        else
            return toDoId.getValue() + DEFAULT_ID;
    }
}
