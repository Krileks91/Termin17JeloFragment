package com.example.termin17jelofragment;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.jar.Attributes;

public class DetailsFragment extends Fragment {

    private TextView tvJela;
    private int id;

    public DetailsFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_details, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        tvJela = view.findViewById(R.id.tvJela);
        setupViews();
    }
    //Dodajemo setter id
    public void setId(int id) {
        this.id = id;
    }

    private void setupViews(){
        tvJela.setText(JeloProvider.getAllJela(id));

    }

    //
    public void updateId(int id){
        this.id = id;
        tvJela.setText(JeloProvider.getJeloById(id));
    }
}