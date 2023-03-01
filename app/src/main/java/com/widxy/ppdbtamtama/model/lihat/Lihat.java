package com.widxy.ppdbtamtama.model.lihat;

import com.google.gson.annotations.SerializedName;
import com.widxy.ppdbtamtama.model.alamat.AlamatData;

public class Lihat {
    @SerializedName("data")
    private LihatData lihatData;

    @SerializedName("message")
    private String message;

    @SerializedName("status")
    private boolean status;

    public LihatData getLihatData() {
        return lihatData;
    }

    public void setLihatData(LihatData lihatData) {
        this.lihatData = lihatData;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }
}
