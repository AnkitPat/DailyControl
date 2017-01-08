package com.example.ankit.dailycontrol;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

/**
 * Created by Azhar on 25-12-2016.
 */

public class Login extends Activity {

    private EditText username,password;
    private Spinner spinner_login;
    private Button submit;
    Intent intent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);

        username = (EditText)findViewById(R.id.username);
        password = (EditText)findViewById(R.id.password);
        spinner_login = (Spinner)findViewById(R.id.spinner_login);
        submit = (Button)findViewById(R.id.submit);

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if((username.getText().toString().equals("demo"))  && (password.getText().toString().equals("123"))) {
                    intent = new Intent(Login.this, MainActivity.class);
                    startActivity(intent);

                }
            }

        });
    }
}
