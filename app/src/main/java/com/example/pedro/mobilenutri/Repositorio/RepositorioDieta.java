package com.example.pedro.mobilenutri.Repositorio;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.pedro.mobilenutri.Entidade.Dieta;

import java.util.ArrayList;

/**
 * Created by pedro on 23/10/17.
 */

public class RepositorioDieta {

    private MobileNutriDB mobileNutriDB;
    //private SQLiteDatabase sqLiteDatabase;
    private String nomeTabela;

    private String colunaId;
    private String colunaNome;
    private String colunaCalorias;
    private String colunaSodio;
    private String colunaAcucar;

    public RepositorioDieta(Context context){

        this.mobileNutriDB = new MobileNutriDB(context);
        this.nomeTabela = "dieta";

        this.colunaId = "_id";
        this.colunaCalorias = "quantidadecalorias";
        this.colunaSodio = "quantidadesodio";
        this.colunaAcucar = "quantidadeacucar";
        this.colunaNome = "nome";
    }

    public long inserirDieta(Dieta dieta){

        //Obtem o ContentValues e o Repositório de Dados ( Em modo de Escrita )
        long id = -1;

        SQLiteDatabase sqLiteDatabase = mobileNutriDB.getWritableDatabase();

        try{
            ContentValues contentValues = new ContentValues();

            //Mapeia os dados no ContentValues
            contentValues.put(this.colunaNome, dieta.getNomeDieta());
            contentValues.put(this.colunaCalorias , dieta.getQuantidadeMaximaCalorias());
            contentValues.put(this.colunaAcucar, dieta.getQuantidadeMaximaAcucar());
            contentValues.put(this.colunaSodio , dieta.getQuantidadeMaximaSodio());

            id = sqLiteDatabase.insert(this.nomeTabela , null , contentValues);

            return id;

        }finally {
            sqLiteDatabase.close();
        }

    }

    public Dieta pesquisarDieta(long idDieta){

        ContentValues contentValues = new ContentValues();
        SQLiteDatabase sqLiteDatabase = mobileNutriDB.getReadableDatabase();
        Dieta dieta;

        //Parametros de Busca
        String colunasDesejadas[] = {this.colunaId , this.colunaCalorias , this.colunaSodio , this.colunaAcucar , this.colunaNome};
        String clausulaWhere = this.colunaId+" = ?";
        String argumentosWhere[] = {String.valueOf(idDieta)};
        String ordenacao = this.colunaNome+ " DESC";

        //Retorna null se nada for encontrado
        Cursor cursor = sqLiteDatabase.query(this.nomeTabela , colunasDesejadas , clausulaWhere , argumentosWhere , null , null , ordenacao);

        if(cursor.getCount() > 0){

            //Caso encontre algum registro
            dieta = new Dieta();
            dieta.setId(cursor.getLong(cursor.getColumnIndex(this.colunaId)));
            dieta.setNomeDieta(cursor.getString(cursor.getColumnIndex(this.colunaNome)));
            dieta.setQuantidadeMaximaAcucar(cursor.getFloat(cursor.getColumnIndex(this.colunaAcucar)));
            dieta.setQuantidadeMaximaCalorias(cursor.getFloat(cursor.getColumnIndex(this.colunaCalorias)));
            dieta.setQuantidadeMaximaSodio(cursor.getFloat(cursor.getColumnIndex(this.colunaSodio)));
        }
        else{

            dieta = null;
        }

        sqLiteDatabase.close();

        return dieta;
    }

    public int deletarDieta(long idDieta){

        SQLiteDatabase sqLiteDatabase = mobileNutriDB.getWritableDatabase();

        int count;
        String clausula = "_id = ?";
        String[] valorClausula = {String.valueOf(idDieta)};

        count = sqLiteDatabase.delete(this.nomeTabela , clausula , valorClausula);
        //Count será 1 caso tenha excluido o registro

        return count;
    }

    public ArrayList<Dieta> obterTodasAsDietas(){

        ArrayList<Dieta> dietas = null;
        SQLiteDatabase sqLiteDatabase = this.mobileNutriDB.getReadableDatabase();

        try {
            Cursor cursor = sqLiteDatabase.query(this.nomeTabela , null , null , null , null , null , null);

            if(cursor.moveToFirst()){

                dietas = new ArrayList<Dieta>();

                do{
                    Dieta dieta = new Dieta();
                    dieta.setId(cursor.getLong(cursor.getColumnIndex(this.colunaId)));
                    dieta.setNomeDieta(cursor.getString(cursor.getColumnIndex(this.colunaNome)));
                    dieta.setQuantidadeMaximaCalorias(cursor.getFloat(cursor.getColumnIndex(colunaCalorias)));
                    dieta.setQuantidadeMaximaSodio(cursor.getFloat(cursor.getColumnIndex(colunaSodio)));
                    dieta.setQuantidadeMaximaAcucar(cursor.getFloat(cursor.getColumnIndex(colunaAcucar)));

                    dietas.add(dieta);

                }while (cursor.moveToNext());
            }

        }finally {

            sqLiteDatabase.close();
        }

        return dietas;
    }
}
