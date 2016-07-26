package com.android.com.paritydemoproject.model;

/**
 * Created by mukesh.teckwani on 24-07-2016.
 */
public class Forum {

    private String id;

    private String title;

    private String last_activity_at;

    private String have_subforum;

    private String description;

    private String posts_count;

    private String topics_count;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getLast_activity_at() {
        return last_activity_at;
    }

    public void setLast_activity_at(String last_activity_at) {
        this.last_activity_at = last_activity_at;
    }

    public String getHave_subforum() {
        return have_subforum;
    }

    public void setHave_subforum(String have_subforum) {
        this.have_subforum = have_subforum;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPosts_count() {
        return posts_count;
    }

    public void setPosts_count(String posts_count) {
        this.posts_count = posts_count;
    }

    public String getTopics_count() {
        return topics_count;
    }

    public void setTopics_count(String topics_count) {
        this.topics_count = topics_count;
    }

    @Override
    public String toString() {
        return "ClassPojo [id = " + id + ", title = " + title + ", last_activity_at = " + last_activity_at + ", have_subforum = " + have_subforum + ", description = " + description + ", posts_count = " + posts_count + ", topics_count = " + topics_count + "]";
    }
}
