package com.example.pedro.mobilenutri.Visao;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.example.pedro.mobilenutri.Entidade.Alimento;
import com.example.pedro.mobilenutri.Entidade.AlimentoTACOS;
import com.example.pedro.mobilenutri.R;

import org.apache.poi.hssf.record.chart.FontIndexRecord;
import org.w3c.dom.Text;

public class AlimentoActivity extends AppCompatActivity {

    private AlimentoTACOS alimento;

    private TextView tNomeAlimento;
    private TextView tTipoAlimento;
    private TextView tUmidade;
    private TextView tEnergiaKcal;
    private TextView tEnergiaKj;
    private TextView tProteina;
    private TextView tLipideos;
    private TextView tColesterol;
    private TextView tCarboidrato;
    private TextView tFibraAlimentar;
    private TextView tCinzas;
    private TextView tCalcio;
    private TextView tMagnesio;
    private TextView tManganes;
    private TextView tFosforo;
    private TextView tFerro;
    private TextView tSodio;
    private TextView tPotassio;
    private TextView tCobre;
    private TextView tZinco;
    private TextView tRetinol;
    private TextView tRE;
    private TextView tRAE;
    private TextView tTiamina;
    private TextView tRiboflavina;
    private TextView tPiridoxina;
    private TextView tNiacina;
    private TextView tVitaminaC;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alimento);

        //Recebe objeto da classe AlimentoTACOS passado pela activity anterior
        Intent intent = getIntent();
        this.alimento = (AlimentoTACOS) intent.getSerializableExtra("alimento");


        //Obtendo os TextViews
        tNomeAlimento = (TextView) findViewById(R.id.tNomeAlimento);
        tTipoAlimento = (TextView) findViewById(R.id.tTipoAlimento);
        tUmidade = (TextView) findViewById(R.id.tUmidade);
        tEnergiaKcal = (TextView) findViewById(R.id.tEnergiaKcal);
        tEnergiaKj = (TextView) findViewById(R.id.tEnergiaKj);
        tProteina = (TextView) findViewById(R.id.tProteina);
        tLipideos = (TextView) findViewById(R.id.tLipideos);
        tColesterol = (TextView) findViewById(R.id.tColesterol);
        tCarboidrato = (TextView) findViewById(R.id.tCarboidrato);
        tFibraAlimentar = (TextView) findViewById(R.id.tFibraAlimentar);
        tCinzas = (TextView) findViewById(R.id.tCinzas);
        tCalcio = (TextView) findViewById(R.id.tCalcio);
        tMagnesio = (TextView) findViewById(R.id.tMagnesio);
        tManganes = (TextView) findViewById(R.id.tManganes);
        tFosforo = (TextView) findViewById(R.id.tFosforo);
        tFerro = (TextView) findViewById(R.id.tFerro);
        tSodio = (TextView) findViewById(R.id.tSodio);
        tPotassio = (TextView) findViewById(R.id.tPotassio);
        tCobre = (TextView) findViewById(R.id.tCobre);
        tZinco = (TextView) findViewById(R.id.tZinco);
        tRetinol = (TextView) findViewById(R.id.tRetinol);
        tRE = (TextView) findViewById(R.id.tRE);
        tRAE = (TextView) findViewById(R.id.tRAE);
        tTiamina = (TextView) findViewById(R.id.tTiamina);
        tRiboflavina = (TextView) findViewById(R.id.tRiboflavina);
        tPiridoxina = (TextView) findViewById(R.id.tPiridoxina);
        tNiacina = (TextView) findViewById(R.id.tNiacina);
        tVitaminaC = (TextView) findViewById(R.id.tVitaminaC);

        //Exibindo os dados do Alimento nos TextViews formatado para 2 casas decimais
        tNomeAlimento.setText(alimento.getNomeAlimento());
        tTipoAlimento.setText("Tipo : "+alimento.getTipoAlimento());
        tUmidade.setText("Umidade : "+formatarString(alimento.getUmidade())+" %");
        tEnergiaKcal.setText("Energia : "+formatarString(alimento.getEnergiaKcal())+" kCal");
        tEnergiaKj.setText("Energia :"+formatarString(alimento.getEnergiaKJoule())+" kJ");
        tProteina.setText("Proteína : "+formatarString(alimento.getProteina())+" g");
        tLipideos.setText("Lípideos : "+formatarString(alimento.getLipideos())+" g");
        tColesterol.setText("Colesterol : "+formatarString(alimento.getColesterol())+" mg");
        tCarboidrato.setText("Carboidrato : "+formatarString(alimento.getCarboidrato())+" g");
        tFibraAlimentar.setText("Fibra Alimentar : "+formatarString(alimento.getFibraAlimentar())+" g");
        tCinzas.setText("Cinzas : "+formatarString(alimento.getCinzas())+" g");
        tCalcio.setText("Cálcio : "+formatarString(alimento.getCalcio())+" mg");
        tMagnesio.setText("Magnésio : "+formatarString(alimento.getMagnesio())+" mg");
        tManganes.setText("Manganês : "+formatarString(alimento.getManganes())+" mg");
        tFosforo.setText("Fósforo : "+formatarString(alimento.getFosforo())+" mg");
        tFerro.setText("Ferro : "+formatarString(alimento.getFerro())+" mg");
        tSodio.setText("Sódio : "+formatarString(alimento.getSodio())+" mg");
        tPotassio.setText("Potássio : "+formatarString(alimento.getPotassio())+" mg");
        tCobre.setText("Cobre : "+formatarString(alimento.getCobre())+" mg");
        tZinco.setText("Zinco : "+formatarString(alimento.getZinco())+" mg");
        tRetinol.setText("Retinol : "+formatarString(alimento.getRetinol())+" mcg");
        tRE.setText("RE : "+formatarString(alimento.getRe())+" mcg");
        tRAE.setText("RAE : "+formatarString(alimento.getRae())+" mcg");
        tTiamina.setText("Tiamina : "+formatarString(alimento.getTiamina())+" mg");
        tRiboflavina.setText("Riboflavina : "+formatarString(alimento.getRiboflavina())+" mg");
        tPiridoxina.setText("Piridoxina : "+formatarString(alimento.getPiridoxina())+" mg");
        tNiacina.setText("Niacina : "+formatarString(alimento.getNiacina())+" mg");
        tVitaminaC.setText("Vitamina C : "+formatarString(alimento.getVitaminaC())+" mg");

    }

    /*Recebe uma String e a formata para duas casas decimais caso seu conteúdo corresponda a um
    * Float ou a retorna como foi recebida, caso contrário */
    private String formatarString(String s){

        try{
            float f = Float.parseFloat(s);

            return String.format(java.util.Locale.US,"%.2f", f);
        }catch (NumberFormatException e){
            return s;
        }
    }
}
