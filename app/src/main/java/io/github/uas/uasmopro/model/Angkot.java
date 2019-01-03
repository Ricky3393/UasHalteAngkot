package io.github.uas.uasmopro.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Angkot {

    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("RUAS_JALAN")
    @Expose
    private String rUASJALAN;
    @SerializedName("TITIK_LOKASI")
    @Expose
    private String tITIKLOKASI;
    @SerializedName("KETERANGAN")
    @Expose
    private String kETERANGAN;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getRUASJALAN() {
        return rUASJALAN;
    }

    public void setRUASJALAN(String rUASJALAN) {
        this.rUASJALAN = rUASJALAN;
    }

    public String getTITIKLOKASI() {
        return tITIKLOKASI;
    }

    public void setTITIKLOKASI(String tITIKLOKASI) {
        this.tITIKLOKASI = tITIKLOKASI;
    }

    public String getKETERANGAN() {
        return kETERANGAN;
    }

    public void setKETERANGAN(String kETERANGAN) {
        this.kETERANGAN = kETERANGAN;
    }

}