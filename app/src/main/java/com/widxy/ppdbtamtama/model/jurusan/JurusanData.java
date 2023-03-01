package com.widxy.ppdbtamtama.model.jurusan;

import com.google.gson.annotations.SerializedName;

public class JurusanData {
    @SerializedName("id_siswa")
    private String id_siswa;

    @SerializedName("jurusan1")
    private String jurusan1;

    @SerializedName("jurusan2")
    private String jurusan2;

    public String getId_siswa() {
        return id_siswa;
    }

    public void setId_siswa(String id_siswa) {
        this.id_siswa = id_siswa;
    }

    public String getJurusan1() {
        return jurusan1;
    }

    public void setJurusan1(String jurusan1) {
        this.jurusan1 = jurusan1;
    }

    public String getJurusan2() {
        return jurusan2;
    }

    public void setJurusan2(String jurusan2) {
        this.jurusan2 = jurusan2;
    }
}
