package com.example.pedro.mobilenutri.Visao;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.example.pedro.mobilenutri.Controle.ControleDieta;
import com.example.pedro.mobilenutri.Entidade.Dieta;
import com.example.pedro.mobilenutri.R;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class MinhasDietasFragment extends Fragment {

    private ListView minhasDietas;
    private ControleDieta controleDieta;
    private ArrayList<Dieta> dietas;

    public MinhasDietasFragment() {
        // Required empty public constructor

        controleDieta = new ControleDieta(getActivity());
        dietas = controleDieta.obterTodasAsDietas();

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_minhas_dietas, container, false);

        minhasDietas = view.findViewById(R.id.minhasDietas);
        minhasDietas.setAdapter(new DietasAdapter(getActivity(),dietas));


        return view;
    }

}
