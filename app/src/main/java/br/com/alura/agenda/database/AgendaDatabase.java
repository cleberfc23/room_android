package br.com.alura.agenda.database;

import static br.com.alura.agenda.database.Migrations.ALL_MIGRATIONS;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.room.TypeConverters;
import androidx.room.migration.Migration;
import androidx.sqlite.db.SupportSQLiteDatabase;

import br.com.alura.agenda.database.converter.ConversorCalendar;
import br.com.alura.agenda.database.dao.RoomAlunoDAO;
import br.com.alura.agenda.model.Aluno;

@Database(
        entities = {Aluno.class},
        version = 4,
        exportSchema = false)

@TypeConverters({ConversorCalendar.class})
public abstract class AgendaDatabase extends RoomDatabase {

    public static final String AGENDA_DB = "agenda.db";


    public static AgendaDatabase instance;

    public abstract RoomAlunoDAO getRoomAlunoDAO();

    public static AgendaDatabase getInstanceRoom(Context context) {
        if (instance == null) {
            instance = Room.databaseBuilder(context, AgendaDatabase.class, AGENDA_DB)
                    .allowMainThreadQueries()
                    .addMigrations(ALL_MIGRATIONS)
                    .build();
        }
        return instance;
    }

}


