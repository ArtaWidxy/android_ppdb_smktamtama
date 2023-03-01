package com.widxy.ppdbtamtama.model.pendaftaran;

import com.google.gson.annotations.SerializedName;

public class Pendaftaran {
    @SerializedName("data")
    private PendaftaranData pendaftaranData;

    @SerializedName("message")
    private String message;

    @SerializedName("status")
    private boolean status;

    public PendaftaranData getPendaftaranData() {
        return pendaftaranData;
    }

    public void setPendaftaranData(PendaftaranData pendaftaranData) {
        this.pendaftaranData = pendaftaranData;
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
