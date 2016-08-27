package com.dsb.apps.readit;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserFactory;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class NewsFeedParser {
    private InputStream urlStream;
    private XmlPullParserFactory factory;
    private XmlPullParser parser;

    private List<RSSFeed> rssFeedList;
    private RSSFeed rssFeed;

    private String urlString;
    private String tagName;

    private String title;
    private String link;
    private String description_1;
    private String category;
    private String pubDate;
    private String guid;
    private String feedburner;
    private String description;
    public String url;
    public String img;
    public String storyimage;

    public static final String ITEM = "item";
    public static final String CHANNEL = "channel";

    public static final String TITLE = "title";
    public static final String LINK = "link";
    public static final String DESCRIPTION = "description";
    public static final String CATEGORY = "category";
    public static final String PUBLISHEDDATE = "pubDate";
    public static final String GUID = "guid";
    public static final String FEEDBURNERORIGLINK = "feedburner:origLink";
    public  String url_content ;

    public NewsFeedParser(String urlString) {
        this.urlString = urlString;
    }

    public static InputStream downloadUrl(String urlString) throws IOException {
        URL url = new URL(urlString);
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("GET");
        conn.setDoInput(true);
        conn.connect();
        InputStream stream = conn.getInputStream();
        return stream;
    }

    public List<RSSFeed> parse() {

        try {
            int count = 0;
            factory = XmlPullParserFactory.newInstance();
            parser = factory.newPullParser();
            urlStream = downloadUrl(urlString);
            parser.setInput(urlStream, null);
            int eventType = parser.getEventType();
            boolean done = false;
            rssFeed = new RSSFeed();
            rssFeedList = new ArrayList<RSSFeed>();
            while (eventType != XmlPullParser.END_DOCUMENT && !done ) {
                tagName = parser.getName();

                switch (eventType) {
                    case XmlPullParser.START_DOCUMENT:
                        break;
                    case XmlPullParser.START_TAG:
                        if (tagName.equals(ITEM)) {
                            rssFeed = new RSSFeed();
                        }
                        if (tagName.equals(TITLE)) {
                            title = parser.nextText().toString();
                        }
                        if (tagName.equals(LINK)) {
                            link = parser.nextText().toString();
                        }
                        if (tagName.equals(DESCRIPTION)) {
                            description_1= parser.nextText().toString();
                            Pattern REMOVE_TAGS = Pattern.compile("<.+?>");
                            Matcher m = REMOVE_TAGS.matcher(description_1);
                            description= m.replaceAll("");
                         }
                        if (tagName.equals(CATEGORY)) {
                            category = parser.nextText().toString();
                        }
                        if (tagName.equals(PUBLISHEDDATE)) {
                            pubDate = parser.nextText().toString();

                        }
                        if (tagName.equals(GUID)) {
                            guid = parser.nextText().toString();
                        }
                        if (tagName.equals(FEEDBURNERORIGLINK)) {
                            feedburner = parser.nextText().toString();
                        }
                         if (tagName.equals("media:thumbnail")) {
                            url = parser.getAttributeValue(null,"url").toString();
                                }
                        if (tagName.equals("media:content")) {
                            url_content = parser.getAttributeValue(null,"url").toString();
                        }
                        if (tagName.equals("StoryImage")) {
                        storyimage = parser.nextText().toString();
                    }
                        break;
                    case XmlPullParser.END_TAG:
                        if (tagName.equals(CHANNEL)) {
                            done = true;
                        } else if (tagName.equals(ITEM)) {
                            rssFeed = new RSSFeed(title,link,description,category,pubDate,guid,
                                    feedburner,url,description_1,storyimage,url_content);
                            rssFeedList.add(rssFeed);
                        }
                        break;
                }
                eventType = parser.next();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return rssFeedList;
    }
}

