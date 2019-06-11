package com.example.lab5;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;


public class MainActivity extends AppCompatActivity {





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ac_main);


        if (getSupportFragmentManager().getFragments().size() == 0){
            addFragment(FragmentMain.newInstance());
        }






    }

    public void addFragment(Fragment fragment){
        getSupportFragmentManager().popBackStackImmediate(null,0);
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.container,fragment)
                .commit();
    }
}
