package com.mateuslima.mvpcats.data.network.result;

import com.google.gson.annotations.SerializedName;

public class CatResult {

    @SerializedName("id")
    private String id;
    @SerializedName("url")
    private String url;

    public CatResult() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
