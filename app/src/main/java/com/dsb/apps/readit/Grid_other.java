package com.dsb.apps.readit;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.Toast;

import com.suredigit.inappfeedback.FeedbackDialog;

import java.util.ArrayList;

import io.doorbell.android.Doorbell;

public class Grid_other extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    private GridViewAdapter mAdapter;
    private ArrayList<String> list;
    private ArrayList<String> image;
    private FeedbackDialog feedBack;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grid_other);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        feedBack = new FeedbackDialog(this, "AF-7A87FD4730F8-66");
        prepareList();
        mAdapter = new GridViewAdapter(this,list, image);

        // Set custom adapter to gridview
        GridView gridView = (GridView) findViewById(R.id.gridView1);
        gridView.setAdapter(mAdapter);

        // Implement On Item click listener
        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener()
        {
            @Override
            public void onItemClick(AdapterView<?> arg0, View arg1, int position,
                                    long arg3) {
                if (position ==0) {
                    String title="Mad, Mad World";
                    String link="http://timesofindia.indiatimes.com/rssfeeds/2178430.cms";
                    Intent intent = new Intent(Grid_other.this, MainActivity.class);
                    intent.putExtra("link",link);
                    intent.putExtra("title",title);
                    String feed_text="Times Of India";
                    String feed_link="http://media.148apps.com/icons/505094/505094_180.jpg";
                    intent.putExtra("feed_text",feed_text);
                    intent.putExtra("feed_link",feed_link);
                    startActivity(intent);
                }

                if (position ==1) {
                    String title="NBC News";
                    String link="http://feeds.nbcnews.com/feeds/topstories";
                    Intent intent = new Intent(Grid_other.this,MainActivity.class);
                    intent.putExtra("link",link);
                    intent.putExtra("title",title);
                    String feed_text="NBC News";
                    String feed_link="https://feed.mikle.com/images/NBC.png";
                    intent.putExtra("feed_text",feed_text);
                    intent.putExtra("feed_link",feed_link);
                    startActivity(intent);
                }
                if (position ==2) {
                    String title="Stocks";
                    String link="http://economictimes.indiatimes.com/markets/stocks/rssfeeds/2146842.cms";
                    Intent intent = new Intent(Grid_other.this,MainActivity.class);
                    intent.putExtra("link",link);
                    intent.putExtra("title",title);
                    String feed_text="Economic Times";
                    String feed_link="https://pbs.twimg.com/profile_images/3058389561/59776ba42f417ecab27de0262f048df3_400x400.jpeg";
                    intent.putExtra("feed_text",feed_text);
                    intent.putExtra("feed_link",feed_link);
                    startActivity(intent);
                }
                if (position ==3) {
                    String title="Market";
                    String link="http://economictimes.indiatimes.com/et-now/markets/rssfeedsvideo/4413330.cms";
                    Intent intent = new Intent(Grid_other.this,MainActivity.class);
                    intent.putExtra("link",link);
                    intent.putExtra("title",title);
                    String feed_text="Economic Times";
                    String feed_link="https://pbs.twimg.com/profile_images/3058389561/59776ba42f417ecab27de0262f048df3_400x400.jpeg";
                    intent.putExtra("feed_text",feed_text);
                    intent.putExtra("feed_link",feed_link);
                    startActivity(intent);
                }if (position ==4) {
                    String title="Defence";
                    String link="http://economictimes.indiatimes.com/news/defence/rssfeeds/46687796.cms";
                    Intent intent = new Intent(Grid_other.this,MainActivity.class);
                    intent.putExtra("link",link);
                    intent.putExtra("title",title);
                    String feed_text="Economic Times";
                    String feed_link="https://pbs.twimg.com/profile_images/3058389561/59776ba42f417ecab27de0262f048df3_400x400.jpeg";
                    intent.putExtra("feed_text",feed_text);
                    intent.putExtra("feed_link",feed_link);
                    startActivity(intent);
                }if (position ==5) {
                    String title="Investment";
                    String link="http://economictimes.indiatimes.com/slideshows/investments-markets/rssfeeds/17461695.cms";
                    Intent intent = new Intent(Grid_other.this,MainActivity.class);
                    intent.putExtra("link",link);
                    intent.putExtra("title",title);
                    String feed_text="Economic Times";
                    String feed_link="https://pbs.twimg.com/profile_images/3058389561/59776ba42f417ecab27de0262f048df3_400x400.jpeg";
                    intent.putExtra("feed_text",feed_text);
                    intent.putExtra("feed_link",feed_link);
                    startActivity(intent);
                }
                if (position ==6) {
                    String title="Offbeat";
                    String link="http://feeds.feedburner.com/ndtvnews-offbeat-news";
                    Intent intent = new Intent(Grid_other.this, MainActivity.class);
                    intent.putExtra("link",link);
                    intent.putExtra("title",title);
                    String feed_text="NDTV.com";
                    String feed_link="http://www.indiantelevision.com/sites/drupal7.indiantelevision.co.in/files/images/tv-images/2014/09/12/sdfrsd_1.png";
                    intent.putExtra("feed_text",feed_text);
                    intent.putExtra("feed_link",feed_link);
                    startActivity(intent);
                }
                Toast.makeText(Grid_other.this, mAdapter.getItem(position), Toast.LENGTH_SHORT).show();
            }
        });



        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open,R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
    }

    public void prepareList()
    {
        list = new ArrayList<String>();
        list.add("Mad, Mad World");
        list.add("NBC Top ");
        list.add("Stocks");
        list.add("Market");
        list.add("Defence");
        list.add("Investments");
        list.add("Offbeat");

        image = new ArrayList<String>();
        //image.add("http://www.harishanker.net/wp-content/uploads/2014/12/Indian-politics.jpg");
        image.add("http://cdn.images.express.co.uk/img/dynamic/151/590x/secondary/UFO-Hillary-427995.jpg");
        image.add("https://feed.mikle.com/images/NBC.png");
        image.add("https://assets.entrepreneur.com/content/16x9/822/20150710182041-china-chinesse-stock-market-stocks.jpeg");
        image.add("http://images.all-free-download.com/images/graphicthumb/stock_market_514592.jpg");
        image.add("http://www.defenceweb.co.za/images/stories/Tiger_Abrahams_400.jpg");
        image.add("http://s3.india.com/wp-content/uploads/2015/02/investment-options.jpg");
        image.add("https://pbs.twimg.com/profile_images/1472715503/offbeatsquare.png");
    }
    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if(id== R.id.start_page){

            Intent i=new Intent(Grid_other.this,StartActivity.class);
            i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
            startActivity(i);
        }else if (id == R.id.inter) {
            Intent intent = new Intent(Grid_other.this,Grid_int.class);
            startActivity(intent);
        }else if (id == R.id.sports) {
            Intent intent = new Intent(Grid_other.this,Grid_sports.class);
            startActivity(intent);
        } else if (id == R.id.tech) {
            Intent intent = new Intent(Grid_other.this,Grid_Tech.class);
            startActivity(intent);
        }
        else if (id == R.id.ent) {
            Intent intent = new Intent(Grid_other.this, Grid_ent.class);
            startActivity(intent);
        }else if (id == R.id.life) {
            Intent intent = new Intent(Grid_other.this, Grid_life.class);
            startActivity(intent);
        }else if (id == R.id.other) {
            Intent intent = new Intent(Grid_other.this, Grid_other.class);
            startActivity(intent);
        }
        else if (id == R.id.rate_us) {
            final Uri marketUri = Uri.parse("market://details?id=" + "com.dsb.apps.readit");
            startActivity(new Intent(Intent.ACTION_VIEW, marketUri));

        } else if (id == R.id.about_us) {

            Intent intent = new Intent(Grid_other.this,FaqActivity.class);
            startActivity(intent);

        } else if (id == R.id.feedback) {

            new Doorbell(this, 3938, "nOnmWddPUW9PUgTXafNuZoveYas6OlpkqzT1eqyIAc7CWuWOXTvs68mM1LwxjrvU").show();

        } else if (id == R.id.share_app) {
            Intent sharingIntent = new Intent(android.content.Intent.ACTION_SEND);
            sharingIntent.setType("text/plain");
            String link = "ReadIt: News Reader is a great app. Find all the latest news here .";
            sharingIntent.putExtra(android.content.Intent.EXTRA_SUBJECT, "Subject Here");
            link =link +"\n" + "https://play.google.com/store/apps/details?id=com.dsb.apps.readit";
            sharingIntent.putExtra(android.content.Intent.EXTRA_TEXT, link);
            startActivity(Intent.createChooser(sharingIntent, "Share via"));

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
