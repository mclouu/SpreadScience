package com.romain.mathieu.spreadscience.Controller.Fragment;


import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;

import com.romain.mathieu.spreadscience.Model.CardData;
import com.romain.mathieu.spreadscience.Model.WPPostAPI;
import com.romain.mathieu.spreadscience.Model.WordPressService;
import com.romain.mathieu.spreadscience.R;
import com.romain.mathieu.spreadscience.View.MyAdapter;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import static com.romain.mathieu.spreadscience.Model.WordPressService.constant;

/**
 * A simple {@link Fragment} subclass.
 */
public class NewsPageFragment extends Fragment {

    private LinearLayoutManager llm;
    private MyAdapter adapter;
    private ArrayList<CardData> list;
    public static List<WPPostAPI> mListPost;

    RecyclerView recyclerView;
    ProgressBar progressBar;

    Context context;

    public NewsPageFragment() {
        // Required empty public constructor
    }

    public static NewsPageFragment newInstance() {
        return (new NewsPageFragment());
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_news_page, container, false);

        context = container.getContext();

        progressBar = view.findViewById(R.id.progressBar);
        recyclerView = view.findViewById(R.id.recyclerView);
        llm = new LinearLayoutManager(context);
        recyclerView.setLayoutManager(llm);

        list = new ArrayList<>();

        getRetrofit();

        adapter = new MyAdapter(list);
        recyclerView.setAdapter(adapter);


        // Inflate the layout for this fragment

        return view;


    }


//    -----------------------
//     HTTP REQUEST RETROFIT
//    -----------------------

    public void getRetrofit() {

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(constant.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        WordPressService service = retrofit.create(WordPressService.class);
        Call<List<WPPostAPI>> call = service.getPostInfo();

        // to make call to dynamic URL

        // String yourURL = yourURL.replace(BaseURL,"");
        // Call<List<WPPostAPI>>  call = service.getPostInfo( yourURL);

        /// to get only 6 post from your blog
        // http://your-blog-url/wp-json/wp/v2/posts?per_page=2

        // to get any specific blog post, use id of post
        //  http://www.blueappsoftware.in/wp-json/wp/v2/posts/1179

        // to get only title and id of specific
        // http://www.blueappsoftware.in/android/wp-json/wp/v2/posts/1179?fields=id,title


        call.enqueue(new Callback<List<WPPostAPI>>() {
            @Override
            public void onResponse(Call<List<WPPostAPI>> call, Response<List<WPPostAPI>> response) {
                mListPost = response.body();
                progressBar.setVisibility(View.GONE);
                Log.e("URL image : ", response.body().get(1).getLinks().getWpFeaturedmedia().get(0).getHref());
                for (int i = 0; i < response.body().size(); i++) {

                    String tempdetails = response.body().get(i).getExcerpt().getRendered();
                    tempdetails = tempdetails.replace("<p>", "");
                    tempdetails = tempdetails.replace("</p>", "");
                    tempdetails = tempdetails.replace("[&hellip;]", "");

                    list.add(new CardData(response.body().get(i).getTitle().getRendered(), tempdetails, response.body().get(1).getLinks().getWpFeaturedmedia().get(0).getHref()));

                }
                adapter.notifyDataSetChanged();

            }

            @Override
            public void onFailure(Call<List<WPPostAPI>> call, Throwable t) {

            }
        });

    }
}
