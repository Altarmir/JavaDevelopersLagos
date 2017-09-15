package com.example.android.javadeveloperslagos;

public class ListItem {
    private String login;
    private String html_url;
    private String imageUrl;


    public ListItem(String head, String address, String imageUrl) {
        this.login = head;
        this.html_url = address;
        this.imageUrl = imageUrl;

    }

    public String getHead() {
        return login;
    }

    public String getAbout() {
        return html_url;
    }

    public String getImageUrl() {
        return imageUrl;
    }


} 