package com.example.oliinyk.lab8;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class MainActivity extends AppCompatActivity implements View.OnTouchListener {

    TextView t1;
    float x,y,x_down,y_down, x_move, y_move, x_up, y_up;
    int mX,mY;

    private ViewGroup mMoveLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        t1 = (TextView) findViewById(R.id.textView);
        t1.setOnTouchListener(this);
    }

    public boolean onTouch(View v, MotionEvent event) {
        final int X = (int) event.getRawX();
        final int Y = (int) event.getRawY();

        x = event.getX(); // текущая координата X пальца
        x = (float) new BigDecimal(x).setScale(1, RoundingMode.UP).doubleValue();
        y = event.getY(); // текущая координата Y пальца
        y = (float) new BigDecimal(y).setScale(1, RoundingMode.UP).doubleValue();


        switch (event.getAction()) {

            case MotionEvent.ACTION_DOWN:
                x_down = x;
                y_down = y;
                break;
            case MotionEvent.ACTION_MOVE:
                x_move = x;
                y_move = y;
                t1.setPadding(X,(Y-200),0,0);
                break;
            case MotionEvent.ACTION_UP:
                x_up=x;
                y_up=y;
                break;
            case MotionEvent.ACTION_CANCEL:
                break;
        }
        t1.setText("Down "+ x_down + " " + y_down+"\nMove "+ x_move + " " + y_move+"\nUp " + x_up +" "+ y_up);
        return true;
    }
}
