package com.example.loginstatis;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ActivityOptions;
import android.content.ActivityNotFoundException;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.view.View;

public class Tampilan extends AppCompatActivity {

    private String NIM = "";
    private String usernameKey;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tampilan);
    }

    public void openCompany(View view){
        Bundle extras = getIntent().getExtras();
        usernameKey = extras.getString(NIM);
        if (usernameKey.equals("1167050058")){
            Intent i = new Intent(Tampilan.this,Rog.class);
            if(Build.VERSION.SDK_INT>20){
                ActivityOptions options = ActivityOptions.makeSceneTransitionAnimation(Tampilan.this);
                startActivity(i,options.toBundle());
            }else {
                startActivity(i);
            }
        }
        else if (usernameKey.equals("1167050067")){
            Intent i = new Intent(Tampilan.this,Balarea.class);
            if(Build.VERSION.SDK_INT>20){
                ActivityOptions options = ActivityOptions.makeSceneTransitionAnimation(Tampilan.this);
                startActivity(i,options.toBundle());
            }else {
                startActivity(i);
            }
        }
    }

    //OPEN ISNSTAGRAM SESUAI USERNAME
    public void openInstagram(View view) {
        Bundle extras = getIntent().getExtras();
        usernameKey = extras.getString(NIM);
        if (usernameKey.equals("1167050058")){
            Uri uri = Uri.parse("https://instagram.com/have_fahn");
            Intent i = new Intent(Intent.ACTION_VIEW, uri);

            i.setPackage("com.instagram.android");

            try {
                startActivity(i);
                overridePendingTransition(R.anim.goup,R.anim.godown);
            }
            catch (ActivityNotFoundException e) {
                startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://instagram.com/have_fahn")));
            }
        }
        else if (usernameKey.equals("1167050067")){
            Uri uri = Uri.parse("https://www.instagram.com/febbyai_");
            Intent i = new Intent(Intent.ACTION_VIEW, uri);

            i.setPackage("com.instagram.android");

            try {
                startActivity(i);
                overridePendingTransition(R.anim.goup,R.anim.godown);
            }
            catch (ActivityNotFoundException e) {
                startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.instagram.com/febbyai_")));
            }
        }
    }

    @Override
    public void onBackPressed() {
        new AlertDialog.Builder(this)
                .setIcon(android.R.drawable.ic_dialog_alert)
                .setTitle("Keluar Aplikasi")
                .setMessage("Yakin ingin mengakhiri aplikasi?")
                .setPositiveButton("Ya", new DialogInterface.OnClickListener()
                {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        finish();
                    }

                })
                .setNegativeButton("Tidak", null)
                .show();
    }
}