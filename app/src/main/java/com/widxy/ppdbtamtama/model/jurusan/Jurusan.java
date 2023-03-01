package com.widxy.ppdbtamtama.model.jurusan;

import com.google.gson.annotations.SerializedName;

public class Jurusan {
    @SerializedName("data")
    private JurusanData jurusanData;

    @SerializedName("message")
    private String message;

    @SerializedName("status")
    private boolean status;

    public JurusanData getJurusanData() {
        return jurusanData;
    }

    public void setJurusanData(JurusanData jurusanData) {
        this.jurusanData = jurusanData;
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
