package com.example.termin17jelofragment;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.ListFragment;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity implements MasterFragment.OnJeloClickListener{

    private boolean landscape = false;
    private DetailsFragment detailsFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        showListView();

        if (findViewById(R.id.frameDetails) != null) {
            landscape = true;
            detailsFragment = new DetailsFragment();
            detailsFragment.setId(0);
            getSupportFragmentManager().beginTransaction().replace(R.id.frameDetails, detailsFragment).commit();
        }
    }

    private void showListView() {
        ListFragment listfragment = new ListFragment();

        getSupportFragmentManager().beginTransaction().replace(R.id.frameList, listfragment).addToBackStack(null).commit();
    }

    private void showName(int id) {
        if (landscape) {
            detailsFragment.updateID(id);
        } else {
            DetailsFragment detailsFragment = new DetailsFragment();
            detailsFragment.setId(id);
            getSupportFragmentManager().beginTransaction().replace(R.id.frameList, detailsFragment).addToBackStack(null).commit();
        }
    }

    @Override
    public void onJeloClicked(int id) {
        showName(id);
    }
}