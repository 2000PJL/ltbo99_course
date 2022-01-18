package com.example.iot228;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.net.Uri;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import androidx.constraintlayout.widget.ConstraintLayout;

public class MainActivity extends AppCompatActivity {

    EditText ed1,ed2;
    Button buttonyes,buttonno;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ed1=findViewById(R.id.myname1);
        ed2=findViewById(R.id.mytxtpwd1);
        buttonyes=findViewById(R.id.button_yes);
        buttonno=findViewById(R.id.button_no);

       final Intent intent =new Intent(MainActivity.this, DataActivity.class);

        Button.OnClickListener buttonListener = new Button.OnClickListener(){
			@Override
			public void onClick(View v) {
				switch(v.getId()){
					case R.id.button_yes:
//						ed1.setText("1");
//                       ed2.setText("2");
                        intent.putExtra("data",ed1.getText().toString()+ed2.getText().toString());
                        startActivity(intent);
						return;
                    case R.id.button_no:
//                        ed1.setText("彭俊龙");
//						ed2.setText("");
                        intent.putExtra("data",ed2.getText().toString()+ed1.getText().toString());
                        startActivity(intent);
						return;
                    default:
                        break;
				}
			}};

		buttonyes.setOnClickListener(buttonListener);
		buttonno.setOnClickListener(buttonListener);




    }
}
