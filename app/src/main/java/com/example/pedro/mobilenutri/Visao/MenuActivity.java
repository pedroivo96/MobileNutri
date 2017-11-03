package com.example.pedro.mobilenutri.Visao;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import com.example.pedro.mobilenutri.R;
import com.example.pedro.mobilenutri.Repositorio.MobileNutriDB;

public class MenuActivity extends AppCompatActivity {

    private ViewPager viewPager;
    private MobileNutriDB mobileNutriDB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        mobileNutriDB = new MobileNutriDB(this);

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

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();

        if(id == R.id.zerar){

            AlertDialog.Builder alerta = new AlertDialog.Builder(MenuActivity.this);
            alerta.setTitle("Confirmação");
            alerta.setMessage("Você tem certeza que deseja apagar todos os dados cadastrados?");
            alerta.setNegativeButton("Não", null);
            alerta.setPositiveButton("Sim", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    mobileNutriDB.resetarBaseDeDados();
                }
            });
            AlertDialog dialog = alerta.create();
            dialog.show();

            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
