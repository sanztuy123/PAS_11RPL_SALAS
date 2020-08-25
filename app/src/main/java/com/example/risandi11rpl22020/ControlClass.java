package com.example.risandi11rpl22020;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

public class ControlClass
{

    public class Controlclass extends AppCompatActivity {
        SharedPreferences sharedPreferences;
        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);

            sharedPreferences=getSharedPreferences("login", Context.MODE_PRIVATE);

            if (sharedPreferences.getString("nama","").isEmpty()){
                startActivity(new Intent(Controlclass.this,MainActivity.class));
                finish();
            }else{
                startActivity(new Intent(Controlclass.this,MenuActivity.class));
                finish();
            }
        }
    }
}
