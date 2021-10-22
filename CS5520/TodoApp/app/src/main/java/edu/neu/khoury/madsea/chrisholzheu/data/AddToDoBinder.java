package edu.neu.khoury.madsea.chrisholzheu.data;

import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;

import androidx.databinding.BindingAdapter;

public class AddToDoBinder {

    @BindingAdapter("dispatchOnLoseFocus")
    public static void dispatchOnLoseFocus(EditText view, final View.OnFocusChangeListener listener) {
        view.setOnFocusChangeListener(new View.OnFocusChangeListener(){
            @Override
            public void onFocusChange(View focusedView, boolean hasFocus) {
                EditText editText = (EditText) focusedView;
                if (!hasFocus){
                    listener.onFocusChange(editText, false);
                }
            }});
    }

    @BindingAdapter("dispatchOnLoseFocus")
    public static void dispatchOnLoseFocus(CheckBox view, final View.OnFocusChangeListener listener) {
        view.setOnFocusChangeListener(new View.OnFocusChangeListener(){
            @Override
            public void onFocusChange(View focusedView, boolean hasFocus) {
                CheckBox checkBox = (CheckBox) focusedView;
                if (!hasFocus){
                    listener.onFocusChange(checkBox, false);
                }
            }});
    }
}
