package com.example.pedro.mobilenutri.Repositorio;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import com.example.pedro.mobilenutri.Entidade.Dieta;

import java.util.ArrayList;

/**
 * Created by pedro on 23/10/17.
 */

public class RepositorioDieta {

    private MobileNutriDB mobileNutriDB;
    private SQLiteDatabase sqLiteDatabase;

    public RepositorioDieta(Context context){
        this.mobileNutriDB = new MobileNutriDB(context);
    }

    public long inserirDieta(Dieta dieta){

        long id = -1;

        return id;
    }

    public Dieta pesquisarDieta(long idDieta){

        Dieta dieta = null;

        return dieta;
    }

    public int deletarDieta(long idDieta){
        int count = 0;

        return count;
    }

    public ArrayList<Dieta> obterTodasAsDietas(){
        ArrayList<Dieta> dietas = null;

        return dietas;
    }
}
