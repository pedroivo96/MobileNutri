package com.example.pedro.mobilenutri.Visao;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.pedro.mobilenutri.Controle.ControleRefeicao;
import com.example.pedro.mobilenutri.Entidade.Dieta;
import com.example.pedro.mobilenutri.Entidade.Refeicao;
import com.example.pedro.mobilenutri.R;

public class AdicionarRefeicaoActivity extends AppCompatActivity {

    private EditText editTextNomeRefeicao;
    private Spinner spinnerHoras;
    private Spinner spinnerMinutos;
    private Button buttonAdicionarRefeicao;
    private ControleRefeicao controleRefeicao;
    Dieta dieta;
    String selecionadoHoras , selecionadoMinutos , nomeRefeicao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adicionar_refeicao);

        controleRefeicao = new ControleRefeicao(getContext());

        editTextNomeRefeicao = (EditText) findViewById(R.id.nomeRefeicao);
        spinnerHoras = (Spinner) findViewById(R.id.spinnerHoras);
        spinnerMinutos = (Spinner) findViewById(R.id.spinnerMinutos);
        buttonAdicionarRefeicao = (Button) findViewById(R.id.buttonAdicionarRefeicao);

        Intent intent = getIntent();
        dieta = (Dieta) intent.getSerializableExtra("dieta");
        long idDieta = dieta.getId();

        ArrayAdapter<CharSequence> adapter1 = ArrayAdapter.createFromResource(getContext() , R.array.horas_array , android.R.layout.simple_spinner_item);
        adapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerHoras.setAdapter(adapter1);

        ArrayAdapter<CharSequence> adapter2 = ArrayAdapter.createFromResource(getContext() , R.array.minutos_array , android.R.layout.simple_spinner_item);
        adapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerMinutos.setAdapter(adapter2);

        spinnerHoras.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                //Por padrão o item é Horas, então caso o Usuário tenho deixado ele significa que nao seleciona nenhum outri
                //Então deve-se exibir uma mensagem obrigando o usuário a selecionar algo

                selecionadoHoras = adapterView.getItemAtPosition(i).toString();

                //Toast.makeText(AdicionarRefeicaoActivity.this, "Selecionou "+selecionado, Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        spinnerMinutos.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

                selecionadoMinutos = adapterView.getItemAtPosition(i).toString();

                //Toast.makeText(AdicionarRefeicaoActivity.this, "Selecionou "+selecionado, Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        buttonAdicionarRefeicao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                nomeRefeicao = editTextNomeRefeicao.getText().toString();
                Refeicao refeicao = new Refeicao();
                refeicao.setNome(nomeRefeicao);
                refeicao.setIdDieta(dieta.getId());
                refeicao.setHoras(Integer.parseInt(selecionadoHoras));
                refeicao.setMinutos(Integer.parseInt(selecionadoMinutos));

                long id = controleRefeicao.inserirRefeicao(refeicao);

                if(id == -1){
                    //Nao deu certo

                    Toast.makeText(AdicionarRefeicaoActivity.this, "Não foi possível inserir", Toast.LENGTH_SHORT).show();
                }
                else{
                    //Deu certo
                    refeicao.setIdDieta(id);

                    Intent intent = new Intent(getContext(), RefeicoesActivity.class);
                    intent.putExtra("dieta" , dieta);
                    startActivity(intent);
                    finish();

                }
            }
        });

    }

    public Context getContext(){
        return this;
    }
}
