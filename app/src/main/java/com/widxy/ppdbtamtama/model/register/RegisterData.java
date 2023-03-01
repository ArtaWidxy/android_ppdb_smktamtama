package com.widxy.ppdbtamtama.model.register;

import com.google.gson.annotations.SerializedName;

public class RegisterData {
    @SerializedName("kode_pendaftar")
    private String kode_pendaftar;

    @SerializedName("username")
    private String username;

    @SerializedName("email")
    private String email;

    @SerializedName("role")
    private String role;

    public String getKode_pendaftar() {
        return kode_pendaftar;
    }

    public void setKode_pendaftar(String kode_pendaftar) {
        this.kode_pendaftar = kode_pendaftar;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}
