package br.com.alura.agenda.database.converter;

import androidx.room.TypeConverter;

import java.util.Calendar;

public class ConversorCalendar {

    @TypeConverter
    public Long toLong(Calendar valor) {
        if (valor != null) {
            return valor.getTimeInMillis();
        } else {
            return 0L;
        }
    }

    @TypeConverter
    public Calendar toCalendar(Long valor) {
        Calendar instance = Calendar.getInstance();
        if (valor != null) {
            instance.setTimeInMillis(valor);
        }
        return instance;
    }


}
