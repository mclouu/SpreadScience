package com.romain.mathieu.spreadscience.Controller.Activity;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Html;
import android.text.method.LinkMovementMethod;
import android.util.Log;
import android.widget.TextView;

import com.romain.mathieu.spreadscience.R;

/**
 * Created by romain on 31/03/2018.
 */

public class ArticleActivity extends AppCompatActivity {

    TextView mtitle, mcontent;
    Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_article);

        context = getApplicationContext();

        mtitle = findViewById(R.id.articile_title);
        mcontent = findViewById(R.id.article_content);

        Intent intent = getIntent();
        if (intent != null) {

            String title = "";
            if (intent.hasExtra("titleArticle")) {
                title = intent.getStringExtra("titleArticle");
            }

            String content = "";
            if (intent.hasExtra("contentArticle")) {
                content = intent.getStringExtra("contentArticle");
                Log.e("TAG", content);
            }

            mtitle.setText(title);
            mcontent.setText(Html.fromHtml(content, new Html.ImageGetter() {
                @Override
                public Drawable getDrawable(String source) {
                    Drawable drawable;
                    int dourceId =
                            getApplicationContext()
                                    .getResources()
                                    .getIdentifier(source, "drawable", getPackageName());

                    drawable =
                            getApplicationContext()
                                    .getResources()
                                    .getDrawable(dourceId);

                    drawable.setBounds(
                            0,
                            0,
                            drawable.getIntrinsicWidth(),
                            drawable.getIntrinsicHeight());

                    return drawable;
                }

            }, null));

            mcontent.setMovementMethod(LinkMovementMethod.getInstance());

        }
    }
}
