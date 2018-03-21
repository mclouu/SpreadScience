package com.romain.mathieu.spreadscience.Model;


import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by romain on 19/03/2018.
 */

public interface WordPressService {
    MyConstant constant = new MyConstant();

    @GET("wp-json/wp/v2/posts")
    Call<List<WPPostAPI>> getPostInfo();
    /// to make call to dynamic URL
    //  @GET
    //  Call<List<WPPostAPI>> getPostInfo(@Url String url);
    //


}
