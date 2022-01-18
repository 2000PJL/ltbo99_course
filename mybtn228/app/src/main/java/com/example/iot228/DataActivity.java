package com.example.iot228;

import android.app.Activity;
import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

public class DataActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_data);

        TextView tv3;
        tv3=findViewById(R.id.tv3);
        Button button=findViewById(R.id.button);
        Intent intent=getIntent();
        //final Intent intent =new Intent(MainActivity.this, MainActivity.class);
        String message=intent.getStringExtra("data");
        tv3.setText("我所接收到的信息是："+message);
        final Intent intent1 =new Intent(DataActivity.this, MainActivity.class);

        Button.OnClickListener buttonListener = new Button.OnClickListener(){
            @Override
            public void onClick(View v) {
                switch(v.getId()){
                    case R.id.button:
                     startActivity(intent1);
                        return;
                    default:
                        break;
                }
            }};

        button.setOnClickListener(buttonListener);


    }
}
