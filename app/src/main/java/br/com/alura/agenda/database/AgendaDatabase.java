package br.com.alura.agenda.database;


import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import br.com.alura.agenda.model.Aluno;

@Database(entities = {Aluno.class}, version = 1, exportSchema = false)

public abstract class AgendaDatabase extends RoomDatabase {

    public static final String AGENDA_DB = "agenda.db";
    public static AgendaDatabase instance;

    public static AgendaDatabase getInstanceRoom(Context context) {
        if (instance == null) {
            instance = Room.databaseBuilder(context, AgendaDatabase.class, AGENDA_DB)
                    .allowMainThreadQueries()
                    .build();
        }
        return instance;
    }

}
