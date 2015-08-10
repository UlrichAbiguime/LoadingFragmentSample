package com.bnsgfxample.loadingfragmentsample.activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.AbsListView;
import android.widget.Toast;

import com.bnsgfxample.loadingfragmentsample.R;
import com.bnsgfxample.loadingfragmentsample.activities.adapterz.GridViewAdapter;
import com.bnsgfxample.loadingfragmentsample.activities.adapterz.GridViewAdapter2;
import com.bnsgfxample.loadingfragmentsample.activities.beanz.ResearchResultBeanz;
import com.bnsgfxample.loadingfragmentsample.activities.interfaces.VolleyRequestOnResultListener;
import com.bnsgfxample.loadingfragmentsample.activities.utils.MaVolleyRequest;
import com.bnsgfxample.loadingfragmentsample.activities.utils.Utils;
import com.etsy.android.grid.StaggeredGridView;
import com.google.gson.Gson;
import com.google.gson.JsonObject;

import butterknife.Bind;
import butterknife.ButterKnife;

public class ImageGridViewActivity extends AppCompatActivity implements AbsListView.OnScrollListener{

    @Bind(R.id.grid_view)
    StaggeredGridView gridView;

    private int PAGE_NUM = 1;
    // variables
    private String link = "https://api.imgur.com/3/gallery/t/game/";

    // viewz
    GridViewAdapter2 adapter;
    private boolean flag_loading = false;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image_grid_view);
        ButterKnife.bind(this);
        // setting gridview footer.
        gridView.addFooterView(LayoutInflater.from(this).inflate(R.layout.gridview_footer, null));
        // support actionbarmaterial on old versions of android.
        // init adapters.
        gridView.setOnScrollListener(this);
        MaVolleyRequest.getInstance(getApplicationContext()).GetMethodRequest(getLink(), null, new VolleyRequestOnResultListener() {
            @Override
            public void onSucces(String result) {
                Log.d("qwerty", result);
                ResearchResultBeanz item = (new Gson()).fromJson((new Gson()).fromJson(result, JsonObject.class).getAsJsonObject("data"), ResearchResultBeanz.class);
//                makeToast(item.toString());
                adapter = new GridViewAdapter2(ImageGridViewActivity.this, Utils.fromArrayToList(item.items));
                gridView.setAdapter(adapter);
            }

            @Override
            public void onFailure(String error) {
                Log.d("qwerty", error);
            }
        });
    }

    private String getLink() {
        return link+PAGE_NUM;
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


    public void onScrollStateChanged(AbsListView view, int scrollState) {

    }

    public void onScroll(AbsListView view, int firstVisibleItem,
                         int visibleItemCount, int totalItemCount) {

        if(firstVisibleItem+visibleItemCount == totalItemCount && totalItemCount!=0)
        {
            if(flag_loading == false)
            {
                flag_loading = true;
                PAGE_NUM++;
                gridView.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        additems();
                    }
                }, 100);
            }
        }
    }

    private void additems() {
        // load more data to the item
        MaVolleyRequest.getInstance(getApplicationContext()).GetMethodRequest(getLink(), null, new VolleyRequestOnResultListener() {
            @Override
            public void onSucces(String result) {
                Log.d("qwerty", getLink());
                ResearchResultBeanz item = (new Gson()).fromJson((new Gson()).fromJson(result, JsonObject.class).getAsJsonObject("data"), ResearchResultBeanz.class);
                if (adapter == null) {
                    adapter = new GridViewAdapter2(ImageGridViewActivity.this, Utils.fromArrayToList(item.items));
                    gridView.setAdapter(adapter);
                } else {
                    adapter.appendData (Utils.fromArrayToList(item.items));
                }
                flag_loading = false;
            }
            @Override
            public void onFailure(String error) {
                makeToast("Loading failure");
                flag_loading = false;
            }
        });
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        MaVolleyRequest.getInstance(getApplication()).
                killAllRequest(ImageGridViewActivity.class.toString());
    }
}
