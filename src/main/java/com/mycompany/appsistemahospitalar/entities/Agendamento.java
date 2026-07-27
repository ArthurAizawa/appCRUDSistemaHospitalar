/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.appsistemahospitalar.entities;

import com.mycompany.appsistemahospitalar.entities.Medico;
import com.mycompany.appsistemahospitalar.entities.Paciente;
import java.time.LocalDate;
import java.time.LocalTime;

/**
 *
 * @author arthu
 */
public class Agendamento {
    private int id_agendamento;
    private String status;
    private String obs;

    private LocalTime horarioConsulta;
    private LocalDate dataConsulta;

   

    private Medico medico;
    private Paciente paciente;
    
    public Agendamento(){
        
    }
    
    public Agendamento(int id_agendamento, String status, String obs, LocalTime horarioConsulta, Medico medico, Paciente paciente) {
        this.id_agendamento = id_agendamento;
        this.status = status;
        this.obs = obs;
        this.horarioConsulta = horarioConsulta;
        this.medico = medico;
        this.paciente = paciente;
    }
    
    public int getId_agendamento() {
        return id_agendamento;
    }

    public void setId_agendamento(int id_agendamento) {
        this.id_agendamento = id_agendamento;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getObs() {
        return obs;
    }

    public void setObs(String obs) {
        this.obs = obs;
    }

    public LocalTime getHorarioConsulta() {
        return horarioConsulta;
    }

    public void setHorarioConsulta(LocalTime horarioConsulta) {
        this.horarioConsulta = horarioConsulta;
    }

    public Medico getMedico() {
        return medico;
    }

    public void setMedico(Medico medico) {
        this.medico = medico;
    }

    public Paciente getPaciente() {
        return paciente;
    }

    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }
     public LocalDate getDataConsulta() {
        return dataConsulta;
    }

    public void setDataConsulta(LocalDate dataConsulta) {
        this.dataConsulta = dataConsulta;
    }
}
