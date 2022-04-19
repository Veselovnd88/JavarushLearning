package com.mytrainings.api;

import com.fasterxml.jackson.annotation.*;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Image {

    private String copyright;

    private String date;

    private String media_type;

    private String title;

    private String url;


    public String getCopyright() {
        return copyright;
    }

    public String getDate() {
        return date;
    }

    public String getMedia_type() {
        return media_type;
    }

    public String getTitle() {
        return title;
    }

    public String getUrl() {
        return url;
    }



    public void setCopyright(String copyright) {
        this.copyright = copyright;
    }
    @JsonSetter("date")
    public void setDate(String date) {
        this.date = date;
    }
    @JsonSetter("media_type")
    public void setMedia_type(String media_type) {
        this.media_type = media_type;
    }
    @JsonSetter("title")
    public void setTitle(String title) {
        this.title = title;
    }
    @JsonSetter("url")
    public void setUrl(String url) {
        this.url = url;
    }

    @JsonCreator

    public Image(@JsonProperty("copyright") String copyright, @JsonProperty("date") String date,
                 @JsonProperty("media_type") String media_type, @JsonProperty("title") String title,
                 @JsonProperty("url") String url) {
        this.copyright = copyright;
        this.date = date;
        this.media_type = media_type;
       this.title = title;
        this.url = url;
    }



}
