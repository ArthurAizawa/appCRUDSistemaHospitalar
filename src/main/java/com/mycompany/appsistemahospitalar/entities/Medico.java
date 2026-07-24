/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.appsistemahospitalar;

import com.mycompany.appsistemahospitalar.entities.Especialidade;

/**
 *
 * @author arthu
 */
public class Medico {
    private int id_medico;
    private String nome;
    private String crm;
    private int tel;
    private String email;
    private Especialidade especialidade;
    
    public Medico(){
        id_medico = 0;
        nome = "";
        crm = "";
        tel = 0;
        email = "0";
    }

    public Medico(int id_medico, String nome, String crm, int tel, String email, Especialidade especialidade) {
        this.id_medico = id_medico;
        this.nome = nome;
        this.crm = crm;
        this.tel = tel;
        this.email = email;
        this.especialidade = especialidade;
    }

    public int getId() {
        return id_medico;
    }

    public void setId(int id_medico) {
        this.id_medico= id_medico;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCrm() {
        return crm;
    }

    public void setCrm(String crm) {
        this.crm = crm;
    }

    public int getTel() {
        return tel;
    }

    public void setTel(int tel) {
        this.tel = tel;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Especialidade getEspecialidade() {
        return especialidade;
    }

    public void setEspecialidade(Especialidade especialidade) {
        this.especialidade = especialidade;
    }
    
    
}
