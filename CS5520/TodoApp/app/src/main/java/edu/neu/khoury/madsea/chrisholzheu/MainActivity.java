package edu.neu.khoury.madsea.chrisholzheu;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ArrayList<String> todos;
    private ArrayAdapter<String> todoAdapter;
    private ListView todosListView;
    private ToDoDataSource todoData;
    private final static int DATA_REQUEST = 1;
    public static final String EXTRA_TITLE = "edu.neu.khoury.madsea.chrisholzheu.MESSAGE";
    private static final String LOG_TAG = MainActivity.class.getSimpleName();

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
        setupListViewListener();
        setupTaskEditListener();
    }

    public void addTodo(View view) {
        EditText newTodoItem = (EditText) findViewById(R.id.add_item_field);
        String todoDetails = newTodoItem.getText().toString();
        todoAdapter.add(todoDetails);
        newTodoItem.setText("");
    }

    public void setupTaskEditListener() {
        // Intent intent = new Intent(this, TaskEditActivity.class);
        todosListView.setOnItemClickListener(
                new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                        Intent intent = new Intent(MainActivity.this, NewTodoActivity.class);
                        String taskTitleText = (todosListView.getItemAtPosition(i).toString());
                        intent.putExtra(EXTRA_TITLE, taskTitleText);
                        startActivity(intent);
            }
        });
    }

    private void setupListViewListener() {
        todosListView.setOnItemLongClickListener(
                new AdapterView.OnItemLongClickListener() {
                    @Override
                    public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long l) {
                        todos.remove(i);
                        todoAdapter.notifyDataSetChanged();
                        return true;
                    }
                });
    }


}