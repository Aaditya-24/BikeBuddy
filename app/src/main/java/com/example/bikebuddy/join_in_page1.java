package com.example.bikebuddy;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class join_in_page1 extends AppCompatActivity  {

    private EditText editTextName, editTextEmail, editTextPassword, editTextPhone;
    Button registerbutton;

    private FirebaseAuth mAuth;

    private DatabaseReference mDatabaseUser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_join_in_page1);

        editTextName = findViewById(R.id.name);
        editTextEmail = findViewById(R.id.email);
        editTextPassword = findViewById(R.id.password);
        editTextPhone = findViewById(R.id.phone);


        mAuth = FirebaseAuth.getInstance();

        mDatabaseUser = FirebaseDatabase.getInstance().getReference("Users");

        registerbutton = (Button)findViewById(R.id.btnRegister);
        registerbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                final String emailR = editTextEmail.getText().toString().trim();
                final String passwordR = editTextPassword.getText().toString().trim();


                if (emailR.isEmpty()) {
                    editTextEmail.setError(getString(R.string.input_error_email));
                    editTextEmail.requestFocus();
                    return;
                }

                if (!Patterns.EMAIL_ADDRESS.matcher(emailR).matches()) {
                    editTextEmail.setError(getString(R.string.input_error_email_invalid));
                    editTextEmail.requestFocus();
                    return;
                }

                if (passwordR.isEmpty()) {
                    editTextPassword.setError(getString(R.string.input_error_password));
                    editTextPassword.requestFocus();
                    return;
                }

                if (passwordR.length() < 6) {
                    editTextPassword.setError(getString(R.string.input_error_password_length));
                    editTextPassword.requestFocus();
                    return;
                }


                mAuth.createUserWithEmailAndPassword(emailR, passwordR)
                        .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {

                                if (task.isSuccessful()) {

                                    final String nameR = editTextName.getText().toString().trim();
                                    final String phoneR = editTextPhone.getText().toString().trim();

                                    if (nameR.isEmpty()) {
                                        editTextName.setError(getString(R.string.input_error_name));
                                        editTextName.requestFocus();
                                        return;
                                    }

                                    if (phoneR.isEmpty()) {
                                        editTextPhone.setError(getString(R.string.input_error_phone));
                                        editTextPhone.requestFocus();
                                        return;
                                    }

                                    if (phoneR.length() != 10) {
                                        editTextPhone.setError(getString(R.string.input_error_phone_invalid));
                                        editTextPhone.requestFocus();
                                        return;
                                    }


                                    String id = mDatabaseUser.push().getKey();

                                    User user = new User(nameR,emailR,passwordR,phoneR);

                                    mDatabaseUser.child(id).setValue(user);

                                    Toast.makeText(join_in_page1.this, getString(R.string.registration_success), Toast.LENGTH_LONG).show();
                                    Intent int1 = new Intent(join_in_page1.this,Front_page.class);
                                    startActivity(int1);

                                }else {
                                    Toast.makeText(join_in_page1.this, task.getException().getMessage(), Toast.LENGTH_LONG).show();
                                }
                            }
                        });

            }
        });

    }

}


















