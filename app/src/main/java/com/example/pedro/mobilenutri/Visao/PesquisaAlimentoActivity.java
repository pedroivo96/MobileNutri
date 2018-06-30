package com.example.pedro.mobilenutri.Visao;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.pedro.mobilenutri.Controle.ControleAlimento;
import com.example.pedro.mobilenutri.Entidade.AlimentoTACOS;
import com.example.pedro.mobilenutri.R;

import java.io.IOException;
import java.util.ArrayList;

public class PesquisaAlimentoActivity extends AppCompatActivity {

    private EditText eNomeAlimento;
    private Button bPesquisarAlimento;
    private ControleAlimento controleAlimento;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pesquisa_alimento);

        eNomeAlimento = (EditText) findViewById(R.id.eNomeAlimento);
        bPesquisarAlimento = (Button) findViewById(R.id.bPesquisarAlimento);

        try {
            controleAlimento = new ControleAlimento(getContext());
        } catch (IOException e) {
            e.printStackTrace();
        }

        bPesquisarAlimento.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(eNomeAlimento.getText().toString().equals("")){
                    Toast.makeText(getContext(), "Nenhum nome digitado", Toast.LENGTH_SHORT).show();
                }
                else{

                    String nomeAlimento = eNomeAlimento.getText().toString();

                    ArrayList<AlimentoTACOS> alimentos = new ArrayList<AlimentoTACOS>();
                    try {
                        alimentos = controleAlimento.obterAlimentosPeloNome(nomeAlimento);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }

                    if(alimentos.isEmpty()){
                        Toast.makeText(getContext(), "Nenhum alimento encontrado", Toast.LENGTH_SHORT).show();
                    }
                    else{

                        Intent intent = new Intent(getContext(), ResultadosPesquisaAlimentosActivity.class);
                        intent.putExtra("alimentos", alimentos);
                        startActivity(intent);
                    }

                }
            }
        });
    }

    private Context getContext(){
        return this;
    }
}
