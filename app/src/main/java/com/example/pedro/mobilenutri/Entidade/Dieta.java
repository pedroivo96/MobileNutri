package com.example.pedro.mobilenutri.Entidade;

/**
 * Created by pedro on 22/10/17.
 */

public class Dieta {

    private int id;
    private String nomeDieta;
    private int quantidadeMaximaCalorias;
    private int quantidadeMaximaSodio;
    private int quantidadeMaximaAcucar;

    public Dieta(int id, String nomeDieta , int quantidadeMaximaCalorias , int quantidadeMaximaSodio , int quantidadeMaximaAcucar){

        this.id = id;
        this.nomeDieta = nomeDieta;
        this.quantidadeMaximaCalorias = quantidadeMaximaCalorias;
        this.quantidadeMaximaSodio = quantidadeMaximaSodio;
        this.quantidadeMaximaAcucar = quantidadeMaximaAcucar;

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNomeDieta() {
        return nomeDieta;
    }

    public void setNomeDieta(String nomeDieta) {
        this.nomeDieta = nomeDieta;
    }

    public int getQuantidadeMaximaCalorias() {
        return quantidadeMaximaCalorias;
    }

    public void setQuantidadeMaximaCalorias(int quantidadeMaximaCalorias) {
        this.quantidadeMaximaCalorias = quantidadeMaximaCalorias;
    }

    public int getQuantidadeMaximaSodio() {
        return quantidadeMaximaSodio;
    }

    public void setQuantidadeMaximaSodio(int quantidadeMaximaSodio) {
        this.quantidadeMaximaSodio = quantidadeMaximaSodio;
    }

    public int getQuantidadeMaximaAcucar() {
        return quantidadeMaximaAcucar;
    }

    public void setQuantidadeMaximaAcucar(int quantidadeMaximaAcucar) {
        this.quantidadeMaximaAcucar = quantidadeMaximaAcucar;
    }
}
