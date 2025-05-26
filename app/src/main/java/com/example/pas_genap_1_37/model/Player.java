package com.example.pas_genap_1_37.model;

import com.google.gson.annotations.SerializedName;

public class Player {
    @SerializedName("idPlayer")
    private String idPlayer;

    @SerializedName("strPlayer")
    private String strPlayer;

    @SerializedName("strPosition")
    private String strPosition;

    @SerializedName("strThumb") // URL gambar potret pemain
    private String strThumb;

    @SerializedName("strDescriptionEN")
    private String strDescriptionEN;


    public String getIdPlayer() {
        return idPlayer;
    }

    public String getStrPlayer() {
        return strPlayer;
    }

    public String getStrPosition() {
        return strPosition;
    }

    public String getStrThumb() {
        return strThumb;
    }

    public String getStrDescriptionEN() {
        return strDescriptionEN;
    }
}