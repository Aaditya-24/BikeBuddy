package com.example.bikebuddy;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class sign_in_page extends AppCompatActivity {

    Button btnjoinback,btnlogin;
    TextView descr, policy,want;
    private EditText em;
    private EditText pswd;

    private FirebaseAuth firebaseAuth;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in_page);

        descr = (TextView) findViewById(R.id.descrSignin);
        policy = (TextView) findViewById(R.id.policy);
        want = (TextView) findViewById(R.id.notmembertext);
        em = (EditText)findViewById(R.id.emailsignin);
        pswd = (EditText)findViewById(R.id.pswrdsignin);
        firebaseAuth = FirebaseAuth.getInstance();

    }
    public void btnUserLogin_Click(View view){

        //final ProgressDialog progressDialog = ProgressDialog.show(sign_in_page.this,"Please wait...", "Processing... ",true);

        btnlogin = (Button)findViewById(R.id.btnLoginsignin);

        (firebaseAuth.signInWithEmailAndPassword(em.getText().toString(),pswd.getText().toString()))
                .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        //progressDialog.dismiss();

                        if(task.isSuccessful()){
                            Toast.makeText(sign_in_page.this,"Login successful",Toast.LENGTH_SHORT).show();
                            Intent sint2 = new Intent(sign_in_page.this,Front_page.class);
                            sint2.putExtra("EMAIL", firebaseAuth.getCurrentUser().getEmail());
                            startActivity(sint2);
                        }
                        else {
                            Log.e("ERROR IN CREDENTIALS",task.getException().toString());
                            Toast.makeText(sign_in_page.this,task.getException().getMessage(),Toast.LENGTH_SHORT).show();

                        }
                    }
                });

    }



    public void btnJoinBackMethod(View view){

        btnjoinback = (Button)findViewById(R.id.btnJoinGoback);
        Intent sint1 = new Intent(sign_in_page.this, join_in_page1.class);
        startActivity(sint1);
    }
}
