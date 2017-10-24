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

    public Dieta pesquisarDietaPorId(int idDieta){

        Dieta dieta = null;

        return dieta;
    }

    public Dieta pesquisarDietaPorNome(String nomeDieta){

        Dieta dieta = null;

        return dieta;
    }

    public long inserirDieta(Dieta dieta){

        long idDieta = -1;

        idDieta = repositorioDieta.inserirDieta(dieta);

        return idDieta;
    }

    public boolean removerDietaPorId(int idDieta){

        boolean resultadoRemocao = false;

        return resultadoRemocao;
    }

    public ArrayList<Dieta> obterTodasAsDietas(){
        ArrayList<Dieta> dietas = null;

        return dietas;
    }
}
