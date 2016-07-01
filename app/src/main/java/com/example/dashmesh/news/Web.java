package com.example.dashmesh.news;

import android.annotation.SuppressLint;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.support.v4.app.NavUtils;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Toast;


@SuppressLint("SetJavaScriptEnabled")
public class Web extends AppCompatActivity {
    private SwipeRefreshLayout swipeLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.webview);
        Toolbar myToolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(myToolbar);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);


        Intent intent = getIntent();
        String link = intent.getStringExtra("link");
        getSupportActionBar().setTitle(link);
        WebView mainWebView = (WebView) findViewById(R.id.webview1);
        WebSettings webSettings = mainWebView.getSettings();
        webSettings.setJavaScriptEnabled(true);
        mainWebView.setWebViewClient(new MyCustomWebViewClient());
        mainWebView.setScrollBarStyle(View.SCROLLBARS_INSIDE_OVERLAY);
        mainWebView.loadData(link, "text/html; charset=utf-8", "utf-8");
        swipeLayout = (SwipeRefreshLayout) findViewById(R.id.swipe_container);
        mainWebView.loadUrl(link);
        swipeLayout.setOnRefreshListener(
                new SwipeRefreshLayout.OnRefreshListener() {
                    @Override
                    public void onRefresh() {
                        Log.i("LOG_TAG", "onRefresh called from SwipeRefreshLayout");

                        // This method performs the actual data-refresh operation.
                        // The method calls setRefreshing(false) when it's finished.
                        myUpdateOperation();

                    }
                }
        );
        if (swipeLayout.isRefreshing()) {
            swipeLayout.setRefreshing(false);
        }

    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_web, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        if (id==R.id.home){
            NavUtils.navigateUpFromSameTask(this);
            return true;
          //  onBackPressed();
        }
    if(id==R.id.action_share)
    {
        Intent intent = getIntent();
        String link = intent.getStringExtra("link");
        String title=intent.getStringExtra("title");
        Intent sharingIntent = new Intent(android.content.Intent.ACTION_SEND);
        sharingIntent.setType("text/plain");
        sharingIntent.putExtra(android.content.Intent.EXTRA_SUBJECT, "Subject Here");
        //sharingIntent.putExtra(android.content.Intent.EXTRA_TEXT, shareBody);
        String via="Shared via:News Feeder: app_link";
        title=title + "\n "+link;
        sharingIntent.putExtra(android.content.Intent.EXTRA_TEXT, title);
        startActivity(Intent.createChooser(sharingIntent, "Share via"));
        return true;
    }

        return super.onOptionsItemSelected(item);
    }

    public  void myUpdateOperation() {

            Intent intent = getIntent();
            String link = intent.getStringExtra("link");
            WebView mainWebView = (WebView) findViewById(R.id.webview1);
            mainWebView.setWebViewClient(new MyCustomWebViewClient() {
                @Override
                public void onPageFinished(WebView web, String url) {
                    if (swipeLayout.isRefreshing()) {
                        swipeLayout.setRefreshing(false);
                    }
                }
            });
            WebSettings webSettings = mainWebView.getSettings();
            webSettings.setJavaScriptEnabled(true);
            mainWebView.setScrollBarStyle(View.SCROLLBARS_INSIDE_OVERLAY);
            mainWebView.loadData(link, "text/html; charset=utf-8", "utf-8");
            swipeLayout = (SwipeRefreshLayout) findViewById(R.id.swipe_container);
            mainWebView.loadUrl(link);

        boolean connected = false;
        ConnectivityManager connectivityManager = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        if (connectivityManager.getNetworkInfo(ConnectivityManager.TYPE_MOBILE).getState() == NetworkInfo.State.CONNECTED ||
                connectivityManager.getNetworkInfo(ConnectivityManager.TYPE_WIFI).getState() == NetworkInfo.State.CONNECTED) {
            //we are connected to a network
            connected = true;
        } else
            connected = false;

        if (connected== false) {
            Context context = getApplicationContext();
            CharSequence text = "No Network Connection";
            int duration = Toast.LENGTH_SHORT;
            Toast toast = Toast.makeText(context, text, duration);
            toast.show();
        }
    }

    private class MyCustomWebViewClient extends WebViewClient {
        ProgressDialog pd = new ProgressDialog(Web.this);

        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url)
        {
            pd.setTitle("Please wait");
            pd.setMessage("Page is loading..");
            pd.show();
            view.loadUrl(url);
            return true;
        }
        @Override
        public void onPageFinished(WebView view, String url) {
            super.onPageFinished(view, url);
            pd.dismiss();
        }

    }
}
