/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.appsistemahospitalar;

import com.mycompany.appsistemahospitalar.entities.Agendamento;

/**
 *
 * @author arthu
 */
public class AppSistemaHospitalar {

    public static void main(String[] args) {
        Medico medico = new Medico();
        medico.setId(1);
        Agendamento agenda = new Agendamento();
        agenda.setMedico(medico);
        System.out.println("id = "+agenda.getMedico().getId());
    }
}
