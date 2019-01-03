package io.github.uas.uasmopro.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class AngkotResponse {

    @SerializedName("status")
    @Expose
    private String status;
    @SerializedName("data")
    @Expose
    private List<Angkot> data = null;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public List<Angkot> getData() {
        return data;
    }

    public void setData(List<Angkot> data) {
        this.data = data;
    }
}