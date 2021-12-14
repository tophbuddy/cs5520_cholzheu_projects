package edu.neu.khoury.madsea.chrisholzheu.data;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.lifecycle.LiveData;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.ListAdapter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ThreadPoolExecutor;


import edu.neu.khoury.madsea.chrisholzheu.ToDoViewModel;
import edu.neu.khoury.madsea.chrisholzheu.databinding.TodoItemViewBinding;
import edu.neu.khoury.madsea.chrisholzheu.itemtouchhelpers.ItemTouchHelperAdapter;
import edu.neu.khoury.madsea.chrisholzheu.itemtouchhelpers.OnStartDragListener;

public class ToDoRecyclerViewAdapter extends ListAdapter<ToDo, ToDoViewHolder>
        implements ItemTouchHelperAdapter {
    private static final String RECYCLER_TAG = "ToDoRecyclerViewAdapter";
    private ExternalOnClickListener clickListener;
    private final OnStartDragListener dragListener;
//    private List<? extends ToDo> todoList;

    public ToDoRecyclerViewAdapter(Context context, ExternalOnClickListener onClickListener,
                                   OnStartDragListener onDragListener) {
        super(ToDo.toDoItemCallback);
        this.clickListener = onClickListener;
        this.dragListener = onDragListener;
//        this.todoList = new ArrayList<>();
    }

//    public void setTodoList(final List<? extends ToDo> list) {
//        if (todoList == null) {
//            todoList = list;
//            notifyItemRangeInserted(0, list.size());
//        } else {
//            DiffUtil.DiffResult result = DiffUtil.calculateDiff(new DiffUtil.Callback() {
//                @Override
//                public int getOldListSize() {
//                    return todoList.size();
//                }
//
//                @Override
//                public int getNewListSize() {
//                    return list.size();
//                }
//
//                @Override
//                public boolean areItemsTheSame(int oldItemPosition, int newItemPosition) {
//                    return todoList.get(oldItemPosition).getTodoId() ==
//                            list.get(newItemPosition).getTodoId();
//                }
//
//                @Override
//                public boolean areContentsTheSame(int oldItemPosition, int newItemPosition) {
//                    ToDo newTodo = list.get(newItemPosition);
//                    ToDo oldTodo = todoList.get(oldItemPosition);
//                    return newTodo.getTodoId() == oldTodo.getTodoId()
//                            && TextUtils.equals(newTodo.getTodoDetails(), oldTodo.getTodoDetails())
//                            && TextUtils.equals(newTodo.getTodoTitle(), oldTodo.getTodoTitle());
//                }
//            });
//            todoList = list;
//            result.dispatchUpdatesTo(this);
//        }
//    }

    @NonNull
    @Override
    public ToDoViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ToDoViewHolder(TodoItemViewBinding.inflate(LayoutInflater.from(parent.getContext()),
                parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull ToDoViewHolder holder, int position) {
        final int viewPosition = position;
        holder.bind(getCurrentList().get(viewPosition));
        holder.todoViewBinding.getRoot().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clickListener.toDoItemClickListener(new ToDo(getItem(holder.getLayoutPosition())));
            }
        });
        holder.todoViewBinding.deleteButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clickListener.toDoItemDeleteListener(getItem(holder.getLayoutPosition()));
            }
        });
    }

    @Override
    public boolean onItemMove(int fromPosition, int toPosition) {
        Log.d(RECYCLER_TAG, "From Position: " + fromPosition);
        Log.d(RECYCLER_TAG, "To Position: " + toPosition);
        List<ToDo> currentList = getCurrentList();
        List<ToDo> newList = new ArrayList<>(currentList);
        Collections.swap(newList, fromPosition, toPosition);
        submitList(newList);
//        if (fromPosition < toPosition) {
//            for (int i = fromPosition; i < toPosition; i++) {
//                Collections.swap(todoList, i, i + 1);
//            }
//        } else {
//            for (int i = fromPosition; i > toPosition; i--) {
//                Collections.swap(todoList, i, i - 1);
//            }
//        }
//        notifyItemMoved(fromPosition, toPosition);
        this.notifyItemChanged(fromPosition);
        this.notifyItemChanged(toPosition);

        return true;
    }

    @Override
    public void onItemDismiss(int position) {
//        todoList.remove(position);
        notifyItemRemoved(position);
    }

//    @Override
//    public void submitList(final List<ToDo> list) {
//        super.submitList(list != null ? new ArrayList<ToDo>(list) : null);
//    }


    public interface ExternalOnClickListener {
        public void toDoItemClickListener(ToDo todo);
        public void toDoItemDeleteListener(ToDo toDo);
    }

    public static class TodoDiff extends DiffUtil.ItemCallback<ToDo> {

        @Override
        public boolean areItemsTheSame(@NonNull ToDo oldItem, @NonNull ToDo newItem) {
            return oldItem == newItem;
        }

        @Override
        public boolean areContentsTheSame(@NonNull ToDo oldItem, @NonNull ToDo newItem) {
            return oldItem.getTodoTitle().equals(newItem.getTodoTitle());
        }
    }
}
