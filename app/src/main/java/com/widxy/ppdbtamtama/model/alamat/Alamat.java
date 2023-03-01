package com.widxy.ppdbtamtama.model.alamat;

import com.google.gson.annotations.SerializedName;

public class Alamat {

    @SerializedName("data")
    private AlamatData alamatData;

    @SerializedName("message")
    private String message;

    @SerializedName("status")
    private boolean status;

    public AlamatData getAlamatData() {
        return alamatData;
    }

    public void setAlamatData(AlamatData alamatData) {
        this.alamatData = alamatData;
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
