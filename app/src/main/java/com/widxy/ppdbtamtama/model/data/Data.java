package com.widxy.ppdbtamtama.model.data;

import com.google.gson.annotations.SerializedName;

public class Data {
    @SerializedName("data")
    private DataData dataData;

    @SerializedName("message")
    private String message;

    @SerializedName("status")
    private boolean status;

    public DataData getDataData() {
        return dataData;
    }

    public void setDataData(DataData dataData) {
        this.dataData = dataData;
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
