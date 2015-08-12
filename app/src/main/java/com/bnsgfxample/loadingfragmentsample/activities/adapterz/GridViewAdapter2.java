package com.bnsgfxample.loadingfragmentsample.activities.adapterz;

import android.app.ActionBar;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.bnsgfxample.loadingfragmentsample.R;
import com.bnsgfxample.loadingfragmentsample.activities.Constants;
import com.bnsgfxample.loadingfragmentsample.activities.beanz.ResearchResultBeanz;
import com.etsy.android.grid.util.DynamicHeightImageView;
import com.squareup.picasso.Picasso;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by UlrichAbiguime at Shenzhen.
 */
public class GridViewAdapter2 extends BaseAdapter {


    static Context mCtx;
    List<ResearchResultBeanz.PictureItem> data;
    LayoutInflater inf;

    public GridViewAdapter2(Context ctx, List<ResearchResultBeanz.PictureItem> items) {

        mCtx = ctx;
        data = items;
        inf = LayoutInflater.from(ctx);
    }


    @Override
    public int getCount() {
        return data.size();
    }

    @Override
    public Object getItem(int position) {
        return data.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        ResearchResultBeanz.PictureItem item = (ResearchResultBeanz.PictureItem) getItem(position);
        View view;
        ViewHolder viewHolder;
        if (convertView == null) {
            view = inf.inflate(R.layout.gridview_item2, parent, false);
            viewHolder = new ViewHolder(view, item);
        } else {
            view = convertView;
            viewHolder = (ViewHolder) convertView.getTag();
        }

        // i think i can actually set the size of the picture
        ViewGroup.LayoutParams params = viewHolder.imageView.getLayoutParams();

        // get the newheight size of the picture.
        /*
        if          w -> 6320
        but now is  w -> 640

    // get the diviserzzz
        \ */
        float ratio = item.width / Constants.DOWNLOADED_IMAGE_WIDTH;
if (ratio <= 0)
    ratio = 1;

        params.height = (int) (item.height / ratio);
        params.width = /*item.width*/640;
        viewHolder.imageView.setLayoutParams(params);

        viewHolder.tv_pres.setText(item.description);
        viewHolder.tv_title.setText(item.title);
        viewHolder.tv_comz.setText(item.comment_count+"");
        viewHolder.tv_eyes.setText(item.views+"");
        viewHolder.tv_likes.setText(item.ups+"");
        // links should be change
        Picasso.with(mCtx).load(item.link)/*.placeholder(R.drawable.heliboy) *//*.transform(new RoundedTransformation(50, 4))*/
                /*.error(R.drawable.heliboy)*/.into(viewHolder.imageView);
        // if it is an album then upload little pics from the album and put them inside to show.
        viewHolder.inner = item;
        view.setTag(viewHolder);
        return view;
    }

    public void appendData(List<ResearchResultBeanz.PictureItem> pictureItems) {
        data.addAll(pictureItems);
        notifyDataSetChanged();
    }

    static class ViewHolder {

        @Bind(R.id.iv_gridview_item) public DynamicHeightImageView imageView;
        @Bind(R.id.tv_description)public TextView tv_pres;
        @Bind(R.id.tv_title) public TextView tv_title;
        @Bind (R.id.tv_eye) public TextView tv_eyes;
        @Bind (R.id.tv_coms) public TextView tv_comz;
        @Bind (R.id.tv_likes) public TextView tv_likes;



        public ResearchResultBeanz.PictureItem inner;

        public ViewHolder (View v, ResearchResultBeanz.PictureItem item) {
            ButterKnife.bind(this, v);
            inner = item;
        }
    }


}
