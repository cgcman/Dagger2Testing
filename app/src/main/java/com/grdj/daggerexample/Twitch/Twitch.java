
package com.grdj.daggerexample.Twitch;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Twitch {

    @SerializedName("data")
    @Expose
    private List<com.grdj.daggerexample.Twitch.Datum> data = null;
    @SerializedName("pagination")
    @Expose
    private com.grdj.daggerexample.Twitch.Pagination pagination;

    public List<com.grdj.daggerexample.Twitch.Datum> getData() {
        return data;
    }

    public void setData(List<com.grdj.daggerexample.Twitch.Datum> data) {
        this.data = data;
    }

    public com.grdj.daggerexample.Twitch.Pagination getPagination() {
        return pagination;
    }

    public void setPagination(com.grdj.daggerexample.Twitch.Pagination pagination) {
        this.pagination = pagination;
    }

}
