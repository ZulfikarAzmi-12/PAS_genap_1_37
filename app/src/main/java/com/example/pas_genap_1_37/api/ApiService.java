package com.example.pas_genap_1_37.api;

import com.example.pas_genap_1_37.model.PlayerResponse;
import com.example.pas_genap_1_37.model.SpanyolResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApiService {
    @GET("api/v1/json/3/search_all_teams.php?s=Soccer")
    Call<SpanyolResponse> getSpanyol(
            @Query("c") String country
    );

    @GET("api/v1/json/3/lookup_all_players.php")
    Call<PlayerResponse> getPlayersByTeamId(
            @Query("id") String teamId
    );
}