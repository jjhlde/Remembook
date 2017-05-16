package com.remembook.kimryoji.remembook.Fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.remembook.kimryoji.remembook.Interface.MainWriteContract;
import com.remembook.kimryoji.remembook.Pojo.BookRepo;
import com.remembook.kimryoji.remembook.Presenter.MainWritePresenter;
import com.remembook.kimryoji.remembook.R;

import butterknife.ButterKnife;

/**
 * Created by KimRyoji on 2017-04-19.
 */

public class MainWriteFragment extends Fragment implements MainWriteContract.View{

    //Sample Data
    private String mImageUrl;
    private String mTitle;
    private String mDescription;

    //Presenter
    private MainWritePresenter mPresenter;

    public MainWriteFragment(){

    }

    public static MainWriteFragment newInstance(BookRepo.Channel.BookItems items){
        MainWriteFragment fragment = new MainWriteFragment();
        Bundle bundle = new Bundle();

        //프래그먼트 테스트용 매개변수
        bundle.putString("imageUrl",items.getImageUrl());
        bundle.putString("title",items.getTitle());
        bundle.putString("description",items.getDescription());
        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if(getArguments()!=null){
            mImageUrl = getArguments().getString("imageUrl");
            mTitle = getArguments().getString("title");
            mDescription = getArguments().getString("description");
        }

        mPresenter = new MainWritePresenter();
        mPresenter.attachView(this);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_write_main,container,false);
        ButterKnife.bind(this,view);
        //Set

        return view;
    }
}
