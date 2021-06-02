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

    //Getters y setters

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getText() {
        return titulo;
    }

    public void setText(String titulo) {
        this.titulo = titulo;
    }

    public String getText2() {
        return descripcion;
    }

    public void setText2(String descripcion) {
        this.descripcion = descripcion;
    }
}
