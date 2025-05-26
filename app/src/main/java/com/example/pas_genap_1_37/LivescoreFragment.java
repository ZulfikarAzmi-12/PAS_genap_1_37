package com.example.pas_genap_1_37;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.android.volley.Request;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.example.pas_genap_1_37.R;
import com.example.pas_genap_1_37.Adapter.LivescoreAdapter;
import com.example.pas_genap_1_37.model.Livescore;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class LivescoreFragment extends Fragment {

    private RecyclerView recyclerView;
    private LivescoreAdapter adapter;
    private List<Livescore> livescoreList;

    public LivescoreFragment() {}

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_livescore, container, false);
        recyclerView = view.findViewById(R.id.rvLivescore);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        livescoreList = new ArrayList<>();
        adapter = new LivescoreAdapter(livescoreList);
        recyclerView.setAdapter(adapter);

        fetchLivescore();

        return view;
    }

    private void fetchLivescore() {
        String url = "https://www.thesportsdb.com/api/v2/json/livescore/soccer";

        JsonObjectRequest request = new JsonObjectRequest(Request.Method.GET, url, null,
                response -> {
                    try {
                        JSONArray events = response.getJSONArray("events");
                        for (int i = 0; i < events.length(); i++) {
                            JSONObject obj = events.getJSONObject(i);
                            String home = obj.getString("strHomeTeam");
                            String away = obj.getString("strAwayTeam");
                            String homeScore = obj.optString("intHomeScore", "-");
                            String awayScore = obj.optString("intAwayScore", "-");
                            String score = homeScore + " : " + awayScore;
                            livescoreList.add(new Livescore(home + " vs " + away, score));
                        }
                        adapter.notifyDataSetChanged();
                    } catch (Exception e) {
                        Log.e("Livescore", "Parsing error: " + e.getMessage());
                    }
                },
                error -> Log.e("Livescore", "Volley error: " + error.getMessage())
        );

        Volley.newRequestQueue(requireContext()).add(request);
    }
}
