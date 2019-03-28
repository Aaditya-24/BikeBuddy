package com.example.bikebuddy;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Admin extends AppCompatActivity {

    private EditText adminEmail;
    private EditText adminPassword;
    private Button adminAccess;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin);

     adminEmail = (EditText)findViewById(R.id.editAdminTextEmail);
     adminPassword = (EditText)findViewById(R.id.editAdminTextPassword);



    }
    public void AdminAccessF(View view){

        String Aemail = adminEmail.getText().toString();
        String Apassword = adminPassword.getText().toString();

        adminAccess = (Button)findViewById(R.id.admin);


        if(( Aemail.equals("aditya@gmail.com")||Apassword.equals("123456"))){

            adminEmail.setText("");
            adminPassword.setText("");

            Intent intentAd = new Intent(Admin.this,AdminSide.class);
            startActivity(intentAd);
        }
        else {
            Toast.makeText(Admin.this,"WRONG CREDENTIALS",Toast.LENGTH_SHORT).show();
        }
    }
}
