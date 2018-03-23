package com.romain.mathieu.spreadscience.Controller.Fragment;


import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Html;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;

import com.romain.mathieu.spreadscience.Model.CardData;
import com.romain.mathieu.spreadscience.Model.RetrofitRequest;
import com.romain.mathieu.spreadscience.Model.WPPostAPI;
import com.romain.mathieu.spreadscience.Model.WordPressService;
import com.romain.mathieu.spreadscience.R;
import com.romain.mathieu.spreadscience.View.MyAdapter;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

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


        RetrofitRequest.getRetrofit();

        WordPressService service = RetrofitRequest.retrofit.create(WordPressService.class);
        Call<List<WPPostAPI>> call = service.getPostInfo();


        call.enqueue(new Callback<List<WPPostAPI>>() {
            @Override
            public void onResponse(Call<List<WPPostAPI>> call, Response<List<WPPostAPI>> response) {
                mListPost = response.body();
                progressBar.setVisibility(View.GONE);


                JSONObject jsonObject = new JSONObject();
                try {
                    JSONArray array = jsonObject.getJSONArray("post");
                    JSONObject ob = array.getJSONObject(1);
                    String image = String.valueOf(Html.fromHtml(ob.getString("thumbnail")));
                    Log.e("Retrofit", "var array : " + array + " var ob : " + ob + "var image : " + image);
                } catch (JSONException e) {
                    e.printStackTrace();
                    Log.e("catch", "error");
                }


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
