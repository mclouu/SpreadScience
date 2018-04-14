package com.romain.mathieu.spreadscience.View;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.romain.mathieu.spreadscience.Controller.Activity.ArticleActivity;
import com.romain.mathieu.spreadscience.Model.CardData;
import com.romain.mathieu.spreadscience.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by romain on 17/03/2018.
 */

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ArticleViewHolder> {

    private Context context;

    public MyAdapter(Context context) {
        this.context = context;
    }

    private ArrayList<CardData> mdatas;


    public MyAdapter(ArrayList<CardData> mlist) {
        this.mdatas = mlist;
    }

    @NonNull
    @Override
    public ArticleViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item, parent, false);
        return new ArticleViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ArticleViewHolder holder, int position) {
        final CardData object = mdatas.get(position);


        holder.title.setText(Html.fromHtml(object.getTitle()));
        holder.subtitle.setText(Html.fromHtml(object.getSubtitle()));

        holder.date.setText(object.getDate());
        holder.category.setText(object.getCategory());

        String url = object.getImageURL();

        Picasso.get()
                .load(url)
                .into(holder.imageView);
    }

    @Override
    public int getItemCount() {
        if (mdatas != null) {
            return mdatas.size();
        }
        return 0;
    }

    class ArticleViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.thumbnail)
        ImageView imageView;
        @BindView(R.id.title)
        TextView title;
        @BindView(R.id.content)
        TextView subtitle;
        @BindView(R.id.date)
        TextView date;
        @BindView(R.id.category)
        TextView category;


        ArticleViewHolder(final View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
            context = itemView.getContext();
        }

        @OnClick(R.id.card_view)
        void submit(View view) {
            int position = getAdapterPosition();

            Intent intent = new Intent(context, ArticleActivity.class);
            final CardData object = mdatas.get(position);
            intent.putExtra("titleArticle", String.valueOf(Html.fromHtml(object.getTitle())));
            intent.putExtra("subtitleArticle", String.valueOf(Html.fromHtml(object.getSubtitle())));
            intent.putExtra("contentArticle", object.getContent());
            intent.putExtra("urlArticle", object.getUrl());
            intent.putExtra("imageUrl", object.getImageURL());
            context.startActivity(intent);
        }
    }
}
