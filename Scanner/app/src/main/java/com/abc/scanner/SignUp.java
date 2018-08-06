package com.abc.scanner;

import android.annotation.SuppressLint;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class SignUp extends AppCompatActivity {

    EditText First_Name, Last_Name, email, password, passwordconfo;

    DBHelper myDB;

    Button signUpBut;


    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        myDB = new DBHelper(this);

        First_Name = findViewById(R.id.editFirstName);
        Last_Name = findViewById(R.id.editLastName);
        password = findViewById(R.id.editPassword);
        passwordconfo = findViewById(R.id.editConfirmPassword);
        email = findViewById(R.id.editEmail);

        signUpBut = findViewById(R.id.signUpBut);

        AddDataToDB();
    }

    /**
     * Method to add data to the database(also error checks password before sign up)
     */

    public void AddDataToDB(){

        signUpBut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(password.getText().toString().equals(passwordconfo.getText().toString()))
                {
                    try{

                        myDB.insertData(First_Name.getText().toString(),Last_Name.getText().toString(), email.getText().toString(), password.getText().toString());

                        Toast.makeText(SignUp.this,"Data inserted successfully",Toast.LENGTH_LONG).show();
                    }
                    catch (IllegalArgumentException e){

                        Toast.makeText(SignUp.this, "Error: Data not successfully inserted", Toast.LENGTH_LONG).show();
                    }
                }
                else{
                    Toast.makeText(SignUp.this, "Error: Passwords do not match", Toast.LENGTH_LONG).show();

                }
            }
        });
    }
}