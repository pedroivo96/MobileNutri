package com.example.pedro.mobilenutri.Visao;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.pedro.mobilenutri.Entidade.AlimentoTACOS;
import com.example.pedro.mobilenutri.R;

import java.util.ArrayList;

public class ResultadosPesquisaAlimentosActivity extends AppCompatActivity {

    private ListView resultadosPesquisa;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resultados_pesquisa_alimentos);

        Intent intent = getIntent();

        final ArrayList<AlimentoTACOS> alimentosTACOS = (ArrayList<AlimentoTACOS>) intent.getSerializableExtra("alimentos");

        resultadosPesquisa = (ListView) findViewById(R.id.resultadosPesquisaAlimentos);

        ArrayList<String> nomesAlimentos = new ArrayList<>();
        for(int i = 0; i < alimentosTACOS.size();i++){
            nomesAlimentos.add(alimentosTACOS.get(i).getNomeAlimento());
        }

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, nomesAlimentos);
        resultadosPesquisa.setAdapter(adapter);

        resultadosPesquisa.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                Intent intent = new Intent(getContext(), AlimentoActivity.class);
                intent.putExtra("alimento", alimentosTACOS.get(i));
                startActivity(intent);
            }
        });


    }

    private Context getContext(){
        return this;
    }
}
