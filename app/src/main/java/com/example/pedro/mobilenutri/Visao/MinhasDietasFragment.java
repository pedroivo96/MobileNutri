package com.example.pedro.mobilenutri.Visao;


import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

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
    private Context context;
    private DietasAdapter dietasAdapter;

    public MinhasDietasFragment() {
        // Required empty public constructor

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_minhas_dietas, container, false);

        controleDieta = new ControleDieta(getContext());
        dietas = controleDieta.obterTodasAsDietas();

        minhasDietas = view.findViewById(R.id.minhasDietas);
        dietasAdapter = new DietasAdapter(getActivity(),dietas);
        minhasDietas.setAdapter(dietasAdapter);

        minhasDietas.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Dieta dieta = (Dieta) adapterView.getAdapter().getItem(i);

                Intent intent = new Intent(getContext() , DietaActivity.class);
                intent.putExtra("dieta",dieta);

                startActivity(intent);

            }
        });

        return view;

    }

    @Override
    public void onAttach(Context context) {
        this.context = context;
        super.onAttach(context);
    }

    @Override

    public void onDetach() {
        super.onDetach();
    }

    /*@Override
    public void onStart() {

        Toast.makeText(context, "Chamou onStart", Toast.LENGTH_SHORT).show();

        super.onStart();
        dietas = controleDieta.obterTodasAsDietas();

        dietasAdapter = new DietasAdapter(getActivity(),dietas);
        minhasDietas.setAdapter(dietasAdapter);

    }*/

    @Override
    public void onResume() {

        Toast.makeText(context, "Chamou onResume", Toast.LENGTH_SHORT).show();

        super.onResume();
        dietas = controleDieta.obterTodasAsDietas();

        dietasAdapter = new DietasAdapter(getActivity(),dietas);
        minhasDietas.setAdapter(dietasAdapter);
    }

}
