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
import com.google.firebase.database.FirebaseDatabase;

import java.util.regex.Pattern;

public class signup extends AppCompatActivity implements View.OnClickListener {
    private EditText editemail,editpass,editfullname,editusername;
    private TextView email,password,fullname,username,signup,btnsignup;
    private FirebaseAuth mAuth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        mAuth = FirebaseAuth.getInstance();

        signup = (TextView)findViewById(R.id.signup);
        signup.setOnClickListener(this);

        btnsignup = (Button) findViewById(R.id.btnsignup);
        btnsignup.setOnClickListener(this);

        editemail = (EditText)findViewById(R.id.editemail);
        editpass = (EditText) findViewById(R.id.editpass);
        editfullname = (EditText) findViewById(R.id.editfullname);
        editusername = (EditText) findViewById(R.id.editusername);

    }
    
    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.signup:
                startActivity(new Intent(this,MainActivity.class));
                break;
            case R.id.btnsignup :
                btnsignup();
                break;
        }
    }

    private void btnsignup() {
        final String email =  editemail.getText().toString().trim();
        String password = editpass.getText().toString().trim();
        final String fullname = editfullname.getText().toString().trim();
        final String username = editusername.getText().toString().trim();

        if(fullname.isEmpty()){
            editfullname.setError("Full name harus di isi");
            editfullname.requestFocus();
            return;
        }

        if(email.isEmpty()){
            editemail.setError("Full name harus di isi");
            editemail.requestFocus();
            return;
        }

        if(!Patterns.EMAIL_ADDRESS.matcher(email).matches()){
            editemail.setError("Please provide valid email address");
            editemail.requestFocus();
            return;
        }

        if(password.isEmpty()){
            editpass.setError("Full name harus di isi");
            editpass.requestFocus();
            return;
        }

        if(password.length() < 6){
            editpass.setError("Password at least has 6 char");
            editpass.requestFocus();
            return;
        }

        if(username.isEmpty()){
            editusername.setError("Full name harus di isi");
            editusername.requestFocus();
            return;
        }

        mAuth.createUserWithEmailAndPassword(email,password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            User user = new User (fullname,email,username);
                            FirebaseDatabase.getInstance().getReference("User")
                                    .child(FirebaseAuth.getInstance().getCurrentUser().getUid())
                                    .setValue(user).addOnCompleteListener(new OnCompleteListener<Void>() {
                                @Override
                                public void onComplete(@NonNull Task<Void> task) {
                                    if(task.isSuccessful()) {
                                        Toast.makeText(signup.this , "User Has Been Successfully!" , Toast.LENGTH_LONG).show();
                                    } else {
                                        Toast.makeText(signup.this , "Failed To Registered! Try Again!" , Toast.LENGTH_LONG).show();
                                    }
                                }
                            });
                        } else {
                            Toast.makeText(signup.this , "Failed To Registered!" , Toast.LENGTH_LONG).show();
                        }
                    }
                });

    }
}