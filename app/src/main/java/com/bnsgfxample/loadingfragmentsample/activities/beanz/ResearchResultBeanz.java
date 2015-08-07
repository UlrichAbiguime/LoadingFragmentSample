package com.bnsgfxample.loadingfragmentsample.activities.beanz;

import java.util.Arrays;

/**
 * Created by UlrichAbiguime at Shenzhen.
 */
public class ResearchResultBeanz {

    public String name;
    public int followers;
    public int total_items;
    public boolean following;
    public PictureItem[] items;
    public boolean success;
    public int status;


    @Override
    public String toString() {
        return "ResearchResultBeanz{" +
                "name='" + name + '\'' +
                ", followers=" + followers +
                ", total_items=" + total_items +
                ", following=" + following +
                ", items=" + Arrays.toString(items) +
                '}';
    }

    public class PictureItem {
        /* "id": "PtrvzYG",
                 "title": "A beautiful movie about the profound bond humans and dogs share",
                 "description": null,
                 "datetime": 1420741054,
                 "type": "image/jpeg",
                 "animated": false,
                 "width": 750,
                 "height": 313,
                 "size": 337037,
                 "views": 1260,
                 "bandwidth": 424666620,
                 "vote": null,
                 "favorite": false,
                 "nsfw": false,
                 "section": "",
                 "account_url": "manbrodude",
                 "account_id": 7575848,
                 "comment_preview": null,
                 "topic": null,
                 "topic_id": 0,
                 "link": "http://i.imgur.com/PtrvzYG.jpg",
                 "comment_count": 4,
                 "ups": 15,
                 "downs": 0,
                 "score": 15,
                 "is_album": false*/
        public String id, title, description;
        public long datetime;
        public String type;
        public boolean animated;
        public int width, height, size, views, bandwidth, vote;
        public boolean favorite, nsfw;
        public String section, account_url;
        public long accound_id;
        public String comment_preview, topic;
        public long topic_id;
        public String link;
        public int comment_count, ups, downs, score;
        public boolean is_album;

        @Override
        public String toString() {
            return "PictureItem{" +
                    "id='" + id + '\'' +
                    ", title='" + title + '\'' +
                    ", description='" + description + '\'' +
                    ", datetime=" + datetime +
                    ", type='" + type + '\'' +
                    ", animated=" + animated +
                    ", width=" + width +
                    ", height=" + height +
                    ", size=" + size +
                    ", views=" + views +
                    ", bandwidth=" + bandwidth +
                    ", vote=" + vote +
                    ", favorite=" + favorite +
                    ", nsfw=" + nsfw +
                    ", section='" + section + '\'' +
                    ", account_url='" + account_url + '\'' +
                    ", accound_id=" + accound_id +
                    ", comment_preview='" + comment_preview + '\'' +
                    ", topic='" + topic + '\'' +
                    ", topic_id=" + topic_id +
                    ", link='" + link + '\'' +
                    ", comment_count=" + comment_count +
                    ", ups=" + ups +
                    ", downs=" + downs +
                    ", score=" + score +
                    ", is_album=" + is_album +
                    '}';
        }
    }
   /* "name": "peace",
            "followers": 0,
            "total_items": 181,
            "following": false,
            "items": [*/




}
