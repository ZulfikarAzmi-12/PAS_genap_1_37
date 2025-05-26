package com.example.pas_genap_1_37;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import android.widget.TextView;

import androidx.fragment.app.Fragment;

public class profileFragment extends Fragment {
    private TextView tvProfileTitle;
    private TextView tvName1;
    private TextView tvName2;

    public profileFragment() {
    }

    public static profileFragment newInstance() {
        return new profileFragment();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_profile, container, false);
        tvProfileTitle = view.findViewById(R.id.tv_profile_title);
        tvName1 = view.findViewById(R.id.tv_name1);
        tvName2 = view.findViewById(R.id.tv_name2);
        return view;
    }
}
