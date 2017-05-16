package com.remembook.kimryoji.remembook.Adapter.Holder;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.remembook.kimryoji.remembook.Interface.Listner.OnItemClickListner;
import com.remembook.kimryoji.remembook.Pojo.BookRepo;
import com.remembook.kimryoji.remembook.R;
import com.remembook.kimryoji.remembook.Utility;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by KimRyoji on 2017-04-12.
 */

public class BookDataViewHolder extends RecyclerView.ViewHolder {

    private Context mContext;
    private OnItemClickListner mClickListner;

    @BindView(R.id.ivBookItem)
    ImageView ivBookItem;
    @BindView(R.id.tvBookItem)
    TextView tvBookItem;

    public BookDataViewHolder(Context context, ViewGroup parent, OnItemClickListner onItemClickListner) {
        super(LayoutInflater.from(context).inflate(R.layout.book_data_item,parent,false));

        this.mContext = context;
        this.mClickListner = onItemClickListner;

        ButterKnife.bind(this,itemView);
    }

    public void onBind(final int position, ArrayList<BookRepo.Channel.BookItems> list){
        tvBookItem.setText(list.get(position).getTitle());
//        Utility.getInstance().setPicasso(mContext,list.get(position).getImageUrl(),ivBookItem);
        Utility.getInstance().setGlideThumbNail(mContext,list.get(position).getImageUrl(),ivBookItem);
        itemView.setOnClickListener(v -> {
            if(mClickListner!=null){
                mClickListner.onItemClick(position);
            }
        });
    }
}
