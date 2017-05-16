package com.remembook.kimryoji.remembook.Presenter;

import com.remembook.kimryoji.remembook.Interface.MainWriteContract;

/**
 * Created by KimRyoji on 2017-04-21.
 */

public class MainWritePresenter implements MainWriteContract.Presenter {

    private MainWriteContract.View view;

    @Override
    public void attachView(MainWriteContract.View view) {
        this.view = view;
    }

}
