package com.remembook.kimryoji.remembook.Interface;

/**
 * Created by KimRyoji on 2017-04-21.
 */

public interface MainWriteContract {

    interface View{

    }
    interface Presenter{
        void attachView(View view);
    }

}
