/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Main;

import java.util.Date;

/**
 *
 * @author a2021005
 */
public class Materia {
    private String nome;
    private String professor;
    private Double nota;
    private int faltas;
    private Date ultimoDia; 

    public Materia() {
    }

    public Materia(String nome, String professor, Double nota, int faltas, Date ultimoDia) {
        this.nome = nome;
        this.professor = professor;
        this.nota = nota;
        this.faltas = faltas;
        this.ultimoDia = ultimoDia;
    }

    public Date getUltimoDia() {
        return ultimoDia;
    }

    public void setUltimoDia(Date ultimoDia) {
        this.ultimoDia = ultimoDia;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getProfessor() {
        return professor;
    }

    public void setProfessor(String professor) {
        this.professor = professor;
    }

    public Double getNota() {
        return nota;
    }

    public void setNota(Double nota) {
        this.nota = nota;
    }

    public int getFaltas() {
        return faltas;
    }

    public void setFaltas(int faltas) {
        this.faltas = faltas;
    }
    
}
