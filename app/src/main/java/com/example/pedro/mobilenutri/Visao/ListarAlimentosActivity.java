package com.example.pedro.mobilenutri.Visao;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.pedro.mobilenutri.Controle.ControleAlimento;
import com.example.pedro.mobilenutri.Entidade.AlimentoTACOS;
import com.example.pedro.mobilenutri.R;

import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class ListarAlimentosActivity extends AppCompatActivity {

    Spinner spListaTiposAlimentos;
    ListView lvListaAlimentos;
    ControleAlimento controleAlimento;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listar_alimentos);

        //Obtendo as Views
        spListaTiposAlimentos = (Spinner) findViewById(R.id.spListaTiposAlimentos);
        lvListaAlimentos = (ListView) findViewById(R.id.lvListaAlimentos);

        //Obtendo o ControleAlimento
        try {
            controleAlimento = new ControleAlimento(getContext());
        } catch (IOException e) {
            e.printStackTrace();
            Toast.makeText(getContext(), "Erro na Leitura do Arquivo", Toast.LENGTH_SHORT).show();
        }

        //Declarando um List de Strings com os Tipos de Alimentos
        ArrayList<String> listaTiposAlimentos = new ArrayList<>();

        //Populando com os Tipos de Alimentos
        listaTiposAlimentos.add("Cereais e derivados");
        listaTiposAlimentos.add("Verduras, hortaliças e derivados");
        listaTiposAlimentos.add("Frutas e derivados");
        listaTiposAlimentos.add("Gorduras e óleos");
        listaTiposAlimentos.add("Pescados e frutos do mar");
        listaTiposAlimentos.add("Carnes e derivados");
        listaTiposAlimentos.add("Leite e derivados");
        listaTiposAlimentos.add("Bebidas (alcoólicas e não alcoólicas)");
        listaTiposAlimentos.add("Ovos e derivados");
        listaTiposAlimentos.add("Produtos açucarados");
        listaTiposAlimentos.add("Miscelâneas");
        listaTiposAlimentos.add("Outros alimentos industrializados");
        listaTiposAlimentos.add("Leguminosas e derivados");
        listaTiposAlimentos.add("Nozes e sementes");

        //Criando um ArrayAdapter com os tipos dos alimentos
        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(getContext(),
                                                                    android.R.layout.simple_spinner_item,
                                                                    listaTiposAlimentos);

        //Drop Down Style
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        //Conectando o ArrayAdapter ao Spinner
        spListaTiposAlimentos.setAdapter(dataAdapter);

        //Configurando o evento de seleção de item no Spinner
        spListaTiposAlimentos.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                String tipoAlimento = adapterView.getItemAtPosition(i).toString();

                try {

                    //Obtém a lista com os alimentos referentes ao tipo selecionado
                    ArrayList<AlimentoTACOS> listaAlimentos = controleAlimento.obterAlimentosPeloTipo(tipoAlimento);

                    //Cria um ArrayList de String com os nomes do alimentos para serem colocado no ListView
                    ArrayList<String> listaNomesAlimentos = new ArrayList<String>();

                    //Popula o ArrayList de String com os nomes dos alimentos
                    for(int j = 0; j < listaAlimentos.size(); j++){
                        listaNomesAlimentos.add(listaAlimentos.get(j).getNomeAlimento());
                    }

                    //Cria um Adapter com a lista de Nomes dos alimentos
                    ArrayAdapter<String> adapter = new ArrayAdapter<String>(getContext(),
                                                                            android.R.layout.simple_list_item_1,
                                                                            listaNomesAlimentos);

                    //Associa o Adapter com Nomes de Alimentos ao ListView
                    lvListaAlimentos.setAdapter(adapter);

                } catch (IOException e) {
                    e.printStackTrace();
                    Toast.makeText(getContext(), "Erro na Leitura do Arquivo", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

    }

    private Context getContext(){
        return this;
    }
}
