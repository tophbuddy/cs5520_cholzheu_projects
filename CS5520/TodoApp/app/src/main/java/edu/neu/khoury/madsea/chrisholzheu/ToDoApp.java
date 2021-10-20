package edu.neu.khoury.madsea.chrisholzheu;

import android.app.Application;
import android.util.Log;

import edu.neu.khoury.madsea.chrisholzheu.data.ToDoRepository;
import edu.neu.khoury.madsea.chrisholzheu.data.ToDoRoomDatabase;

public class ToDoApp extends Application {

    private static ToDoApp instance;

    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;
        Log.d("ToDoApp","Created ToDoApp.");
    }

    public static ToDoApp getInstance() {
        return ToDoApp.instance;
    }

    public ToDoRoomDatabase getDatabase() {
        return ToDoRoomDatabase.getDatabase(this);
    }

    public ToDoRepository getRepository() {
        return ToDoRepository.getInstance(getDatabase());
    }
}
