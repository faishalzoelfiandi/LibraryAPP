package com.example.libapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Dashboard extends AppCompatActivity implements View.OnClickListener  {
    DrawerLayout drawerLayout;
    private EditText judul,halaman,publisher,penulis;

    private Button simpanbuku;
    private FirebaseAuth mAuth;
    private DatabaseReference mDatabase;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);
        drawerLayout = findViewById(R.id.drawer_layout);
        simpanbuku = (Button) findViewById(R.id.btnsimpanbuku);
        simpanbuku.setOnClickListener(this);

        mDatabase = FirebaseDatabase.getInstance().getReference().child("Book data");

        judul = (EditText)findViewById(R.id.editjudul);
        halaman = (EditText) findViewById(R.id.edithalaman);
        publisher = (EditText) findViewById(R.id.editpublisher);
        penulis = (EditText) findViewById(R.id.editPenulis);


        simpanbuku.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String judulbuku,halamanbuku,publisherbuku,penulisbuku,bukuid;

                bukuid = mDatabase.push().getKey();
                judulbuku = judul.getText().toString();
                halamanbuku = halaman.getText().toString();
                publisherbuku = publisher.getText().toString();
                penulisbuku = penulis.getText().toString();

                if (judulbuku.equals(" ")){
                    Toast.makeText(Dashboard.this,"Judul buku required",Toast.LENGTH_SHORT).show();
                }
                else if (halamanbuku.isEmpty()){
                    Toast.makeText(Dashboard.this,"halaman buku required",Toast.LENGTH_SHORT).show();
                }
                else if (penulisbuku.isEmpty()){
                    Toast.makeText(Dashboard.this,"penulis buku required",Toast.LENGTH_SHORT).show();
                }
                else if (publisherbuku.isEmpty()){
                    Toast.makeText(Dashboard.this,"Publisher buku required",Toast.LENGTH_SHORT).show();
                }
                 else {
                     Bookdata bookdata = new Bookdata(bukuid,judulbuku,penulisbuku,publisherbuku,halamanbuku);
                     mDatabase.child(bukuid).setValue(bookdata);
                     Toast.makeText(Dashboard.this,"Data sukses",Toast.LENGTH_SHORT).show();

                }
            }
        });

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


    @Override
    public void onClick(View view) {

    }
}