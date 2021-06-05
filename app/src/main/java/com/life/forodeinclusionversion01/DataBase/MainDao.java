package com.life.forodeinclusionversion01.DataBase;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

import static androidx.room.OnConflictStrategy.REPLACE;

@Dao
public interface MainDao {

    //Query de insert
    @Insert(onConflict = REPLACE)
    void insert(MainData mainData);

    //Query de delete
    @Delete
    void delete(MainData mainData);

    //Query de delete all
    @Delete
    void reset(List<MainData> mainData);

    //Query de update titulo
    @Query("UPDATE tabla_foro SET titulo = :sTitulo WHERE ID = :sID")
    void updateTitulo(int sID,String sTitulo);

    //Query de update descripcion
    @Query("UPDATE tabla_foro SET descripcion = :sDescripcion WHERE ID = :sID")
    void updateDescripcion(int sID,String sDescripcion);

    //Query Get all data
    @Query("SELECT * FROM tabla_foro")
    List<MainData> getAll();

    //Get element filter by fecha
    @Query("SELECT * FROM tabla_foro WHERE fecha = :sFecha")
    List<MainData> SearchByFecha(String sFecha);

}
