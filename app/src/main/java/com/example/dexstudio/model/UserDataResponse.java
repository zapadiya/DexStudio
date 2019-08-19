package com.example.dexstudio.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;


public class UserDataResponse {

    @SerializedName("title")
    private String title;
    @SerializedName("rows")
    private List<UserData> results;

    public String gettitle() {
        return title;
    }

    public void settitle(String page) {
        this.title = page;
    }

    public List<UserData> getResults() {
        return results;
    }

    public void setResults(List<UserData> results) {
        this.results = results;
    }
}
