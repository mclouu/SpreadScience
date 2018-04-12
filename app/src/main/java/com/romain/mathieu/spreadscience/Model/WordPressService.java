package com.romain.mathieu.spreadscience.Model;


import com.facebook.stetho.okhttp3.StethoInterceptor;
import com.romain.mathieu.spreadscience.Model.API.WPPostAPI;

import java.util.List;

import okhttp3.OkHttpClient;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * Created by romain on 19/03/2018.
 */

public interface WordPressService {
    MyConstant constant = new MyConstant();

    OkHttpClient okHttpClient = new OkHttpClient.Builder()
            .addNetworkInterceptor(new StethoInterceptor())
            .build();


    @GET("wp-json/wp/v2/posts?_embed")
    Call<List<WPPostAPI>> getPostInfo();
    /// to make call to dynamic URL
    //  @GET
    //  Call<List<WPPostAPI>> getPostInfo(@Url String url);

    @GET("wp-json/wp/v2/posts/?categories={id}")
    Call<List<WPPostAPI>> getPostCategories(@Path("id") int id);

    Retrofit retrofit = new Retrofit.Builder()
            .baseUrl(constant.BASE_URL)
            .client(okHttpClient)
            .addConverterFactory(GsonConverterFactory.create())
            .build();
}
