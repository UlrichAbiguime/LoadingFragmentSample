package com.bnsgfxample.loadingfragmentsample.activities.adapterz;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.bnsgfxample.loadingfragmentsample.R;
import com.bnsgfxample.loadingfragmentsample.activities.ImageGridViewActivity;
import com.bnsgfxample.loadingfragmentsample.activities.beanz.ResearchResultBeanz;
import com.bnsgfxample.loadingfragmentsample.activities.on3.MyBoruto;
import com.bnsgfxample.loadingfragmentsample.activities.viewz.RoundedTransformation;
import com.etsy.android.grid.util.DynamicHeightImageView;
import com.squareup.picasso.NetworkPolicy;
import com.squareup.picasso.Picasso;

import org.w3c.dom.Text;

import java.util.List;

/**
 * Created by UlrichAbiguime at Shenzhen.
 */
public class GridViewAdapter extends BaseAdapter {


    Context mCtx;
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

        View view;
        ViewHolder viewHolder;
        if (convertView == null) {
            view = inf.inflate(R.layout.gridview_item, parent, false);
            viewHolder = ViewHolder.makeUp (view);
        } else {
            view = convertView;
            viewHolder = (ViewHolder) convertView.getTag();
        }

        ResearchResultBeanz.PictureItem item = (ResearchResultBeanz.PictureItem) getItem(position);

        viewHolder.tv_vues.setText("#" + item.views + "");
        viewHolder.tv_pres.setText(item.description);
        // links should be change

     Picasso.with(mCtx).load(item.link).placeholder(R.drawable.heliboy)/*.transform(new RoundedTransformation(50, 4))*/
                .error(R.drawable.error).into(viewHolder.imageView);

        // if it is an album then upload little pics from the album and put them inside to show.
        //                viewHolder.imageView.setImageResource(R.drawable.sample);
        view.setTag(viewHolder);
        return view;
    }

    static class ViewHolder {

        public DynamicHeightImageView imageView;
        public TextView tv_pres,tv_vues, tv_title;

        public static ViewHolder makeUp (View v) {

            ViewHolder vh = new ViewHolder();
            vh.imageView = (DynamicHeightImageView) v.findViewById(R.id.iv_gridview_item);
            vh.tv_pres = (TextView) v.findViewById(R.id.tv_description);
            vh.tv_vues = (TextView) v.findViewById(R.id.tv_vues);
            vh.tv_title = (TextView) v.findViewById(R.id.tv_title);
            return vh;
        }
    }


}
