package com.example.pas_genap_1_37.model;

import com.google.gson.annotations.SerializedName;

public class Spanyol {
    @SerializedName("strTeam")
    private String strTeam;

    @SerializedName("strDescriptionEN")
    private String strDescriptionEN;

    @SerializedName("strBadge")
    private String strBadge;

    public String getStrTeam() {
        return strTeam;
    }

    public String getStrDescriptionEN() {
        return strDescriptionEN;
    }

    public String getStrBadge() {
        return strBadge;
    }
}
