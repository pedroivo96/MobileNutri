package com.example.pedro.mobilenutri.Entidade;

import java.io.Serializable;

/**
 * Created by pedro on 22/10/17.
 */

public class Dieta implements Serializable {

    private long idDieta;
    private String nomeDieta;
    private float quantidadeMaximaCalorias;
    private float quantidadeMaximaSodio;
    private float quantidadeMaximaAcucar;

    /*public Dieta(int id, String nomeDieta , int quantidadeMaximaCalorias , int quantidadeMaximaSodio , int quantidadeMaximaAcucar){

        this.idDieta = id;
        this.nomeDieta = nomeDieta;
        this.quantidadeMaximaCalorias = quantidadeMaximaCalorias;
        this.quantidadeMaximaSodio = quantidadeMaximaSodio;
        this.quantidadeMaximaAcucar = quantidadeMaximaAcucar;

    }*/

    public long getId() {
        return idDieta;
    }

    public void setId(long id) {
        this.idDieta = id;
    }

    public String getNomeDieta() {
        return nomeDieta;
    }

    public void setNomeDieta(String nomeDieta) {
        this.nomeDieta = nomeDieta;
    }

    public float getQuantidadeMaximaCalorias() {
        return quantidadeMaximaCalorias;
    }

    public void setQuantidadeMaximaCalorias(float quantidadeMaximaCalorias) {
        this.quantidadeMaximaCalorias = quantidadeMaximaCalorias;
    }

    public float getQuantidadeMaximaSodio() {
        return quantidadeMaximaSodio;
    }

    public void setQuantidadeMaximaSodio(float quantidadeMaximaSodio) {
        this.quantidadeMaximaSodio = quantidadeMaximaSodio;
    }

    public float getQuantidadeMaximaAcucar() {
        return quantidadeMaximaAcucar;
    }

    public void setQuantidadeMaximaAcucar(float quantidadeMaximaAcucar) {
        this.quantidadeMaximaAcucar = quantidadeMaximaAcucar;
    }
}
