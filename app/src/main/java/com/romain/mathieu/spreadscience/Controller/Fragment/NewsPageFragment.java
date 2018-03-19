package com.romain.mathieu.spreadscience.Controller.Fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.romain.mathieu.spreadscience.Model.CardViewData;
import com.romain.mathieu.spreadscience.R;
import com.romain.mathieu.spreadscience.View.MyAdapter;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * A simple {@link Fragment} subclass.
 */
public class NewsPageFragment extends Fragment {

    @BindView(R.id.recyclerView)
    RecyclerView recyclerView;

    public static ArrayList<CardViewData> cardViewData = new ArrayList<>();

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
        ButterKnife.bind(this, view);

        cardViewData.add(new CardViewData("Titre", "Content", R.drawable.article_singe));


        LinearLayoutManager llm = new LinearLayoutManager(this.getActivity());
        recyclerView.setLayoutManager(llm);


        MyAdapter adapter = new MyAdapter(cardViewData);
        recyclerView.setAdapter(adapter);


        // Inflate the layout for this fragment

        return view;


    }

}
