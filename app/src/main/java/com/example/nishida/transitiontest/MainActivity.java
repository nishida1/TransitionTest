package com.example.nishida.transitiontest;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    // the key constant
    public static final String EXTRA_MESSAGE
//            = "com.example.testactivitytrasdata.MESSAGE";
            = "com.example.nishida.transitiontest.MESSAGE";

    private TextView textView;
    //static final int RESULT_SUBACTIVITY = 1000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        locationPermission();

        /*
        textView = findViewById(R.id.text_view);
        final EditText editText= findViewById(R.id.edit_text);

        //SubActivity への Intent
        Button button = findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(getApplication(), SubActivity.class);
                startActivityForResult( intent, RESULT_SUBACTIVITY );
                // in order to clear the edittext
                editText.setText("");
            }
        });
        */
    }

    private void locationPermission() {
        Intent intent = new Intent(getApplication(), LocationPermission.class);
        startActivity(intent);
    }

    // SubActivity からの返しの結果を受け取る
    /*
    protected void onActivityResult( int requestCode, int resultCode, Intent intent) {
        super.onActivityResult(requestCode, resultCode, intent);

        if(resultCode == RESULT_OK && requestCode == RESULT_SUBACTIVITY &&
                null != intent) {
            String res = intent.getStringExtra(MainActivity.EXTRA_MESSAGE);
            textView.setText(res);
        }
    }
    */
}