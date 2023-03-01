package com.widxy.ppdbtamtama.model.pengumuman;

import com.google.gson.annotations.SerializedName;
import com.widxy.ppdbtamtama.model.pendaftaran.PendaftaranData;

public class Pengumuman {
    @SerializedName("message")
    private String message;

    @SerializedName("status")
    private boolean status;

    @SerializedName("data")
    private PengumumanData pengumumanData;

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

    public PengumumanData getPengumumanData() {
        return pengumumanData;
    }

    public void setPengumumanData(PengumumanData pengumumanData) {
        this.pengumumanData = pengumumanData;
    }
}
