package br.com.mr.agenda;

import java.util.Date;
import java.util.Objects;

public class Bovino {
    public void setId(int id) {
        this.id = id;
    }

    private int id;
    private String codigoRegistro;
    private String raca;
    private String sexo;
    private double peso;
    private Date dataNascimento;


    public Bovino(){

    }

    public Bovino(int id, String codigoRegistro, String raca, String sexo, double peso, Date dataNascimento) {
        this.id = id;
        this.codigoRegistro = codigoRegistro;
        this.raca = raca;
        this.sexo = sexo;
        this.peso = peso;
        this.dataNascimento = dataNascimento;
    }


    public int getId() {
        return id;
    }

    public String getCodigoRegistro() {
        return codigoRegistro;
    }

    public void setCodigoRegistro(String codigoRegistro) {
        this.codigoRegistro = codigoRegistro;
    }

    public String getRaca() {
        return raca;
    }

    public void setRaca(String raca) {
        this.raca = raca;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    public Date getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(Date dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Bovino bovino = (Bovino) o;
        return id == bovino.id && Objects.equals(codigoRegistro, bovino.codigoRegistro);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, codigoRegistro);
    }
}