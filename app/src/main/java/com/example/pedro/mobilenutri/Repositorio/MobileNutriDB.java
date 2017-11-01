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

        sqLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS dieta (_id integer primary key autoincrement , nome text , quantidadecalorias real , quantidadeacucar real , quantidadesodio real); ");
        sqLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS refeicao (_id integer primary key autoincrement , iddieta integer , horas integer , minutos integer , nome text);");
        sqLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS refeicaoalimento (idrefeicao integer , idalimento integer , quantidade real);");
        
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }

    public void resetarBaseDeDados(){
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();

        sqLiteDatabase.delete("dieta" , null , null);
        sqLiteDatabase.delete("refeicao" , null , null);
        sqLiteDatabase.delete("refeicaoalimento" , null , null);

        sqLiteDatabase.close();
    }
}
