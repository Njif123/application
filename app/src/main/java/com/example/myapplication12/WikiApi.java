package com.example.myapplication12;

import com.example.myapplication12.pojo.Example;

import java.util.List;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Url;

public interface WikiApi {
    @GET("page/summary/{title}")
    public Call<Example> getSummary(@Path("title") String title);
}
