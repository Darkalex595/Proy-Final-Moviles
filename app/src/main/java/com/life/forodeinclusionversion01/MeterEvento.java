package com.life.forodeinclusionversion01;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.TextView;
import android.widget.Toast;

import com.life.forodeinclusionversion01.DataBase.MainData;
import com.life.forodeinclusionversion01.DataBase.RoomDB;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;


public class MeterEvento extends Fragment {

    public MeterEvento() {
        // Required empty public constructor
    }

    String año;
    String mes;
    String dia;
    String fecha;

    private RoomDB roomDB;

    // TODO: Rename and change types and number of parameters
    public static MeterEvento newInstance(String param1, String param2) {
        MeterEvento fragment = new MeterEvento();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        roomDB = RoomDB.getInstance(getActivity());
        CalendarView cView = view.findViewById(R.id.datePicker);
        TextView titulo = view.findViewById(R.id.editTitulo);
        TextView decrip = view.findViewById(R.id.editDescripcion);
        TextView hour = view.findViewById(R.id.tHora);
        Button añadir = view.findViewById(R.id.c_event);
        Button borrar = view.findViewById(R.id.c_delete);

        SimpleDateFormat formatter= new SimpleDateFormat("dd/MM/yyyy");
        Date date = new Date(System.currentTimeMillis());
        fecha = formatter.format(date);

        cView.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(@NonNull CalendarView view, int year, int month, int dayOfMonth) {
                month = month + 1;

                if(dayOfMonth < 10){
                    dia = String.valueOf(dayOfMonth);
                    dia = "0"+dia;
                }
                else{
                    dia = String.valueOf(dayOfMonth);
                }

                if(month < 10){
                    mes = String.valueOf(month);
                    mes = "0"+mes;
                }
                else{
                    mes = String.valueOf(month);
                }

                año = String.valueOf(year);

                fecha = dia +  "/" + mes + "/" + año;

            }
        });

        añadir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String title = String.valueOf(titulo.getText());
                String description = String.valueOf(decrip.getText());
                String Hora = String.valueOf(hour.getText());

                if(title.matches("") || description.matches("") || Hora.matches("")){
                    Toast.makeText(getActivity().getApplicationContext(), "Hay que llenar todos los campos", Toast.LENGTH_SHORT).show();
                }

                else{

                    MainData md = new MainData(title, description, fecha, Hora);
                    roomDB.mainDao().insert(md);

                    titulo.setText("");
                    decrip.setText("");
                    hour.setText("");

                    Toast.makeText(getActivity().getApplicationContext(), "Evento agregado", Toast.LENGTH_SHORT).show();
                }


            }
        });

        borrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                List<MainData> lista = roomDB.mainDao().getAll();
                roomDB.mainDao().reset(lista);
                titulo.setText("");
                decrip.setText("");
                hour.setText("");
            }
        });

        super.onViewCreated(view, savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_meter_evento, container, false);
    }
}