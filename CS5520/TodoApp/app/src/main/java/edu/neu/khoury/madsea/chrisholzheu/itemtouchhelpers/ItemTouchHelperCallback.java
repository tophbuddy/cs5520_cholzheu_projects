package edu.neu.khoury.madsea.chrisholzheu.itemtouchhelpers;

import android.graphics.Canvas;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.RecyclerView;

import edu.neu.khoury.madsea.chrisholzheu.ToDoViewModel;
import edu.neu.khoury.madsea.chrisholzheu.data.ToDoRepository;


public class ItemTouchHelperCallback extends ItemTouchHelper.Callback {

    private static final String ITEM_TOUCH_TAG = "ItemTouchHelperCallback";
    public static final float ALPHA = 1.0f;
    private final ItemTouchHelperAdapter mAdapter;
    private ToDoViewModel mViewModel;

    public ItemTouchHelperCallback(ItemTouchHelperAdapter adapter, ToDoViewModel viewModel) {
        mAdapter = adapter;
        mViewModel = viewModel;
    }

    @Override
    public boolean isLongPressDragEnabled() {
        return true;
    }

    @Override
    public boolean isItemViewSwipeEnabled() {
        return false;
    }

    @Override
    public int getMovementFlags(@NonNull RecyclerView recyclerView,
                                @NonNull RecyclerView.ViewHolder viewHolder) {
        return makeMovementFlags(ItemTouchHelper.UP | ItemTouchHelper.DOWN, 0);
    }

    @Override
    public boolean onMove(@NonNull RecyclerView recyclerView,
                          @NonNull RecyclerView.ViewHolder viewHolder,
                          @NonNull RecyclerView.ViewHolder target) {
        if (viewHolder.getItemViewType() != target.getItemViewType()) {
            return false;
        }
        long oldPos = viewHolder.getBindingAdapterPosition() + 1;
        long newPos = target.getBindingAdapterPosition() + 1;
        Log.d(ITEM_TOUCH_TAG, "ItemTouch old position: " + oldPos);
        Log.d(ITEM_TOUCH_TAG, "ItemTouch new position: " + newPos);
        mAdapter.onItemMove(viewHolder.getBindingAdapterPosition(),
                target.getBindingAdapterPosition());
        if (oldPos != newPos) {
            mViewModel.swapItems(oldPos, newPos);
//            mViewModel.updateOrder();
        }
        return true;
    }

    @Override
    public void onSwiped(@NonNull RecyclerView.ViewHolder viewHolder, int direction) {
    }

    @Override
    public void onChildDraw(Canvas canvas, RecyclerView recyclerView,
                            RecyclerView.ViewHolder viewHolder, float dX, float dY, int actionState,
                            boolean isCurrentlyActive) {
        if (actionState == ItemTouchHelper.ACTION_STATE_SWIPE) {
            final float alpha = ALPHA - Math.abs(dX) / (float) viewHolder.itemView.getWidth();
            viewHolder.itemView.setAlpha(alpha);
            viewHolder.itemView.setTranslationX(dX);
        } else {
            super.onChildDraw(canvas, recyclerView, viewHolder, dX, dY, actionState,
                    isCurrentlyActive);
        }
    }

    @Override
    public void onSelectedChanged(RecyclerView.ViewHolder viewHolder, int actionState) {
        if (actionState != ItemTouchHelper.ACTION_STATE_IDLE) {
            if (viewHolder instanceof ItemTouchHelperViewHolder) {
                ItemTouchHelperViewHolder itemViewHolder = (ItemTouchHelperViewHolder) viewHolder;
                itemViewHolder.onItemSelected();
            }
        }
        super.onSelectedChanged(viewHolder, actionState);
    }

    @Override
    public void clearView(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder) {
        super.clearView(recyclerView, viewHolder);
        viewHolder.itemView.setAlpha(ALPHA);
//        mViewModel.updateOrder();
        if (viewHolder instanceof ItemTouchHelperViewHolder) {
            ItemTouchHelperViewHolder itemViewHolder = (ItemTouchHelperViewHolder) viewHolder;
            itemViewHolder.onItemClear();
            mViewModel.updateOrder();
        }
    }
}
