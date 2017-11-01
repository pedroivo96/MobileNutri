package com.example.pedro.mobilenutri.Visao;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import com.example.pedro.mobilenutri.Controle.ControleAlimento;
import com.example.pedro.mobilenutri.Entidade.Alimento;
import com.example.pedro.mobilenutri.Entidade.Refeicao;
import com.example.pedro.mobilenutri.R;

import java.util.ArrayList;

public class RefeicaoActivity extends AppCompatActivity {

    private TextView textViewNomeRefeicao;
    private TextView textViewHoras;
    private TextView textViewMinutos;
    private ListView listViewAlimentos;

    private Refeicao refeicao;
    private ArrayList<Alimento> alimentos;

    private ControleAlimento controleAlimento;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_refeicao);

        Intent intent = getIntent();
        refeicao = (Refeicao) intent.getSerializableExtra("refeicao");

        controleAlimento = new ControleAlimento();

        textViewNomeRefeicao = (TextView) findViewById(R.id.textViewNomeRefeicao);
        textViewHoras = (TextView) findViewById(R.id.textViewHoras);
        textViewMinutos = (TextView) findViewById(R.id.textViewMinutos);

        listViewAlimentos = (ListView) findViewById(R.id.listViewAlimentos);
        listViewAlimentos.setAdapter(new AlimentosAdapter(getContext() , alimentos));
        listViewAlimentos.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                Alimento alimento = alimentos.get(i);

                /*Intent intent1 = new Intent(getContext() , AlimentoActivity.class);
                intent1.putExtra("alimento" , alimento);
                startActivity(intent1);*/

            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        textViewNomeRefeicao.setText(refeicao.getNome());
        textViewHoras.setText(refeicao.getHoras());
        textViewMinutos.setText(refeicao.getMinutos());
    }

    public Context getContext(){
        return this;
    }
}
