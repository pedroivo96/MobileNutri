package com.example.pedro.mobilenutri.Controle;

import android.content.Context;
import android.inputmethodservice.Keyboard;
import android.util.Log;

import com.example.pedro.mobilenutri.Entidade.Alimento;
import com.example.pedro.mobilenutri.Entidade.AlimentoTACOS;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;

import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 * Created by pedro on 23/10/17.
 */

public class ControleAlimento {
    //Manipula a Tabela TACO

    private Context context;
    private InputStream fis;
    static HSSFWorkbook workbook;

    public ControleAlimento(Context context) throws IOException {
        this.context = context;

        fis = context.getAssets().open("Taco_4a_edicao_2011.xls");

        if(workbook == null){
            workbook = new HSSFWorkbook(fis);
        }
    }

    public ArrayList<AlimentoTACOS> obterAlimentosPeloId(int id) throws IOException {

        HSSFSheet spreadsheet = workbook.getSheetAt(0);
        Iterator<Row> rowIterator = spreadsheet.iterator();

        ArrayList<AlimentoTACOS> alimentosTACOS = new ArrayList<AlimentoTACOS>();

        while(rowIterator.hasNext()){
            HSSFRow row = (HSSFRow) rowIterator.next();

            AlimentoTACOS alimentoTACOS = new AlimentoTACOS();

            Iterator < Cell >  cellIterator = row.cellIterator();
            Cell cell = cellIterator.next();

            if(cell.getColumnIndex() == 0){
                //Se for a coluna dos IDs

                if(cell.getNumericCellValue() == id){
                    //Se for o ID certo

                    while(cellIterator.hasNext()) {
                        //Obter todos os campos

                        cell = cellIterator.next();

                        switch (cell.getColumnIndex()){
                            case 1:
                                //Coluna 1  : Nome e Descrição do Alimento

                                alimentoTACOS.setNomeAlimento(cell.getStringCellValue());

                                break;

                            case 2:
                                //Coluna 2  : Tipo de Alimento

                                alimentoTACOS.setTipoAlimento(cell.getStringCellValue());

                                break;

                            case 3:
                                //Coluna 3  : Umidade         (   %  )

                                alimentoTACOS.setUmidade(cell.getStringCellValue());

                                break;

                            case 4:
                                //Coluna 4  : Energia         ( Kcal )

                                alimentoTACOS.setEnergiaKcal(cell.getStringCellValue());

                                break;

                            case 5:
                                //Coluna 5  : Energia         (  KJ  )

                                alimentoTACOS.setEnergiaKJoule(cell.getStringCellValue());

                                break;

                            case 6:
                                //Coluna 6  : Proteína        (  g   )

                                alimentoTACOS.setProteina(cell.getStringCellValue());

                                break;

                            case 7:
                                //Coluna 7  : Lipídeos        (  g   )

                                alimentoTACOS.setLipideos(cell.getStringCellValue());

                                break;

                            case 8:
                                //Coluna 8  : Colesterol      (  mg  )

                                alimentoTACOS.setColesterol(cell.getStringCellValue());

                                break;

                            case 9:
                                //Coluna 9  : Carboidrato     (  g   )

                                alimentoTACOS.setCarboidrato(cell.getStringCellValue());

                                break;

                            case 10:
                                //Coluna 10 : Fibra Alimentar (  g   )

                                alimentoTACOS.setFibraAlimentar(cell.getStringCellValue());

                                break;

                            case 11:
                                //Coluna 11 : Cinzas          (  g   )

                                alimentoTACOS.setCinzas(cell.getStringCellValue());

                                break;

                            case 12:
                                //Coluna 12 : Cálcio          (  mg  )

                                alimentoTACOS.setCalcio(cell.getStringCellValue());

                                break;

                            case 13:
                                //Coluna 13 : Magnésio        (  mg  )

                                alimentoTACOS.setMagnesio(cell.getStringCellValue());

                                break;

                            case 14:
                                //Coluna 14 : Manganês        (  mg  )

                                alimentoTACOS.setManganes(cell.getStringCellValue());

                                break;

                            case 15:
                                //Coluna 15 : Fósforo         (  mg  )

                                alimentoTACOS.setFosforo(cell.getStringCellValue());

                                break;

                            case 16:
                                //Coluna 16 : Ferro           (  mg  )

                                alimentoTACOS.setFerro(cell.getStringCellValue());

                                break;

                            case 17:
                                //Coluna 17 : Sódio           (  mg  )

                                alimentoTACOS.setSodio(cell.getStringCellValue());

                                break;

                            case 18:
                                //Coluna 18 : Potássio        (  mg  )

                                alimentoTACOS.setPotassio(cell.getStringCellValue());

                                break;

                            case 19:
                                //Coluna 19 : Cobre           (  mg  )

                                alimentoTACOS.setCobre(cell.getStringCellValue());

                                break;

                            case 20:
                                //Coluna 20 : Zinco           (  mg  )

                                alimentoTACOS.setZinco(cell.getStringCellValue());

                                break;

                            case 21:
                                //Coluna 21 : Retinol         (  mg  )

                                alimentoTACOS.setRetinol(cell.getStringCellValue());

                                break;

                            case 22:
                                //Coluna 22 : RE              (  mcg )

                                alimentoTACOS.setRe(cell.getStringCellValue());

                                break;

                            case 23:
                                //Coluna 23 : RAE             (  mcg )

                                alimentoTACOS.setRae(cell.getStringCellValue());

                                break;

                            case 24:
                                //Coluna 24 : Tiamina         (  mg  )

                                alimentoTACOS.setTiamina(cell.getStringCellValue());

                                break;

                            case 25:
                                //Coluna 25 : Riboflavina     (  mg  )

                                alimentoTACOS.setRiboflavina(cell.getStringCellValue());

                                break;

                            case 26:
                                //Coluna 26 : Piridoxina      (  mg  )

                                alimentoTACOS.setPiridoxina(cell.getStringCellValue());

                                break;

                            case 27:
                                //Coluna 27 : Niacina         (  mg  )

                                alimentoTACOS.setNiacina(cell.getStringCellValue());

                                break;

                            case 28:
                                //Coluna 28 : Vitamina C      (  mg  )

                                alimentoTACOS.setVitaminaC(cell.getStringCellValue());

                                break;
                        }
                    }

                    alimentosTACOS.add(alimentoTACOS);

                }
            }

        }

        return alimentosTACOS;
    }

