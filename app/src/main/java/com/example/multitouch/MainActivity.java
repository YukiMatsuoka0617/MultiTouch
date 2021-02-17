package com.example.multitouch;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {

    TextView textView;
    int touchCount;

    float downPositionX;
    float downPositionY;
    float movePositionX;
    float movePositionY;
    long downTime;
    long moveTime;
    long timeThreshold = 1000;
    boolean longPress = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = findViewById(R.id.textview);
    }

    @Override
    public boolean onTouchEvent(MotionEvent motionEvent) {
        touchCount = motionEvent.getPointerCount();
        textView.setText("touchCount : " + touchCount);

        switch (motionEvent.getAction()) {
            case MotionEvent.ACTION_DOWN:
                Log.d("test", "ACTION_DOWN");
                downPositionX = motionEvent.getX();
                downPositionY = motionEvent.getY();
                downTime = System.currentTimeMillis();
                // something to do
                break;
            case MotionEvent.ACTION_MOVE:
                Log.d("test", "ACTION_MOVE");
                movePositionX = motionEvent.getX();
                movePositionY = motionEvent.getY();
                float differenceX = Math.abs(downPositionX - movePositionX);
                float differenceY = Math.abs(downPositionY - movePositionY);
                // something to do
                if (differenceX > differenceY && differenceX > 100) {
                    switch (touchCount) {
                        case 1:
                            Log.d("test", "ACTION_MOVE yoko 01");
                            break;
                        case 2:
                            Log.d("test", "ACTION_MOVE yoko 02");
                            break;
                        case 3:
                            Log.d("test", "ACTION_MOVE yoko 03");
                            break;
                    }
                } else if (differenceY > differenceX && differenceY > 100) {
                    switch (touchCount) {
                        case 1:
                            Log.d("test", "ACTION_MOVE tate 01");
                            break;
                        case 2:
                            Log.d("test", "ACTION_MOVE tate 02");
                            break;
                        case 3:
                            Log.d("test", "ACTION_MOVE tate 03");
                            break;
                    }
                } else {
                    moveTime = System.currentTimeMillis();
                    if (moveTime - downTime > timeThreshold && longPress) {
                        switch (touchCount) {
                            case 1:
                                Log.d("test", "3 point long press 01");
                                break;
                            case 2:
                                Log.d("test", "3 point long press 02");
                                break;
                            case 3:
                                Log.d("test", "3 point long press 03");
                                break;
                        }
                        longPress = false;
                    }
                }
                break;
            case MotionEvent.ACTION_UP:
                Log.d("test", "ACTION_UP");
                // something to do
                longPress = true;
                break;
            case MotionEvent.ACTION_OUTSIDE:
                Log.d("test", "ACTION_OUTSIDE");
                // something to do
                break;
            case MotionEvent.ACTION_CANCEL:
                Log.d("test", "ACTION_CANCEL");
                // something to do
                break;
        }
        return true;
    }
}