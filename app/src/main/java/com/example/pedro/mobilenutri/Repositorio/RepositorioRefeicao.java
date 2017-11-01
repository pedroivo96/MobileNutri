package com.example.pedro.mobilenutri.Repositorio;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.pedro.mobilenutri.Entidade.Dieta;
import com.example.pedro.mobilenutri.Entidade.Refeicao;
import com.example.pedro.mobilenutri.R;

import java.util.ArrayList;

/**
 * Created by pedro on 23/10/17.
 */

public class RepositorioRefeicao {

    private String nomeTabela;
    private String colunaId;
    private String colunaIddieta;
    private String colunaHorasRefeicao;
    private String colunaMinutosRefeicao;
    private String colunaNomeRefeicao;

    private MobileNutriDB mobileNutriDB;
    private SQLiteDatabase sqLiteDatabase;

    public RepositorioRefeicao(Context context){

        this.mobileNutriDB = new MobileNutriDB(context);
        this.nomeTabela = "refeicao";
        this.colunaId = "_id";
        this.colunaIddieta = "iddieta";
        this.colunaHorasRefeicao = "horas";
        this.colunaMinutosRefeicao = "minutos";
        this.colunaNomeRefeicao = "nome";

    }

    public long inserirRefeicao(Refeicao refeicao){
        long id = -1;

        SQLiteDatabase sqLiteDatabase = mobileNutriDB.getWritableDatabase();

        try{
            ContentValues contentValues = new ContentValues();

            //Mapeia os dados no ContentValues
            contentValues.put(this.colunaIddieta, refeicao.getIdDieta());
            contentValues.put(this.colunaHorasRefeicao ,refeicao.getHoras());
            contentValues.put(this.colunaMinutosRefeicao , refeicao.getMinutos());
            contentValues.put(this.colunaNomeRefeicao , refeicao.getNome());

            id = sqLiteDatabase.insert(this.nomeTabela , null , contentValues);

            return id;

        }finally {
            sqLiteDatabase.close();
        }
    }

    public Refeicao pesquisarRefeicao(long id){

        ContentValues contentValues = new ContentValues();
        SQLiteDatabase sqLiteDatabase = mobileNutriDB.getReadableDatabase();
        Refeicao refeicao;

        //Parametros de Busca
        String colunasDesejadas[] = {this.colunaId , this.colunaIddieta , this.colunaHorasRefeicao , this.colunaMinutosRefeicao , this.colunaNomeRefeicao};
        String clausulaWhere = this.colunaId+" = ?";
        String argumentosWhere[] = {String.valueOf(id)};
        String ordenacao = this.colunaNomeRefeicao+ " DESC";

        //Retorna null se nada for encontrado
        Cursor cursor = sqLiteDatabase.query(this.nomeTabela , colunasDesejadas , clausulaWhere , argumentosWhere , null , null , ordenacao);

        if(cursor.getCount() > 0){

            //Caso encontre algum registro
            refeicao = new Refeicao();
            refeicao.setIdRefeicao(cursor.getLong(cursor.getColumnIndex(this.colunaId)));
            refeicao.setIdDieta(cursor.getLong(cursor.getColumnIndex(this.colunaIddieta)));
            refeicao.setHoras(cursor.getInt(cursor.getColumnIndex(this.colunaHorasRefeicao)));
            refeicao.setMinutos(cursor.getInt(cursor.getColumnIndex(this.colunaMinutosRefeicao)));
            refeicao.setNome(cursor.getString(cursor.getColumnIndex(this.colunaNomeRefeicao)));

        }
        else{

            refeicao = null;
        }

        sqLiteDatabase.close();

        return refeicao;
    }

    public ArrayList<Refeicao> pesquisarRefeicoesDeUmaDieta(long idDieta){
        ArrayList<Refeicao> refeicoes = null;
        SQLiteDatabase sqLiteDatabase = this.mobileNutriDB.getReadableDatabase();

        String clausulaWhere = this.colunaIddieta+" = ?";
        String argumentosWhere[] = {String.valueOf(idDieta)};

        try {
            Cursor cursor = sqLiteDatabase.query(this.nomeTabela , null , clausulaWhere , argumentosWhere , null , null , null);

            if(cursor.moveToFirst()){

                refeicoes = new ArrayList<Refeicao>();

                do{
                    //Caso encontre algum registro
                    Refeicao refeicao = new Refeicao();
                    refeicao.setIdRefeicao(cursor.getLong(cursor.getColumnIndex(this.colunaId)));
                    refeicao.setIdDieta(cursor.getLong(cursor.getColumnIndex(this.colunaIddieta)));
                    refeicao.setHoras(cursor.getInt(cursor.getColumnIndex(this.colunaHorasRefeicao)));
                    refeicao.setMinutos(cursor.getInt(cursor.getColumnIndex(this.colunaMinutosRefeicao)));
                    refeicao.setNome(cursor.getString(cursor.getColumnIndex(this.colunaNomeRefeicao)));

                    refeicoes.add(refeicao);

                }while (cursor.moveToNext());
            }

        }finally {

            sqLiteDatabase.close();
        }

        return refeicoes;
    }

    public int deletarRefeicao(long id){

        SQLiteDatabase sqLiteDatabase = mobileNutriDB.getWritableDatabase();
        String clausula = "_id = ?";
        String[] valorClausula = {String.valueOf(id)};
        int count;

        count = sqLiteDatabase.delete(this.nomeTabela , clausula , valorClausula);

        return count;
    }
}
