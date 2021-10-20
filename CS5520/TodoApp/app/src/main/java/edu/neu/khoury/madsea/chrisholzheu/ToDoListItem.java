package edu.neu.khoury.madsea.chrisholzheu;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.fragment.NavHostFragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import edu.neu.khoury.madsea.chrisholzheu.data.ToDo;
import edu.neu.khoury.madsea.chrisholzheu.data.ToDoRecyclerViewAdapter;
import edu.neu.khoury.madsea.chrisholzheu.databinding.TodoListBinding;

public class ToDoListItem extends Fragment {

    private TodoListBinding listBinding;
    private ToDoViewModel viewModel;
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
        mAdapter = new ToDoRecyclerViewAdapter(this);
        viewModel.getToDoList().observe(getViewLifecycleOwner(), list -> {
            mAdapter.submitList(list);
        });
        mRecyclerView.setAdapter(mAdapter);
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

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        listBinding = null;
    }

    @Override
    public void onToDoClick(ToDo toDo) {
        viewModel.setEditFlag(toDo);
        NavHostFragment.findNavController(AddTodoActivity.this)
                .navigate(R.id.action_FirstFragment_to_SecondFragment);
    }

    @Override
    public void onToDoDeleteClick(ToDo toDo) {
        viewModel.deleteToDo(toDo);
    }

    @Override
    public void onToDoCheckboxClick(ToDo toDo, boolean complete) {
        toDo.setComplete(complete);
        viewModel.updateToDo(toDo);
    }
}
