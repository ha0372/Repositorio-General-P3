/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entidades;

/**
 *
 * @author William
 */
public class Nota extends Estudiante {

    String nota;
    int fkMateria;
    int fkEstudiante;

    public int getFkMateria() {
        return fkMateria;
    }

    public void setFkMateria(int fkMateria) {
        this.fkMateria = fkMateria;
    }

    public int getFkEstudiante() {
        return fkEstudiante;
    }

    public void setFkEstudiante(int fkEstudiante) {
        this.fkEstudiante = fkEstudiante;
    }

    public String getNota() {
        return nota;
    }

    public void setNota(String nota) {
        this.nota = nota;
    }

}
