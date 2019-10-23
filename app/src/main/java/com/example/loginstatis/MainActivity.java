package com.example.loginstatis;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText username,password;
    private Button mLogin;
    private String NIM = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        username = (EditText) findViewById(R.id.nim);
        password = (EditText) findViewById(R.id.pass);
        mLogin = (Button) findViewById(R.id.login);

        mLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String usernameKey = username.getText().toString();
                String passwordKey = password.getText().toString();

                if (usernameKey.equals("1167050058") && passwordKey.equals("12345")){
                    //jika login berhasil
                    Toast.makeText(getApplicationContext(), "Selamat Datang Fahni", Toast.LENGTH_LONG).show();
                    Intent intent = new Intent(getApplicationContext(), Tampilan.class);
                    intent.putExtra(NIM,usernameKey);
                    startActivity(intent);
                    overridePendingTransition(R.anim.goup,R.anim.godown);
                    finish();
                }
                else if (usernameKey.equals("1167050067") && passwordKey.equals("12345")){
                    //jika login berhasil
                    Toast.makeText(getApplicationContext(), "Selamat Datang Febby", Toast.LENGTH_LONG).show();
                    Intent intent = new Intent(getApplicationContext(), Tampilan.class);
                    intent.putExtra(NIM,usernameKey);
                    startActivity(intent);
                    overridePendingTransition(R.anim.goup,R.anim.godown);
                    finish();
                }
                else {
                    //jika login gagal
                    AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                    builder.setMessage("NIM atau Password Anda salah!").setNegativeButton("Retry", null).create().show();
                }
            }
        });
    }
}
