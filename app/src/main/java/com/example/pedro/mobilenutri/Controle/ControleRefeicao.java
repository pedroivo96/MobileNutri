package com.example.pedro.mobilenutri.Controle;

import android.content.Context;

import com.example.pedro.mobilenutri.Entidade.Refeicao;
import com.example.pedro.mobilenutri.Repositorio.RepositorioRefeicao;

import java.util.ArrayList;

/**
 * Created by pedro on 23/10/17.
 */

public class ControleRefeicao {
    //Interage com o RepositorioRefeicao

    private RepositorioRefeicao repositorioRefeicao;

    public ControleRefeicao(Context context){

        this.repositorioRefeicao = new RepositorioRefeicao(context);
    }

    public Refeicao pesquisarRefeicaoPorId(long id){

        Refeicao refeicao;

        refeicao = repositorioRefeicao.pesquisarRefeicao(id);

        return  refeicao;
    }

    public long inserirRefeicao(Refeicao refeicao){

        long idRefeicao;

        idRefeicao = repositorioRefeicao.inserirRefeicao(refeicao);

        return idRefeicao;
    }

    public ArrayList<Refeicao> pesquisarRefeicoesDeUmaDieta(long idDieta){

        ArrayList<Refeicao> refeicoes;

        refeicoes = repositorioRefeicao.pesquisarRefeicoesDeUmaDieta(idDieta);

        return refeicoes;
    }

    public boolean removerRefeicao(int idRefeicao){

        boolean resultadoRemocao = false;

        return resultadoRemocao;
    }
}
