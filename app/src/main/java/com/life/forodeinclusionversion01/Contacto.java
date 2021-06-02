package com.life.forodeinclusionversion01;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

public class Contacto extends Fragment {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        DrawerLayout mDrawerLayout = view.findViewById(R.id.drawer_layout);;

        Button ingresar_btn = view.findViewById(R.id.contacto_btn);

        ingresar_btn.setOnClickListener(view1 -> {goToEvents();});
    }

    private void goToEvents(){
        FragmentTransaction transaction;
        Fragment fragment;

        transaction = getFragmentManager().beginTransaction();

        fragment = new Eventos();

        transaction.replace(R.id.content,fragment);

        transaction.addToBackStack(null);

        transaction.commit();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_contacto, container, false);
    }
}