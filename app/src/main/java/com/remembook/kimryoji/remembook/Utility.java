package com.remembook.kimryoji.remembook;

import android.content.Context;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.squareup.picasso.Picasso;

/**
 * Created by KimRyoji on 2017-04-12.
 * 유틸리티 클래스
 *
 */

public class Utility {

    private Utility(){};
    private static Utility instance;

    public static Utility getInstance(){
        if(instance == null){
            instance = new Utility();
        }
        return instance;
    }

    /**
     * Image URL이 isEmpty일 경우에 에러 이미지를 출력해주는 메서드
     * @param context Context
     * @param url image URL
     * @param imageView 이미지뷰
     */
    public void setPicasso(Context context, String url, ImageView imageView){
        if(!url.isEmpty()){
            Picasso.with(context).load(url).placeholder(R.drawable.loading).into(imageView);
        }else{
            Picasso.with(context).load(R.drawable.error).into(imageView);
        }

    }

    public void setGlideThumbNail(Context context,String url, ImageView imageView){
        if(!url.isEmpty()){
            Glide.with(context).load(url).thumbnail(0.2f).into(imageView);
        }else{
            Glide.with(context).load(R.drawable.error).into(imageView);
        }
    }

    public void setGlideFullSize(Context cOntext,String url, ImageView imageView){
        if(!url.isEmpty()){
            Glide.with(cOntext).load(url).fitCenter().thumbnail(0.2f).into(imageView);
        }else {
            Glide.with(cOntext).load(R.drawable.error).into(imageView);
        }
    }

}
