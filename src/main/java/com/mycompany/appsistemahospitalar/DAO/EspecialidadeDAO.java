/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.appsistemahospitalar.DAO;

import com.mycompany.appsistemahospitalar.BD.ConnectionBD;
import com.mycompany.appsistemahospitalar.entities.Especialidade;
import java.sql.Connection;
import java.sql.PreparedStatement;

/**
 *
 * @author arthu
 */
public class EspecialidadeDAO {
    public void inserirEspecialidade(Especialidade especialidade){
        try {
            //iniciando conexao com o banco de dados
            Connection conn = ConnectionBD.conectar();
            //comando slq para inserir valores no banco
            String command = 
                    "INSERT INTO especialidade(nome,descricao) VALUES(?,?)";
            PreparedStatement ps =  conn.prepareStatement(command);
            
            //os numeros representam os values(?,?), que sao referente as colunas do banco de dados
            ps.setString(1, especialidade.getEspecialidade());
            ps.setString(2, especialidade.getDescricao());
            
            //atualizando o banco
            ps.executeUpdate();
            
            System.out.println("Especialidade cadastrada!");
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
