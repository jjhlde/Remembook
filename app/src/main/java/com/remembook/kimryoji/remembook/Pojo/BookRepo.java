package com.remembook.kimryoji.remembook.Pojo;

import com.google.gson.annotations.SerializedName;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by KimRyoji on 2017-04-07.
 */

public class BookRepo {

    @SerializedName("channel")
    private Channel channel;
    private Channel getChannel(){
        return channel;
    }
    private void setChannel(Channel channel){
        this.channel = channel;
    }

    public static class Channel{
        @SerializedName("item")
        private ArrayList<BookItems> items;
        public ArrayList<BookItems> getItems(){
            return items;
        }
        public void setItems(ArrayList<BookItems> items) {
            this.items = items;
        }

        public static class BookItems{
            @SerializedName("title")
            private String title;
            @SerializedName("description")
            private String description;
            @SerializedName("cover_l_url")
            private String imageUrl;
            @SerializedName("pub_nm")
            private String pubName;
            @SerializedName("pub_date")
            private String pubDate;

            public String getTitle() {
                return title;
            }

            public void setTitle(String title) {
                this.title = title;
            }

            public String getDescription() {
                return description;
            }

            public void setDescription(String description) {
                this.description = description;
            }

            public String getImageUrl() {
                return imageUrl;
            }

            public void setImageUrl(String imageUrl) {
                this.imageUrl = imageUrl;
            }

            public String getPubName() {
                return pubName;
            }

            public void setPubName(String pubName) {
                this.pubName = pubName;
            }

            public String getPubDate() {
                return pubDate;
            }

            public void setPubDate(String pubDate) {
                this.pubDate = pubDate;
            }


        }
    }
    public ArrayList<Channel.BookItems> getBookInfoList(){
        return getChannel().getItems();
    }


}
