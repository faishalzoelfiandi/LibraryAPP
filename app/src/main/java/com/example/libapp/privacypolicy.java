package com.example.libapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;

import android.os.Bundle;
import android.view.View;

public class privacypolicy extends AppCompatActivity {
    DrawerLayout drawerLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_privacypolicy);
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