package com.remembook.kimryoji.remembook;

/**
 * Created by KimRyoji on 2017-04-10.
 */

public class Constans {

    private static Constans instance;
    private Constans(){}
    private final String API_KEY = "1ea70c750ab40c69961786f446fc8e76";
    private final String API_URL = "https://apis.daum.net";
    private final int RESULT_NO = 20;

    public static Constans getInstance() {
        if(instance == null){
            instance = new Constans();
        }
        return instance;
    }

    public String getAPI_KEY(){
        return API_KEY;
    }
    public String getAPI_URL(){
        return API_URL;
    }
    public int getRESULT_NO(){return RESULT_NO;}
}
