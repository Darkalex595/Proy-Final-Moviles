package com.life.forodeinclusionversion01;

import android.app.AlarmManager;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;
import androidx.fragment.app.Fragment;

import com.life.forodeinclusionversion01.DataBase.MainData;
import com.life.forodeinclusionversion01.DataBase.RoomDB;

import java.util.Calendar;
import java.util.List;

import static android.content.Context.MODE_PRIVATE;
import static androidx.core.content.ContextCompat.getSystemService;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link Notificaciones#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Notificaciones extends Fragment {

    public Notificaciones() {
        // Required empty public constructor
    }

    private RoomDB roomDB;
    MainData md;

    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;

    int dia;
    String Date, Date_substr;
    boolean switch1, switch2;
    Button bNotifCancel1, bNotifCancel2;


    private RoomDB roomDB;

    public static Notificaciones newInstance() {
        Notificaciones fragment = new Notificaciones();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        sharedPreferences = getActivity().getSharedPreferences("Notificaciones", MODE_PRIVATE);
        editor = sharedPreferences.edit();

        switch1 = false;
        switch2 = false;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        switch1 = sharedPreferences.getBoolean("notif_1", false);
        switch2 = sharedPreferences.getBoolean("notif_2", false);

        bNotifCancel1 = view.findViewById(R.id.notificacion_notif_1);
        bNotifCancel2 = view.findViewById(R.id.notificacion_notif_2);

        if (switch1 || switch2) {
            View v = view.findViewById(R.id.noNotifs);
            v.setVisibility(View.GONE);
            if (switch1) {
                View c1 = view.findViewById(R.id.cardNotif);
                c1.setVisibility(View.VISIBLE);

                Date = "30/06/2021";        //Cambiar referencia a BD
                List<MainData> list = roomDB.mainDao().SearchByFecha(Date);
                md = list.get(0);

                Date = md.getFecha();
                Date_substr = Date.substring(0,1);
                dia = Integer.parseInt(Date_substr);
                dia = dia - 1;

                Calendar cal1 = Calendar.getInstance();
                cal1.set(Calendar.DATE, dia);
                cal1.set(Calendar.HOUR_OF_DAY, 12);
                cal1.set(Calendar.MINUTE, 0);
                cal1.set(Calendar.SECOND, 0);

            }
            if (switch2) {
                View c2 = view.findViewById(R.id.cardNotif2);
                c2.setVisibility(View.VISIBLE);

                Date = "04/07/2021";        //Cambiar referencia a BD
                List<MainData> list = roomDB.mainDao().SearchByFecha(Date);
                md = list.get(0);

                Date = md.getFecha();
                Date_substr = Date.substring(0,1);
                dia = Integer.parseInt(Date_substr);
                dia = dia - 1;

                Calendar cal2 = Calendar.getInstance();
                cal2.set(Calendar.DATE, dia);
                cal2.set(Calendar.HOUR_OF_DAY, 12);
                cal2.set(Calendar.MINUTE, 0);
                cal2.set(Calendar.SECOND, 0);

            }
        }

        bNotifCancel1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editor.putBoolean("notif_1", false);
                editor.apply();

                View c1 = view.findViewById(R.id.cardNotif);
                c1.setVisibility(View.GONE);

                clearNotif();
            }
        });
        bNotifCancel2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editor.putBoolean("notif_2", false);
                editor.apply();

                View c2 = view.findViewById(R.id.cardNotif2);
                c2.setVisibility(View.GONE);

                clearNotif();
            }
        });


    }



    public void clearNotif() {
        if ((!switch1) && (!switch2)) {
            View v = getView().findViewById(R.id.noNotifs);
            v.setVisibility(View.VISIBLE);
        }
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_notificaciones, container, false);
    }
}