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
import com.example.pas_genap_1_37.model.Spanyol;

import java.util.List;

public class SpanyolAdapter  extends RecyclerView.Adapter<SpanyolAdapter.ViewHolder> {
    public List<Spanyol> spanyolList;

    public SpanyolAdapter(List<Spanyol> spanyolList){
        this.spanyolList = spanyolList ;
    }

    public void setSpanyolList(List<Spanyol> spanyolList) {
        this.spanyolList = spanyolList;
    }

    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_spanyol, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Spanyol spanyol = spanyolList.get(position);
        holder.teamName.setText(spanyol.getStrTeam());
        holder.teamDescription.setText((spanyol.getStrDescriptionEN()));
        Glide.with(holder.itemView.getContext())
                .load(spanyol.getStrBadge())
                .placeholder(R.drawable.ic_launcher_foreground)
                .error(R.drawable.ic_launcher_background)
                .into(holder.teamBadge);
    }

    @Override
    public int getItemCount() {
        return spanyolList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        TextView teamName, teamDescription;
        ImageView teamBadge;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            teamName = itemView.findViewById(R.id.tvTeamName);
            teamDescription = itemView.findViewById(R.id.tvDescription);
            teamBadge = itemView.findViewById(R.id.imageTeam);
        }
    }


}
