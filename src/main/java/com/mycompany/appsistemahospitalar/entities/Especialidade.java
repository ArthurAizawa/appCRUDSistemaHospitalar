/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.appsistemahospitalar.entities;

/**
 *
 * @author arthu
 */
public class Especialidade {
    private int id_especialidade;
    private String especialidade;
    private String descricao;
    
    public Especialidade(){
        
    }

    public void setId_especialidade(int id_especialidade) {
        this.id_especialidade = id_especialidade;
    }

    public Especialidade(int id_especialidade, String especialidade, String descricao) {
        this.id_especialidade = id_especialidade;
        this.especialidade = especialidade;
        this.descricao = descricao;
    }

    public int getId_especialidade() {
        return id_especialidade;
    }

    public String getEspecialidade() {
        return especialidade;
    }

    public void setEspecialidade(String especialidade) {
        this.especialidade = especialidade;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
    
}
