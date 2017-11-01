package com.example.pedro.mobilenutri.Entidade;

/**
 * Created by pedro on 01/11/17.
 */

public class Alimento {

    long idDieta;
    long idAlimento;
    float quantidade;
    String nomeAlimento;

    public String getNomeAlimento() {
        return nomeAlimento;
    }

    public void setNomeAlimento(String nomeAlimento) {
        this.nomeAlimento = nomeAlimento;
    }

    public long getIdAlimento() {
        return idAlimento;
    }

    public void setIdAlimento(long idAlimento) {
        this.idAlimento = idAlimento;
    }

    public float getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(float quantidade) {
        this.quantidade = quantidade;
    }

    public long getIdDieta() {
        return idDieta;
    }

    public void setIdDieta(long idDieta) {
        this.idDieta = idDieta;
    }
}
