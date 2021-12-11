package com.example.hamburgermymebu;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class kronometre extends AppCompatActivity {
    TextView textView;
    Button button;

    int number;
    Runnable runnable;
    Handler handler;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.kronometre);
        textView=findViewById(R.id.textView);
        button=findViewById(R.id.button);
        number=0;


    }

    public void start(View view){
        Toast.makeText(this,"Başlatıldı",Toast.LENGTH_LONG).show();
        handler= new Handler();
        runnable= new Runnable() {
            @Override
            public void run() {
                textView.setText("Time: "+number);
                number++;
                textView.setText("Time: "+number);
                handler.postDelayed(runnable,1000);

            }
        };
        handler.post(runnable);
        button.setEnabled(false);




    }
    public void stop(View view){
        Toast.makeText(this,"Burduruldu",Toast.LENGTH_LONG).show();
        button.setEnabled(true);
        handler.removeCallbacks(runnable);
        number = 0;
        textView.setText("Time"+number);


    }

















}