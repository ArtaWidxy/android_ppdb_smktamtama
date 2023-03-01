package com.widxy.ppdbtamtama.model.sekolah;

import com.google.gson.annotations.SerializedName;

public class SekolahData {
    @SerializedName("id_siswa")
    private String id_siswa;

    @SerializedName("nama_sekolah")
    private String nama_sekolah;

    @SerializedName("nama_kepala_sekolah")
    private String nama_kepala_sekolah;

    @SerializedName("status_sekolah")
    private String status_sekolah;

    @SerializedName("tahun_lulus")
    private String tahun_lulus;

    @SerializedName("nem")
    private String nem;

    @SerializedName("npsn_sekolah")
    private String npsn_sekolah;

    public String getId_siswa() {
        return id_siswa;
    }

    public void setId_siswa(String id_siswa) {
        this.id_siswa = id_siswa;
    }

    public String getNama_sekolah() {
        return nama_sekolah;
    }

    public void setNama_sekolah(String nama_sekolah) {
        this.nama_sekolah = nama_sekolah;
    }

    public String getNama_kepala_sekolah() {
        return nama_kepala_sekolah;
    }

    public void setNama_kepala_sekolah(String nama_kepala_sekolah) {
        this.nama_kepala_sekolah = nama_kepala_sekolah;
    }

    public String getStatus_sekolah() {
        return status_sekolah;
    }

    public void setStatus_sekolah(String status_sekolah) {
        this.status_sekolah = status_sekolah;
    }

    public String getTahun_lulus() {
        return tahun_lulus;
    }

    public void setTahun_lulus(String tahun_lulus) {
        this.tahun_lulus = tahun_lulus;
    }

    public String getNem() {
        return nem;
    }

    public void setNem(String nem) {
        this.nem = nem;
    }

    public String getNpsn_sekolah() {
        return npsn_sekolah;
    }

    public void setNpsn_sekolah(String npsn_sekolah) {
        this.npsn_sekolah = npsn_sekolah;
    }
}
