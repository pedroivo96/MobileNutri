package com.example.pedro.mobilenutri.Visao;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.pedro.mobilenutri.Entidade.Dieta;
import com.example.pedro.mobilenutri.R;

import java.util.ArrayList;

/**
 * Created by pedro on 23/10/17.
 */

public class DietasAdapter extends BaseAdapter {

    private final Context context;
    private final ArrayList<Dieta> dietas;

    public DietasAdapter(Context context, ArrayList<Dieta> dietas) {
        this.context = context;
        this.dietas = dietas;
    }

    @Override
    public int getCount() {
        return dietas != null ? dietas.size() : 0;
    }

    @Override
    public Object getItem(int i) {
        return dietas.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {

        //Infla a View
        View view1 = LayoutInflater.from(context).inflate(R.layout.adapterdieta , viewGroup , false);

        TextView tNomeDieta = view1.findViewById(R.id.nomeDieta);

        tNomeDieta.setText(dietas.get(i).getNomeDieta());

        return view1;
    }
}
