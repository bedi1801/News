package com.example.dashmesh.news;


import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;
import com.suredigit.inappfeedback.FeedbackDialog;

import java.util.ArrayList;
import java.util.List;

public class HorizontalLists extends AppCompatActivity implements  NavigationView.OnNavigationItemSelectedListener {

    private RecyclerView horizontal_recycler_view2, horizontal_recycler_view,horizontal_recycler_view3;
    private ArrayList<String> horizontalList, verticalList;
    private HorizontalAdapter horizontalAdapter;
    private HorizontalAdapter2 horizontalAdapter2;
    private HorizontalAdapter3 horizontalAdapter3;
    private FeedbackDialog feedBack;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_horizontal_lists_drawer);
        feedBack = new FeedbackDialog(this, "AF-7A87FD4730F8-66");
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
        //getSupportActionBar().setHomeButtonEnabled(true);
        //getSupportActionBar().setDisplayShowHomeEnabled(true);

        horizontal_recycler_view = (RecyclerView) findViewById(R.id.horizontal_recycler_view);
        horizontal_recycler_view2 = (RecyclerView) findViewById(R.id.horizontal_recycler_view2);
        horizontal_recycler_view3 = (RecyclerView) findViewById(R.id.horizontal_recycler_view3);
        horizontalList = new ArrayList<>();
        horizontalList.add("World Sports");
        horizontalList.add("Football");
        horizontalList.add("Cricket News");
        horizontalList.add("Tennis");
        horizontalList.add("Manchester City");
        horizontalList.add("Other Sports");

        ArrayList<String> image1 = new ArrayList<>();
        image1.add("http://news.popalz.com.pk/wp-content/themes/Journal/images/sportsnews.jpeg");
        image1.add("http://www.chestertonsportscentre.org.uk/wp-content/uploads/2015/05/Football.jpg");
        image1.add("http://cdn.theunlockr.com/wp-content/uploads/2011/12/cricket_logo_rev-820x344.gif");
        image1.add("http://i2.cdn.turner.com/cnnnext/dam/assets/160118110422-australian-open-court-view-2016-super-169.jpg");
        image1.add("http://e1.365dm.com/15/12/16-9/20/manchester-city-new-club-badge-big-screen-etihad_3392198.jpg?20151226152621");
        image1.add("http://static1.squarespace.com/static/513f55cfe4b09478fd2a780a/513f55cfe4b09478fd2a7810/53593e8ee4b09312a903ea75/1398358360380/Olympic+Flag.jpg?format=1000w");

        ArrayList<String> horizontalList2 = new ArrayList<>();
        horizontalList2.add("Technology");
        horizontalList2.add("CNET Tech News");
        horizontalList2.add("Android");
        horizontalList2.add("Gaming");
        horizontalList2.add("Reviews");
        horizontalList2.add("TechCrunch:Mobile");
        ArrayList<String> image2 = new ArrayList<>();
        image2.add("http://www.managementguru.net/wp-content/uploads/2014/03/technology.jpg");
        image2.add("http://www.organizingla.com/.a/6a00d83451b1af69e2010534993db6970b-600wi");
        image2.add("http://www.androidcentral.com/sites/androidcentral.com/files/styles/w800h450crop/public/article_images/2015/03/podcast-ac-new_2.jpg?itok=0wcOMHZD");
        image2.add("http://www.igyaan.in/wp-content/uploads/2015/10/Gaming.jpg");
        image2.add("http://www.cnet.com/i/pod/images/cnetTechReview_600x600.jpg");
        image2.add("http://www.cnet.com/i/pod/images/cnetTechReview_600x600.jpg");
        ArrayList<String> horizontalList3 = new ArrayList<>();
        horizontalList3.add("Entertainment");
        horizontalList3.add("Bollywood");
        horizontalList3.add("Hollywood");
        horizontalList3.add("Movie Review");
        horizontalList3.add("Music Review");
        ArrayList<String> image3 = new ArrayList<>();
        image3.add("http://media.creativebloq.futurecdn.net/sites/creativebloq.com/files/images/2013/03/daftpunkicon.jpg");
        image3.add("http://thrivalroom.com/wp-content/uploads/2014/05/bollywood-logo.jpg");
        image3.add("https://lh4.googleusercontent.com/-mq2O5I91OLA/TXqDa9Eql7I/AAAAAAAAK4Y/t3GxPnZJ0g8/s1600/hollywood_logo3.jpg");
        image3.add("http://i0.wp.com/www.54daysthemovie.com/wp-content/uploads/2014/09/movie-review.jpg");
        image3.add("https://pbs.twimg.com/profile_images/468817264175611904/iOKjG2tM_400x400.jpeg");


        horizontalAdapter = new HorizontalAdapter(horizontalList,image1);
        LinearLayoutManager horizontalLayoutManagaer = new LinearLayoutManager(HorizontalLists.this, LinearLayoutManager.HORIZONTAL, false);
        horizontal_recycler_view.setLayoutManager(horizontalLayoutManagaer);
        horizontal_recycler_view.setAdapter(horizontalAdapter);

        horizontalAdapter2 = new HorizontalAdapter2(horizontalList2,image2);
        LinearLayoutManager horizontalLayoutManagaer2 = new LinearLayoutManager(HorizontalLists.this, LinearLayoutManager.HORIZONTAL, false);
        horizontal_recycler_view2.setLayoutManager(horizontalLayoutManagaer2);
        horizontal_recycler_view2.setAdapter(horizontalAdapter2);

        horizontalAdapter3 = new HorizontalAdapter3(horizontalList3,image3);
        LinearLayoutManager horizontalLayoutManagaer3 = new LinearLayoutManager(HorizontalLists.this, LinearLayoutManager.HORIZONTAL, false);
        horizontal_recycler_view3.setLayoutManager(horizontalLayoutManagaer3);
        horizontal_recycler_view3.setAdapter(horizontalAdapter3);

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

        if (id == R.id.start_page) {
            Intent i=new Intent(HorizontalLists.this,StartActivity.class);
            i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
            startActivity(i);
            // Handle the camera action
        } else if (id == R.id.favorite) {

        } else if (id == R.id.rate_us) {
            final Uri marketUri = Uri.parse("market://details?id=" + "com.example.dashmesh.news");
            startActivity(new Intent(Intent.ACTION_VIEW, marketUri));

        } else if (id == R.id.about_us) {

            Intent intent = new Intent(HorizontalLists.this,FaqActivity.class);
            startActivity(intent);

        } else if (id == R.id.feedback) {

            feedBack.show();

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


    public class HorizontalAdapter extends RecyclerView.Adapter<HorizontalAdapter.MyViewHolder> {

        private List<String> horizontalList;
        private List<String> image1;

        public class MyViewHolder extends RecyclerView.ViewHolder {
            public TextView txtView;
            public ImageView image;
            public MyViewHolder(View view) {
                super(view);
                txtView = (TextView) view.findViewById(R.id.txtView);
                image = (ImageView) view.findViewById(R.id.image);
            }
        }


        public HorizontalAdapter(List<String> horizontalList,List<String> image1) {
            this.horizontalList = horizontalList;
            this.image1= image1;
        }

        @Override
        public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View itemView = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.horizontal_item_view, parent, false);

            return new MyViewHolder(itemView);
        }

        @Override
        public void onBindViewHolder(final MyViewHolder holder, final int position) {
            holder.txtView.setText(horizontalList.get(position));
            //String pic=image1.get(position);
            Picasso.with(getBaseContext()).load(image1.get(position)).resize(110,55).into(holder.image);
            //holder.image.setImageDrawable(getResources().getDrawable(R.drawable.pic);
            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(HorizontalLists.this, holder.txtView.getText().toString(), Toast.LENGTH_LONG).show();
                    if (position ==1) {
                        String link="http://indianexpress.com/section/sports/football/feed/";
                        String title="Football";
                        Intent intent = new Intent(HorizontalLists.this, MainActivity.class);
                        intent.putExtra("link",link);
                        intent.putExtra("title",title);
                        startActivity(intent);
                    }
                    if (position ==2) {
                        String link="http://indianexpress.com/section/sports/cricket/feed/";
                        String title="Cricket";
                        Intent intent = new Intent(HorizontalLists.this, MainActivity.class);
                        intent.putExtra("title",title);
                        intent.putExtra("link",link);
                        startActivity(intent);
                    }
                    if (position ==0) {
                        String link="http://indianexpress.com/section/sports/feed/";
                        String title="World";
                        Intent intent = new Intent(HorizontalLists.this, MainActivity.class);
                        intent.putExtra("link",link);
                        intent.putExtra("title",title);
                        startActivity(intent);
                    }
                    if (position ==4) {
                        String link="http://www.manchestereveningnews.co.uk/all-about/manchester-city-fc?service=rss";
                        String title="Manchester City";
                        Intent intent = new Intent(HorizontalLists.this, MainActivity_Media.class);
                        intent.putExtra("link",link);
                        intent.putExtra("title",title);
                        startActivity(intent);
                    }
                    if (position ==3) {
                        String link="http://indianexpress.com/section/sports/tennis/feed/";
                        String title="Tennis";
                        Intent intent = new Intent(HorizontalLists.this, MainActivity.class);
                        intent.putExtra("link",link);
                        intent.putExtra("title",title);
                        startActivity(intent);
                    }if (position ==5) {
                        String link="http://indianexpress.com/section/sports/sport-others/feed/";
                        String title="Other Sports";
                        Intent intent = new Intent(HorizontalLists.this, MainActivity.class);
                        intent.putExtra("link",link);
                        intent.putExtra("title",title);
                        startActivity(intent);
                    }

                }
            });
        }

        @Override
        public int getItemCount() {
            return horizontalList.size();
        }
    }

    public class HorizontalAdapter2 extends RecyclerView.Adapter<HorizontalAdapter2.MyViewHolder> {

        private List<String> horizontalList;
        private List<String> image1;
        public class MyViewHolder extends RecyclerView.ViewHolder {
            public TextView txtView;
            public ImageView image1;

            public MyViewHolder(View view) {
                super(view);
                txtView = (TextView) view.findViewById(R.id.txtView);
                image1=(ImageView) view.findViewById(R.id.image);
            }
        }


        public HorizontalAdapter2(List<String> horizontalList,List<String> image1) {
            this.horizontalList = horizontalList;
            this.image1=image1;
        }

        @Override
        public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View itemView = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.horizontal_item_view2, parent, false);

            return new MyViewHolder(itemView);
        }

        @Override
        public void onBindViewHolder(final MyViewHolder holder, final int position) {
            holder.txtView.setText(horizontalList.get(position));
            Picasso.with(getBaseContext()).load(image1.get(position)).resize(110,55).into(holder.image1);
            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (position ==0) {
                        String title="Technology";
                        String link="http://indianexpress.com/section/technology/feed/";
                        Intent intent = new Intent(HorizontalLists.this, MainActivity.class);
                        intent.putExtra("link",link);
                        intent.putExtra("title",title);
                        startActivity(intent);
                    }if (position ==1) {
                        String title="CNET Tech News";
                        String link="http://www.cnet.com/rss/news/";
                        Intent intent = new Intent(HorizontalLists.this, MainActivity.class);
                        intent.putExtra("link",link);
                        intent.putExtra("title",title);
                        startActivity(intent);
                    }if (position ==2) {
                        String title="Android";
                        String link="http://www.cnet.com/rss/android-update/";
                        Intent intent = new Intent(HorizontalLists.this, MainActivity.class);
                        intent.putExtra("link",link);
                        intent.putExtra("title",title);
                        startActivity(intent);
                    }if (position ==3) {
                        String title="Gaming";
                        String link="http://www.cnet.com/rss/gaming/";
                        Intent intent = new Intent(HorizontalLists.this, MainActivity.class);
                        intent.putExtra("link",link);
                        intent.putExtra("title",title);
                        startActivity(intent);
                    }if (position ==4) {
                        String title="CNET Reviews";
                        String link="http://www.cnet.com/rss/reviews/";
                        Intent intent = new Intent(HorizontalLists.this, MainActivity.class);
                        intent.putExtra("link",link);
                        intent.putExtra("title",title);
                        startActivity(intent);
                    }
                    if (position ==5) {
                        String title="TechCrunch:Mobile";
                        String link="http://feeds.feedburner.com/Mobilecrunch";
                        Intent intent = new Intent(HorizontalLists.this, MainActivity_Nocontent.class);
                        intent.putExtra("link",link);
                        intent.putExtra("title",title);
                        startActivity(intent);
                    }
                    //Intent intent = new Intent(HorizontalLists.this, MainActivity.class);
                    //startActivity(intent);
                    Toast.makeText(HorizontalLists.this, holder.txtView.getText().toString(), Toast.LENGTH_SHORT).show();
                }
            });
        }

        @Override
        public int getItemCount() {
            return horizontalList.size();
        }
    }

    public class HorizontalAdapter3 extends RecyclerView.Adapter<HorizontalAdapter3.MyViewHolder> {

        private List<String> horizontalList;
        private List<String> image1;
        public class MyViewHolder extends RecyclerView.ViewHolder {
            public TextView txtView;
            public  ImageView image1;
            public MyViewHolder(View view) {
                super(view);
                txtView = (TextView) view.findViewById(R.id.txtView);
                image1=(ImageView) view.findViewById(R.id.image);
            }
        }


        public HorizontalAdapter3(List<String> horizontalList,List<String> image1) {
            this.horizontalList = horizontalList;
            this.image1=image1;
        }

        @Override
        public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View itemView = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.horizontal_item_view3, parent, false);

            return new MyViewHolder(itemView);
        }

        @Override
        public void onBindViewHolder(final MyViewHolder holder, final int position) {
            holder.txtView.setText(horizontalList.get(position));
            Picasso.with(getBaseContext()).load(image1.get(position)).resize(110,55).into(holder.image1);
            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    //Intent intent = new Intent(HorizontalLists.this, MainActivity.class);
                    //startActivity(intent);
                     Toast.makeText(HorizontalLists.this, holder.txtView.getText().toString(), Toast.LENGTH_SHORT).show();
                    if (position ==0) {
                        String link="http://indianexpress.com/section/entertainment/feed/";
                        String title="Entertainment";
                        Intent intent = new Intent(HorizontalLists.this, MainActivity.class);
                        intent.putExtra("link",link);
                        intent.putExtra("title",title);
                        startActivity(intent);
                    }if (position ==1) {
                        String link="http://indianexpress.com/section/entertainment/bollywood/feed/";
                        String title="Bollywood";
                        Intent intent = new Intent(HorizontalLists.this, MainActivity.class);
                        intent.putExtra("link",link);
                        intent.putExtra("title",title);
                        startActivity(intent);
                    }if (position ==2) {
                        String link="http://indianexpress.com/section/entertainment/hollywood/feed/";
                        String title="Hollywood";
                        Intent intent = new Intent(HorizontalLists.this, MainActivity.class);
                        intent.putExtra("link",link);
                        intent.putExtra("title",title);
                        startActivity(intent);
                    }if (position ==3) {
                        String link="http://indianexpress.com/section/entertainment/movie-review/feed/";
                        String title="Movie Review";
                        Intent intent = new Intent(HorizontalLists.this, MainActivity.class);
                        intent.putExtra("link",link);
                        intent.putExtra("title",title);
                        startActivity(intent);
                    }if (position ==4) {
                        String link="http://indianexpress.com/print/reviews-music/feed/";
                        String title="Music Review";
                        Intent intent = new Intent(HorizontalLists.this, MainActivity.class);
                        intent.putExtra("link",link);
                        intent.putExtra("title",title);
                        startActivity(intent);
                    }

                }
            });
        }

        @Override
        public int getItemCount() {
            return horizontalList.size();
        }
    }


}

