package com.remembook.kimryoji.remembook.Adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;

import com.remembook.kimryoji.remembook.Adapter.Holder.BookDataViewHolder;
import com.remembook.kimryoji.remembook.Interface.BookDataAdapterContract;
import com.remembook.kimryoji.remembook.Interface.Listner.OnItemClickListner;
import com.remembook.kimryoji.remembook.Pojo.BookRepo;

import java.util.ArrayList;

/**
 * Created by KimRyoji on 2017-04-10.
 */

public class BookDataAdapter extends RecyclerView.Adapter<BookDataViewHolder>
        implements BookDataAdapterContract.View,BookDataAdapterContract.Model{

    private Context mContext;
    private ArrayList<BookRepo.Channel.BookItems> mList;
    private OnItemClickListner mClickListner;

    public BookDataAdapter(Context context){
        mContext = context;
    }

    @Override
    public BookDataViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new BookDataViewHolder(mContext,parent,mClickListner);
    }

    @Override
    public void onBindViewHolder(BookDataViewHolder holder, int position) {
        if(holder==null)return;
        holder.onBind(position,mList);
    }

    @Override
    public int getItemCount() {
        return mList !=null ? mList.size() : 0;
    }

    @Override
    public void notifyAdapter() {
        notifyDataSetChanged();
    }

    @Override
    public void setOnClickListner(OnItemClickListner listner) {
        this.mClickListner = listner;
    }

    @Override
    public void clearItem() {
        if(mList!=null){
            mList.clear();
        }
    }

    @Override
    public void addBookItems(ArrayList<BookRepo.Channel.BookItems> items) {
        this.mList = items;
    }

    @Override
    public BookRepo.Channel.BookItems getItem(int position) {
        return mList.get(position);
    }
}
