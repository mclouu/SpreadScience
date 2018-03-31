package com.romain.mathieu.spreadscience.Model;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import static com.romain.mathieu.spreadscience.Model.WordPressService.constant;

/**
 * Created by romain on 23/03/2018.
 */

public class RetrofitRequest {

    public static Retrofit retrofit;


    public static void getRetrofit() {

        retrofit = new Retrofit.Builder()
                .baseUrl(constant.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        // to make call to dynamic URL

        // String yourURL = yourURL.replace(BaseURL,"");
        // Call<List<WPPostAPI>>  call = service.getPostInfo( yourURL);

        /// to get only 6 post from your blog
        // http://your-blog-url/wp-json/wp/v2/posts?per_page=2

        // to get any specific blog post, use id of post
        //  http://www.blueappsoftware.in/wp-json/wp/v2/posts/1179

        // to get only title and id of specific
        // http://www.blueappsoftware.in/android/wp-json/wp/v2/posts/1179?fields=id,title
    }
}