package com.example.termin17jelofragment;

import android.graphics.drawable.Drawable;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.io.InputStream;
import java.util.jar.Attributes;

public class DetailsFragment extends Fragment {
    private int id;
    TextView tvNaziv, tvOpis, tvKategorija, tvSastojci, tvKalorije, tvCena;
        ImageView ivSlika;

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

        tvNaziv = view.findViewById(R.id.textView_Naziv);
        tvOpis = view.findViewById(R.id.textView_Opis);
        tvKategorija = view.findViewById(R.id.textView_Kategorija);
        tvSastojci = view.findViewById(R.id.textView_Sastojci);
        tvKalorije = view.findViewById(R.id.textView_Kalorije);
        tvCena = view.findViewById(R.id.textView_Cena);

        ivSlika = view.findViewById(R.id.imageView_Slika);

        setupViews();

        }

public void setId(int id) {
        this.id = id;
        }

private void setupViews() {
        Jelo jelo_ref = JeloProvider.getJeloById(id);

        tvNaziv.setText(jelo_ref.getNaziv());
        tvOpis.setText(jelo_ref.getOpis());
        tvKategorija.setText(jelo_ref.getKategorija());
        tvSastojci.setText(jelo_ref.getSastojci());
        tvKalorije.setText(jelo_ref.getKategorija() + " KCAL");
        tvCena.setText(jelo_ref.getCena() + " RSD");


        try {
        InputStream is = getContext().getAssets().open(jelo_ref.getSlikaUrl());
        Drawable drawable = Drawable.createFromStream(is, null);

        ivSlika.setImageDrawable(drawable);
        } catch (Exception e) {
        Toast.makeText(getContext(), e.getMessage(), Toast.LENGTH_SHORT).show();
        }
        }

        public void updateID(int id) {
        this.id = id;
        setupViews();
        }

        }