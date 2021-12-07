package edu.neu.khoury.madsea.chrisholzheu.itemtouchhelpers;

public interface ItemTouchHelperAdapter {

    boolean onItemMove(int startPos, int endPos);

    void onItemDismiss(int pos);
}
