package edu.neu.khoury.madsea.chrisholzheu;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.fragment.NavHostFragment;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import edu.neu.khoury.madsea.chrisholzheu.data.ToDo;
import edu.neu.khoury.madsea.chrisholzheu.data.ToDoRecyclerViewAdapter;
import edu.neu.khoury.madsea.chrisholzheu.databinding.TodoListBinding;
import edu.neu.khoury.madsea.chrisholzheu.itemtouchhelpers.ItemTouchHelperCallback;
import edu.neu.khoury.madsea.chrisholzheu.itemtouchhelpers.OnStartDragListener;


public class ToDoListItem extends Fragment implements ToDoRecyclerViewAdapter.ExternalOnClickListener, OnStartDragListener {

    private TodoListBinding listBinding;
    private static final String RECYCLER_TAG = "ToDoRecyclerListItem";
    private ToDoViewModel viewModel;
    private ItemTouchHelper mItemTouchHelper;
    private ArrayList<ToDo> todoList = new ArrayList<>();
    protected RecyclerView mRecyclerView;
    protected ToDoRecyclerViewAdapter mAdapter;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {
        ToDoViewModel.Factory viewFactory = new ToDoViewModel.Factory(
                requireActivity().getApplication());
        viewModel = new ViewModelProvider(requireActivity(), viewFactory).get(ToDoViewModel.class);
        listBinding = TodoListBinding.inflate(inflater, container, false);
        mRecyclerView = (RecyclerView) listBinding.recyclerView;
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        mRecyclerView.scrollToPosition(0);
        mAdapter = new ToDoRecyclerViewAdapter(getActivity(),this, this);

        viewModel.getToDoList().observe(getViewLifecycleOwner(),
                list -> {
            mAdapter.submitList(list);
        });

        mRecyclerView.setAdapter(mAdapter);
        mAdapter.registerAdapterDataObserver(new RecyclerView.AdapterDataObserver() {
            @Override
            public void onChanged() {
                Log.e(RECYCLER_TAG, "item position changed");
            }
        });
        ItemTouchHelper.Callback callback = new ItemTouchHelperCallback(mAdapter);
        mItemTouchHelper = new ItemTouchHelper(callback);
        mItemTouchHelper.attachToRecyclerView(mRecyclerView);
        return listBinding.getRoot();
    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        listBinding.newToDoButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                viewModel.setAddingFlag();
                NavHostFragment.findNavController(ToDoListItem.this)
                        .navigate(R.id.action_FirstFragment_to_SecondFragment);
            }
        });
    }

//    private void updateUi(LiveData<List<ToDo>> liveData) {
//        liveData.observe(getViewLifecycleOwner(), myTodos -> {
//            if (myTodos != null) {
//                mAdapter.setTodoList(myTodos);
//            }
//
//        });
//    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        listBinding = null;
    }

    @Override
    public void toDoItemDeleteListener(ToDo toDo) {
        viewModel.deleteToDo(toDo);
    }

    public void onToDoCheckboxClick(ToDo toDo, boolean complete) {
        toDo.setComplete(complete);
        viewModel.updateToDo(toDo);
    }

    @Override
    public void toDoItemClickListener(ToDo toDo) {
        viewModel.setEditFlag(toDo);
        NavHostFragment.findNavController(ToDoListItem.this)
                .navigate(R.id.action_FirstFragment_to_SecondFragment);
    }

    @Override
    public void onStartDrag(RecyclerView.ViewHolder viewHolder) {
        mItemTouchHelper.startDrag(viewHolder);
    }
}
