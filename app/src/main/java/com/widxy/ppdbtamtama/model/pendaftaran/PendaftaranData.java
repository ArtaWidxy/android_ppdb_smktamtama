package com.widxy.ppdbtamtama.model.pendaftaran;

import com.google.gson.annotations.SerializedName;

public class PendaftaranData {
    @SerializedName("id_siswa")
    private String id_siswa;

    @SerializedName("status")
    private String status;

    public String getId_siswa() {
        return id_siswa;
    }

    public void setId_siswa(String id_siswa) {
        this.id_siswa = id_siswa;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
