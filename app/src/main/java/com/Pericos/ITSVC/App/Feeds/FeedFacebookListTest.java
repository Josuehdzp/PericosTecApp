package com.Pericos.ITSVC.App.Feeds;

import com.Pericos.ITSVC.App.Feeds.LogicaFB;

import org.ocpsoft.prettytime.PrettyTime;

import java.util.Date;
import java.util.Locale;

public class FeedFacebookListTest {

    private LogicaFB logicaFB;

    private String created_time;

    private String message;

    private String full_picture;

    private String permalink_url;

    private String status_type;

    private String story;

    private String description;



    public FeedFacebookListTest(String created_time, String message, String full_picture, String permalink_url, String status_type, String story, String description) {
        this.created_time = created_time;
        this.full_picture = full_picture;
        this.message = message;
        this.permalink_url = permalink_url;
        this.status_type = status_type;
        this.story = story;
        this.description = description;

    }

    public String getCreated_time() {
        return created_time;
    }

    public void setCreated_time(String created_time) {
        this.created_time = created_time;
    }


    public String getMessage() {
        return String.valueOf(message);
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getFull_picture() {
        return full_picture;
    }

    public void setFull_picture(String full_picture) {
        this.full_picture = full_picture;
    }

    public String getPermalink_url() {
        return permalink_url;
    }

    public void setPermalink_url(String permalink_url) {
        this.permalink_url = permalink_url;
    }


    public String getStatus_type() {
        return status_type;
    }

    public void setStatus_type(String status_type) {
        this.status_type = status_type;
    }

    public String getStory() {
        return story;
    }

    public void setStory(String story) {
        this.story = story;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public FeedFacebookListTest(LogicaFB logicaFB) {
        this.logicaFB = logicaFB;
    }

    public long getCreatedTimestampLong(){
        return (long) logicaFB.getCreatedTimestamp();
    }

    public String fechaDeCreacionDelMensaje() {
        Date date = new Date(getCreatedTimestampLong());
        PrettyTime prettyTime = new PrettyTime(new Date(), Locale.getDefault());
        return prettyTime.format(date);

    /* public DevelopersList(String login, String gitUrl, String avatar_url) {
        this.tv_created_time = login;
        this.tv_full_picture = avatar_url;
        this.tv_permalink_url = gitUrl;
    }*/
    }
}
