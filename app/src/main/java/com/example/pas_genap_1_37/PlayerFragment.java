package com.example.pas_genap_1_37;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.pas_genap_1_37.Adapter.PlayerAdapter;
import com.example.pas_genap_1_37.api.ApiClient;
import com.example.pas_genap_1_37.api.ApiService;
import com.example.pas_genap_1_37.model.Player;
import com.example.pas_genap_1_37.model.PlayerResponse;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PlayerFragment extends Fragment {
    private RecyclerView rvPlayers;
    private PlayerAdapter playerAdapter;
    private List<Player> playerList = new ArrayList<>();
    private ApiService apiService;

    private static final String TEAM_ID = "133604";

    public PlayerFragment() {

    }

    public static PlayerFragment newInstance() {
        return new PlayerFragment();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_player, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        rvPlayers = view.findViewById(R.id.rvPlayers);
        rvPlayers.setLayoutManager(new LinearLayoutManager(getContext()));
        playerAdapter = new PlayerAdapter(playerList);
        rvPlayers.setAdapter(playerAdapter);

        apiService = ApiClient.getClient().create(ApiService.class);
        fetchPlayers(TEAM_ID);
    }

    private void fetchPlayers(String teamId) {
        Call<PlayerResponse> call = apiService.getPlayersByTeamId(teamId);
        call.enqueue(new Callback<PlayerResponse>() {
            @Override
            public void onResponse(Call<PlayerResponse> call, Response<PlayerResponse> response) {
                if (response.isSuccessful() && response.body() != null) {
                    List<Player> players = response.body().getPlayers();
                    if (players != null && !players.isEmpty()) {
                        playerAdapter.setPlayerList(players);
                        Log.d("PlayerFragment", "Data pemain berhasil dimuat. Jumlah pemain: " + players.size());
                    } else {
                        Log.e("PlayerFragment", "Respons API berhasil, tapi daftar pemain kosong atau null.");
                    }
                } else {
                    Log.e("PlayerFragment", "Respons API tidak berhasil: " + response.code() + " - " + response.message());
                    if (response.errorBody() != null) {
                        try {
                            Log.e("PlayerFragment", "Error Body: " + response.errorBody().string());
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }

            @Override
            public void onFailure(Call<PlayerResponse> call, Throwable t) {
                Log.e("PlayerFragment", "Gagal memuat data API pemain: " + t.getMessage(), t);
                t.printStackTrace();
            }
        });
    }
}