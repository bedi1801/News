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
import android.view.Menu;
import android.view.MenuItem;

import com.suredigit.inappfeedback.FeedbackDialog;

import io.doorbell.android.Doorbell;

public class FaqActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {
    private FeedbackDialog feedBack;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_faq);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

         feedBack = new FeedbackDialog(this, "AF-7A87FD4730F8-66");
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
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
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
       // getMenuInflater().inflate(R.menu.faq, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
      //  if (id == R.id.action_settings) {
        //    return true;
       // }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if(id== R.id.start_page){

            Intent i=new Intent(FaqActivity.this,StartActivity.class);
            i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
            startActivity(i);
        }else if (id == R.id.inter) {
            Intent intent = new Intent(FaqActivity.this,Grid_int.class);
            startActivity(intent);
        }else if (id == R.id.sports) {
            Intent intent = new Intent(FaqActivity.this,Grid_sports.class);
            startActivity(intent);
        } else if (id == R.id.tech) {
            Intent intent = new Intent(FaqActivity.this,Grid_Tech.class);
            startActivity(intent);
        }
        else if (id == R.id.ent) {
            Intent intent = new Intent(FaqActivity.this, Grid_ent.class);
            startActivity(intent);
        }else if (id == R.id.life) {
            Intent intent = new Intent(FaqActivity.this, Grid_life.class);
            startActivity(intent);
        }else if (id == R.id.other) {
            Intent intent = new Intent(FaqActivity.this, Grid_other.class);
            startActivity(intent);
        }else if (id == R.id.rate_us) {
            final Uri marketUri = Uri.parse("market://details?id=" + "com.example.dashmesh.news");
            startActivity(new Intent(Intent.ACTION_VIEW, marketUri));


        }else if (id == R.id.feedback) {

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
