package com.example.pedro.mobilenutri.Controle;

import android.content.Context;

import com.example.pedro.mobilenutri.Entidade.Dieta;
import com.example.pedro.mobilenutri.Repositorio.RepositorioDieta;

import java.util.ArrayList;

/**
 * Created by pedro on 23/10/17.
 */

public class ControleDieta {
    //Interage com o RepositórioDieta

    private RepositorioDieta repositorioDieta;

    public ControleDieta(Context context){
        this.repositorioDieta = new RepositorioDieta(context);
    }

    public long inserirDieta(Dieta dieta){

        long idDieta;

        idDieta = repositorioDieta.inserirDieta(dieta);

        return idDieta;
    }

    public Dieta pesquisarDietaPorId(long idDieta){

        Dieta dieta;

        dieta = repositorioDieta.pesquisarDieta(idDieta);

        return dieta;
    }

    public Dieta pesquisarDietaPorNome(String nomeDieta){

        Dieta dieta = null;

        return dieta;
    }


    public int deletarDietaPorId(long idDieta){

        int count;

        count = repositorioDieta.deletarDieta(idDieta);

        return count;
    }

    public ArrayList<Dieta> obterTodasAsDietas(){
        ArrayList<Dieta> dietas;

        dietas = repositorioDieta.obterTodasAsDietas();

        return dietas;
    }
}
