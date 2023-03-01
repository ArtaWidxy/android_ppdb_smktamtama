package com.widxy.ppdbtamtama.model.alamat;

import com.google.gson.annotations.SerializedName;

public class AlamatData {
    @SerializedName("id_siswa")
    private String id_siswa;

    @SerializedName("longitude")
    private String longitude;

    @SerializedName("latitude")
    private String latitude;

    @SerializedName("alamat")
    private String alamat;

    @SerializedName("jarak")
    private String jarak;

    @SerializedName("url")
    private String url;

    public String getid_siswa() {
        return id_siswa;
    }

    public void setid_siswa(String id_siswa) {
        this.id_siswa = id_siswa;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public String getAlamat() {
        return alamat;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }

    public String getJarak() {
        return jarak;
    }

    public void setJarak(String jarak) {
        this.jarak = jarak;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
