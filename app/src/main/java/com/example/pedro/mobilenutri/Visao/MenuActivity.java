package com.example.pedro.mobilenutri.Visao;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import com.example.pedro.mobilenutri.R;
import com.example.pedro.mobilenutri.Repositorio.MobileNutriDB;

public class MenuActivity extends AppCompatActivity {

    private MobileNutriDB mobileNutriDB;
    private Button bPesquisarAlimento;
    private Button bListarAlimentos;
    private Button bSobre;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        mobileNutriDB = new MobileNutriDB(this);

        bPesquisarAlimento = (Button) findViewById(R.id.bPesquisaAlimento);
        bPesquisarAlimento.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getContext(), PesquisaAlimentoActivity.class);
                startActivity(intent);
            }
        });


        bListarAlimentos = (Button) findViewById(R.id.bListarAlimentos);
        bListarAlimentos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getContext(), ListarAlimentosActivity.class);
                startActivity(intent);
            }
        });

        bSobre = (Button) findViewById(R.id.bSobre);
        bSobre.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getContext(), SobreActivity.class);
                startActivity(intent);
            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();

        if(id == R.id.zerar){

            AlertDialog.Builder alerta = new AlertDialog.Builder(MenuActivity.this);
            alerta.setTitle("Confirmação");
            alerta.setMessage("Você tem certeza que deseja apagar todos os dados cadastrados?");
            alerta.setNegativeButton("Não", null);
            alerta.setPositiveButton("Sim", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    mobileNutriDB.resetarBaseDeDados();
                }
            });
            AlertDialog dialog = alerta.create();
            dialog.show();

            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    private Context getContext(){
        return this;
    }
}
