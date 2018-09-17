package com.example.nishida.transitiontest;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class SubActivity extends AppCompatActivity {

    private EditText editText;
    private String message;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sub);

        // to get message from MainActivity
        /*
        Intent intent = getIntent();
        message = intent.getStringExtra(MainActivity.EXTRA_MESSAGE);

        TextView textView = findViewById(R.id.text_view);
        textView.setText(message);
        */

        editText = findViewById(R.id.edit_text);

        // back to MainActivity
        Button button = findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent();
                if (editText.getText() != null) {
                    String str = editText.getText().toString();
                    intent.putExtra(MainActivity.EXTRA_MESSAGE, str);
                }

                editText.setText("");

                setResult(RESULT_OK, intent);

                finish();
            }
        });
    }
}