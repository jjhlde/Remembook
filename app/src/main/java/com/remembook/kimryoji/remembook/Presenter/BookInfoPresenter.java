package com.remembook.kimryoji.remembook.Presenter;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;

import com.remembook.kimryoji.remembook.Adapter.MainPagerAdapter;
import com.remembook.kimryoji.remembook.Constans;
import com.remembook.kimryoji.remembook.Interface.BookDataAdapterContract;
import com.remembook.kimryoji.remembook.Interface.BookDataContract;
import com.remembook.kimryoji.remembook.Interface.Listner.OnItemClickListner;
import com.remembook.kimryoji.remembook.Model.BookDataModel;
import com.remembook.kimryoji.remembook.Pojo.BookRepo;
import com.remembook.kimryoji.remembook.R;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by KimRyoji on 2017-04-10.
 */

public class BookInfoPresenter implements BookDataContract.Presenter, OnItemClickListner{

    private BookDataContract.View view;
    private BookDataModel model;
    private BookDataAdapterContract.Model mAdapterModel;
    private BookDataAdapterContract.View mAdapterView;

    private MainPagerAdapter mPagerAdapter;

    @Override
    public void attachView(BookDataContract.View view) {
        this.view = view;
    }

    @Override
    public void detachView() {
        view = null;
    }

    @Override
    public void setBookDataModel(BookDataModel model) {
        this.model = model;
    }

    @Override
    public void setMainPagerAdapter(MainPagerAdapter adapter) {
        this.mPagerAdapter = adapter;
    }

    @Override
    public void loadItems(Context context, String bookTitle,String sort,int pageNo,boolean isClear) {
        if(isClear){
            mAdapterModel.clearItem();
        }
        model.getRetrofit()
                .getBookDefault(Constans.getInstance().getAPI_KEY()
                        ,bookTitle
                        , Constans.getInstance().getRESULT_NO()
                        ,sort
                        ,pageNo
                        ,"json")
                .enqueue(new Callback<BookRepo>() {
                    @Override
                    public void onResponse(Call<BookRepo> call, Response<BookRepo> response) {
                        if(response.isSuccessful()){
                            Log.d("retrofit","success");
                            mAdapterModel.addBookItems(response.body().getBookInfoList());
                            mAdapterView.notifyAdapter();
                        }

                    }
                    @Override
                    public void onFailure(Call<BookRepo> call, Throwable t) {
                        Log.d("retrofit","failure");
                    }
                });
    }


    @Override
    public void setBookDataAdapterModel(BookDataAdapterContract.Model model) {
        this.mAdapterModel = model;
    }

    @Override
    public void setBookDataAdapterView(BookDataAdapterContract.View view) {
        this.mAdapterView = view;
        this.mAdapterView.setOnClickListner(this);
    }

    @Override
    public void onItemClick(int position) {
        BookRepo.Channel.BookItems items = mAdapterModel.getItem(position);
        view.addFragment(items);
    }

}
