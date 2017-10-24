package com.example.pedro.mobilenutri.Controle;

import com.example.pedro.mobilenutri.Entidade.Refeicao;
import com.example.pedro.mobilenutri.Repositorio.RepositorioRefeicao;

import java.util.ArrayList;

/**
 * Created by pedro on 23/10/17.
 */

public class ControleRefeicao {
    //Interage com o RepositorioRefeicao

    private RepositorioRefeicao repositorioRefeicao;

    public ControleRefeicao(){
        this.repositorioRefeicao = new RepositorioRefeicao();
    }

    public Refeicao pesquisarRefeicaoPorId(int id){

        Refeicao refeicao = null;

        return  refeicao;
    }

    public boolean inserirRefeicao(Refeicao refeicao){

        boolean resultadoInsercao = false;

        return resultadoInsercao;
    }

    public ArrayList<Refeicao> pesquisarRefeicoesDeUmaDieta(int idDieta){

        ArrayList<Refeicao> refeicoes = null;

        return refeicoes;
    }

    public boolean removerRefeicao(int idRefeicao){

        boolean resultadoRemocao = false;

        return resultadoRemocao;
    }
}
