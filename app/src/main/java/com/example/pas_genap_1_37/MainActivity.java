package com.example.pas_genap_1_37;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.ViewModelProvider;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {

    private BottomNavigationView bottomNavigationView;
    private TeamViewModel teamViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main); // Pastikan layout ini memiliki BottomNavigationView dan FrameLayout

        bottomNavigationView = findViewById(R.id.bottom_navigation); // Ganti dengan ID BottomNavigationView Anda

        // Inisialisasi ViewModel sekali di MainActivity (shared ke semua fragment)
        teamViewModel = new ViewModelProvider(this).get(TeamViewModel.class);

        // Set fragment default saat activity dibuat
        loadFragment(SpanyolFragment.newInstance());

        bottomNavigationView.setOnItemSelectedListener(item -> {
            Fragment fragment = null;
            int itemId = item.getItemId();

            if (itemId == R.id.menu_spanyol) {
                fragment = SpanyolFragment.newInstance();
            }
            // Tambahkan kondisi lain untuk item menu lainnya dan fragment yang sesuai

            if (fragment != null) {
                loadFragment(fragment);
                return true;
            }
            return false;
        });

    }
    private void loadFragment(Fragment fragment) {
        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
        ft.replace(R.id.frame_layout, fragment); // Ganti dengan ID FrameLayout Anda
        ft.commit();
    }

}