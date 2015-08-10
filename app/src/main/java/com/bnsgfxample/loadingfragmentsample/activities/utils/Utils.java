package com.bnsgfxample.loadingfragmentsample.activities.utils;

import android.graphics.Picture;
import android.util.Log;

import com.bnsgfxample.loadingfragmentsample.activities.Constants;
import com.bnsgfxample.loadingfragmentsample.activities.beanz.ResearchResultBeanz;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by UlrichAbiguime at Shenzhen.
 */
public class Utils {
    public static List<String> ArrayToList(String[] d) {

        List<String> data = new ArrayList<>();
        for (int i = 0; i < d.length; i++) {
            data.add(d[i]);
        }
        return data;
    }

    public static List<ResearchResultBeanz.PictureItem> fromArrayToList(ResearchResultBeanz.PictureItem[] data) {

        List<ResearchResultBeanz.PictureItem> tmp = new ArrayList<>();
        if (data != null)
            for (int i = 0; i < data.length; i++) {
                ResearchResultBeanz.PictureItem item = data[i];
                String size = "h";
                switch (Constants.DOWNLOADED_IMAGE_WIDTH) {
                    case 640:
                        size = "l";
                        break;
                    case 320:
                        size = "m";
                        break;
                    case 160:
                        size = "b";
                        break;
                    case 161:
                        size = "t";
                        break;
                    case 90:
                        size = "s";
                        break;
                }
//                Log.d("qwerty", item.link + " ---- " + item.link.replace(".jpg", size + ".jpg").replace(".png", size + ".png").replace(".gif", size + ".gif").replace(".jpeg", size + ".jpeg"));
                item.link = item.link.replace(".jpg", size+".jpg").replace(".png", size+".png").replace(".gif", size+".gif").replace(".jpeg", size+".jpeg");

                if (item.link.contains(".jpg") || item.link.contains(".png") || item.link.contains(".jpeg") )
                    tmp.add(item);
            }
        return tmp;
    }
}
