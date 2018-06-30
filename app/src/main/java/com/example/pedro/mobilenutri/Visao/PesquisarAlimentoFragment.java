package com.example.pedro.mobilenutri.Visao;


import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.example.pedro.mobilenutri.Controle.ControleAlimento;
import com.example.pedro.mobilenutri.Entidade.AlimentoTACOS;
import com.example.pedro.mobilenutri.R;

import java.io.IOException;
import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class PesquisarAlimentoFragment extends Fragment {

    private Context context;
    private EditText editTextNomeAlimento;
    private Button buttonPesquisarAlimento;
    private ControleAlimento controleAlimento;

    ArrayList<AlimentoTACOS> alimentosTACOS;

    public PesquisarAlimentoFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_pesquisar_alimento, container, false);

        editTextNomeAlimento = view.findViewById(R.id.nomeAlimento);
        buttonPesquisarAlimento = view.findViewById(R.id.pesquisarAlimento);

        try {
            controleAlimento = new ControleAlimento(getActivity());
        } catch (IOException e) {
            e.printStackTrace();
        }

        buttonPesquisarAlimento.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String nomeAlimento = editTextNomeAlimento.getText().toString();

                alimentosTACOS = new ArrayList<AlimentoTACOS>();

                try {

                    alimentosTACOS = controleAlimento.obterAlimentosPeloNome(nomeAlimento);

                } catch (IOException e) {
                    e.printStackTrace();
                }

                if(alimentosTACOS.size() == 0){
                    //Não foi encontrado nada

                    Toast.makeText(getActivity(), "Não foi encontrado nada", Toast.LENGTH_SHORT).show();
                }
                else{
                    //Teve resultado
                    //Passar o ArrayList de resultados pra classe dos Resultados de Pesquisa

                    Intent intent = new Intent(getActivity() , ResultadosPesquisaAlimentosActivity.class);
                    intent.putExtra("resultadosPesquisa" , alimentosTACOS);
                    startActivity(intent);
                }
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
}
