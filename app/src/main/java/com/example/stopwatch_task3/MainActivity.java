package com.example.stopwatch_task3;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {

    TextView text;
    Button button, button2, button3;
    Handler handler=new Handler();
    boolean running = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        text = findViewById(R.id.text);
        button = findViewById(R.id.button);
        button2 = findViewById(R.id.button2);
        button3 = findViewById(R.id.button3);

        button.setOnClickListener(new View.OnClickListener() {
            private int second = 0;
            @Override
            public void onClick(View view) {
                running=true;
                handler.post(new Runnable() {
                    @Override
                    public void run() {
                        if (running) {
                            second++;
                            int hours = second / 3600;
                            int min = (second % 3600) / 60;
                            int sec = second % 60;
                            String fin = String.valueOf(hours);
                            String fin2 = String.valueOf(min);
                            String fin3 = String.valueOf(sec);
                            text.setText(fin + " : " + fin2 + " : " + fin3);
                        }
                        handler.postDelayed(this,1000);
                    }
                });
                Toast.makeText(MainActivity.this, "first", Toast.LENGTH_SHORT).show();
            }
        });
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               running=false;
            }
        });

        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                reset();
                text.setText("00:00:00");
            }
        });
    }

    private  void reset(){
        Toast.makeText(MainActivity.this, "3rd", Toast.LENGTH_SHORT).show();
    }


}