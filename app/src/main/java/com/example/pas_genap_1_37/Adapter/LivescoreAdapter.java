package com.example.pas_genap_1_37.Adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.pas_genap_1_37.R;
import com.example.pas_genap_1_37.model.Livescore;

import java.util.List;

public class LivescoreAdapter extends RecyclerView.Adapter<LivescoreAdapter.ViewHolder> {

    private List<Livescore> livescoreList;

    public LivescoreAdapter(List<Livescore> livescoreList) {
        this.livescoreList = livescoreList;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public TextView tvEvent, tvScore;

        public ViewHolder(View view) {
            super(view);
            tvEvent = view.findViewById(R.id.tvEvent);
            tvScore = view.findViewById(R.id.tvScore);
        }
    }

    @NonNull
    @Override
    public LivescoreAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_livescore, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Livescore item = livescoreList.get(position);
        holder.tvEvent.setText(item.getEvent());
        holder.tvScore.setText(item.getScore());
    }

    @Override
    public int getItemCount() {
        return livescoreList.size();
    }
}
