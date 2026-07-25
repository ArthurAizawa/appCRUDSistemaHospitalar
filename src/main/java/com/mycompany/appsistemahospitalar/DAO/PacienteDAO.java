/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.appsistemahospitalar.DAO;

import com.mycompany.appsistemahospitalar.BD.ConnectionBD;
import com.mycompany.appsistemahospitalar.entities.Paciente;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Samuel Freitas Costa
 */
public class PacienteDAO {
    
     public void inserirPaciente(Paciente paciente) {
        try {
            //iniciando conexao com o banco de dados
            Connection conn = ConnectionBD.conectar();
            //comando slq para inserir valores no banco
            String command
                    = "INSERT INTO paciente(nome,cpf,data_nascimento,telefone,email,endereco) VALUES(?,?,?,?,?,?)";
            PreparedStatement ps = conn.prepareStatement(command);

            //os numeros representam os values(?,?), que sao referente as colunas do banco de dados
            ps.setString(1, paciente.getNome());
            ps.setString(2, paciente.getCpf());
            ps.setDate(3, java.sql.Date.valueOf(paciente.getDataNascimento()));
            ps.setInt(4, paciente.getTelefone());
            ps.setString(5, paciente.getEmail());
            ps.setString(6, paciente.getEndereco());
            

            //atualizando o banco
            ps.executeUpdate();

            System.out.println("Paciente cadastrado!");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}