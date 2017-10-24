package com.example.pedro.mobilenutri.Repositorio;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

/**
 * Created by pedro on 23/10/17.
 */

public class RepositorioRefeicao {

    private MobileNutriDB mobileNutriDB;
    private SQLiteDatabase sqLiteDatabase;

    public RepositorioRefeicao(Context context){
        this.mobileNutriDB = new MobileNutriDB(context);
    }
}
