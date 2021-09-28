package edu.neu.khoury.madsea.chrisholzheu;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ArrayList<String> todos;
    private ArrayAdapter<String> todoAdapter;
    private ListView todosListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        todosListView = (ListView) findViewById(R.id.main_todo_list);
        todos = new ArrayList<String>();
        todoAdapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1, todos);
        todosListView.setAdapter(todoAdapter);
        todos.add("Buy ingredients for dinner");
        todos.add("Go to the gym");
    }

    public void addTodo(View view) {
        EditText newTodoItem = (EditText) findViewById(R.id.add_item_field);
        String todoDetails = newTodoItem.getText().toString();
        todoAdapter.add(todoDetails);
        newTodoItem.setText("");
    }
}