package com.widxy.ppdbtamtama.model.data;

import com.google.gson.annotations.SerializedName;

public class DataData {
    @SerializedName("id_pendaftar")
    private String id_pendaftar;

    @SerializedName("kode_pendaftar")
    private String kode_pendaftar;

    @SerializedName("nama_lengkap")
    private String nama_lengkap;

    @SerializedName("nis")
    private String nis;

    @SerializedName("nisn")
    private String nisn;

    @SerializedName("jenis_kelamin")
    private String jenis_kelamin;

    @SerializedName("tempat_lahir")
    private String tempat_lahir;

    @SerializedName("tanggal_lahir")
    private String tanggal_lahir;

    @SerializedName("agama")
    private String agama;

    @SerializedName("nik")
    private String nik;

    @SerializedName("no_telp")
    private String no_telp;

    @SerializedName("email")
    private String email;

    @SerializedName("alamat")
    private String alamat;

    public String getId_pendaftar() {
        return id_pendaftar;
    }

    public void setId_pendaftar(String id_pendaftar) {
        this.id_pendaftar = id_pendaftar;
    }

    public String getKode_pendaftar() {
        return kode_pendaftar;
    }

    public void setKode_pendaftar(String kode_pendaftar) {
        this.kode_pendaftar = kode_pendaftar;
    }

    public String getNama_lengkap() {
        return nama_lengkap;
    }

    public void setNama_lengkap(String nama_lengkap) {
        this.nama_lengkap = nama_lengkap;
    }

    public String getNis() {
        return nis;
    }

    public void setNis(String nis) {
        this.nis = nis;
    }

    public String getNisn() {
        return nisn;
    }

    public void setNisn(String nisn) {
        this.nisn = nisn;
    }

    public String getJenis_kelamin() {
        return jenis_kelamin;
    }

    public void setJenis_kelamin(String jenis_kelamin) {
        this.jenis_kelamin = jenis_kelamin;
    }

    public String getTempat_lahir() {
        return tempat_lahir;
    }

    public void setTempat_lahir(String tempat_lahir) {
        this.tempat_lahir = tempat_lahir;
    }

    public String getTanggal_lahir() {
        return tanggal_lahir;
    }

    public void setTanggal_lahir(String tanggal_lahir) {
        this.tanggal_lahir = tanggal_lahir;
    }

    public String getAgama() {
        return agama;
    }

    public void setAgama(String agama) {
        this.agama = agama;
    }

    public String getNik() {
        return nik;
    }

    public void setNik(String nik) {
        this.nik = nik;
    }

    public String getNo_telp() {
        return no_telp;
    }

    public void setNo_telp(String no_telp) {
        this.no_telp = no_telp;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAlamat() {
        return alamat;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }
}
