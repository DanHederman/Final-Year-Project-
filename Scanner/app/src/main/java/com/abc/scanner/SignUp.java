package com.abc.scanner;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import java.net.URL;

public class SignUp extends AppCompatActivity {

    EditText full_name, email, password, passwordconfo;

    String FullName, Password, PasswordConfo, Email;

    Context ctx = this;

    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        full_name = (EditText) findViewById(R.id.fullname);
        password = (EditText) findViewById(R.id.pwd);
        passwordconfo = (EditText) findViewById(R.id.pwdconfo);
        email = (EditText) findViewById(R.id.email);
    }

    public void register(View V){

        FullName = full_name.getText().toString();
        Password = password.getText().toString();
        PasswordConfo = passwordconfo.getText().toString();
        Email = email.getText().toString();



        BackGround b = new BackGround();

    }

    class BackGround extends AsyncTask<String, String, String>{

        @Override
        protected String doInBackground(String... params) {

            String full_name = params[0];
            String email = params[2];
            String password = params[1];
            String data ="";
            int tmp;

            try{
                URL url = new URL()
            }

            return null;
        }
    }
}
