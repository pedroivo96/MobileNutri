package com.example.pedro.mobilenutri.Visao;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.pedro.mobilenutri.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class MinhasDietasFragment extends Fragment {


    public MinhasDietasFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_minhas_dietas, container, false);
    }

}
