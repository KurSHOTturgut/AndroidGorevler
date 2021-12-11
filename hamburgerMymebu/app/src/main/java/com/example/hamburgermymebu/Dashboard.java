package com.example.hamburgermymebu;

import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Dashboard extends AppCompatActivity {

    DrawerLayout drawerLayout;
    public Button geributon;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);


        geributon=findViewById(R.id.gitbuttonu);
        geributon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent kayit= new Intent(Dashboard.this,MainActivity.class);
                startActivity(kayit);
            }
        });


        drawerLayout=findViewById(R.id.drawle_layout);

    }

    public void ClickMenu(View view){
        MainActivity.openDrawer(drawerLayout);

    }
    public void ClickLogo(View view){
        MainActivity.closeDrawer(drawerLayout);
    }
    public void ClickHome(View view){
        MainActivity.redirectActivity(this,MainActivity.class);
    }
    public void ClickDashboard(View view){
        recreate();
    }
    public  void ClickAboutUs(View view){
        MainActivity.redirectActivity(this,AboutUs.class);
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