package co.appdev.search.data.model;

import com.google.gson.annotations.SerializedName;


public class User {

    @SerializedName("login")
    private String name;
    @SerializedName("avatar_url")
    private String url;
    @SerializedName("score")
    private double score;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public double getScore() {
        return score;
    }

    public void setScore(double score) {
        this.score = score;
    }
}
