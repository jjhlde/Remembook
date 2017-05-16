package com.remembook.kimryoji.remembook.Interface;

import android.content.Context;
import android.support.v4.app.Fragment;

import com.remembook.kimryoji.remembook.Adapter.MainPagerAdapter;
import com.remembook.kimryoji.remembook.Model.BookDataModel;
import com.remembook.kimryoji.remembook.Pojo.BookRepo;

/**
 * Created by KimRyoji on 2017-04-10.
 */

public interface BookDataContract {

    interface View{
        void addFragment(BookRepo.Channel.BookItems items);
    }

    interface Presenter{
        void attachView(View view);
        void detachView();
        void setBookDataModel(BookDataModel model);
        void setMainPagerAdapter(MainPagerAdapter adapter);

        void setBookDataAdapterModel(BookDataAdapterContract.Model model);
        void setBookDataAdapterView(BookDataAdapterContract.View view);

        void loadItems(Context context,String bookTitle,String sort,int pageNo,boolean isClear);

    }
}