    public ArrayList<AlimentoTACOS> obterAlimentosPeloNome(String nome) throws IOException {

        HSSFSheet spreadsheet = workbook.getSheetAt(0);
        Iterator<Row> rowIterator = spreadsheet.iterator();

        ArrayList<AlimentoTACOS> alimentosTACOS = new ArrayList<AlimentoTACOS>();

        while(rowIterator.hasNext()){
            HSSFRow row = (HSSFRow) rowIterator.next();

            AlimentoTACOS alimentoTACOS = new AlimentoTACOS();

            Iterator < Cell >  cellIterator = row.cellIterator();
            Cell cell = cellIterator.next(); //cellIterator em 0

            int id = (int) cell.getNumericCellValue();
            cell = cellIterator.next();//cellIterator em 1

            if(cell.getColumnIndex() == 1){
                //Se for a coluna dos IDs

                if(cell.getStringCellValue().toLowerCase().contains(nome.toLowerCase())){
                    //Verifica o nome

                    Log.d("Tag", cell.getStringCellValue());

                    alimentoTACOS.setNomeAlimento(cell.getStringCellValue());

                    while(cellIterator.hasNext()) {
                        //Obter todos os campos

                        cell = cellIterator.next();

                        switch (cell.getColumnIndex()){

                            case 2:
                                //Coluna 2  : Tipo de Alimento

                                alimentoTACOS.setTipoAlimento(cell.getStringCellValue());

                                break;

                            case 3:
                                //Coluna 3  : Umidade         (   %  )

                                try{
                                    alimentoTACOS.setUmidade(String.valueOf(cell.getNumericCellValue()));
                                }catch (Exception e){
                                    alimentoTACOS.setUmidade(cell.getStringCellValue());
                                }

                                break;

                            case 4:
                                //Coluna 4  : Energia         ( Kcal )

                                try{
                                    alimentoTACOS.setEnergiaKcal(String.valueOf(cell.getNumericCellValue()));
                                }catch (Exception e){
                                    alimentoTACOS.setEnergiaKcal(cell.getStringCellValue());
                                }


                                break;

                            case 5:
                                //Coluna 5  : Energia         (  KJ  )

                                try{
                                    alimentoTACOS.setEnergiaKJoule(String.valueOf(cell.getNumericCellValue()));
                                }catch (Exception e){
                                    alimentoTACOS.setEnergiaKJoule(cell.getStringCellValue());
                                }


                                break;

                            case 6:
                                //Coluna 6  : Proteína        (  g   )

                                try{
                                    alimentoTACOS.setProteina(String.valueOf(cell.getNumericCellValue()));
                                }catch (Exception e){
                                    alimentoTACOS.setProteina(cell.getStringCellValue());
                                }

                                break;

                            case 7:
                                //Coluna 7  : Lipídeos        (  g   )

                                try{
                                    alimentoTACOS.setLipideos(String.valueOf(cell.getNumericCellValue()));
                                }catch (Exception e){
                                    alimentoTACOS.setLipideos(cell.getStringCellValue());
                                }

                                break;

                            case 8:
                                //Coluna 8  : Colesterol      (  mg  )

                                try{
                                    alimentoTACOS.setColesterol(String.valueOf(cell.getNumericCellValue()));
                                }catch (Exception e){
                                    alimentoTACOS.setColesterol(cell.getStringCellValue());
                                }

                                break;

                            case 9:
                                //Coluna 9  : Carboidrato     (  g   )

                                try{
                                    alimentoTACOS.setCarboidrato(String.valueOf(cell.getNumericCellValue()));
                                }catch (Exception e){
                                    alimentoTACOS.setCarboidrato(cell.getStringCellValue());
                                }

                                break;

                            case 10:
                                //Coluna 10 : Fibra Alimentar (  g   )

                                try{
                                    alimentoTACOS.setFibraAlimentar(String.valueOf(cell.getNumericCellValue()));
                                }catch (Exception e){
                                    alimentoTACOS.setFibraAlimentar(cell.getStringCellValue());
                                }

                                break;

                            case 11:
                                //Coluna 11 : Cinzas          (  g   )

                                try{
                                    alimentoTACOS.setCinzas(String.valueOf(cell.getNumericCellValue()));
                                }catch (Exception e){
                                    alimentoTACOS.setCinzas(cell.getStringCellValue());
                                }

                                break;

                            case 12:
                                //Coluna 12 : Cálcio          (  mg  )

                                try{
                                    alimentoTACOS.setCalcio(String.valueOf(cell.getNumericCellValue()));
                                }catch (Exception e){
                                    alimentoTACOS.setCalcio(cell.getStringCellValue());
                                }

                                break;

                            case 13:
                                //Coluna 13 : Magnésio        (  mg  )

                                try{
                                    alimentoTACOS.setMagnesio(String.valueOf(cell.getNumericCellValue()));
                                }catch (Exception e){
                                    alimentoTACOS.setMagnesio(cell.getStringCellValue());
                                }

                                break;

                            case 14:
                                //Coluna 14 : Manganês        (  mg  )

                                try{
                                    alimentoTACOS.setManganes(String.valueOf(cell.getNumericCellValue()));
                                }catch (Exception e){
                                    alimentoTACOS.setManganes(cell.getStringCellValue());
                                }

                                break;

                            case 15:
                                //Coluna 15 : Fósforo         (  mg  )

                                try{
                                    alimentoTACOS.setFosforo(String.valueOf(cell.getNumericCellValue()));
                                }catch (Exception e){
                                    alimentoTACOS.setFosforo(cell.getStringCellValue());
                                }

                                break;

                            case 16:
                                //Coluna 16 : Ferro           (  mg  )

                                try{
                                    alimentoTACOS.setFerro(String.valueOf(cell.getNumericCellValue()));
                                }catch (Exception e){
                                    alimentoTACOS.setFerro(cell.getStringCellValue());
                                }

                                break;

                            case 17:
                                //Coluna 17 : Sódio           (  mg  )

                                try{
                                    alimentoTACOS.setSodio(String.valueOf(cell.getNumericCellValue()));
                                }catch (Exception e){
                                    alimentoTACOS.setSodio(cell.getStringCellValue());
                                }

                                break;

                            case 18:
                                //Coluna 18 : Potássio        (  mg  )

                                try{
                                    alimentoTACOS.setPotassio(String.valueOf(cell.getNumericCellValue()));
                                }catch (Exception e){
                                    alimentoTACOS.setPotassio(cell.getStringCellValue());
                                }

                                break;

                            case 19:
                                //Coluna 19 : Cobre           (  mg  )

                                try{
                                    alimentoTACOS.setCobre(String.valueOf(cell.getNumericCellValue()));
                                }catch (Exception e){
                                    alimentoTACOS.setCalcio(cell.getStringCellValue());
                                }

                                break;

                            case 20:
                                //Coluna 20 : Zinco           (  mg  )

                                try{
                                    alimentoTACOS.setZinco(String.valueOf(cell.getNumericCellValue()));
                                }catch (Exception e){
                                    alimentoTACOS.setZinco(cell.getStringCellValue());
                                }

                                break;

                            case 21:
                                //Coluna 21 : Retinol         (  mg  )

                                try{
                                    alimentoTACOS.setRetinol(String.valueOf(cell.getNumericCellValue()));
                                }catch (Exception e){
                                    alimentoTACOS.setRetinol(cell.getStringCellValue());
                                }

                                break;

                            case 22:
                                //Coluna 22 : RE              (  mcg )

                                try{
                                    alimentoTACOS.setRe(String.valueOf(cell.getNumericCellValue()));
                                }catch (Exception e){
                                    alimentoTACOS.setRe(cell.getStringCellValue());
                                }

                                break;

                            case 23:
                                //Coluna 23 : RAE             (  mcg )

                                try{
                                    alimentoTACOS.setRae(String.valueOf(cell.getNumericCellValue()));
                                }catch (Exception e){
                                    alimentoTACOS.setRae(cell.getStringCellValue());
                                }

                                break;

                            case 24:
                                //Coluna 24 : Tiamina         (  mg  )

                                try{
                                    alimentoTACOS.setTiamina(String.valueOf(cell.getNumericCellValue()));
                                }catch (Exception e){
                                    alimentoTACOS.setTiamina(cell.getStringCellValue());
                                }

                                break;

                            case 25:
                                //Coluna 25 : Riboflavina     (  mg  )

                                try{
                                    alimentoTACOS.setRiboflavina(String.valueOf(cell.getNumericCellValue()));
                                }catch (Exception e){
                                    alimentoTACOS.setRiboflavina(cell.getStringCellValue());
                                }

                                break;

                            case 26:
                                //Coluna 26 : Piridoxina      (  mg  )

                                try{
                                    alimentoTACOS.setPiridoxina(String.valueOf(cell.getNumericCellValue()));
                                }catch (Exception e){
                                    alimentoTACOS.setPiridoxina(cell.getStringCellValue());
                                }

                                break;

                            case 27:
                                //Coluna 27 : Niacina         (  mg  )

                                try{
                                    alimentoTACOS.setNiacina(String.valueOf(cell.getNumericCellValue()));
                                }catch (Exception e){
                                    alimentoTACOS.setNiacina(cell.getStringCellValue());
                                }

                                break;

                            case 28:
                                //Coluna 28 : Vitamina C      (  mg  )

                                try{
                                    alimentoTACOS.setVitaminaC(String.valueOf(cell.getNumericCellValue()));
                                }catch (Exception e){
                                    alimentoTACOS.setVitaminaC(cell.getStringCellValue());
                                }

                                break;
                        }
                    }

                    alimentosTACOS.add(alimentoTACOS);

                }
            }
        }

        return alimentosTACOS;
    }

