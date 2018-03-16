package com.romain.mathieu.spreadscience.Controller.Fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.romain.mathieu.spreadscience.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class NewsPageFragment extends Fragment {


    public NewsPageFragment() {
        // Required empty public constructor
    }

    public static NewsPageFragment newInstance(){
        return (new NewsPageFragment());
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_news_page, container, false);
    }

}
