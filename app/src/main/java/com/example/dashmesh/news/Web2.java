package com.example.dashmesh.news;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

public class Web2 extends AppCompatActivity {

    //String URL="http://indianexpress.com/article/sports/football/michy-batshuayi-to-join-chelsea-lequipe-reports-2883248/";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web2);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
        new Title().execute();
        //   Document doc= Jsoup.connect().url();
        new Logo().execute();
        new Description().execute();
    }
    // Title AsyncTask
    private class Title extends AsyncTask<Void, Void, Void> {
        String title;
        @Override
        protected void onPreExecute() {
            super.onPreExecute();

        }

        @Override
        protected Void doInBackground(Void... params) {
            try {
                // Connect to the web site
                Intent intent = getIntent();
                String link = intent.getStringExtra("link");
                Document document = Jsoup.connect(link).get();
                // Get the html document title
                title = document.title();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return null;
        }

        @Override
        protected void onPostExecute(Void result) {
            // Set title into TextView
            TextView txttitle = (TextView) findViewById(R.id.text);
            txttitle.setText(title);
        }
    }
    private class Logo extends AsyncTask<Void, Void, Bitmap> {
        Bitmap bitmap;

        @Override
        protected void onPreExecute() {
            Intent intent = getIntent();
            String link = intent.getStringExtra("link");
            super.onPreExecute();

        }

        @Override
        protected Bitmap doInBackground(Void... params) {
            Bitmap result = null;
            try {
                Intent intent = getIntent();
                String link = intent.getStringExtra("link");
                Document doc = Jsoup.connect(link).get();

                //parse("http://lulpix.com");
                if (doc != null) {
                    Elements elems = doc.getElementsByAttributeValue("class", "custom-caption");
                    if (elems != null && !elems.isEmpty()) {
                        Element elem = elems.first();
                        elems = elem.getElementsByTag("img");
                        if (elems != null && !elems.isEmpty()) {
                            elem = elems.first();
                            String src = elem.attr("src");
                            if (src != null) {
                                URL url = new URL(src);
                                // Just assuming that "src" isn't a relative URL is probably stupid.
                                InputStream is = url.openStream();
                                try {
                                    result = BitmapFactory.decodeStream(is);
                                } finally {
                                    is.close();
                                }
                            }
                        }
                    }
                }
            } catch (IOException e) {
                // Error handling goes here
            }
            return result;
        }

        @Override
        protected void onPostExecute(Bitmap result) {
            // Set downloaded image into ImageView
            ImageView logoimg = (ImageView) findViewById(R.id.logo);
            if (result != null) {
                logoimg.setImageBitmap(result);
            } else {
                logoimg = (ImageView) findViewById(R.id.logo);
                logoimg.setImageResource(R.drawable.ic_favorite);
            }
        }
    }

    private class Description extends AsyncTask<Void, Void, Void> {
        String desc;
        String text;
        @Override
        protected void onPreExecute() {
            super.onPreExecute();

        }

        @Override
        protected Void doInBackground(Void... params) {
            try {
                // Connect to the web site
                Intent intent = getIntent();
                String link = intent.getStringExtra("link");
                Document document = Jsoup.connect(link).get();
                // Using Elements to get the Meta data
                Elements description = document
                        .select("meta[name=description]");
                // Locate the content attribute
                desc = description.attr("content");
                Elements p=document.select("p");
                text = p.text();

            } catch (IOException e) {
                e.printStackTrace();
            }
            return null;
        }

        @Override
        protected void onPostExecute(Void result) {
            // Set description into TextView
            TextView txtdesc = (TextView) findViewById(R.id.des);
            txtdesc.setText(desc);
        TextView txtp = (TextView) findViewById(R.id.p);
            txtp.setText(text);
        }
    }
}
