package com.example.pas_genap_1_37;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.ViewModelProvider;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {

    private BottomNavigationView bottomNavigationView;
    private TeamViewModel teamViewModel; // Jika TeamViewModel masih relevan untuk Fragment lain

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bottomNavigationView = findViewById(R.id.bottom_navigation);

        teamViewModel = new ViewModelProvider(this).get(TeamViewModel.class); // Jaga ini jika masih dibutuhkan

        if (savedInstanceState == null) {
            loadFragment(SpanyolFragment.newInstance()); // Fragment default tetap Spanyol
        }

        bottomNavigationView.setOnItemSelectedListener(item -> {
            Fragment selectedFragment = null;
            int itemId = item.getItemId();

            if (itemId == R.id.menu_spanyol) {
                selectedFragment = SpanyolFragment.newInstance();
            } else if (itemId == R.id.menu_players) { // KOREKSI: Tambahkan kondisi untuk menu pemain
                selectedFragment = PlayerFragment.newInstance();
            }


            if (selectedFragment != null) {
                loadFragment(selectedFragment);
                return true;
            }
            return false;
        });
    }

    private void loadFragment(Fragment fragment) {
        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
        ft.replace(R.id.frame_layout, fragment);
        ft.commit();
    }
}