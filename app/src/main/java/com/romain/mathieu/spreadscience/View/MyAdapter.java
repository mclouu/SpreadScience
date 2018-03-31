package com.romain.mathieu.spreadscience.View;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.romain.mathieu.spreadscience.Model.CardData;
import com.romain.mathieu.spreadscience.R;

import java.util.ArrayList;

/**
 * Created by romain on 17/03/2018.
 */

public class MyAdapter extends RecyclerView.Adapter {

    static Context context;

    private ArrayList<CardData> dataset;


    public MyAdapter(ArrayList<CardData> mlist) {
        this.dataset = mlist;
    }

    public static class ImageTypeViewHolder extends RecyclerView.ViewHolder {


        TextView title, subtitle, date, category;
        ImageView imageView;

        ImageTypeViewHolder(View itemView) {
            super(itemView);

            context = itemView.getContext();
            this.title = itemView.findViewById(R.id.title);
            this.subtitle = itemView.findViewById(R.id.content);
            this.imageView = itemView.findViewById(R.id.thumbnail);
            this.date = itemView.findViewById(R.id.date);
            this.category = itemView.findViewById(R.id.category);
        }
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item, parent, false);
        return new ImageTypeViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final RecyclerView.ViewHolder holder, final int position) {
        final CardData object = dataset.get(position);


        ((ImageTypeViewHolder) holder).title.setText(Html.fromHtml(object.getTitle()));
        ((ImageTypeViewHolder) holder).subtitle.setText(Html.fromHtml(object.getSubtitle()));
        ((ImageTypeViewHolder) holder).date.setText(object.getDate());
        ((ImageTypeViewHolder) holder).category.setText(object.getCategory());

        String url = object.getImageURL();

        Glide.with(context)
                .load(url)
                .into(((ImageTypeViewHolder) holder).imageView);


        /// dataset.get(position)
    }

    @Override
    public int getItemCount() {
        return dataset.size();
    }
}
