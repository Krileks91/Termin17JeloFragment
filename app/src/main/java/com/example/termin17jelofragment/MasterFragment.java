package com.example.termin17jelofragment;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MasterFragment extends Fragment {

    //Mi kuckamo:
    private ListView listView_Jela;
    private List<Jelo> jela = new ArrayList<>();

    private OnJeloClickListener listener;

    public MasterFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_master, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        listView_Jela = view.findViewById(R.id.listView);

        setupList();

    }

    private void setupList() {
        jela = JeloProvider.getAllJela();

        JeloAdapter adapter = new JeloAdapter(jela, getActivity());
        //ArrayAdapter<String> adapter = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_list_item_1, imena);
        listView_Jela.setAdapter(adapter);

        listView_Jela.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                if (listener != null) {
                    listener.onJeloClicked(i);
                }
            }
        });
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        if (context instanceof OnJeloClickListener) {
            listener = (OnJeloClickListener) context;
        } else {
            Toast.makeText(getContext(), "Morate implementirati intefrace", Toast.LENGTH_SHORT).show();

        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        listener = null;
    }

    interface OnJeloClickListener {
        void onJeloClicked(int id);
    }
}