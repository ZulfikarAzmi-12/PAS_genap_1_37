package com.example.pas_genap_1_37;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.pas_genap_1_37.model.Spanyol;

import java.util.List;

public class TeamViewModel extends ViewModel {
    private final MutableLiveData<List<Spanyol>> teamsLiveData = new MutableLiveData<>();

    public void setTeams(List<Spanyol> teams) {
        teamsLiveData.setValue(teams);
    }

    public LiveData<List<Spanyol>> getTeams() {
        return teamsLiveData;
    }
}
