package com.romain.mathieu.spreadscience.Model;

import com.romain.mathieu.spreadscience.API.Post;

import java.util.List;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;

/**
 * Created by romain on 19/03/2018.
 */

public interface WordPressService {

    @GET("wp-json/posts")
    Call<List<Post>> getAllPost();

    /// to make call to dynamic URL
    //  @GET
    //  Call<List<WPPost>> getPostInfo(@Url String url);
    //

    public static final Retrofit retrofit = new Retrofit.Builder()
            .baseUrl("http://long-pixel.alwaysdata.net/")
            .addConverterFactory(GsonConverterFactory.create())
            .build();


}
