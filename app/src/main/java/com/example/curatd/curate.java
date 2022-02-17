package com.example.curatd;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;

import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class curate extends AppCompatActivity implements BottomNavigationView.OnNavigationItemSelectedListener{

    BottomNavigationView bottomNavigationView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.curate);
        bottomNavigationView=(BottomNavigationView)findViewById(R.id.bot_nav);
        FragmentManager fragmentManager=getSupportFragmentManager();
        fragmentManager.beginTransaction().replace(R.id.switch_fragments,new feeds()).commit();
        bottomNavigationView.setOnNavigationItemSelectedListener(this);
        bottomNavigationView.setSelectedItemId(R.id.feeds);


    }


    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.feeds:
                getSupportFragmentManager().beginTransaction().replace(R.id.switch_fragments,new feeds()).commit();
                return true;

            case R.id.add:
                getSupportFragmentManager().beginTransaction().replace(R.id.switch_fragments,new reccomended_list()).commit();
                return true;

            case R.id.profile:
                getSupportFragmentManager().beginTransaction().replace(R.id.switch_fragments,new profile()).commit();
                return true;
        }
        return false;
    }
}