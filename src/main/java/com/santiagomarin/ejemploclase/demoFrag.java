package com.santiagomarin.ejemploclase;

import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

public class demoFrag extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_demo_frag);

        FragmentManager fm =getSupportFragmentManager();
        FragmentTransaction ft= fm.beginTransaction();

        primerFragment fragment =new primerFragment();
        ft.add(android.R.id.content, fragment).commit();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu2,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id=item.getItemId();

        FragmentManager fm =getSupportFragmentManager();
        FragmentTransaction ft= fm.beginTransaction();

        switch (id)
        {
            case R.id.fragm1:
                primerFragment fragment =new primerFragment();
                ft.replace(android.R.id.content, fragment).commit();
                break;
            case R.id.fragm2:
                segundoFragment fragment2 = new segundoFragment();
                ft.replace(android.R.id.content, fragment2).commit();
        }
        return super.onOptionsItemSelected(item);
    }
}
