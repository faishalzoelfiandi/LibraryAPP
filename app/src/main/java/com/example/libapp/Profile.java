package com.example.libapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class Profile extends AppCompatActivity {

    DrawerLayout drawerLayout;
    private Button editprofile;
    private TextView namatext,surnametext,fullnametext,emailtext;
    private FirebaseDatabase database;
    private DatabaseReference mDatabase;
    private String email;
    private String userid;

    private FirebaseAuth mAuth;
    String Email;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        drawerLayout = findViewById(R.id.drawer_layout);




    }
    public  void ClickMenu (View view){
        MainActivity.openDrawer(drawerLayout);

    }
    public void ClickLogo(View view){
        MainActivity.closeDrawer(drawerLayout);

    }
    public void ClickHome(View view){
        MainActivity.redirectActivity(this,MainActivity.class);
    }
    public void ClickProfile(View view){
        MainActivity.redirectActivity(this,Profile.class);
    }
    public void ClickEditProfile (View view){
        MainActivity.redirectActivity(this,edit_profile.class);
    }
    public void ClickDashboard(View view){
        recreate();
    }
    public void ClickAboutUs (View view){
        MainActivity.redirectActivity(this,AboutUs.class);
    }
    public void ClickPrivacy (View view){
        MainActivity.redirectActivity(this,privacypolicy.class);
    }
    public void ClickLogout(View view){
        MainActivity.logout(this);
    }

    @Override
    protected void onPause() {
        super.onPause();
        MainActivity.closeDrawer(drawerLayout);
    }


}