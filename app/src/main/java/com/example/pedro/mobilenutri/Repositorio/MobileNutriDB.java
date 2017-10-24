package com.example.pedro.mobilenutri.Repositorio;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by pedro on 23/10/17.
 */

public class MobileNutriDB extends SQLiteOpenHelper {

    private static final String NOME_BANCO = "banco.db";
    private static final int VERSAO_BANCO = 1;
    //private static final String TAG = "bancodb";

    public MobileNutriDB(Context context) {
        super(context, NOME_BANCO, null, VERSAO_BANCO);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {

        //sqLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS hoteis (_id integer primary key autoincrement, nome text, cidade text, estado text);");
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
