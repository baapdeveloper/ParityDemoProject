package com.android.com.paritydemoproject.model;

/**
 * Created by mukesh.teckwani on 24-07-2016.
 */
public class Topic {

    private String id;

    private String title;

    private String updated_at;

    private String last_activity_at;

    private String share_url;

    private String forum_name;

    private String posts_count;

    private String score;

    private String fpd_flag;

    private String view_count;

    private String front_page_suggestions_count;

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

    public String getUpdated_at() {
        return updated_at;
    }

    public void setUpdated_at(String updated_at) {
        this.updated_at = updated_at;
    }

    public String getLast_activity_at() {
        return last_activity_at;
    }

    public void setLast_activity_at(String last_activity_at) {
        this.last_activity_at = last_activity_at;
    }

    public String getShare_url() {
        return share_url;
    }

    public void setShare_url(String share_url) {
        this.share_url = share_url;
    }

    public String getForum_name() {
        return forum_name;
    }

    public void setForum_name(String forum_name) {
        this.forum_name = forum_name;
    }

    public String getPosts_count() {
        return posts_count;
    }

    public void setPosts_count(String posts_count) {
        this.posts_count = posts_count;
    }

    public String getScore() {
        return score;
    }

    public void setScore(String score) {
        this.score = score;
    }

    public String getFpd_flag() {
        return fpd_flag;
    }

    public void setFpd_flag(String fpd_flag) {
        this.fpd_flag = fpd_flag;
    }

    public String getView_count() {
        return view_count;
    }

    public void setView_count(String view_count) {
        this.view_count = view_count;
    }

    public String getFront_page_suggestions_count() {
        return front_page_suggestions_count;
    }

    public void setFront_page_suggestions_count(String front_page_suggestions_count) {
        this.front_page_suggestions_count = front_page_suggestions_count;
    }

    @Override
    public String toString() {
        return "ClassPojo [id = " + id + ", title = " + title + ", updated_at = " + updated_at + ", last_activity_at = " + last_activity_at + ", share_url = " + share_url + ", forum_name = " + forum_name + ", posts_count = " + posts_count + ", score = " + score + ", fpd_flag = " + fpd_flag + ", view_count = " + view_count + ", front_page_suggestions_count = " + front_page_suggestions_count + "]";
    }
}
