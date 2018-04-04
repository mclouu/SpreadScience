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
import android.widget.Toast;

import com.romain.mathieu.spreadscience.Model.API.WPPostAPI;
import com.romain.mathieu.spreadscience.Model.CardData;
import com.romain.mathieu.spreadscience.Model.RetrofitRequest;
import com.romain.mathieu.spreadscience.Model.SharedPeferencesUtils;
import com.romain.mathieu.spreadscience.Model.WordPressService;
import com.romain.mathieu.spreadscience.R;
import com.romain.mathieu.spreadscience.View.MyAdapter;

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
    public static ArrayList<CardData> list = new ArrayList<>();
    public static List<WPPostAPI> responseBody;

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

        //SharedPeferencesUtils.getArrayList(context);

        progressBar = view.findViewById(R.id.progressBar);
        recyclerView = view.findViewById(R.id.recyclerView);
        llm = new LinearLayoutManager(context);
        recyclerView.setLayoutManager(llm);

        adapter = new MyAdapter(list);
        recyclerView.setAdapter(adapter);


        adapter.notifyDataSetChanged();


        getRetrofit();

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
                responseBody = response.body();
                progressBar.setVisibility(View.GONE);


                for (int i = 0; i < response.body().size(); i++) {

                    String title = responseBody.get(i).getTitle().getRendered();
                    String subTitle = responseBody.get(i).getExcerpt().getRendered();
                    String content = responseBody.get(i).getContent().getRendered();
                    String featuredImage = responseBody.get(i).getEmbedded().getWpFeaturedmedia().get(0).getSourceUrl();
                    String date = responseBody.get(i).getDate();
                    date = date.replace("T", " - ");
                    String category = responseBody.get(i).getEmbedded().getWpTerm().get(0).get(0).getName();

                    list.add(new CardData(title, subTitle, featuredImage, date, category, content));


                }


                SharedPeferencesUtils.saveArrayList(context);
                adapter.notifyDataSetChanged();

            }

            @Override
            public void onFailure(Call<List<WPPostAPI>> call, Throwable t) {
                Toast.makeText(context, "Lecture hors-ligne", Toast.LENGTH_SHORT).show();
                progressBar.setVisibility(View.GONE);

            }
        });

    }
}