    public ArrayList<AlimentoTACOS> obterAlimentosPeloTipo(String tipo) throws IOException {

        HSSFSheet spreadsheet = workbook.getSheetAt(0);
        Iterator<Row> rowIterator = spreadsheet.iterator();

        ArrayList<AlimentoTACOS> alimentosTACOS = new ArrayList<AlimentoTACOS>();

        while(rowIterator.hasNext()){

            HSSFRow row = (HSSFRow) rowIterator.next();

            AlimentoTACOS alimentoTACOS = new AlimentoTACOS();

            Iterator < Cell >  cellIterator = row.cellIterator();
            Cell cell = cellIterator.next(); //cellIterator vai pra 0

            int id = (int) cell.getNumericCellValue();

            cell = cellIterator.next();//cellIterator vai pra 1
            String nome = cell.getStringCellValue();

            cell = cellIterator.next(); //cellIterator vai pra 2
            alimentoTACOS.setNomeAlimento(nome);

            if(cell.getColumnIndex() == 2){
                //Se for a coluna dos tipos

                if(cell.getStringCellValue().toLowerCase().equals(tipo.toLowerCase())){
                    //Verifica o Tipo

                    Log.d("Tag", cell.getStringCellValue());

                    alimentoTACOS.setTipoAlimento(cell.getStringCellValue());

                    while(cellIterator.hasNext()) {
                        //Obter todos os campos

                        cell = cellIterator.next();

                        switch (cell.getColumnIndex()){

                            case 3:
                                //Coluna 3  : Umidade         (   %  )

                                try{
                                    alimentoTACOS.setUmidade(String.valueOf(cell.getNumericCellValue()));
                                }catch (Exception e){
                                    alimentoTACOS.setUmidade(cell.getStringCellValue());
                                }

                                break;

                            case 4:
                                //Coluna 4  : Energia         ( Kcal )

                                try{
                                    alimentoTACOS.setEnergiaKcal(String.valueOf(cell.getNumericCellValue()));
                                }catch (Exception e){
                                    alimentoTACOS.setEnergiaKcal(cell.getStringCellValue());
                                }


                                break;

                            case 5:
                                //Coluna 5  : Energia         (  KJ  )

                                try{
                                    alimentoTACOS.setEnergiaKJoule(String.valueOf(cell.getNumericCellValue()));
                                }catch (Exception e){
                                    alimentoTACOS.setEnergiaKJoule(cell.getStringCellValue());
                                }


                                break;

                            case 6:
                                //Coluna 6  : Proteína        (  g   )

                                try{
                                    alimentoTACOS.setProteina(String.valueOf(cell.getNumericCellValue()));
                                }catch (Exception e){
                                    alimentoTACOS.setProteina(cell.getStringCellValue());
                                }

                                break;

                            case 7:
                                //Coluna 7  : Lipídeos        (  g   )

                                try{
                                    alimentoTACOS.setLipideos(String.valueOf(cell.getNumericCellValue()));
                                }catch (Exception e){
                                    alimentoTACOS.setLipideos(cell.getStringCellValue());
                                }

                                break;

                            case 8:
                                //Coluna 8  : Colesterol      (  mg  )

                                try{
                                    alimentoTACOS.setColesterol(String.valueOf(cell.getNumericCellValue()));
                                }catch (Exception e){
                                    alimentoTACOS.setColesterol(cell.getStringCellValue());
                                }

                                break;

                            case 9:
                                //Coluna 9  : Carboidrato     (  g   )

                                try{
                                    alimentoTACOS.setCarboidrato(String.valueOf(cell.getNumericCellValue()));
                                }catch (Exception e){
                                    alimentoTACOS.setCarboidrato(cell.getStringCellValue());
                                }

                                break;

                            case 10:
                                //Coluna 10 : Fibra Alimentar (  g   )

                                try{
                                    alimentoTACOS.setFibraAlimentar(String.valueOf(cell.getNumericCellValue()));
                                }catch (Exception e){
                                    alimentoTACOS.setFibraAlimentar(cell.getStringCellValue());
                                }

                                break;

                            case 11:
                                //Coluna 11 : Cinzas          (  g   )

                                try{
                                    alimentoTACOS.setCinzas(String.valueOf(cell.getNumericCellValue()));
                                }catch (Exception e){
                                    alimentoTACOS.setCinzas(cell.getStringCellValue());
                                }

                                break;

                            case 12:
                                //Coluna 12 : Cálcio          (  mg  )

                                try{
                                    alimentoTACOS.setCalcio(String.valueOf(cell.getNumericCellValue()));
                                }catch (Exception e){
                                    alimentoTACOS.setCalcio(cell.getStringCellValue());
                                }

                                break;

                            case 13:
                                //Coluna 13 : Magnésio        (  mg  )

                                try{
                                    alimentoTACOS.setMagnesio(String.valueOf(cell.getNumericCellValue()));
                                }catch (Exception e){
                                    alimentoTACOS.setMagnesio(cell.getStringCellValue());
                                }

                                break;

                            case 14:
                                //Coluna 14 : Manganês        (  mg  )

                                try{
                                    alimentoTACOS.setManganes(String.valueOf(cell.getNumericCellValue()));
                                }catch (Exception e){
                                    alimentoTACOS.setManganes(cell.getStringCellValue());
                                }

                                break;

                            case 15:
                                //Coluna 15 : Fósforo         (  mg  )

                                try{
                                    alimentoTACOS.setFosforo(String.valueOf(cell.getNumericCellValue()));
                                }catch (Exception e){
                                    alimentoTACOS.setFosforo(cell.getStringCellValue());
                                }

                                break;

                            case 16:
                                //Coluna 16 : Ferro           (  mg  )

                                try{
                                    alimentoTACOS.setFerro(String.valueOf(cell.getNumericCellValue()));
                                }catch (Exception e){
                                    alimentoTACOS.setFerro(cell.getStringCellValue());
                                }

                                break;

                            case 17:
                                //Coluna 17 : Sódio           (  mg  )

                                try{
                                    alimentoTACOS.setSodio(String.valueOf(cell.getNumericCellValue()));
                                }catch (Exception e){
                                    alimentoTACOS.setSodio(cell.getStringCellValue());
                                }

                                break;

                            case 18:
                                //Coluna 18 : Potássio        (  mg  )

                                try{
                                    alimentoTACOS.setPotassio(String.valueOf(cell.getNumericCellValue()));
                                }catch (Exception e){
                                    alimentoTACOS.setPotassio(cell.getStringCellValue());
                                }

                                break;

                            case 19:
                                //Coluna 19 : Cobre           (  mg  )

                                try{
                                    alimentoTACOS.setCobre(String.valueOf(cell.getNumericCellValue()));
                                }catch (Exception e){
                                    alimentoTACOS.setCalcio(cell.getStringCellValue());
                                }

                                break;

                            case 20:
                                //Coluna 20 : Zinco           (  mg  )

                                try{
                                    alimentoTACOS.setZinco(String.valueOf(cell.getNumericCellValue()));
                                }catch (Exception e){
                                    alimentoTACOS.setZinco(cell.getStringCellValue());
                                }

                                break;

                            case 21:
                                //Coluna 21 : Retinol         (  mg  )

                                try{
                                    alimentoTACOS.setRetinol(String.valueOf(cell.getNumericCellValue()));
                                }catch (Exception e){
                                    alimentoTACOS.setRetinol(cell.getStringCellValue());
                                }

                                break;

                            case 22:
                                //Coluna 22 : RE              (  mcg )

                                try{
                                    alimentoTACOS.setRe(String.valueOf(cell.getNumericCellValue()));
                                }catch (Exception e){
                                    alimentoTACOS.setRe(cell.getStringCellValue());
                                }

                                break;

                            case 23:
                                //Coluna 23 : RAE             (  mcg )

                                try{
                                    alimentoTACOS.setRae(String.valueOf(cell.getNumericCellValue()));
                                }catch (Exception e){
                                    alimentoTACOS.setRae(cell.getStringCellValue());
                                }

                                break;

                            case 24:
                                //Coluna 24 : Tiamina         (  mg  )

                                try{
                                    alimentoTACOS.setTiamina(String.valueOf(cell.getNumericCellValue()));
                                }catch (Exception e){
                                    alimentoTACOS.setTiamina(cell.getStringCellValue());
                                }

                                break;

                            case 25:
                                //Coluna 25 : Riboflavina     (  mg  )

                                try{
                                    alimentoTACOS.setRiboflavina(String.valueOf(cell.getNumericCellValue()));
                                }catch (Exception e){
                                    alimentoTACOS.setRiboflavina(cell.getStringCellValue());
                                }

                                break;

                            case 26:
                                //Coluna 26 : Piridoxina      (  mg  )

                                try{
                                    alimentoTACOS.setPiridoxina(String.valueOf(cell.getNumericCellValue()));
                                }catch (Exception e){
                                    alimentoTACOS.setPiridoxina(cell.getStringCellValue());
                                }

                                break;

                            case 27:
                                //Coluna 27 : Niacina         (  mg  )

                                try{
                                    alimentoTACOS.setNiacina(String.valueOf(cell.getNumericCellValue()));
                                }catch (Exception e){
                                    alimentoTACOS.setNiacina(cell.getStringCellValue());
                                }

                                break;

                            case 28:
                                //Coluna 28 : Vitamina C      (  mg  )

                                try{
                                    alimentoTACOS.setVitaminaC(String.valueOf(cell.getNumericCellValue()));
                                }catch (Exception e){
                                    alimentoTACOS.setVitaminaC(cell.getStringCellValue());
                                }

                                break;
                        }
                    }

                    alimentosTACOS.add(alimentoTACOS);

                }
            }
        }

        return alimentosTACOS;
    }


}
