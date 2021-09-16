package com.example.lesson1_1_hw;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d("Lesson1_1","Debug Level Message");
        Log.e("Lesson1_1", "Error Level Message");
        Log.i("Lesson1_1", "Info Level Message");
    }
}