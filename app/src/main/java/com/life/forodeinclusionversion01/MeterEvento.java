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


public class MeterEvento extends Fragment {

    public MeterEvento() {
        // Required empty public constructor
    }

    String año;
    String mes;
    String dia;

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
        Button añadir = view.findViewById(R.id.c_event);

        cView.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(@NonNull CalendarView view, int year, int month, int dayOfMonth) {
                año = String.valueOf(year);
                mes = String.valueOf(month);
                dia = String.valueOf(dayOfMonth);
            }
        });

        añadir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String title = String.valueOf(titulo.getText());
                String description = String.valueOf(decrip.getText());
                String fecha = dia +  "/" + mes + "/" + año;
                MainData md = new MainData(title, description, fecha);
                roomDB.mainDao().insert(md);

                titulo.setText("");
                decrip.setText("");
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