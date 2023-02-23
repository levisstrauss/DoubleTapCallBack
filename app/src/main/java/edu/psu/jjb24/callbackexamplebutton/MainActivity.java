package edu.psu.jjb24.callbackexamplebutton;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity implements DoubleTapButton.OnDoubleTapListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        DoubleTapButton dtb = findViewById(R.id.button1);
        dtb.setOnDoubleTapListener(this);
        // For Button two
        dtb = findViewById(R.id.button2);
        dtb.setOnDoubleTapListener(new DoubleTapButton.OnDoubleTapListener() {
            @Override
            public void onDoubleTap(long elapsed) {
                TextView tv = findViewById(R.id.tvResult);
                tv.setText("Double tap on second button with interval " + elapsed);
            }
        });

        dtb = findViewById(R.id.button3);
        dtb.setOnDoubleTapListener(elapsed -> {TextView tv = findViewById(R.id.tvResult);
            tv.setText("Double tap on third button with interval " + elapsed);});
    }

    public void buttonClick(View view) {
        DoubleTapButton button = (DoubleTapButton) view;
        Log.d("CallbackExView", "Click detected on '" + button.getText().toString() + "'");
    }

    @Override
    public void onDoubleTap(long elapsed) {
        TextView tv = findViewById(R.id.tvResult);
        tv.setText("Double tap on first button with interval " + elapsed);
    }
}