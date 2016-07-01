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

public class Grid_int extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    private GridViewAdapter mAdapter;
    private ArrayList<String> list;
    private ArrayList<String> image;
    private FeedbackDialog feedBack;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grid_int);
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
                    String title="World";
                    String link="http://rss.cnn.com/rss/edition_world.rss/";
                    Intent intent = new Intent(Grid_int.this, MainActivity_Media.class);
                    intent.putExtra("link",link);
                    intent.putExtra("title",title);
                    String feed_text="CNN.com";
                    String feed_link="http://logodatabases.com/wp-content/uploads/2012/03/cnn-logo-icon.png";
                    intent.putExtra("feed_text",feed_text);
                    intent.putExtra("feed_link",feed_link);
                    startActivity(intent);
                }if (position ==1) {
                    String title="Asia";
                    String link="http://feeds.bbci.co.uk/news/world/asia/rss.xml";
                    Intent intent = new Intent(Grid_int.this, MainActivity.class);
                    intent.putExtra("link",link);
                    intent.putExtra("title",title);
                    String feed_text="BBC News";
                    String feed_link="https://pbs.twimg.com/profile_images/662708106/bbc.png";
                    intent.putExtra("feed_text",feed_text);
                    intent.putExtra("feed_link",feed_link);
                    startActivity(intent);
                }if (position ==2) {
                    String title="Europe";
                    String link="http://feeds.bbci.co.uk/news/world/europe/rss.xml";
                    Intent intent = new Intent(Grid_int.this, MainActivity.class);
                    intent.putExtra("link",link);
                    intent.putExtra("title",title);
                    String feed_text="BBC News";
                    String feed_link="https://pbs.twimg.com/profile_images/662708106/bbc.png";
                    intent.putExtra("feed_text",feed_text);
                    intent.putExtra("feed_link",feed_link);
                    startActivity(intent);
                }if (position ==3) {
                    String title="Middle East";
                    String link="http://feeds.bbci.co.uk/news/world/middle_east/rss.xml";
                    Intent intent = new Intent(Grid_int.this, MainActivity.class);
                    intent.putExtra("link",link);
                    intent.putExtra("title",title);
                    String feed_text="BBC News";
                    String feed_link="https://pbs.twimg.com/profile_images/662708106/bbc.png";
                    intent.putExtra("feed_text",feed_text);
                    intent.putExtra("feed_link",feed_link);
                    startActivity(intent);
                }if (position ==4) {
                    String title="US & Canada";
                    String link="http://feeds.bbci.co.uk/news/world/us_and_canada/rss.xml";
                    Intent intent = new Intent(Grid_int.this, MainActivity.class);
                    intent.putExtra("link",link);
                    intent.putExtra("title",title);
                    String feed_text="BBC News";
                    String feed_link="https://pbs.twimg.com/profile_images/662708106/bbc.png";
                    intent.putExtra("feed_text",feed_text);
                    intent.putExtra("feed_link",feed_link);
                    startActivity(intent);
                }if (position ==5) {
                    String title="England";
                    String link="http://feeds.bbci.co.uk/news/england/rss.xml";
                    Intent intent = new Intent(Grid_int.this, MainActivity.class);
                    intent.putExtra("link",link);
                    intent.putExtra("title",title);
                    String feed_text="BBC News";
                    String feed_link="https://pbs.twimg.com/profile_images/662708106/bbc.png";
                    intent.putExtra("feed_text",feed_text);
                    intent.putExtra("feed_link",feed_link);
                    startActivity(intent);
                }if (position ==6) {
                    String title="UK";
                    String link="http://feeds.bbci.co.uk/news/uk/rss.xml";
                    Intent intent = new Intent(Grid_int.this, MainActivity.class);
                    intent.putExtra("link",link);
                    intent.putExtra("title",title);
                    String feed_text="BBC News";
                    String feed_link="https://pbs.twimg.com/profile_images/662708106/bbc.png";
                    intent.putExtra("feed_text",feed_text);
                    intent.putExtra("feed_link",feed_link);
                    startActivity(intent);
                }if (position ==7) {
                    String title="Africa";
                    String link="http://feeds.bbci.co.uk/news/world/africa/rss.xml";
                    Intent intent = new Intent(Grid_int.this, MainActivity.class);
                    intent.putExtra("link",link);
                    intent.putExtra("title",title);
                    String feed_text="BBC News";
                    String feed_link="https://pbs.twimg.com/profile_images/662708106/bbc.png";
                    intent.putExtra("feed_text",feed_text);
                    intent.putExtra("feed_link",feed_link);
                    startActivity(intent);
                }


                Toast.makeText(Grid_int.this, mAdapter.getItem(position), Toast.LENGTH_SHORT).show();
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
        list.add("World");
        list.add("Asia");
        list.add("Europe");
        list.add("Middle East");
        list.add("US & Canada");
        list.add("England");
        list.add("UK");
        list.add("Africa");

        image = new ArrayList<String>();
        image.add("http://wallpapercave.com/wp/C0qcsMw.png");
        image.add("http://ste.india.com/sites/default/files/2015/05/07/354790-taj.jpg");
        image.add("http://i.telegraph.co.uk/multimedia/archive/03300/Paris_3300925b.jpg");
        image.add("http://www.e-architect.co.uk/images/jpgs/dubai/burj_al_arab_jumeirah231008_2.jpg");
        image.add("http://www.wdtv.com/content/images/Politics/capitol%20building.jpg");
        image.add("http://i.telegraph.co.uk/multimedia/archive/02128/Tower_Bridge_night_2128191b.jpg");
        image.add("http://images7.content-bc.com/commimg/eduk/article/7214.jpg");
        image.add("https://pixabay.com/static/uploads/photo/2015/04/24/08/15/kenya-737416_960_720.jpg");
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

            Intent i=new Intent(Grid_int.this,StartActivity.class);
            i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
            startActivity(i);
        }else if (id == R.id.inter) {
            Intent intent = new Intent(Grid_int.this,Grid_int.class);
            startActivity(intent);
        }else if (id == R.id.sports) {
            Intent intent = new Intent(Grid_int.this,Grid_sports.class);
            startActivity(intent);
        } else if (id == R.id.tech) {
            Intent intent = new Intent(Grid_int.this,Grid_Tech.class);
            startActivity(intent);
        }
        else if (id == R.id.ent) {
            Intent intent = new Intent(Grid_int.this, Grid_ent.class);
            startActivity(intent);
        }else if (id == R.id.life) {
            Intent intent = new Intent(Grid_int.this, Grid_life.class);
            startActivity(intent);
        }else if (id == R.id.other) {
            Intent intent = new Intent(Grid_int.this, Grid_other.class);
            startActivity(intent);
        }else if(id== R.id.rate_us) {
            final Uri marketUri = Uri.parse("market://details?id=" + "com.example.dashmesh.news");
            startActivity(new Intent(Intent.ACTION_VIEW, marketUri));

        } else if (id == R.id.about_us) {

            Intent intent = new Intent(Grid_int.this,FaqActivity.class);
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
