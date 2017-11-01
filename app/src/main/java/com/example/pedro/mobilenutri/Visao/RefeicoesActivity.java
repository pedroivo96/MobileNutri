package com.example.pedro.mobilenutri.Visao;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;

import com.example.pedro.mobilenutri.Controle.ControleRefeicao;
import com.example.pedro.mobilenutri.Entidade.Dieta;
import com.example.pedro.mobilenutri.Entidade.Refeicao;
import com.example.pedro.mobilenutri.R;

import java.util.ArrayList;

public class RefeicoesActivity extends AppCompatActivity {

    private ListView listViewRefeicoes;
    private Button buttonAdicionarRefeicao;
    private ArrayList<Refeicao> refeicoes;
    private ControleRefeicao controleRefeicao;
    private Dieta dieta;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_refeicoes);

        final Intent intent = getIntent();
        dieta = (Dieta) intent.getSerializableExtra("dieta");
        //Log.d("Teste", dieta.toString());
        refeicoes = new ArrayList<>();

        listViewRefeicoes = (ListView) findViewById(R.id.refeicoes);
        buttonAdicionarRefeicao = (Button) findViewById(R.id.adicionarRefeicao);
        controleRefeicao = new ControleRefeicao(getContext());
        refeicoes = controleRefeicao.pesquisarRefeicoesDeUmaDieta(dieta.getId());

        listViewRefeicoes.setAdapter(new RefeicoesAdapter(getContext() , refeicoes));
        listViewRefeicoes.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                Refeicao refeicao = (Refeicao) adapterView.getAdapter().getItem(i);

                Intent intent1 = new Intent(getContext() , RefeicaoActivity.class);
                intent1.putExtra("refeicao" , refeicao);

                startActivity(intent1);
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        buttonAdicionarRefeicao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //Redireciona para uma Activity onde o usuario diz o nome da refeicao e seu horario ( Spinner )
                Intent intent1 = new Intent(getContext(), AdicionarRefeicaoActivity.class);
                intent1.putExtra("dieta" , dieta);
                startActivity(intent1);
            }
        });

    }

    public Context getContext(){
        return this;
    }
}
