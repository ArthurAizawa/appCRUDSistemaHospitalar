/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.appsistemahospitalar.DAO;

import com.mycompany.appsistemahospitalar.BD.ConnectionBD;
import com.mycompany.appsistemahospitalar.entities.Especialidade;
import com.mysql.cj.util.TestUtils;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

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
    public void listarEspecialidade(){
        try {
            //iniciando conexao com o banco de dados
            Connection conn = ConnectionBD.conectar();
            //comando slq para listar valores do banco
            String command = 
                    "SELECT *FROM especialidade";
            PreparedStatement ps =  conn.prepareStatement(command);
            //resultado do banco
            ResultSet rs =  ps.executeQuery();
            
            while(rs.next()){
                //atribuindo valores resgatado do banco
                int id = rs.getInt("id_especialidade");
                String nome = rs.getString("nome");
                String descricacao = rs.getString("descricao");
                
                //listando no console
                System.out.println("id: " +id);
                System.out.println("nome: " +nome);
                System.out.println("descricao: " +descricacao);
            }
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
