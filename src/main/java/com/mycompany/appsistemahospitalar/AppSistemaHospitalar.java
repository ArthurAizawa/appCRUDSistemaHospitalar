/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.appsistemahospitalar;

import com.mycompany.appsistemahospitalar.DAO.EspecialidadeDAO;
import com.mycompany.appsistemahospitalar.entities.Agendamento;
import com.mycompany.appsistemahospitalar.entities.Especialidade;

/**
 *
 * @author arthu
 */
public class AppSistemaHospitalar {

    public static void main(String[] args) {
        Especialidade especialidade = new Especialidade();

        /*
        especialidade.setEspecialidade("Pediatra");
        especialidade.setDescricao("Medico das criancas ate 14 anos");
        */
        EspecialidadeDAO espDAO = new EspecialidadeDAO();
        espDAO.buscarEspecialidade(1);
        espDAO.removerEspecialidade(2);
        espDAO.listarEspecialidade();
    }
}
