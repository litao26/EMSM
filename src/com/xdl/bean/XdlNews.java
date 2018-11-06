package com.xdl.bean;

import java.io.Serializable;
import java.sql.Timestamp;

public class XdlNews implements Serializable {
    private  int id;
    private String title;
    private String content;
    private Timestamp release_time;
    private String sticky;

    public XdlNews(String title, String content, Timestamp release_time, String sticky) {
        this.title = title;
        this.content = content;
        this.release_time = release_time;
        this.sticky = sticky;
    }

    public XdlNews(int id, String title, String content, Timestamp release_time, String sticky) {

        this.id = id;
        this.title = title;
        this.content = content;
        this.release_time = release_time;
        this.sticky = sticky;
    }

    public XdlNews() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Timestamp getRelease_time() {
        return release_time;
    }

    public void setRelease_time(Timestamp release_time) {
        this.release_time = release_time;
    }

    public String getSticky() {
        return sticky;
    }

    public void setSticky(String sticky) {
        this.sticky = sticky;
    }

    @Override
    public String toString() {
        return "XdlNews{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", release_time=" + release_time +
                ", sticky='" + sticky + '\'' +
                '}';
    }
}
