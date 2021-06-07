package com.life.forodeinclusionversion01;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import static android.content.Context.*;

public class Eventos extends Fragment {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        sharedPreferences = getActivity().getSharedPreferences("Notificaciones", MODE_PRIVATE);
        editor = sharedPreferences.edit();
    }

    //Aqui se declaran los botones a los que se les agregaran las funciones
    Button inclusionRegistro, inclusionRedes, inclusionCalendario;
    Button lgbtRegistro, lgbtRedes, lgbtCalendario;

    //Aqui se declaran los TextView de los que se sacara la informacion para que los botones funcionen
    TextView inclusionTitulo, inclusionInformacion;
    TextView lgbtTitulo, lgbtInformacion;

    Button bNotif1, bNotif2;
    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        //Aqui se les tiene que asignar su respectivo ID a cada boton
        inclusionRegistro = view.findViewById(R.id.inclusion_registro);
        inclusionRedes = view.findViewById(R.id.inclusion_redes);
        inclusionCalendario = view.findViewById(R.id.inclusion_calendario);

        lgbtRegistro = view.findViewById(R.id.lgbt_registro);
        lgbtRedes = view.findViewById(R.id.lgbt_redes);
        lgbtCalendario = view.findViewById(R.id.lgbt_calendario);

        bNotif1 = view.findViewById(R.id.notificacion_event_1);
        bNotif2 = view.findViewById(R.id.notificacion_event_2);

        //Aqui se les tiene que asignar su respectivo ID a cada TextView
        inclusionTitulo = view.findViewById(R.id.inclusion_titulo);
        inclusionInformacion = view.findViewById(R.id.inclusion_informacion);

        lgbtTitulo = view.findViewById(R.id.lgbt_titulo);
        lgbtInformacion = view.findViewById(R.id.lgbt_informacion);

        //Aqui se le asignan las acciones a cada boton
        //Insertar enlace a forms donde se registrarán las personas
        inclusionRegistro.setOnClickListener(view1 -> {abrirRegistro("https://docs.google.com/forms/d/e/1FAIpQLSd09Gs-125vGNkWsYhk9vgQAWGmSWtRJehBvLSDEjJQdGdpoQ/viewform?usp=sf_link"); });
        //Insertar el link de las redes sociales del ponente
        inclusionRedes.setOnClickListener(view1 -> {abrirRedes("https://twitter.com/elonmusk");});
        inclusionCalendario.setOnClickListener(view1 -> {abrirCalendario();});

        //Insertar enlace a forms donde se registrarán las personas
        lgbtRegistro.setOnClickListener(view1 -> {abrirRegistro("https://docs.google.com/forms/d/e/1FAIpQLScg3mz6GIYu_TVAGpGkx0pcLxKUFJIn-gjcFKq0XNI-TzeFlA/viewform?usp=sf_link"); });
        //Insertar el link de las redes sociales del ponente
        lgbtRedes.setOnClickListener(view1 -> {abrirRedes("https://twitter.com/Reforma");});
        lgbtCalendario.setOnClickListener(view1 -> {abrirCalendario();});


        bNotif1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editor.putBoolean("notif_1", true);
                editor.apply();
            }
        });
        bNotif2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editor.putBoolean("notif_2", true);
                editor.apply();
            }
        });

    }

    public void abrirRegistro(String url){
        Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
        startActivity(browserIntent);
    }

    public void abrirRedes(String url){
        Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
        startActivity(browserIntent);
    }

    public void abrirCalendario(){


    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_eventos, container, false);
    }
}