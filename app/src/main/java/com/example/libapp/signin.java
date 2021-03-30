package com.example.libapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class signin extends AppCompatActivity implements View.OnClickListener {
    private EditText editemail,editpass;
    private TextView email,password,signup;
    private Button SignIN;

    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signin);
        mAuth = FirebaseAuth.getInstance();

        signup = (TextView) findViewById(R.id.signup);
        signup.setOnClickListener(this);

        SignIN = (Button) findViewById(R.id.btnsignin);
        SignIN.setOnClickListener(this);

        editemail = (EditText)findViewById(R.id.editemail);
        editpass = (EditText) findViewById(R.id.editpass);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.signup:
                startActivity(new Intent(this,signup.class));
                break;
            case R.id.btnsignin :
                userLogin();
                break;
        }
    }

    private void userLogin() {
        String email =  editemail.getText().toString().trim();
        String password = editpass.getText().toString().trim();

        if(email.isEmpty()){
            editemail.setError("Full name harus di isi");
            editpass.requestFocus();
            return;
        }

        if(!Patterns.EMAIL_ADDRESS.matcher(email).matches()){
            editemail.setError("Please provide valid email address");
            editemail.requestFocus();
            return;
        }

        if(password.isEmpty()){
            editemail.setError("Full name harus di isi");
            editpass.requestFocus();
            return;
        }

        if(password.length() < 6){
            editemail.setError("Password at least has 6 char");
            editpass.requestFocus();
            return;
        }

        mAuth.signInWithEmailAndPassword(email , password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (task.isSuccessful()) {
                    FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();

                    if (user.isEmailVerified()) {

                        startActivity(new Intent(signin.this , MainActivity.class));
                    } else {
                        user.sendEmailVerification();
                        Toast.makeText(signin.this , "Check Your Email To Verify Your Account" , Toast.LENGTH_LONG).show();
                    }

                } else {
                    Toast.makeText(signin.this , "Failed To Login! Try Again!" , Toast.LENGTH_LONG).show();
                }
            }
        });

    }
}