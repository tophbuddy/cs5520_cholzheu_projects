package edu.neu.khoury.madsea.chrisholzheu.itemtouchhelpers;

import androidx.recyclerview.widget.RecyclerView;

public interface ItemTouchHelperAdapter {

    boolean onItemMove(int fromPosition, int toPosition);

    void onItemDismiss(int position);
}
