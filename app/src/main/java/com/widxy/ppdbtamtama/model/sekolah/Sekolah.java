package com.widxy.ppdbtamtama.model.sekolah;

import com.google.gson.annotations.SerializedName;

public class Sekolah {
    @SerializedName("data")
    private SekolahData sekolahData;

    @SerializedName("message")
    private String message;

    @SerializedName("status")
    private boolean status;

    public SekolahData getSekolahData() {
        return sekolahData;
    }

    public void setSekolahData(SekolahData sekolahData) {
        this.sekolahData = sekolahData;
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
