package com.example.pedro.mobilenutri.Visao;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.pedro.mobilenutri.Entidade.Dieta;
import com.example.pedro.mobilenutri.R;

public class DietaActivity extends AppCompatActivity {

    private Dieta dieta;
    private TextView tNomeDieta;
    private TextView tQuantidadeCalorias;
    private TextView tQuantidadeSodio;
    private TextView tQuantidadeAcucar;
    private Button bVerRefeicoes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dieta);

        tNomeDieta = (TextView) findViewById(R.id.nomeDieta);
        tQuantidadeCalorias = (TextView) findViewById(R.id.quantidadeCalorias);
        tQuantidadeSodio = (TextView) findViewById(R.id.quantidadeSodio);
        tQuantidadeAcucar = (TextView) findViewById(R.id.quantidadeAcucar);
        bVerRefeicoes = (Button) findViewById(R.id.verRefeicoes);

        Intent intent = getIntent();
        dieta = (Dieta) intent.getSerializableExtra("dieta");

        tNomeDieta.setText(dieta.getNomeDieta());
        tQuantidadeCalorias.setText(Float.toString(dieta.getQuantidadeMaximaCalorias()));
        tQuantidadeSodio.setText(Float.toString(dieta.getQuantidadeMaximaSodio()));
        tQuantidadeAcucar.setText(Float.toString(dieta.getQuantidadeMaximaAcucar()));

        bVerRefeicoes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //Passar a dieta por Intent, ja que a id dela será usada para obter as refeicoes na proxima Activity
                Intent intent1 = new Intent(getContext(), RefeicoesActivity.class);
                intent1.putExtra("dieta",dieta);
                startActivity(intent1);
                finish();

            }
        });
    }

    public Context getContext(){
        return this;
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }
}
