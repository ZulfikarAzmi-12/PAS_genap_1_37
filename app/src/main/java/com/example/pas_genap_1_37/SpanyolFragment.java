package com.example.pas_genap_1_37;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.pas_genap_1_37.Adapter.SpanyolAdapter;
import com.example.pas_genap_1_37.api.ApiClient;
import com.example.pas_genap_1_37.api.ApiService;
import com.example.pas_genap_1_37.model.Spanyol;
import com.example.pas_genap_1_37.model.SpanyolResponse;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SpanyolFragment extends Fragment {
    private RecyclerView rvSpanyol;
    private SpanyolAdapter spanyolAdapter;
    private List<Spanyol> spanyolList = new ArrayList<>();
    private ApiService apiService;
    private com.example.pas_genap_1_37.TeamViewModel teamViewModel;


    public SpanyolFragment(){

    }

    public static SpanyolFragment newInstance(){
        return new SpanyolFragment();
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_spanyol, container, false);
    }

    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        rvSpanyol = view.findViewById(R.id.rvSpanyol);
        rvSpanyol.setLayoutManager(new LinearLayoutManager(getContext()));
        spanyolAdapter = new SpanyolAdapter(spanyolList);
        rvSpanyol.setAdapter(spanyolAdapter);

        teamViewModel = new ViewModelProvider(requireActivity()).get(TeamViewModel.class);

        apiService = ApiClient.getClient().create(ApiService.class);
        fetchTeams("Spanyol");

    }
    private void fetchTeams(String country) {
        Call<SpanyolResponse> call = apiService.getSpanyol(country);
        call.enqueue(new Callback<SpanyolResponse>() {
            @Override
            public void onResponse(Call<SpanyolResponse> call, Response<SpanyolResponse> response) {
                if (response.isSuccessful() && response.body() != null) {
                    List<Spanyol> teams = response.body().getSpanyol();
                    if (teams != null) {
                        spanyolAdapter.setSpanyolList(teams);

                        // Update data ke ViewModel, agar fragment lain (misal: search) bisa akses
                        teamViewModel.setTeams(teams);
                    }
                } else {
                    // Handle error
                }
            }

            @Override
            public void onFailure(Call<SpanyolResponse> call, Throwable t) {
                // Handle failure
            }
        });
    }



}
