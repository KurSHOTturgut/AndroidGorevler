package com.example.hamburgermymebu;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.provider.Settings;
import android.view.Menu;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    DrawerLayout drawerLayout;
    public Button btn_Kayıt;
    public Button btn_ac;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        drawerLayout= findViewById(R.id.drawle_layout);




        btn_Kayıt=findViewById(R.id.gitbuttonu);
        btn_Kayıt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent kayit= new Intent(MainActivity.this,Dashboard.class);
                startActivity(kayit);
            }
        });

        btn_ac=findViewById(R.id.button);
        btn_ac.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent git=new Intent(MainActivity.this, Menulerimm.class);
                startActivity(git);
            }
        });

    }

    public void ClickMenu(View view){
        openDrawer(drawerLayout);

    }

    public static void openDrawer(DrawerLayout drawerLayout) {
        drawerLayout.openDrawer(GravityCompat.START);

    }

    public void ClickLogo(View view){
        closeDrawer(drawerLayout);

    }

    public static void closeDrawer(DrawerLayout drawerLayout) {


        if (drawerLayout.isDrawerOpen(GravityCompat.START)){
            drawerLayout.closeDrawer(GravityCompat.START);

        }
    }

    public  void ClickHome(View view){
        recreate();
    }
    public void ClickDashboard(View view){
        redirectActivity( this,Dashboard.class);
    }
    public void ClickAboutUs(View view){
        redirectActivity(this,AboutUs.class);
    }

    public void ClickLogout(View view){
        logout(this);
    }

    public static void logout( final Activity activity) {
        AlertDialog.Builder builder = new AlertDialog.Builder(activity);

        builder.setTitle("Logout");

        builder.setMessage(" are you sure you want to logout ?");

        builder.setPositiveButton("YES", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                activity.finishAffinity();
                System.exit(0);
            }
        });

        builder.setNegativeButton("NO", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });
        builder.show();


    }

    public static void redirectActivity(Activity activity,Class aClass) {
        Intent intent= new Intent(activity,aClass);
         intent.setFlags(Intent.FLAG_ACTIVITY_NEW_DOCUMENT);
         activity.startActivity(intent);

    }

    @Override
    protected void onPause() {
        super.onPause();
        closeDrawer(drawerLayout);

    }
}