package edu.neu.khoury.madsea.chrisholzheu;

import android.app.Application;

public class ToDoApp extends Application {

    private static ToDoApp instance;

    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;
    }

    public static ToDoApp getInstance() {
        return ToDoApp.instance;
    }
}
