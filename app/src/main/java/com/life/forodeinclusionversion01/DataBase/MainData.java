package com.life.forodeinclusionversion01.DataBase;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.io.Serializable;

// Definir nombre de la tabla
@Entity(tableName="tabla_foro") //table_name

public class MainData implements Serializable {

    //Columna de id
    @PrimaryKey(autoGenerate = true)
    private int ID;

    //Columna de titulo
    @ColumnInfo(name = "titulo")
    private String titulo;

    //Columna de descripcion
    @ColumnInfo(name = "descripcion")
    private String descripcion;

    //Columna de Fecha
    @ColumnInfo(name = "fecha")
    private String fecha;

    //Getters y setters

    public MainData(String titulo, String descripcion, String fecha){
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.fecha = fecha;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getFecha(){return fecha;}

    public void setFecha(String fecha){this.fecha = fecha;}

}
