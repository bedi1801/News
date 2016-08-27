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

public class Grid_Tech extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    private GridViewAdapter mAdapter;
    private ArrayList<String> list;
    private ArrayList<String> image;
    private FeedbackDialog feedBack;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grid__tech);
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
                    String title="Technology";
                    String link="http://indianexpress.com/section/technology/feed/";
                    Intent intent = new Intent(Grid_Tech.this, MainActivity.class);
                    intent.putExtra("link",link);
                    intent.putExtra("title",title);
                    String feed_text="INDIANEXPRESS.COM";
                    String feed_link="https://pbs.twimg.com/profile_images/1850193578/IE_Square_Logo.png";
                    intent.putExtra("feed_text",feed_text);
                    intent.putExtra("feed_link",feed_link);
                    startActivity(intent);
                }if (position ==1) {
                    String title="CNET:Tech ";
                    String link="http://www.cnet.com/rss/news/";
                    Intent intent = new Intent(Grid_Tech.this, MainActivity.class);
                    intent.putExtra("link",link);
                    intent.putExtra("title",title);
                    String feed_text="CNET News";
                    String feed_link="http://logonoid.com/images/cnet-logo.png";
                    intent.putExtra("feed_text",feed_text);
                    intent.putExtra("feed_link",feed_link);
                    startActivity(intent);
                }if (position ==2) {
                    String title="Mobile";
                    String link="http://feeds.feedburner.com/Mobilecrunch";
                    Intent intent = new Intent(Grid_Tech.this, MainActivity.class);
                    intent.putExtra("link",link);
                    intent.putExtra("title",title);
                    String feed_text="Tech Crunch";
                    String feed_link="https://pbs.twimg.com/profile_images/615392662233808896/EtxjSSKk_400x400.jpg";
                    intent.putExtra("feed_text",feed_text);
                    intent.putExtra("feed_link",feed_link);

                    startActivity(intent);
                }if (position ==3) {
                    String title="Gaming";
                    String link="http://www.cnet.com/rss/gaming/";
                    Intent intent = new Intent(Grid_Tech.this, MainActivity.class);
                    intent.putExtra("link",link);
                    intent.putExtra("title",title);
                    String feed_text="CNET News";
                    String feed_link="http://logonoid.com/images/cnet-logo.png";
                    intent.putExtra("feed_text",feed_text);
                    intent.putExtra("feed_link",feed_link);
                    startActivity(intent);
                }if (position ==4) {
                    String title="CNET Reviews";
                    String link="http://www.cnet.com/rss/reviews/";
                    Intent intent = new Intent(Grid_Tech.this, MainActivity.class);
                    intent.putExtra("link",link);
                    intent.putExtra("title",title);
                    String feed_text="CNET News";
                    String feed_link="http://logonoid.com/images/cnet-logo.png";
                    intent.putExtra("feed_text",feed_text);
                    intent.putExtra("feed_link",feed_link);
                    startActivity(intent);
                }if (position ==5) {
                    String title="Science";
                    String link="http://feeds.bbci.co.uk/news/science_and_environment/rss.xml";
                    Intent intent = new Intent(Grid_Tech.this, MainActivity.class);
                    intent.putExtra("link",link);
                    intent.putExtra("title",title);
                    String feed_text="BBC News";
                    String feed_link="https://pbs.twimg.com/profile_images/662708106/bbc.png";
                    intent.putExtra("feed_text",feed_text);
                    intent.putExtra("feed_link",feed_link);
                    startActivity(intent);
                }if (position ==6) {
                    String title="Auto";
                    String link="http://feeds.feedburner.com/carandbike-latest";
                    Intent intent = new Intent(Grid_Tech.this, MainActivity.class);
                    intent.putExtra("link",link);
                    intent.putExtra("title",title);
                    String feed_text="NDTV.com";
                    String feed_link="http://www.indiantelevision.com/sites/drupal7.indiantelevision.co.in/files/images/tv-images/2014/09/12/sdfrsd_1.png";
                    intent.putExtra("feed_text",feed_text);
                    intent.putExtra("feed_link",feed_link);
                    startActivity(intent);
                }
                if (position ==7) {
                    String title="BBC:Tech";
                    String link="http://feeds.bbci.co.uk/news/technology/rss.xml";
                    Intent intent = new Intent(Grid_Tech.this, MainActivity.class);
                    intent.putExtra("link",link);
                    intent.putExtra("title",title);
                    String feed_text="BBC News";
                    String feed_link="https://pbs.twimg.com/profile_images/662708106/bbc.png";
                    intent.putExtra("feed_text",feed_text);
                    intent.putExtra("feed_link",feed_link);
                    startActivity(intent);
                }if (position ==8) {
                    String title="Internet";
                    String link="http://economictimes.indiatimes.com/tech/internet/rssfeeds/13357549.cms";
                    Intent intent = new Intent(Grid_Tech.this, MainActivity.class);
                    intent.putExtra("link",link);
                    intent.putExtra("title",title);
                    String feed_text="Economic Times";
                    String feed_link="https://pbs.twimg.com/profile_images/3058389561/59776ba42f417ecab27de0262f048df3_400x400.jpeg";
                    intent.putExtra("feed_text",feed_text);
                    intent.putExtra("feed_link",feed_link);
                    startActivity(intent);
                }
                if (position ==9) {
                    String title="Nasa";
                    String link="https://www.nasa.gov/rss/dyn/breaking_news.rss";
                    Intent intent = new Intent(Grid_Tech.this, MainActivity.class);
                    intent.putExtra("link",link);
                    intent.putExtra("title",title);
                    String feed_text="NASA News";
                    String feed_link="http://editorial.designtaxi.com/editorial-images/news-logos141015/2.jpg";
                    intent.putExtra("feed_text",feed_text);
                    intent.putExtra("feed_link",feed_link);
                    startActivity(intent);
                }


                Toast.makeText(Grid_Tech.this, mAdapter.getItem(position), Toast.LENGTH_SHORT).show();
            }
        });



        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar,R.string.navigation_drawer_open,R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
    }

    public void prepareList()
    {
        list = new ArrayList<String>();
        list.add("Technology");
        list.add("CNET:Tech");
        list.add("Mobile");
        list.add("Gaming");
        list.add("Reviews");
        list.add("Science");
        list.add("Auto");
        list.add("BBC:Tech");
        list.add("Internet");
        list.add("Nasa");

        image = new ArrayList<String>();
        image.add("http://www.managementguru.net/wp-content/uploads/2014/03/technology.jpg");
        image.add("http://static3.businessinsider.com/image/4d4c5d5849e2ae3951030000-480/google-pittsburgh.jpg");
        image.add("http://www.androidcentral.com/sites/androidcentral.com/files/styles/w800h450crop/public/article_images/2015/03/podcast-ac-new_2.jpg?itok=0wcOMHZD");
        image.add("http://www.igyaan.in/wp-content/uploads/2015/10/Gaming.jpg");
        image.add("https://d.ibtimes.co.uk/en/full/1453627/samsung-galaxy-s6-edge-plus.jpg");
        image.add("http://www.diamond.ac.uk/Home/News/LatestFeatures/06_06_15/content/06/text_files/file/document/Science%20of%20Pain.jpg");
        image.add("http://www.infosperber.ch/data/dms/media/large/AutoPiktogramm.png");
        image.add("http://ichef-1.bbci.co.uk/news/660/cpsprodpb/17179/production/_87258549_microsoft.gif");
        image.add("http://www.itguyswa.com.au/wp-content/uploads/2015/11/the-internet.jpg");
        image.add("https://assets.entrepreneur.com/content/16x9/822/20150323213749-fun-employee-nasa-space-launch-astronaut-exploration-moon-stars-start.jpeg");

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

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if(id== R.id.start_page){

            Intent i=new Intent(Grid_Tech.this,StartActivity.class);
            i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
            startActivity(i);
        }else if (id == R.id.inter) {
            Intent intent = new Intent(Grid_Tech.this,Grid_int.class);
            startActivity(intent);
        }else if (id ==R.id.sports) {
            Intent intent = new Intent(Grid_Tech.this,Grid_sports.class);
            startActivity(intent);
        } else if (id == R.id.tech) {
            Intent intent = new Intent(Grid_Tech.this,Grid_Tech.class);
            startActivity(intent);
        }
        else if (id == R.id.ent) {
            Intent intent = new Intent(Grid_Tech.this, Grid_ent.class);
            startActivity(intent);
        }else if (id == R.id.life) {
            Intent intent = new Intent(Grid_Tech.this, Grid_life.class);
            startActivity(intent);
        }else if (id == R.id.other) {
            Intent intent = new Intent(Grid_Tech.this, Grid_other.class);
            startActivity(intent);
        }
        else if (id == R.id.rate_us) {
            final Uri marketUri = Uri.parse("market://details?id=" + "com.dsb.apps.readit");
            startActivity(new Intent(Intent.ACTION_VIEW, marketUri));

        } else if (id == R.id.about_us) {

            Intent intent = new Intent(Grid_Tech.this,FaqActivity.class);
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
