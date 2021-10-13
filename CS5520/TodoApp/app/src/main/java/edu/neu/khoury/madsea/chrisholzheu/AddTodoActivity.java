package edu.neu.khoury.madsea.chrisholzheu;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class AddTodoActivity extends AppCompatActivity {

    private TodoViewModel todoViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_todo);

        todoViewModel = new ViewModelProvider(this).get(TodoViewModel.class);
        todoViewModel.getDoesTodoExist().observe(this, new Observer<Boolean>() {
            @Override
            public void onChanged(Boolean aBoolean) {
                if (aBoolean) {
                    finish();
                }
            }
        });
    }
}