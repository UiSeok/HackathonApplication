package com.example.hackathonapplication.community.board;

public class Comment {
    private String profile;
    private String writer;
    private String badge;
    private String contents;
    private String date;
    private String like;

    public Comment(String profile, String writer, String badge, String contents, String date, String like) {
        this.profile = profile;
        this.writer = writer;
        this.badge = badge;
        this.contents = contents;
        this.date = date;
        this.like = like;
    }

    public String getProfile() {
        return profile;
    }

    public void setProfile(String profile) {
        this.profile = profile;
    }

    public String getWriter() {
        return writer;
    }

    public void setWriter(String writer) {
        this.writer = writer;
    }

    public String getBadge() {
        return badge;
    }

    public void setBadge(String badge) {
        this.badge = badge;
    }

    public String getContents() {
        return contents;
    }

    public void setContents(String contents) {
        this.contents = contents;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getLike() {
        return like;
    }

    public void setLike(String like) {
        this.like = like;
    }
}
