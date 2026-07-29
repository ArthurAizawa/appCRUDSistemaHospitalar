/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.appsistemahospitalar.DAO;

import com.mycompany.appsistemahospitalar.BD.ConnectionBD;
import com.mycompany.appsistemahospitalar.entities.Especialidade;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author arthu
 */
public class EspecialidadeDAO {

    public void inserirEspecialidade(Especialidade especialidade) {
        try {
            //iniciando conexao com o banco de dados
            Connection conn = ConnectionBD.conectar();
            //comando slq para inserir valores no banco
            String command
                    = "INSERT INTO especialidade(nome,descricao) VALUES(?,?)";
            PreparedStatement ps = conn.prepareStatement(command);

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

    public List<Especialidade> listarEspecialidade() {
        List<Especialidade> list = new ArrayList();
        try {
            //iniciando conexao com o banco de dados
            Connection conn = ConnectionBD.conectar();
            //comando slq para listar valores do banco
            String command
                    = "SELECT *FROM especialidade";
            PreparedStatement ps = conn.prepareStatement(command);
            //resultado do banco
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {

                Especialidade esp = new Especialidade();

                esp.setId_especialidade(rs.getInt("id_especialidade"));
                esp.setEspecialidade(rs.getString("nome"));
                esp.setDescricao(rs.getString("descricao"));

                list.add(esp);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return list;
    }

    public Especialidade buscarEspecialidade(int id) {
        
        Especialidade esp = null;

        try {
            //iniciando conexao com o banco de dados
            Connection conn = ConnectionBD.conectar();
            //comando slq para listar valores do banco
            String command
                    = "SELECT *FROM especialidade "
                    + "WHERE id_especialidade = ?";

            PreparedStatement ps;
            ps = conn.prepareStatement(command);
            ps.setInt(1, id);

            ResultSet rs = ps.executeQuery();
            //se encontrar a especialidade:
            if (rs.next()) {
                esp = new Especialidade();

                int id_esp = rs.getInt("id_especialidade");
                String nome = rs.getString("nome");
                String descricacao = rs.getString("descricao");

                //listando no console
                System.out.println("id: " + id_esp);
                System.out.println("nome: " + nome);
                System.out.println("descricao: " + descricacao);
            } else {
                System.out.println("id:" + id + " nao encontrado ");
            }
        } catch (SQLException ex) {
            Logger.getLogger(EspecialidadeDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return esp;
    }

    public void removerEspecialidade(int id) {
        try {
            Connection conn = ConnectionBD.conectar();

            String sql = """
                DELETE FROM especialidade
                WHERE id_especialidade = ?
                """;

            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setInt(1, id);

            ps.executeUpdate();

            System.out.println("Especialidade " + id + " excluída com sucesso!");

            ps.close();
            conn.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
