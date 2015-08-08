package com.bnsgfxample.loadingfragmentsample.activities.adapterz;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.bnsgfxample.loadingfragmentsample.R;
import com.bnsgfxample.loadingfragmentsample.activities.beanz.ResearchResultBeanz;
import com.etsy.android.grid.util.DynamicHeightImageView;
import com.squareup.picasso.Picasso;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by UlrichAbiguime at Shenzhen.
 */
public class GridViewAdapter extends BaseAdapter {


    static Context mCtx;
    List<ResearchResultBeanz.PictureItem> data;
    LayoutInflater inf;

    public GridViewAdapter(Context ctx,  List<ResearchResultBeanz.PictureItem> items) {

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
            view = inf.inflate(R.layout.gridview_item, parent, false);
            viewHolder = new ViewHolder(view, item);
        } else {
            view = convertView;
            viewHolder = (ViewHolder) convertView.getTag();
        }

        viewHolder.tv_vues.setText("#" + item.views + "");
        viewHolder.tv_pres.setText(item.description);
        viewHolder.tv_title.setText(item.title);
        // links should be change
        if (item.description == null || item.description.trim().equals("")) {
            viewHolder.tv_pres.setVisibility(View.GONE);
            viewHolder.divider.setVisibility(View.GONE);
        } else {
            viewHolder.tv_pres.setVisibility(View.VISIBLE);
            viewHolder.divider.setVisibility(View.VISIBLE);
        }
        Picasso.with(mCtx).load(item.link).placeholder(R.drawable.heliboy) /*.transform(new RoundedTransformation(50, 4))*/
                .error(R.drawable.heliboy).into(viewHolder.imageView);
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
        @Bind(R.id.tv_vues) public TextView tv_vues;
        @Bind(R.id.tv_title) public TextView tv_title;
        @Bind(R.id.rel_divider) public View divider;
        public ResearchResultBeanz.PictureItem inner;

        public ViewHolder (View v, ResearchResultBeanz.PictureItem item) {
            ButterKnife.bind(this, v);
            inner = item;
        }
    }


}
