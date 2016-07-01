package com.example.dashmesh.news;

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

public class Grid_sports extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    private GridViewAdapter mAdapter;
    private ArrayList<String> list;
    private ArrayList<String> image;
    private FeedbackDialog feedBack;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grid_sports);
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
                    String link="http://indianexpress.com/section/sports/feed/";
                    String title="World";
                    Intent intent = new Intent(Grid_sports.this, MainActivity.class);
                    intent.putExtra("link",link);
                    intent.putExtra("title",title);
                    String feed_text="INDIANEXPRESS.COM";
                    String feed_link="https://pbs.twimg.com/profile_images/1850193578/IE_Square_Logo.png";
                    intent.putExtra("feed_text",feed_text);
                    intent.putExtra("feed_link",feed_link);
                    startActivity(intent);
                }
                if (position ==1) {
                    String link="http://rss.cnn.com/rss/edition_sport.rss";
                    String title="CNN: Sports";
                    Intent intent = new Intent(Grid_sports.this, MainActivity_Media.class);
                    intent.putExtra("link",link);
                    intent.putExtra("title",title);
                    String feed_text="CNN.com";
                    String feed_link="http://logodatabases.com/wp-content/uploads/2012/03/cnn-logo-icon.png";
                    intent.putExtra("feed_text",feed_text);
                    intent.putExtra("feed_link",feed_link);
                    startActivity(intent);
                }
                if (position ==2) {
                    String link="http://indianexpress.com/section/sports/football/feed/";
                    //String link="http://www.news18.com/rss/football.xml";
                    String title="Football";
                    Intent intent = new Intent(Grid_sports.this, MainActivity.class);
                    intent.putExtra("link",link);
                    intent.putExtra("title",title);
                    String feed_text="INDIANEXPRESS.COM";
                    String feed_link="https://pbs.twimg.com/profile_images/1850193578/IE_Square_Logo.png";
                    intent.putExtra("feed_text",feed_text);
                    intent.putExtra("feed_link",feed_link);
                    startActivity(intent);
                }
                if (position ==3) {
                    String link="http://indianexpress.com/section/sports/cricket/feed/";
                    String title="Cricket";
                    Intent intent = new Intent(Grid_sports.this, MainActivity.class);
                    intent.putExtra("title",title);
                    intent.putExtra("link",link);
                    String feed_text="INDIANEXPRESS.COM";
                    String feed_link="https://pbs.twimg.com/profile_images/1850193578/IE_Square_Logo.png";
                    intent.putExtra("feed_text",feed_text);
                    intent.putExtra("feed_link",feed_link);
                    startActivity(intent);
                }
                if (position ==4) {
                    String link="http://indianexpress.com/section/sports/tennis/feed/";
                    String title="Tennis";
                    Intent intent = new Intent(Grid_sports.this, MainActivity.class);
                    intent.putExtra("link",link);
                    intent.putExtra("title",title);
                    String feed_text="INDIANEXPRESS.COM";
                    String feed_link="https://pbs.twimg.com/profile_images/1850193578/IE_Square_Logo.png";
                    intent.putExtra("feed_text",feed_text);
                    intent.putExtra("feed_link",feed_link);
                    startActivity(intent);
                }if (position ==5) {
                    String link="http://rss.cnn.com/rss/edition_golf.rss";
                    String title="Golf";
                    Intent intent = new Intent(Grid_sports.this, MainActivity_Media.class);
                    intent.putExtra("title",title);
                    intent.putExtra("link",link);
                    String feed_text="CNN.com";
                    String feed_link="http://logodatabases.com/wp-content/uploads/2012/03/cnn-logo-icon.png";
                    intent.putExtra("feed_text",feed_text);
                    intent.putExtra("feed_link",feed_link);
                    startActivity(intent);
                }if (position ==6) {
                    String link="http://rss.cnn.com/rss/edition_motorsport.rss";
                    String title="MotorSports";
                    Intent intent = new Intent(Grid_sports.this, MainActivity_Media.class);
                    intent.putExtra("title",title);
                    intent.putExtra("link",link);
                    String feed_text="CNN.com";
                    String feed_link="http://logodatabases.com/wp-content/uploads/2012/03/cnn-logo-icon.png";
                    intent.putExtra("feed_text",feed_text);
                    intent.putExtra("feed_link",feed_link);
                    startActivity(intent);
                }if (position ==7) {
                    String link="http://indianexpress.com/section/sports/sport-others/feed/";
                    String title="Other Sports";
                    Intent intent = new Intent(Grid_sports.this, MainActivity.class);
                    intent.putExtra("link",link);
                    intent.putExtra("title",title);
                    String feed_text="INDIANEXPRESS.COM";
                    String feed_link="https://pbs.twimg.com/profile_images/1850193578/IE_Square_Logo.png";
                    intent.putExtra("feed_text",feed_text);
                    intent.putExtra("feed_link",feed_link);
                    startActivity(intent);
                }if (position ==8) {
                    String link="http://www.manchestereveningnews.co.uk/all-about/manchester-city-fc?service=rss";
                    String title="Manchester City";
                    Intent intent = new Intent(Grid_sports.this, MainActivity_Media.class);
                    intent.putExtra("link",link);
                    intent.putExtra("title",title);
                    String feed_text="MANCHESTER EVENING NEWS";
                    String feed_link="http://www.thecreaturecomfort.com/wordpress/wp-content/uploads/2013/08/Manchester-Evening-News.jpg";
                    intent.putExtra("feed_text",feed_text);
                    intent.putExtra("feed_link",feed_link);
                    startActivity(intent);
                }
                Toast.makeText(Grid_sports.this, mAdapter.getItem(position), Toast.LENGTH_SHORT).show();
            }
        });



        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
    }

    public void prepareList()
    {
        list = new ArrayList<String>();

        list.add("World Sports");
        list.add("Sports:CNN");
        list.add("Football");
        list.add("Cricket");
        list.add("Tennis");
        list.add("Golf");
        list.add("Motorsports");
        list.add("Other Sports");
        list.add("Manchester City");

        image = new ArrayList<String>();
        image.add("http://www.weeklytimesofindia.com/wp-content/uploads/2012/02/FIFA-World-Cup-Trophy.jpg");
        image.add("https://i.ytimg.com/vi/tfwnBkMr78Y/maxresdefault.jpg");
        image.add("http://www.chestertonsportscentre.org.uk/wp-content/uploads/2015/05/Football.jpg");
        image.add("http://cdn.theunlockr.com/wp-content/uploads/2011/12/cricket_logo_rev-820x344.gif");
        image.add("http://i2.cdn.turner.com/cnnnext/dam/assets/160118110422-australian-open-court-view-2016-super-169.jpg");
        image.add("https://2.bp.blogspot.com/-HIDa2tqOMns/V1BABm1EzFI/AAAAAAAACJ4/2Xup3mmcEAYmJ3zQIGlXi43ENpHZJZWxgCLcB/s1600/golfer%2Bat%2Bsunset.jpg");
        image.add("http://images.thecarconnection.com/med/french-grand-prix-canceled-as-french-motorsports-federation-drops-backing_100186505_m.jpg");
        image.add("http://static1.squarespace.com/static/513f55cfe4b09478fd2a780a/513f55cfe4b09478fd2a7810/53593e8ee4b09312a903ea75/1398358360380/Olympic+Flag.jpg?format=1000w");
        image.add("http://e1.365dm.com/15/12/16-9/20/manchester-city-new-club-badge-big-screen-etihad_3392198.jpg?20151226152621");
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
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if(id== R.id.start_page){

            Intent i=new Intent(Grid_sports.this,StartActivity.class);
            i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
            startActivity(i);
        }else if (id == R.id.inter) {
            Intent intent = new Intent(Grid_sports.this,Grid_int.class);
            startActivity(intent);
        }else if (id == R.id.sports) {
            Intent intent = new Intent(Grid_sports.this,Grid_sports.class);
            startActivity(intent);
        } else if (id == R.id.tech) {
            Intent intent = new Intent(Grid_sports.this,Grid_Tech.class);
            startActivity(intent);
        }
        else if (id == R.id.ent) {
            Intent intent = new Intent(Grid_sports.this, Grid_ent.class);
            startActivity(intent);
        }else if (id == R.id.life) {
            Intent intent = new Intent(Grid_sports.this, Grid_life.class);
            startActivity(intent);
        }else if (id == R.id.other) {
            Intent intent = new Intent(Grid_sports.this, Grid_other.class);
            startActivity(intent);
        }else if (id == R.id.rate_us) {
            final Uri marketUri = Uri.parse("market://details?id=" + "com.example.dashmesh.news");
            startActivity(new Intent(Intent.ACTION_VIEW, marketUri));

        } else if (id == R.id.about_us) {

            Intent intent = new Intent(Grid_sports.this,FaqActivity.class);
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
}
