package edu.neu.khoury.madsea.chrisholzheu;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import edu.neu.khoury.madsea.chrisholzheu.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

//    private ArrayList<String> todos;
//    private ArrayAdapter<String> todoAdapter;
//    private ListView todosListView;
//    private ToDoDataSource todoData;
//    private final static int DATA_REQUEST = 1;
//    public static final String EXTRA_TITLE = "edu.neu.khoury.madsea.chrisholzheu.MESSAGE";
//    private static final String LOG_TAG = MainActivity.class.getSimpleName();

    private TodoViewModel todoViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        todoViewModel = new ViewModelProvider(this).get(TodoViewModel.class);
        ActivityMainBinding binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        binding.mainTodoListView.setLayoutManager(new LinearLayoutManager(this));
        binding.mainTodoListView.scrollToPosition(0);

        final ToDoRecyclerViewAdapter adapter = new ToDoRecyclerViewAdapter(
                new ToDoRecyclerViewAdapter.TodoDiff());
        todoViewModel.getCurToDos().observe(this, toDos -> {
            adapter.submitList(toDos);
        });
        binding.mainTodoListView.setAdapter(adapter);

        binding.buttonAddTodo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, AddTodoActivity.class);
                startActivity(intent);
            }
        });
    }
}