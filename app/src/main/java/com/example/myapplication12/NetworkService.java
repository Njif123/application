package com.example.myapplication12;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class NetworkService {

    private static NetworkService mInstance;
    private Retrofit mRetrofit;

    private NetworkService(){
        mRetrofit = new Retrofit.Builder().baseUrl("https://ru.wikipedia.org/api/rest_v1/").addConverterFactory(GsonConverterFactory.create()).build();
    }

    public Retrofit getRetrofitService() {
        return mRetrofit;
    }

    public WikiApi getWikiApi(){
        WikiApi wikiApi = mRetrofit.create(WikiApi.class);
        return wikiApi;
    }

    public static NetworkService getInstance() {
        if (mInstance == null) {
            mInstance = new NetworkService();
        }
        return mInstance;
    }
}
