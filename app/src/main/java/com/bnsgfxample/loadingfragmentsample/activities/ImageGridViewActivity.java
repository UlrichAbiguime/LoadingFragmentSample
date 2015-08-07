package com.bnsgfxample.loadingfragmentsample.activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.StringRequest;
import com.bnsgfxample.loadingfragmentsample.R;
import com.bnsgfxample.loadingfragmentsample.activities.adapterz.GridViewAdapter;
import com.bnsgfxample.loadingfragmentsample.activities.beanz.ResearchResultBeanz;
import com.bnsgfxample.loadingfragmentsample.activities.interfaces.VolleyRequestOnResultListener;
import com.bnsgfxample.loadingfragmentsample.activities.on3.MyBoruto;
import com.bnsgfxample.loadingfragmentsample.activities.utils.MaVolleyRequest;
import com.bnsgfxample.loadingfragmentsample.activities.utils.Utils;
import com.etsy.android.grid.StaggeredGridView;
import com.google.gson.Gson;
import com.google.gson.JsonObject;

import org.json.JSONArray;

import butterknife.Bind;
import butterknife.ButterKnife;

public class ImageGridViewActivity extends AppCompatActivity {

    @Bind(R.id.grid_view)
    StaggeredGridView gridView;

    // variables
    private String link = "https://api.imgur.com/3/gallery/t/gaming/1";


    // viewz
    GridViewAdapter adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image_grid_view);
        ButterKnife.bind(this);
        // support actionbarmaterial on old versions of android.
        // init adapters.
        gridView.setAdapter(adapter);
        MaVolleyRequest.getInstance(getApplicationContext()).GetMethodRequest(link, null, new VolleyRequestOnResultListener() {
            @Override
            public void onSucces(String result) {
                Log.d("qwerty", result);
                ResearchResultBeanz item = (new Gson()).fromJson((new Gson()).fromJson(result, JsonObject.class).getAsJsonObject("data"), ResearchResultBeanz.class);
//                makeToast(item.toString());
                adapter = new GridViewAdapter(ImageGridViewActivity.this, Utils.fromArrayToList(item.items));
                gridView.setAdapter(adapter);
            }

            @Override
            public void onFailure(String error) {
                Log.d("qwerty", error);
            }
        });
    }

    private void makeToast(String s) {
        Toast.makeText(ImageGridViewActivity.this, s, Toast.LENGTH_SHORT).show();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_image_grid_view, menu);
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
