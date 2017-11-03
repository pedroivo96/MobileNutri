package com.example.pedro.mobilenutri.Visao;


import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.pedro.mobilenutri.Controle.ControleDieta;
import com.example.pedro.mobilenutri.Entidade.Dieta;
import com.example.pedro.mobilenutri.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class NovaDietaFragment extends Fragment {

    //Declarando as Views
    private Button bCriarDieta;
    private EditText eNomeDieta;
    private EditText eMaxCalorias;
    private EditText eMaxSodio;
    private EditText eMaxAcucar;
    private ControleDieta controleDieta;
    private Context context;

    public NovaDietaFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_nova_dieta, container, false);

        controleDieta = new ControleDieta(getActivity());

        //Obtendo as Views
        bCriarDieta = view.findViewById(R.id.criarDieta);
        eNomeDieta = view.findViewById(R.id.nomeDieta);
        eMaxCalorias = view.findViewById(R.id.maxCalorias);
        eMaxSodio = view.findViewById(R.id.maxSodio);
        eMaxAcucar = view.findViewById(R.id.maxAcucar);

        bCriarDieta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //Tratar campos vazios
                if(eMaxAcucar.getText().toString().equals("") || 
                        eMaxCalorias.getText().toString().equals("") ||
                        eMaxSodio.getText().toString().equals("")){

                    Toast.makeText(getActivity(), "Ainda existem campos em branco", Toast.LENGTH_SHORT).show();
                    
                }

                //Montar o objeto Dieta
                Dieta dieta = new Dieta();
                dieta.setNomeDieta(eNomeDieta.getText().toString());
                dieta.setQuantidadeMaximaAcucar(Integer.parseInt(eMaxAcucar.getText().toString()));
                dieta.setQuantidadeMaximaCalorias(Integer.parseInt(eMaxCalorias.getText().toString()));
                dieta.setQuantidadeMaximaSodio(Integer.parseInt(eMaxSodio.getText().toString()));

                long idDieta = controleDieta.inserirDieta(dieta);

                if(idDieta == -1){
                    //Não deu certo

                    Toast.makeText(getActivity(), "Erro", Toast.LENGTH_SHORT).show();

                }
                else{
                    //Deu certo, redirecionar para TelaDieta

                    //Completa o objeto Dieta com seu _id
                    dieta.setId(idDieta);

                    Intent intent = new Intent(getActivity(), DietaActivity.class);
                    intent.putExtra("dieta", dieta);
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
