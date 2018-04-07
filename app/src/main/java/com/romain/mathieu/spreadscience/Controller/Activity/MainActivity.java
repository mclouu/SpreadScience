package com.romain.mathieu.spreadscience.Controller.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.romain.mathieu.spreadscience.Model.API.WPPostAPI;
import com.romain.mathieu.spreadscience.Model.CardData;
import com.romain.mathieu.spreadscience.Model.SharedPeferencesUtils;
import com.romain.mathieu.spreadscience.Model.WordPressService;
import com.romain.mathieu.spreadscience.R;
import com.romain.mathieu.spreadscience.View.MyAdapter;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity implements SwipeRefreshLayout.OnRefreshListener {

    private LinearLayoutManager llm;
    private MyAdapter adapter;
    public static ArrayList<CardData> list = new ArrayList<>();
    public static List<WPPostAPI> responseBody;

    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.progressBar)
    ProgressBar progressBar;
    @BindView(R.id.recyclerView)
    RecyclerView recyclerView;
    @BindView(R.id.swipeRefreshLayout)
    SwipeRefreshLayout swipeRefreshLayout;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);


        swipeRefreshLayout.setOnRefreshListener(this);

        setSupportActionBar(toolbar);
        toolbar.setTitle("toolBar");

        progressBar = findViewById(R.id.progressBar);
        recyclerView = findViewById(R.id.recyclerView);
        llm = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(llm);

        adapter = new MyAdapter(list);
        recyclerView.setAdapter(adapter);
        getRetrofit();

    }

    @Override
    public void onRefresh() {

        swipeRefreshLayout.postDelayed(new Runnable() {
            @Override
            public void run() {
                getRetrofit();
                list.clear();
                adapter.notifyDataSetChanged();
                swipeRefreshLayout.setRefreshing(false);
            }
        }, 2000);

    }

    //-----------------------
    // HTTP REQUEST RETROFIT
    //-----------------------

    public void getRetrofit() {

        WordPressService service = WordPressService.retrofit.create(WordPressService.class);


        Call<List<WPPostAPI>> call = service.getPostInfo();
        call.enqueue(new Callback<List<WPPostAPI>>() {
            @Override
            public void onResponse(@NonNull Call<List<WPPostAPI>> call, @NonNull Response<List<WPPostAPI>> response) {
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
                    String url = responseBody.get(i).getLink();


                    list.add(new CardData(title, subTitle, featuredImage, date, category, content, url));


                }
                adapter.notifyDataSetChanged();
                SharedPeferencesUtils.saveArrayList(MainActivity.this);
            }

            @Override
            public void onFailure(@NonNull Call<List<WPPostAPI>> call, @NonNull Throwable t) {
                Toast.makeText(MainActivity.this, "Lecture hors-ligne", Toast.LENGTH_SHORT).show();
                progressBar.setVisibility(View.GONE);

            }
        });

    }


    //------------
    // MENU
    //------------

    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.menu_setting:
                return true;
            case R.id.menu_about:
                Intent intent2 = new Intent(MainActivity.this, AboutActivity.class);
                startActivity(intent2);
                return true;
            case R.id.menu_search:

                return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
