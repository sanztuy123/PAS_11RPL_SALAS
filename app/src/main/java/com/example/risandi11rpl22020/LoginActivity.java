package com.example.risandi11rpl22020;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {
    SharedPreferences pref;
    SharedPreferences.Editor editor;
    Button btnSignUp, btnLogin;
    EditText txtusername, txtpassword;
    TextView tvforgot;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        pref = getSharedPreferences("dataLogin",MODE_PRIVATE);
        SharedPreferences getUser = getSharedPreferences("login",MODE_PRIVATE);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        tvforgot = findViewById(R.id.tvForgot);
        txtusername = findViewById(R.id.txtUsrname);
        txtpassword = findViewById(R.id.txtpass);
        btnSignUp = findViewById(R.id.btnSignUp);
        btnLogin = findViewById(R.id.btnLogin);

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editor =pref.edit();
                editor.putString("user",txtusername.getText().toString());
                editor.apply();
                if (txtusername.getText().toString().equalsIgnoreCase("salas") && txtpassword.getText().toString().equals("salas")){
                    Intent in = new Intent(LoginActivity.this,MainMenuActivity.class);
                    Toast.makeText(LoginActivity.this, "Welcome salas", Toast.LENGTH_SHORT).show();
                    startActivity(in);
                    finish();
                }else if(txtusername.getText().toString().isEmpty() && txtpassword.getText().toString().isEmpty()){
                    Toast.makeText(LoginActivity.this, "Data belum diisi", Toast.LENGTH_SHORT).show();
                }else {
                    Toast.makeText(LoginActivity.this, "Cek username / password", Toast.LENGTH_SHORT).show();
                }
            }
        });


        btnSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in = new Intent(LoginActivity.this, RegistrationActivity.class);
                startActivity(in);
                finish();
            }
        });

        tvforgot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(LoginActivity.this, "Default username & password = salas", Toast.LENGTH_SHORT).show();
            }
        });

    }


}
