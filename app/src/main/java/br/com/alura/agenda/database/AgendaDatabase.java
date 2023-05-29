package br.com.alura.agenda.database;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import br.com.alura.agenda.database.dao.RoomAlunoDAO;
import br.com.alura.agenda.model.Aluno;

@Database(
        entities = {Aluno.class},
        version = 2,
        exportSchema = false)

public abstract class AgendaDatabase extends RoomDatabase {

    public static final String AGENDA_DB = "agenda.db";
    public static AgendaDatabase instance;

    public abstract RoomAlunoDAO getRoomAlunoDAO();

    public static AgendaDatabase getInstanceRoom(Context context) {
        if (instance == null) {
            instance = Room.databaseBuilder(context, AgendaDatabase.class, AGENDA_DB)
                    .allowMainThreadQueries()
                    .fallbackToDestructiveMigration()
                    .build();
        }
        return instance;
    }

}


