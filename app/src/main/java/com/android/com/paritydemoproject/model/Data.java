package com.android.com.paritydemoproject.model;

/**
 * Created by mukesh.teckwani on 24-07-2016.
 */

public class Data {
    private Topic topic;

    private String id;

    private String post_like_status;

    private Forum forum;

    private String text;

    private String like_count;

    private String created_at;

    private String text_raw;

    private User user;

    public Topic getTopic() {
        return topic;
    }

    public void setTopic(Topic topic) {
        this.topic = topic;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPost_like_status() {
        return post_like_status;
    }

    public void setPost_like_status(String post_like_status) {
        this.post_like_status = post_like_status;
    }

    public Forum getForum() {
        return forum;
    }

    public void setForum(Forum forum) {
        this.forum = forum;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getLike_count() {
        return like_count;
    }

    public void setLike_count(String like_count) {
        this.like_count = like_count;
    }

    public String getCreated_at() {
        return created_at;
    }

    public void setCreated_at(String created_at) {
        this.created_at = created_at;
    }

    public String getText_raw() {
        return text_raw;
    }

    public void setText_raw(String text_raw) {
        this.text_raw = text_raw;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "ClassPojo [topic = " + topic + ", id = " + id + ", post_like_status = " + post_like_status + ", forum = " + forum + ", text = " + text + ", like_count = " + like_count + ", created_at = " + created_at + ", text_raw = " + text_raw + ", user = " + user + "]";
    }
}
