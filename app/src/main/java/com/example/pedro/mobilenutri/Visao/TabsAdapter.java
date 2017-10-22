package com.example.pedro.mobilenutri.Visao;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

/**
 * Created by pedro on 22/10/17.
 */

public class TabsAdapter extends FragmentPagerAdapter {

    public TabsAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        if(position == 0){
            return new NovaDietaFragment();
        }
        else if(position == 1){
            return new MinhasDietasFragment();
        }

        return new PesquisarAlimentoFragment();
    }

    @Override
    public int getCount() {

        //Retorna o número de Tabs
        return 3;
    }
}
