package com.bnsgfxample.loadingfragmentsample.activities;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;

import com.bnsgfxample.loadingfragmentsample.activities.fragments.ImageFragment;
import com.bnsgfxample.loadingfragmentsample.R;

public class FragmentContentHidedActivity extends FragmentActivity {

    FrameLayout frameLayout;
    LinearLayout lny;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragment_content_hided);

// init views
        initViews ();
        // request full view.

// put the image fragment inside the frame layout
        ImageFragment frg = new ImageFragment();
        FragmentManager trans = getSupportFragmentManager();
        android.support.v4.app.FragmentTransaction fragmentTransaction = trans.beginTransaction();
        fragmentTransaction.add(R.id.frame_layout, frg, "image_fragment");
        fragmentTransaction.show(frg);
        fragmentTransaction.commit();


    new android.os.Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
// make the linear layout invisible
                lny.setVisibility(View.GONE);
                // show the framelayout
                frameLayout.setVisibility(View.VISIBLE);
            }
        }, 5000);
//        lny.setV/sibility(View.GONE);
//        frameLayout.setVisibility(View.VISIBLE);
    }

    private void initViews() {
        lny = (LinearLayout) findViewById(R.id.linear_layout);
        frameLayout = (FrameLayout) findViewById(R.id.frame_layout);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_fragment_content_hided, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
