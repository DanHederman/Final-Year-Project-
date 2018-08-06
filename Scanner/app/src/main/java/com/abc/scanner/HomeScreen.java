package com.abc.scanner;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class HomeScreen extends AppCompatActivity {

    DBHelper myDb;


    /**
     * Creates all the buttons and instanciates them
     * @param savedInstanceState resumes the instance
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_screen);

        Button loginButn = findViewById(R.id.scannerButton);

        Button signUpButn = findViewById(R.id.signUpButton);

        Button showButn = findViewById(R.id.viewButn);

        showButn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Cursor res;
                res = myDb.getAllData();
                if (res.getCount() == 0){

                    showMessage("Error:", " no data in database");
                    return;
                }

                StringBuilder buffer = new StringBuilder();

                while(res.moveToNext()){

                    buffer.append("First_Name ").append(res.getString(0)).append("\n");
                    buffer.append("Last_Name ").append(res.getString(1)).append("\n");
                    buffer.append("Email ").append(res.getString(2)).append("\n");
                    buffer.append("Password ").append(res.getString(3)).append("\n");

                    showMessage("Data: ", buffer.toString());
                }
            }
        });


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

        myDb = new DBHelper(this);
        //viewAll();
    }

    /**
     * Method to display AlertMessages to the user
     * @param Title To display message type
     * @param Message To display the actual message
     */

    public void showMessage(String Title, String Message){

        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setCancelable(true);
        builder.setTitle(Title);
        builder.setMessage(Message);
        builder.show();
    }

    /**
     * Opens the scanner
     */

    public void openScanner(){

        Intent intent = new Intent(this, Scanner.class);
        startActivity(intent);
    }

    /**
     * Opens the sign up page
     */

    public void openSignUp(){

        Intent intent = new Intent( this, SignUp.class);
        startActivity(intent);
    }
}