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

/**
 *
 * @author arthu
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
            ps.setString(4, paciente.getTelefone());
            ps.setString(5, paciente.getEmail());
            ps.setString(6, paciente.getEndereco());

            //atualizando o banco
            ps.executeUpdate();

            System.out.println("Paciente cadastrado!");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void listarPacientes() {
        try {
            Connection conn = ConnectionBD.conectar();

            String sql = "SELECT * FROM paciente";

            PreparedStatement ps = conn.prepareStatement(sql);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {

                System.out.println("ID: " + rs.getInt("id_paciente"));
                System.out.println("Nome: " + rs.getString("nome"));
                System.out.println("CPF: " + rs.getString("cpf"));
                System.out.println("Nascimento: " + rs.getDate("data_nascimento"));
                System.out.println("Telefone: " + rs.getString("telefone"));
                System.out.println("Email: " + rs.getString("email"));
                System.out.println("Endereço: " + rs.getString("endereco"));
                System.out.println("------------------------------");
            }

            rs.close();
            ps.close();
            conn.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Buscar por ID
    public void buscarPaciente(int id) {

        try {
            Connection conn = ConnectionBD.conectar();

            String sql = """
                    SELECT * FROM paciente
                    WHERE id_paciente = ?
                    """;

            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setInt(1, id);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {

                System.out.println("ID: " + rs.getInt("id_paciente"));
                System.out.println("Nome: " + rs.getString("nome"));
                System.out.println("CPF: " + rs.getString("cpf"));
                System.out.println("Nascimento: " + rs.getDate("data_nascimento"));
                System.out.println("Telefone: " + rs.getString("telefone"));
                System.out.println("Email: " + rs.getString("email"));
                System.out.println("Endereço: " + rs.getString("endereco"));

            } else {

                System.out.println("Paciente não encontrado.");

            }

            rs.close();
            ps.close();
            conn.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Atualizar
    public void atualizarPaciente(Paciente paciente) {

        try {

            Connection conn = ConnectionBD.conectar();

            String sql = """
                    UPDATE paciente
                    SET nome = ?,
                        cpf = ?,
                        data_nascimento = ?,
                        telefone = ?,
                        email = ?,
                        endereco = ?
                    WHERE id_paciente = ?
                    """;

            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setString(1, paciente.getNome());
            ps.setString(2, paciente.getCpf());
            ps.setDate(3, java.sql.Date.valueOf(paciente.getDataNascimento()));
            ps.setString(4, paciente.getTelefone());
            ps.setString(5, paciente.getEmail());
            ps.setString(6, paciente.getEndereco());
            ps.setInt(7, paciente.getId_paciente());

            ps.executeUpdate();

            System.out.println("Paciente atualizado com sucesso!");

            ps.close();
            conn.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Remover
    public void removerPaciente(int id) {

        try {

            Connection conn = ConnectionBD.conectar();

            String sql = """
                    DELETE FROM paciente
                    WHERE id_paciente = ?
                    """;

            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setInt(1, id);

            ps.executeUpdate();

            System.out.println("Paciente removido com sucesso!");

            ps.close();
            conn.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
