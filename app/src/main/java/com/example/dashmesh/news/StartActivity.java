package com.example.dashmesh.news;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.ParseException;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.common.api.GoogleApiClient;
import com.kobakei.ratethisapp.RateThisApp;
import com.squareup.picasso.Picasso;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import io.doorbell.android.Doorbell;

public class StartActivity extends AppCompatActivity implements  AdapterView.OnItemClickListener, NavigationView.OnNavigationItemSelectedListener {
    private ListView mRssListView;
    private NewsFeedParser mNewsFeeder;
    private List<RSSFeed> mRssFeedList;
    private RssAdapter mRssAdap;
    private StartActivity local;
    //private  static final String TOPSTORIES2 = "http://indianexpress.com/print/front-page/feed/";
    //private  static final String TOPSTORIES2 = "http://www.amazon.com/rss/movers-and-shakers/electronics/ref=pd_ms_rss_link&tag=seasrev-20";
    private  static final String TOPSTORIES2 = "http://feeds.bbci.co.uk/news/world/rss.xml";
    private GoogleApiClient client;
    private SwipeRefreshLayout mSwipeRefreshLayout;
    private SwipeRefreshLayout swipeLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start_drawer);
        Toolbar myToolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(myToolbar);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, myToolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);



        swipeLayout = (SwipeRefreshLayout) findViewById(R.id.swipe_container);


        MobileAds.initialize(getApplicationContext(), "ca-app-pub-5488583213676305~4783501875");
        AdView mAdView = (AdView) findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        //mAdView.loadAd(adRequest);
        boolean connected = false;
        ConnectivityManager connectivityManager = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        if (connectivityManager.getNetworkInfo(ConnectivityManager.TYPE_MOBILE).getState() == NetworkInfo.State.CONNECTED ||
                connectivityManager.getNetworkInfo(ConnectivityManager.TYPE_WIFI).getState() == NetworkInfo.State.CONNECTED) {
            //we are connected to a network
            connected = true;
        } else
            connected = false;
        local= this;
        if (connected == true) {
            mRssListView = (ListView) findViewById(R.id.listView);
            mRssFeedList = new ArrayList<RSSFeed>();
            new DoRssFeedTask().execute(TOPSTORIES2);
            mRssListView.setOnItemLongClickListener (new AdapterView.OnItemLongClickListener() {
                @Override
                public boolean onItemLongClick(AdapterView parent, View view, final int position, long id) {
                    view.getFocusables(position);
                    view.setSelected(true);
                    String stringuri = (Uri.parse(mRssFeedList.get(position).getLink())).toString();
                    Intent sharingIntent = new Intent(android.content.Intent.ACTION_SEND);
                    sharingIntent.setType("text/plain");
                    String title = (Uri.parse(mRssFeedList.get(position).getTitle())).toString();
                    sharingIntent.putExtra(android.content.Intent.EXTRA_SUBJECT, "Subject Here");
                    //sharingIntent.putExtra(android.content.Intent.EXTRA_TEXT, shareBody);
                    title =title +"\n"+ stringuri;
                    String via="Shared via:News Feeder: app_link";
                    title=title + "\n" + via;
                    sharingIntent.putExtra(android.content.Intent.EXTRA_TEXT, title);
                    startActivity(Intent.createChooser(sharingIntent, "Share via"));
                    //Context context = getApplicationContext();
                    //CharSequence text = "long pressed";
                    //int duration = Toast.LENGTH_SHORT;
                    //Toast toast = Toast.makeText(context, link, duration);
                    //toast.show();
                    return true;
                }
            });
            mRssListView.setOnItemClickListener(this);

            mAdView.loadAd(adRequest);
            swipeLayout.setOnRefreshListener(
                    new SwipeRefreshLayout.OnRefreshListener() {
                        @Override
                        public void onRefresh() {
                            Log.i("LOG_TAG", "onRefresh called from SwipeRefreshLayout");
                            if(swipeLayout.isRefreshing()) {
                                swipeLayout.setRefreshing(false);
                            }
                        }
                    });


        } else {
            Context context = getApplicationContext();
            CharSequence text = "No Network Connection";
            int duration = Toast.LENGTH_SHORT;

            Toast toast = Toast.makeText(context, text, duration);
            toast.show();
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
            if(swipeLayout.isRefreshing()) {
                swipeLayout.setRefreshing(false);
            }
        }


        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client = new GoogleApiClient.Builder(this).addApi(AppIndex.API).build();

    }

    public  void myUpdateOperation() {
        boolean connected = false;
        ConnectivityManager connectivityManager = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        if (connectivityManager.getNetworkInfo(ConnectivityManager.TYPE_MOBILE).getState() == NetworkInfo.State.CONNECTED ||
                connectivityManager.getNetworkInfo(ConnectivityManager.TYPE_WIFI).getState() == NetworkInfo.State.CONNECTED) {
            //we are connected to a network
            connected = true;
        } else
            connected = false;

        if (connected == true) {

            MobileAds.initialize(getApplicationContext(), "ca-app-pub-5488583213676305~4783501875");
            AdView mAdView = (AdView) findViewById(R.id.adView);
            AdRequest adRequest = new AdRequest.Builder().build();

            Intent intent = getIntent();

            String TOPSTORIES = intent.getStringExtra("link");
            String title = intent.getStringExtra("title");
            mRssListView = (ListView) findViewById(R.id.listView);
            mRssFeedList = new ArrayList<RSSFeed>();
            new DoRssFeedTask().execute(TOPSTORIES);
            mRssListView.setOnItemClickListener(this);
            mRssListView.setOnItemLongClickListener (new AdapterView.OnItemLongClickListener() {
                public boolean onItemLongClick(AdapterView parent, View view, final int position, long id) {
                    view.getFocusables(position);
                    view.setSelected(true);
                    String stringuri = (Uri.parse(mRssFeedList.get(position).getLink())).toString();
                    Intent sharingIntent = new Intent(android.content.Intent.ACTION_SEND);
                    sharingIntent.setType("text/plain");
                    String title = (Uri.parse(mRssFeedList.get(position).getTitle())).toString();
                    sharingIntent.putExtra(android.content.Intent.EXTRA_SUBJECT, "Subject Here");
                    //sharingIntent.putExtra(android.content.Intent.EXTRA_TEXT, shareBody);
                    title =title +"\n"+ stringuri;
                    String via="Shared via:News Feeder: app_link";
                    title=title + "\n" + via;
                    sharingIntent.putExtra(android.content.Intent.EXTRA_TEXT, title);
                    startActivity(Intent.createChooser(sharingIntent, "Share via"));
                    //Context context = getApplicationContext();
                    //CharSequence text = "long pressed";
                    //int duration = Toast.LENGTH_SHORT;
                    //Toast toast = Toast.makeText(context, link, duration);
                    //toast.show();
                    return true;
                }
            });

            mAdView.loadAd(adRequest);
            if (swipeLayout.isRefreshing()) {
                swipeLayout.setRefreshing(false);
            }
        }
        else {
            Context context = getApplicationContext();
            CharSequence text = "No Network Connection";
            int duration = Toast.LENGTH_SHORT;
            Toast toast = Toast.makeText(context, text, duration);
            toast.show();

        }
        if (swipeLayout.isRefreshing()) {
            swipeLayout.setRefreshing(false);
        }
    }
    boolean doubleBackToExitPressedOnce = false;
    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        }
        if (doubleBackToExitPressedOnce) {
            super.onBackPressed();
            return;
        }

        this.doubleBackToExitPressedOnce = true;
        Toast.makeText(this, "Please click BACK again to exit", Toast.LENGTH_SHORT).show();

        new Handler().postDelayed(new Runnable() {

            @Override
            public void run() {
                doubleBackToExitPressedOnce=false;
            }
        }, 2000);
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                super.onBackPressed();
                //this.finish();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.inter) {
            Intent intent = new Intent(StartActivity.this,Grid_int.class);
            startActivity(intent);
        }else if (id == R.id.sports) {
            Intent intent = new Intent(StartActivity.this,Grid_sports.class);
            startActivity(intent);
        }
        else if (id == R.id.tech) {
            Intent intent = new Intent(StartActivity.this,Grid_Tech.class);
            startActivity(intent);
        }
        else if (id == R.id.ent) {
            Intent intent = new Intent(StartActivity.this, Grid_ent.class);
            startActivity(intent);
        }else if (id == R.id.life) {
            Intent intent = new Intent(StartActivity.this, Grid_life.class);
            startActivity(intent);
        }else if (id == R.id.other) {
            Intent intent = new Intent(StartActivity.this, Grid_other.class);
            startActivity(intent);
        }
        else if (id == R.id.rate_us) {
            final Uri marketUri = Uri.parse("market://details?id=" + "com.example.dashmesh.news");
            startActivity(new Intent(Intent.ACTION_VIEW, marketUri));


        } else if (id == R.id.about_us) {
            Intent intent = new Intent(StartActivity.this,FaqActivity.class);
            startActivity(intent);

        } else if (id == R.id.feedback) {

            new Doorbell(this, 3938, "nOnmWddPUW9PUgTXafNuZoveYas6OlpkqzT1eqyIAc7CWuWOXTvs68mM1LwxjrvU").show();
        } else if (id == R.id.share_app) {
            Intent sharingIntent = new Intent(android.content.Intent.ACTION_SEND);
            sharingIntent.setType("text/plain");
            String link = "This is a great news reader app Try this";
            sharingIntent.putExtra(android.content.Intent.EXTRA_SUBJECT, "Subject Here");
            //sharingIntent.putExtra(android.content.Intent.EXTRA_TEXT, shareBody);
            link =link + "app_link";
            sharingIntent.putExtra(android.content.Intent.EXTRA_TEXT, link);
            startActivity(Intent.createChooser(sharingIntent, "Share via"));
        }
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    @Override
    public void onStart() {
        super.onStart();

        // Monitor launch times and interval from installation
        RateThisApp.onStart(this);
        // If the criteria is satisfied, "Rate this app" dialog will be shown
        RateThisApp.showRateDialogIfNeeded(this);
        RateThisApp.Config config = new RateThisApp.Config(3, 5);
// Custom title ,message and buttons names
        //config.setTitle(R.string.my_own_title);
        //config.setMessage(R.string.my_own_message);
        //config.setYesButtonText(R.string.my_own_rate);
       // config.setNoButtonText(R.string.my_own_thanks);
       // config.setCancelButtonText(R.string.my_own_cancel);
        //RateThisApp.init(config);

        RateThisApp.setCallback(new RateThisApp.Callback() {
            @Override
            public void onYesClicked() {
                Toast.makeText(StartActivity.this, "Yes event", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNoClicked() {
                Toast.makeText(StartActivity.this, "No event", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onCancelClicked() {
                Toast.makeText(StartActivity.this, "Cancel event", Toast.LENGTH_SHORT).show();
            }
        });
        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client.connect();
        Action viewAction = Action.newAction(
                Action.TYPE_VIEW, // TODO: choose an action type.
                "Main Page", // TODO: Define a title for the content shown.
                // TODO: If you have web page content that matches this app activity's content,
                // make sure this auto-generated web page URL is correct.
                // Otherwise, set the URL to null.
                Uri.parse("http://host/path"),
                // TODO: Make sure this auto-generated app URL is correct.
                Uri.parse("android-app://com.example.dashmesh.news/http/host/path")
        );
        AppIndex.AppIndexApi.start(client, viewAction);
    }

    @Override
    public void onStop() {
        super.onStop();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        Action viewAction = Action.newAction(
                Action.TYPE_VIEW, // TODO: choose an action type.
                "Main Page", // TODO: Define a title for the content shown.
                // TODO: If you have web page content that matches this app activity's content,
                // make sure this auto-generated web page URL is correct.
                // Otherwise, set the URL to null.
                Uri.parse("http://host/path"),
                // TODO: Make sure this auto-generated app URL is correct.
                Uri.parse("android-app://com.example.dashmesh.news/http/host/path")
        );
        AppIndex.AppIndexApi.end(client, viewAction);
        client.disconnect();
    }

    public static int daysBetween(Date startDate, Date endDate) {
        int daysBetween = 0;
        while (startDate.before(endDate)) {
            startDate.setTime(startDate.getTime() + 86400000);
            daysBetween++;
        }
        return daysBetween;
    }
    private class RssAdapter extends ArrayAdapter<RSSFeed> {
        private List<RSSFeed> rssFeedLst;

        public RssAdapter(Context context, int textViewResourceId, List<RSSFeed> rssFeedLst) {
            super(context, textViewResourceId, rssFeedLst);
            this.rssFeedLst = rssFeedLst;
        }
        @Override
        public int  getCount(){
            return 30;
        }

        //public  CharSequence getDate(String date) {
         //   return DateUtils.getRelativeTimeSpanString (Long.parseLong(date), System.currentTimeMillis(), DateUtils.SECOND_IN_MILLIS, 0);
      //  }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {

            View view = convertView;
            RssHolder rssHolder = null;
            if (convertView == null) {
                view = View.inflate(StartActivity.this, R.layout.rss_list_item, null);
                rssHolder = new RssHolder();
                rssHolder.rssTitleView = (TextView) view.findViewById(R.id.rss_title_view);
                view.setTag(rssHolder);
                rssHolder.rssDescView = (TextView) view.findViewById(R.id.rss_desc_view);
                view.setTag(rssHolder);
                rssHolder.rsspubidView = (TextView) view.findViewById(R.id.rss_pubid_view);
                view.setTag(rssHolder);
                rssHolder.image1 = (ImageView) view.findViewById(R.id.thumbImage);
                view.setTag(rssHolder);
                rssHolder.category = (TextView) view.findViewById(R.id.category);
                view.setTag(rssHolder);
                rssHolder.image2 = (ImageView) view.findViewById(R.id.feed_image);
                view.setTag(rssHolder);
                rssHolder.feed_text = (TextView) view.findViewById(R.id.feed_text);
                view.setTag(rssHolder);
            } else {
                rssHolder = (RssHolder) view.getTag();
            }
            RSSFeed rssFeed = rssFeedLst.get(position);

            rssHolder.rssTitleView.setText(rssFeed.getTitle());
            rssHolder.rssDescView.setText(rssFeed.getDescription());
            rssHolder.category.setText(rssFeed.getCategory());
            String thumbnail = rssFeed.getThumbnail();
            Log.d(thumbnail, "getView");
            Picasso.with(getBaseContext()).load("https://pbs.twimg.com/profile_images/662708106/bbc.png").into(rssHolder.image2);
            String feed="BBC News";
            rssHolder.feed_text.setText(feed);
            Picasso.with(getBaseContext()).load(thumbnail).resize(520,292).into(rssHolder.image1);
            String dateString=rssFeed.getPubDate();
            SimpleDateFormat sdf = new SimpleDateFormat("EEE, dd MMM yyyy HH:mm:ss z", Locale.US);
            Date date = null;
            try {
                date = sdf.parse(dateString);
                String timeOfDay = new SimpleDateFormat("HH:mm").format(date);
                java.sql.Timestamp timeStampDate = new java.sql.Timestamp(date.getTime());
                java.sql.Timestamp timeStampNow = new java.sql.Timestamp(new java.util.Date().getTime());

                long secondDiff = timeStampNow.getTime() / 1000 - timeStampDate.getTime() / 1000;
                int minuteDiff = (int) (secondDiff / 60);
                int hourDiff = (int) (secondDiff / 3600);
                int dayDiff = daysBetween(date, new Date()) - 1;
                if (dayDiff > 0) {
                     String x=dayDiff + " days ago @ " + timeOfDay;
                    rssHolder.rsspubidView.setText(x);
                } else if (hourDiff > 0) {
                    String x=hourDiff + " hour(s) ago @ " + timeOfDay;
                    rssHolder.rsspubidView.setText(x);
                } else if (minuteDiff > 0) {
                    String x=minuteDiff + " minute(s) ago @ " + timeOfDay;
                    rssHolder.rsspubidView.setText(x);
                } else if (secondDiff > 0) {
                    String x=secondDiff + " second(s) ago @ " + timeOfDay;
                    rssHolder.rsspubidView.setText(x);
                }
            }  catch (ParseException | java.text.ParseException e) {
                e.printStackTrace();
            }

            //rssHolder.rsspubidView.setText(x);
            return view;
        }
    }


    static class RssHolder {
        public TextView rsspubidView;
        public TextView rssTitleView;
        public TextView rssDescView;
        public ImageView image1;
        public TextView category;
        public ImageView image2;
        public TextView feed_text;
    }

    public class DoRssFeedTask extends AsyncTask<String, Void, List<RSSFeed>> {
        ProgressDialog prog;
        String jsonStr = null;
        Handler innerHandler;

        @Override
        protected void onPreExecute() {
            prog = new ProgressDialog(StartActivity.this);
            prog.setMessage("Loading....");
            prog.show();
        }

        @Override
        protected List<RSSFeed> doInBackground(String... params) {
            for (String urlVal : params) {
                mNewsFeeder = new NewsFeedParser(urlVal);
            }
            mRssFeedList = mNewsFeeder.parse();

            return mRssFeedList;
        }

        @Override
        protected void onPostExecute(List<RSSFeed> result) {
            prog.dismiss();
            runOnUiThread(new Runnable() {

                @Override
                public void run() {
                    mRssAdap = new RssAdapter(StartActivity.this, R.layout.rss_list_item,
                            mRssFeedList);
                    int count = mRssAdap.getCount();
                    if (count != 0 && mRssAdap != null) {
                        mRssListView.setAdapter(mRssAdap);
                    }
                }
            });
        }

        @Override
        protected void onProgressUpdate(Void... values) {
        }
    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View v, int position, long id) {

            String stringuri = (Uri.parse(mRssFeedList.get(position).getLink())).toString();
        String title = (Uri.parse(mRssFeedList.get(position).getTitle())).toString();


        Intent i = new Intent(this, Web.class);
        i.putExtra("link", stringuri);
        i.putExtra("title",title);
        startActivity(i);

        /*
        String stringuri = (Uri.parse(mRssFeedList.get(position).getLink())).toString();
        Intent i = new Intent(this, Web2.class);
        i.putExtra("link", stringuri);
        startActivity(i);
    */
    }

}