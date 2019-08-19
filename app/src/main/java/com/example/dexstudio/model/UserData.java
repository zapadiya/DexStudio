package com.example.dexstudio.model;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class UserData implements Serializable {
    @SerializedName("title")
    public String title;
    @SerializedName("description")
    public String description;
    @SerializedName("imageHref")
    public String imageHref;
}
