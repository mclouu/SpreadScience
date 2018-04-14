package com.romain.mathieu.spreadscience.Controller.Activity;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.method.LinkMovementMethod;
import android.view.View;
import android.webkit.WebView;
import android.widget.ImageView;
import android.widget.TextView;

import com.romain.mathieu.spreadscience.R;
import com.squareup.picasso.Picasso;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

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
    @BindView(R.id.test)
    WebView webView;


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
            }


            if (intent.hasExtra("urlArticle")) {
                url = intent.getStringExtra("urlArticle");
            }

            if (intent.hasExtra("imageUrl")) {
                imageUrl = intent.getStringExtra("imageUrl");
            }

            mtitle.setText(title);
            webView.setBackgroundColor(Color.TRANSPARENT);
            webView.loadData(content, "text/html; charset=utf-8", "UTF-8");
            Picasso.get()
                    .load(imageUrl)
                    .into(mimageUrl);


            mcontent.setMovementMethod(LinkMovementMethod.getInstance());


        }
    }

    @OnClick(R.id.btn_article_url)
    public void submit(View view) {
        Intent intent = new Intent(ArticleActivity.this, WebViewActivity.class);
        intent.putExtra("urlArticle", url);
        startActivity(intent);

    }
}
