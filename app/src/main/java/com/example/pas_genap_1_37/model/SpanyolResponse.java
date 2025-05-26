package com.example.pas_genap_1_37.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class SpanyolResponse {
    @SerializedName("spanyol")
    private List<Spanyol> spanyol;

    public List<Spanyol> getSpanyol() {
        return spanyol;
    }
}
