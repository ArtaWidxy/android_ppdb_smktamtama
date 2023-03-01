package com.widxy.ppdbtamtama.model.register;

import com.google.gson.annotations.SerializedName;

public class Register {
    @SerializedName("data")
    private RegisterData registerData;

    @SerializedName("message")
    private String message;

    @SerializedName("status")
    private boolean status;

    public RegisterData getRegisterData() {
        return registerData;
    }

    public void setRegisterData(RegisterData registerData) {
        this.registerData = registerData;
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
