package com.example.pedro.mobilenutri.Visao;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.pedro.mobilenutri.Entidade.Dieta;
import com.example.pedro.mobilenutri.Entidade.Refeicao;
import com.example.pedro.mobilenutri.R;

import java.util.ArrayList;

/**
 * Created by pedro on 25/10/17.
 */

public class RefeicoesAdapter extends BaseAdapter {

    private final Context context;
    private final ArrayList<Refeicao> refeicoes;

    public RefeicoesAdapter(Context context, ArrayList<Refeicao> refeicoes){
        this.context = context;
        this.refeicoes = refeicoes;
    }

    @Override
    public int getCount() {
        return refeicoes != null ? refeicoes.size() : 0;
    }

    @Override
    public Object getItem(int i) {
        return refeicoes.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {

        //Infla a View
        View view1 = LayoutInflater.from(context).inflate(R.layout.adapterrefeicao, viewGroup , false);

        TextView tNomeRefeicao = view1.findViewById(R.id.nomeRefeicao);
        TextView tHorarioRefeicao = view1.findViewById(R.id.horarioRefeicao);

        tNomeRefeicao.setText(refeicoes.get(i).getNome());
        tHorarioRefeicao.setText(refeicoes.get(i).getHoras()+":"+refeicoes.get(i).getMinutos());

        return view1;

    }
}
