package com.romain.mathieu.spreadscience.Model;

/**
 * Created by romain on 17/03/2018.
 */

public class CardData {

    private String title, subtitle, imageURL, date, category, content, url;


    public CardData(String mTitle, String mSubtitle, String mImageURL, String date, String category, String content, String url) {

        this.title = mTitle;
        this.subtitle = mSubtitle;
        this.imageURL = mImageURL;
        this.date = date;
        this.category = category;
        this.content = content;
        this.url = url;
    }

    public String getImageURL() {
        return imageURL;
    }

    public String getSubtitle() {
        return subtitle;
    }

    public String getTitle() {
        return title;
    }

    public String getDate() {
        return date;
    }

    public String getCategory() {
        return category;
    }

    public String getContent() {
        return content;
    }

    public String getUrl() {
        return url;
    }
}
