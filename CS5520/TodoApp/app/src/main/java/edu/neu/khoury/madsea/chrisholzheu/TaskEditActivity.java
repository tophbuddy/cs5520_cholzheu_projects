package edu.neu.khoury.madsea.chrisholzheu;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class TaskEditActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_task_edit);

        Intent intent = getIntent();
        String todoTaskTitle = intent.getStringExtra(MainActivity.EXTRA_TITLE);

        TextView textView = (TextView) findViewById(R.id.todo_title);
        if (textView != null) {
            textView.setText(todoTaskTitle);
        }
    }
}