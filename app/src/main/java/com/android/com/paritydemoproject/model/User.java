package com.android.com.paritydemoproject.model;

/**
 * Created by mukesh.teckwani on 24-07-2016.
 */
public class User {

    private String id;

    private String karma;

    private String fpd_count;

    private String rank;

    private String name;

    private String image;

    private String current_dimes;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getKarma() {
        return karma;
    }

    public void setKarma(String karma) {
        this.karma = karma;
    }

    public String getFpd_count() {
        return fpd_count;
    }

    public void setFpd_count(String fpd_count) {
        this.fpd_count = fpd_count;
    }

    public String getRank() {
        return rank;
    }

    public void setRank(String rank) {
        this.rank = rank;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getCurrent_dimes() {
        return current_dimes;
    }

    public void setCurrent_dimes(String current_dimes) {
        this.current_dimes = current_dimes;
    }

    @Override
    public String toString() {
        return "ClassPojo [id = " + id + ", karma = " + karma + ", fpd_count = " + fpd_count + ", rank = " + rank + ", name = " + name + ", image = " + image + ", current_dimes = " + current_dimes + "]";
    }
}
