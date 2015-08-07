package com.bnsgfxample.loadingfragmentsample.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.View;

import com.bnsgfxample.loadingfragmentsample.R;


public class MainActivity extends FragmentActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void jump1(View view) {
        my_startActivity(FragmentContentHidedActivity.class);
    }

    private void my_startActivity(Class<FragmentContentHidedActivity> fragmentContentHidedClass) {
        Intent i = new Intent(this, fragmentContentHidedClass);
        startActivity(i);
    }
}
