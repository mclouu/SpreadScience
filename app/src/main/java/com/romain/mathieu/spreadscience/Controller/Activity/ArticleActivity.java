package com.romain.mathieu.spreadscience.Controller.Activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Html;
import android.text.method.LinkMovementMethod;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.romain.mathieu.spreadscience.R;

import butterknife.BindView;
import butterknife.ButterKnife;

import static com.bumptech.glide.request.RequestOptions.*;

/**
 * Created by romain on 31/03/2018.
 */

public class ArticleActivity extends AppCompatActivity {

    @BindView(R.id.articile_title)
    TextView mtitle;
    @BindView(R.id.article_content)
    TextView mcontent;
    @BindView(R.id.image_url)
    ImageView mimageUrl;


    Context context;

    String title = "";
    String content = "";
    String url = "";
    String imageUrl = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_article);
        ButterKnife.bind(this);

        context = getApplicationContext();


        Intent intent = getIntent();
        if (intent != null) {


            if (intent.hasExtra("titleArticle")) {
                title = intent.getStringExtra("titleArticle");
            }


            if (intent.hasExtra("contentArticle")) {
                content = intent.getStringExtra("contentArticle");
                Log.e("TAG", content);
            }


            if (intent.hasExtra("urlArticle")) {
                url = intent.getStringExtra("urlArticle");
            }

            if (intent.hasExtra("imageUrl")) {
                imageUrl = intent.getStringExtra("imageUrl");
            }

            mtitle.setText(title);
            mcontent.setText(Html.fromHtml(content));


            Glide.with(ArticleActivity.this)
                    .load(imageUrl)
                    .apply(centerCropTransform())
                    .into(mimageUrl);


            mcontent.setMovementMethod(LinkMovementMethod.getInstance());


        }

        Button button = findViewById(R.id.btn_article_url);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ArticleActivity.this, WebViewActivity.class);
                intent.putExtra("urlArticle", url);
                startActivity(intent);
            }
        });

    }
}
