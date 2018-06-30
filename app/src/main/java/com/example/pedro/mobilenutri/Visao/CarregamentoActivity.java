package com.example.pedro.mobilenutri.Visao;

import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.widget.Toast;

import com.example.pedro.mobilenutri.Controle.ControleAlimento;
import com.example.pedro.mobilenutri.R;

import java.io.IOException;

public class CarregamentoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_carregamento);

        CarregaArquivos carregaArquivos = new CarregaArquivos();
        carregaArquivos.execute();

        /*Toast.makeText(getContext(), "Carregamento Concluído", Toast.LENGTH_SHORT).show();

        Intent intent = new Intent(getContext(), MenuActivity.class);
        startActivity(intent);*/
    }

    public Context getContext(){
        return this;
    }

   private class CarregaArquivos extends AsyncTask<Void, Void, String>{

       @Override
       protected void onPreExecute() {
           super.onPreExecute();
       }

       @Override
       protected void onPostExecute(String s) {
           super.onPostExecute(s);

           Toast.makeText(getContext(), s, Toast.LENGTH_SHORT).show();

           Intent intent = new Intent(getContext(), MenuActivity.class);
           startActivity(intent);
       }

       @Override
       protected String doInBackground(Void... voids) {

           try {
               ControleAlimento controleAlimento = new ControleAlimento(getContext());
           } catch (IOException e) {
               e.printStackTrace();
           }
           return "Carregamento Concluído";
       }
   }
}
