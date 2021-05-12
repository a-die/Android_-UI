package com.hnucm.c201901020241;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {
    HomeFragment homeFragment=new HomeFragment();
    MessageFragment messageFragment=new MessageFragment();
    BuyFragment buyFragment=new BuyFragment();
    MyFragment myFragment=new MyFragment();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ConstraintLayout constraintLayout_home = findViewById(R.id.constraintLayout2);
        ConstraintLayout constraintLayout_message = findViewById(R.id.constraintLayout5);
        ConstraintLayout constraintLayout_buy = findViewById(R.id.constraintLayout);
        ConstraintLayout constraintLayout_my = findViewById(R.id.constraintLayout3);
        constraintLayout_home.setSelected(true);
        constraintLayout_message.setSelected(false);
        constraintLayout_buy.setSelected(false);
        constraintLayout_my.setSelected(false);
        getSupportFragmentManager().beginTransaction().add(R.id.fragment,homeFragment).commit();
        getSupportFragmentManager().beginTransaction().add(R.id.fragment,messageFragment).commit();
        getSupportFragmentManager().beginTransaction().add(R.id.fragment,buyFragment).commit();
        getSupportFragmentManager().beginTransaction().add(R.id.fragment,myFragment).commit();
        getSupportFragmentManager().beginTransaction().show(homeFragment).commit();
        getSupportFragmentManager().beginTransaction().hide(messageFragment).commit();
        getSupportFragmentManager().beginTransaction().hide(buyFragment).commit();
        getSupportFragmentManager().beginTransaction().hide(myFragment).commit();
        constraintLayout_home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getSupportFragmentManager().beginTransaction().show(homeFragment).commit();
                getSupportFragmentManager().beginTransaction().hide(messageFragment).commit();
                getSupportFragmentManager().beginTransaction().hide(buyFragment).commit();
                getSupportFragmentManager().beginTransaction().hide(myFragment).commit();
                constraintLayout_home.setSelected(true);
                constraintLayout_message.setSelected(false);
                constraintLayout_buy.setSelected(false);
                constraintLayout_my.setSelected(false);
            }
        });
        constraintLayout_message.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getSupportFragmentManager().beginTransaction().hide(homeFragment).commit();
                getSupportFragmentManager().beginTransaction().show(messageFragment).commit();
                getSupportFragmentManager().beginTransaction().hide(buyFragment).commit();
                getSupportFragmentManager().beginTransaction().hide(myFragment).commit();
                constraintLayout_home.setSelected(false);
                constraintLayout_message.setSelected(true);
                constraintLayout_buy.setSelected(false);
                constraintLayout_my.setSelected(false);
            }
        });
        constraintLayout_buy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getSupportFragmentManager().beginTransaction().hide(homeFragment).commit();
                getSupportFragmentManager().beginTransaction().hide(messageFragment).commit();
                getSupportFragmentManager().beginTransaction().show(buyFragment).commit();
                getSupportFragmentManager().beginTransaction().hide(myFragment).commit();
                constraintLayout_home.setSelected(false);
                constraintLayout_message.setSelected(false);
                constraintLayout_buy.setSelected(true);
                constraintLayout_my.setSelected(false);
            }
        });
        constraintLayout_my.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getSupportFragmentManager().beginTransaction().hide(homeFragment).commit();
                getSupportFragmentManager().beginTransaction().hide(messageFragment).commit();
                getSupportFragmentManager().beginTransaction().hide(buyFragment).commit();
                getSupportFragmentManager().beginTransaction().show(myFragment).commit();
                constraintLayout_home.setSelected(false);
                constraintLayout_message.setSelected(false);
                constraintLayout_buy.setSelected(false);
                constraintLayout_my.setSelected(true);
            }
        });
    }
}