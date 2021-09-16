package com.example.helloconstraint;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private int mCount = 0;
    private TextView mShowCount;
    private Button mZeroButton;
    private Button mCountButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mShowCount = (TextView) findViewById(R.id.show_count);
        mZeroButton = findViewById(R.id.button_zero);
        mCountButton = findViewById(R.id.button_count);
    }

    public void showToast(View view) {
        Toast toast = Toast.makeText(this, R.string.toast_message,
                Toast.LENGTH_SHORT);
        toast.show();
    }

    public void countUp(View view) {
        mCount++;
        mZeroButton.setBackgroundColor(getResources().getColor(R.color.design_default_color_primary));
        if (mShowCount != null)
            mShowCount.setText(Integer.toString(mCount));
        if ((mCount % 2) == 0) {
            view.setBackgroundColor(Color.MAGENTA);
        } else if ((mCount % 2) == 1) {
            view.setBackgroundColor(Color.GREEN);
        }
    }

    public void setZero(View view) {
        mCount = 0;
        mShowCount.setText(Integer.toString(mCount));
        view.setBackgroundColor(Color.GRAY);
        mCountButton.setBackgroundColor(getResources().getColor(R.color.design_default_color_primary));
    }
}