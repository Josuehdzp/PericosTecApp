package com.Pericos.ITSVC.App.Feeds;

import com.Pericos.ITSVC.App.Feeds.FeedFacebookListTest;


public class LogicaFB {

    private FeedFacebookListTest activity2;
    private Object createdTimestamp;

    public LogicaFB(FeedFacebookListTest activity2) {
        this.activity2 = activity2;
    }

    public FeedFacebookListTest getActivity2() {
        return activity2;
    }

    public void setActivity2(FeedFacebookListTest activity2) {
        this.activity2 = activity2;
    }

    public Object getCreatedTimestamp() {
        return createdTimestamp;
    }

}
