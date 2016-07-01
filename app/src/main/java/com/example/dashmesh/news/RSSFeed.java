package com.example.dashmesh.news;

import java.io.Serializable;

public class RSSFeed implements Serializable {

    private String title;
    private String link;
    private String description;
    private String category;
    private String pubDate;
    private String guid;
    private String feedburnerOrigLink;
    private  String url;
    private String image;
    private String d_url;
    public RSSFeed() {
    }

    public RSSFeed(String title, String link, String description, String category, String pubDate,
                   String guid, String feedburnerOrigLink, String Thumbnail_url, String d_url) {
        this.title = title;
        this.link = link;
        this.description = description;
        this.category = category;
        this.pubDate = pubDate;
        this.guid = guid;
        this.feedburnerOrigLink = feedburnerOrigLink;
        this.url= Thumbnail_url;
        this.d_url=d_url;
     //   this.image=desc_img;
    }

    public String getTitle() {
        return title;
    }

    public String getLink() {
        return link;
    }

    public String getDescription() {
        return description;
    }

    public String getCategory() {
        return category;
    }

    public String getPubDate() {
        return pubDate;
    }

    public String getGuid() {
        return guid;
    }

    public String getFeedburnerOrigLink() {
        return feedburnerOrigLink;
    }

    public String getThumbnail() {
        return url;
    }

    public String getD_url() {
        return d_url;
    }

    //public String getImage() {
     //   return image;
    //}
    public void setD_url(String d_url) {
        this.d_url = d_url;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public void setPubDate(String pubDate) {
        this.pubDate = pubDate;
    }

    public void setGuid(String guid) {
        this.guid = guid;
    }

    public void setThumbnail(String url) {
        this.url = url;
    }

    //public void setImage(String image) {
     //   this.image = image;
   // }
    public void setFeedburnerOrigLink(String feedburnerOrigLink) {
        this.feedburnerOrigLink = feedburnerOrigLink;
    }
}
