package com.remembook.kimryoji.remembook.Interface;

import com.remembook.kimryoji.remembook.Interface.Listner.OnItemClickListner;
import com.remembook.kimryoji.remembook.Pojo.BookRepo;

import java.util.ArrayList;

/**
 * Created by KimRyoji on 2017-04-10.
 */

public interface BookDataAdapterContract {

    interface View{
        void setOnClickListner(OnItemClickListner listner);
        void notifyAdapter();
    }

    interface Model{
        void clearItem();
        void addBookItems(ArrayList<BookRepo.Channel.BookItems> items);
        BookRepo.Channel.BookItems getItem(int position);
    }
}
