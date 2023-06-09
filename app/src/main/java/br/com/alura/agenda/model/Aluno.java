package br.com.alura.agenda.model;

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Calendar;

@Entity
public class Aluno implements Serializable {

    @PrimaryKey(autoGenerate = true)
    private int id = 0;
    private String nome;
    //    private String sobrenome;
    private String telefone;
    private String email;
    private Calendar momentoDeCastastro = Calendar.getInstance();

//    @Ignore
//    public Aluno(String nome, String telefone, String email, String sobrenome) {
//        this.nome = nome;
////        this.sobrenome = sobrenome;
//        this.telefone = telefone;
//        this.email = email;
//    }
//
//    public Aluno() {
//
//    }

    public Calendar getMomentoDeCastastro() {
        return momentoDeCastastro;
    }

    public void setMomentoDeCastastro(Calendar momentoDeCastastro) {
        this.momentoDeCastastro = momentoDeCastastro;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

//    public void setSobrenome(String sobrenome) {
//        this.sobrenome = sobrenome;
//    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNome() {
        return nome;
    }

//    public String getSobrenome() {
//        return sobrenome;
//    }

    public String getNomeCompleto() {
        return (getNome() + " ");
    }

    public String getTelefone() {
        return telefone;
    }

    public String getEmail() {
        return email;
    }

    @NonNull
    @Override
    public String toString() {
        return nome + " - " + telefone;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public boolean temIdValido() {
        return id > 0;
    }

    public String getDataFormatada() {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
        return simpleDateFormat.format(this.momentoDeCastastro.getTime());
    }
}
