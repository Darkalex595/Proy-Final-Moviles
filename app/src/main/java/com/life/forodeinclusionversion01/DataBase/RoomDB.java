package com.life.forodeinclusionversion01.DataBase;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

// Entidades base de datos
@Database(entities = {MainData.class}, version = 2, exportSchema = false)
public abstract class RoomDB extends RoomDatabase {

    // Crear instancia de la base de datos
    private static RoomDB database;

    //Definir nombre de la base de datos
    private static String DATABASE_NAME = "database";

    public synchronized static RoomDB getInstance(Context context){
        //Revisar condicion
        if (database == null){
            //inicializar base de datos cuando es null
            database = Room.databaseBuilder(context.getApplicationContext(),
                    RoomDB.class,DATABASE_NAME)
                    .allowMainThreadQueries()
                    .fallbackToDestructiveMigration()
                    .build();
        }
        //retornar base de datos
        return database;
    }

    //Crear Dao
    public abstract MainDao mainDao();
}
