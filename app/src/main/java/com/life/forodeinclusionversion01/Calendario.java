package com.life.forodeinclusionversion01;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.TextView;

import com.life.forodeinclusionversion01.DataBase.MainData;
import com.life.forodeinclusionversion01.DataBase.RoomDB;

import java.util.List;


public class Calendario extends Fragment {

    private RoomDB roomDB;
    private MainData mainData;

    public Calendario() {
        // Required empty public constructor
    }


    public static Calendario newInstance() {
        Calendario fragment = new Calendario();
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
        super.onViewCreated(view, savedInstanceState);

        CalendarView cView = view.findViewById(R.id.vCalendario);
        TextView Confirmacion = view.findViewById(R.id.tEvento);
        //List<MainData> list = roomDB.mainDao().getAll();
        //MainData mD = list.get(0);
        
        cView.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(@NonNull CalendarView view, int year, int month, int dayOfMonth) {
                String Date = dayOfMonth + "/" + month + "/" + year;
                //Confirmacion.setText(String.valueOf(mD.getText()));
                Confirmacion.setText(Date);
            }
        });

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_calendario, container, false);
    }
}