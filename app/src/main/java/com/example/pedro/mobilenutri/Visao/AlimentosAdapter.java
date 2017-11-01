package com.example.pedro.mobilenutri.Visao;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.pedro.mobilenutri.Entidade.Alimento;
import com.example.pedro.mobilenutri.Entidade.Refeicao;
import com.example.pedro.mobilenutri.R;

import java.util.ArrayList;

/**
 * Created by pedro on 01/11/17.
 */

public class AlimentosAdapter extends BaseAdapter {

    private final Context context;
    private final ArrayList<Alimento> alimentos;

    public AlimentosAdapter(Context context, ArrayList<Alimento> alimentos){
        this.context = context;
        this.alimentos = alimentos;
    }

    @Override
    public int getCount() {
        return alimentos != null ? alimentos.size() : 0;
    }

    @Override
    public Object getItem(int i) {
        return alimentos.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {

        //Infla a View
        View view1 = LayoutInflater.from(context).inflate(R.layout.adapteralimento, viewGroup , false);

        TextView textViewNomeAlimento = view1.findViewById(R.id.textViewNomeAlimento);
        TextView textViewQuantidadeAlimento = view1.findViewById(R.id.textViewQuantidadeAlimento);

        textViewNomeAlimento.setText(alimentos.get(i).getNomeAlimento());
        textViewQuantidadeAlimento.setText(Float.toString(alimentos.get(i).getQuantidade()));

        return view1;
    }
}
