package com.romain.mathieu.spreadscience.View;

import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.romain.mathieu.spreadscience.Model.CardViewData;
import com.romain.mathieu.spreadscience.R;

import java.util.ArrayList;

/**
 * Created by romain on 17/03/2018.
 */

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.NewsViewHolder> {


    private ArrayList<CardViewData> mdatas;

    public MyAdapter(ArrayList<CardViewData> cardViewData) {
        this.mdatas = cardViewData;
    }


    @Override
    public NewsViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item, parent, false);
        return new NewsViewHolder(v);
    }

    @Override
    public void onBindViewHolder(NewsViewHolder holder, int position) {
        final CardViewData item = mdatas.get(position);

        holder.mtitle.setText(item.title);
        holder.mcontent.setText(item.content);
        holder.mthumbnail.setImageResource(item.imageCard);

    }

    @Override
    public int getItemCount() {
        return mdatas.size();
    }


    class NewsViewHolder extends RecyclerView.ViewHolder {

        CardView mcardView;
        ImageView mthumbnail;
        TextView mtitle;
        TextView mcontent;

        NewsViewHolder(final View itemView) {
            super(itemView);
            // findViewById ------------------------------------------------------------
            mcardView = itemView.findViewById(R.id.card_view);
            mthumbnail = itemView.findViewById(R.id.thumbnail);
            mtitle = itemView.findViewById(R.id.title);
            mcontent = itemView.findViewById(R.id.content);
            // findViewById ------------------------------------------------------------

            mcardView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                }
            });
        }
    }

}
