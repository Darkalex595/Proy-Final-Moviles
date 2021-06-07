package com.life.forodeinclusionversion01;

import android.media.Image;
import android.widget.ImageView;

public class evento_calendario {

    private String Titulo;
    private String Hora;

    public evento_calendario(String titulo, String hora){
        Titulo = titulo;
        Hora = hora;
    }

    public evento_calendario(){

    }

    public String getTitulo() {
        return Titulo;
    }

    public void setTitulo(String titulo) {
        Titulo = titulo;
    }

    public String getHora() {
        return Hora;
    }

    public void setHora(String hora) {
        Hora = hora;
    }
}
