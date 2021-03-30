package com.example.libapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    DrawerLayout drawerLayout;
    private RecyclerView recyclerView;
    private ArrayList<Bookdata> bookdata;
    private BookAdapter bookAdapter;
    DatabaseReference dRef;
    private FirebaseAuth mAuth;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        drawerLayout = findViewById(R.id.drawer_layout);
        recyclerView = findViewById(R.id.booklist);
        bookdata = new ArrayList<Bookdata>();

        dRef = FirebaseDatabase.getInstance().getReference().child("Book Data");
        dRef.addListenerForSingleValueEvent(valueEventListener);

    }
    ValueEventListener valueEventListener = new ValueEventListener() {
        @Override
        public void onDataChange(@NonNull DataSnapshot snapshot) {
            for(DataSnapshot dataSnapshot1:snapshot.getChildren()){
                Bookdata bData = dataSnapshot1.getValue(Bookdata.class);
                bookdata.add(bData);
            }
            bookAdapter = new BookAdapter(MainActivity.this,bookdata);
            recyclerView.setAdapter(bookAdapter);
        }

        @Override
        public void onCancelled(@NonNull DatabaseError error) {

        }
    };









    public void ClickMenu (View view){
        openDrawer(drawerLayout);

    }
    public static void openDrawer(DrawerLayout drawerLayout){
        drawerLayout.openDrawer(GravityCompat.START);

    }
    public void ClickLogo (View view){
        closeDrawer(drawerLayout);
    }
    public static void closeDrawer(DrawerLayout drawerLayout){
        if (drawerLayout.isDrawerOpen((GravityCompat.START))) {

            drawerLayout.closeDrawer(GravityCompat.START);
        }
    }
    public void ClickHome(View view){
        recreate();
    }
    public void ClickProfile(View view){
        MainActivity.redirectActivity(this,Profile.class);
    }
    public void ClickDashboard(View view){
        redirectActivity(this,Dashboard.class);
    }
    public void ClickPrivacy(View view){
        redirectActivity(this,privacypolicy.class);
    }
    public void ClickEditProfile(View view){
        redirectActivity(this,genre.class);
    }


    public void ClickAboutUs (View view){
        redirectActivity(this,AboutUs.class);
    }
    public void ClickLogout(View view){
        logout(this);
    }
    public static void logout(final Activity activity){
        AlertDialog.Builder builder = new AlertDialog.Builder(activity);
        builder.setTitle("Logout");
        builder.setMessage("are you sure want to logout?");

        builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                activity.finishAffinity();
                System.exit(0);
            }
        });
        builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();

            }
        });
        builder.show();

    }
    public static void redirectActivity(Activity activity, Class aclass) {
        Intent intent = new Intent (activity,aclass);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        activity.startActivity(intent);

    }
    @Override
    protected void onPause() {
        super.onPause();
        closeDrawer(drawerLayout);
    }

}