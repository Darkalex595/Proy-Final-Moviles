package com.life.forodeinclusionversion01;

import android.content.res.Configuration;
import android.os.Bundle;
import android.view.Gravity;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.google.android.material.navigation.NavigationView;
import com.life.forodeinclusionversion01.DataBase.MainData;
import com.life.forodeinclusionversion01.DataBase.RoomDB;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    DrawerLayout mDrawerLayout;
    NavigationView navigationView;
    Toolbar toolbar;
    ActionBarDrawerToggle toogle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mDrawerLayout = findViewById(R.id.drawer_layout);
        navigationView = findViewById(R.id.nav_view);
        toolbar = findViewById(R.id.toolbar);

        getSupportFragmentManager().beginTransaction().add(R.id.content, new Contacto()).addToBackStack(null).commit();
        setTitle("Foro de Inclusión");

        setSupportActionBar(toolbar);

        toogle = setUpDrawerToogle();
        mDrawerLayout.addDrawerListener(toogle);

        navigationView.setNavigationItemSelectedListener(this);
    }

    private ActionBarDrawerToggle setUpDrawerToogle(){
        return new ActionBarDrawerToggle(this, mDrawerLayout, toolbar, R.string.drawer_open,R.string.drawer_close);
    }

    @Override
    protected void onPostCreate(@Nullable Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        toogle.syncState();
    }

    @Override
    public void onConfigurationChanged(@NonNull Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        toogle.onConfigurationChanged(newConfig);
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        selectItemNav(item);
        return false;
    }

    private void selectItemNav(MenuItem item) {
        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
        switch (item.getItemId()) {
            case R.id.nav_home:
                ft.replace(R.id.content, new Contacto()).addToBackStack(null).commit();
                break;
            case R.id.nav_events:
                ft.replace(R.id.content, new Eventos()).addToBackStack(null).commit();
                break;
            case R.id.nav_calendar:
                ft.replace(R.id.content, new Calendario()).addToBackStack(null).commit();
                break;
            case R.id.nav_notifications:
                ft.replace(R.id.content, new Notificaciones()).addToBackStack(null).commit();
                break;
            case R.id.nav_settings:
                ft.replace(R.id.content, new Opciones()).addToBackStack(null).commit();
                break;
            case R.id.nav_exit:
                finish();
                System.exit(0);
                break;
        }
        setTitle(item.getTitle());
        mDrawerLayout.closeDrawers();
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (toogle.onOptionsItemSelected(item)){
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}