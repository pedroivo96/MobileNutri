package com.example.pedro.mobilenutri.Visao;

import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.pedro.mobilenutri.R;

public class MenuActivity extends AppCompatActivity {

    private ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        //Configura o ViewPager
        viewPager = (ViewPager) findViewById(R.id.vPager);
        viewPager.setAdapter(new TabsAdapter(getSupportFragmentManager()));

        //Configura as Tabs
        final ActionBar actionBar = getSupportActionBar();
        actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);

        //Adiciona as Tabs no ActionBar
        actionBar.addTab(actionBar.newTab().setText("Nova Dieta").setTabListener(new MyTabListener(viewPager,0)));
        actionBar.addTab(actionBar.newTab().setText("Minhas Dietas").setTabListener(new MyTabListener(viewPager,1)));
        actionBar.addTab(actionBar.newTab().setText("Pesquisar Alimento").setTabListener(new MyTabListener(viewPager,2)));

        //Configura a Tab baseada na ViewPager
        viewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {

                actionBar.setSelectedNavigationItem(position);
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }
}
