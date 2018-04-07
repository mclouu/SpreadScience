package com.romain.mathieu.spreadscience.View;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.text.Html;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.romain.mathieu.spreadscience.Controller.Activity.ArticleActivity;
import com.romain.mathieu.spreadscience.Model.CardData;
import com.romain.mathieu.spreadscience.R;

import java.util.ArrayList;

import static com.bumptech.glide.request.RequestOptions.centerCropTransform;

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

        Glide.with(context)
                .load(url)
                .apply(centerCropTransform())
                .into(holder.imageView);
    }

    @Override
    public int getItemCount() {
        return mdatas.size();
    }


    class ArticleViewHolder extends RecyclerView.ViewHolder {


        CardView cardView;
        ImageView imageView;
        TextView title, subtitle, date, category;


        ArticleViewHolder(final View itemView) {
            super(itemView);

            context = itemView.getContext();

            this.cardView = itemView.findViewById(R.id.card_view);
            this.imageView = itemView.findViewById(R.id.thumbnail);
            this.title = itemView.findViewById(R.id.title);
            this.subtitle = itemView.findViewById(R.id.content);
            this.date = itemView.findViewById(R.id.date);
            this.category = itemView.findViewById(R.id.category);

            cardView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int position = getAdapterPosition();


                    Intent intent = new Intent(context, ArticleActivity.class);
                    final CardData object = mdatas.get(position);
                    intent.putExtra("titleArticle", String.valueOf(Html.fromHtml(object.getTitle())));
                    intent.putExtra("subtitleArticle", String.valueOf(Html.fromHtml(object.getSubtitle())));
                    intent.putExtra("contentArticle", object.getContent());
                    intent.putExtra("urlArticle", object.getUrl());
                    intent.putExtra("imageUrl", object.getImageURL());
                    Log.e("TAG2", object.getContent());
                    context.startActivity(intent);
                }
            });


        }
    }
}
