package com.abc.scanner;

import android.Manifest;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.zxing.Result;

import me.dm7.barcodescanner.zxing.ZXingScannerView;

import static android.Manifest.permission.CAMERA;

public class HomeScreen extends AppCompatActivity {

    private Button loginButn, signUpButn;

    private EditText Email, Password;

    private TextView info;

    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_screen);

        loginButn=  findViewById(R.id.scannerButton);

        signUpButn = findViewById(R.id.signUpButton);


        loginButn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openScanner();
            }
        });

        signUpButn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openSignUp();
            }
        });

        Email = (EditText)findViewById(R.id.editEmail);

        Password = (EditText)findViewById(R.id.editPassword);

    }

    private void passwordCheck(String Email, String Password){

        //if()
    }

    public void openScanner(){

        Intent intent = new Intent(this, Scanner.class);
        startActivity(intent);
    }

    public void openSignUp(){

        Intent intent = new Intent( this, SignUp.class);
        startActivity(intent);
    }

}