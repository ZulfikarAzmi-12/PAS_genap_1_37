package com.example.pas_genap_1_37.Adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.pas_genap_1_37.R;
import com.example.pas_genap_1_37.model.Player;

import java.util.List;

public class PlayerAdapter extends RecyclerView.Adapter<PlayerAdapter.ViewHolder> {
    private List<Player> playerList;

    public PlayerAdapter(List<Player> playerList) {
        this.playerList = playerList;
    }

    public void setPlayerList(List<Player> playerList) {
        this.playerList = playerList;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_player, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Player player = playerList.get(position);
        holder.playerName.setText(player.getStrPlayer());
        holder.playerPosition.setText(player.getStrPosition());
        holder.playerDescription.setText(player.getStrDescriptionEN());

        Glide.with(holder.itemView.getContext())
                .load(player.getStrThumb())
                .placeholder(R.drawable.ic_launcher_foreground)
                .error(R.drawable.ic_launcher_background)
                .into(holder.playerThumb);
    }

    @Override
    public int getItemCount() {
        return playerList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        TextView playerName, playerPosition, playerDescription;
        ImageView playerThumb;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            playerName = itemView.findViewById(R.id.tvPlayerName);
            playerPosition = itemView.findViewById(R.id.tvPlayerPosition);
            playerDescription = itemView.findViewById(R.id.tvPlayerDescription);
            playerThumb = itemView.findViewById(R.id.imgPlayerThumb);
        }
    }
}