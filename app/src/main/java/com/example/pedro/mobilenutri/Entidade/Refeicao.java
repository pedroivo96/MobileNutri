package com.example.pedro.mobilenutri.Entidade;

import java.io.Serializable;

/**
 * Created by pedro on 22/10/17.
 */

public class Refeicao implements Serializable {

    private long idRefeicao;
    private long idDieta;
    private String nome;
    private int horas;
    private int minutos;

    /*public Refeicao(long idDieta , int horas , int minutos , String nome){

        this.idDieta = idDieta;
        this.horas = horas;
        this.minutos = minutos;
        this.nome = nome;

    }*/

    public long getIdRefeicao() {
        return idRefeicao;
    }

    public void setIdRefeicao(long idRefeicao) {
        this.idRefeicao = idRefeicao;
    }

    public long getIdDieta() {
        return idDieta;
    }

    public void setIdDieta(long idDieta) {
        this.idDieta = idDieta;
    }

    public int getHoras() {
        return horas;
    }

    public void setHoras(int horas) {
        this.horas = horas;
    }

    public int getMinutos() {
        return minutos;
    }

    public void setMinutos(int minutos) {
        this.minutos = minutos;

    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
