package com.example.pedro.mobilenutri.Entidade;

/**
 * Created by pedro on 22/10/17.
 */

public class Refeicao {

    private long idRefeicao;
    private long idDieta;
    private int horas;
    private int minutos;

    public Refeicao(long idRefeicao , long idDieta , int horas , int minutos){

        this.idRefeicao = idRefeicao;
        this.idDieta = idDieta;
        this.horas = horas;
        this.minutos = minutos;

    }

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
}
