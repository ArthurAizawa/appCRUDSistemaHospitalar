package com.mycompany.appsistemahospitalar.DAO;

import com.mycompany.appsistemahospitalar.BD.ConnectionBD;
import com.mycompany.appsistemahospitalar.entities.Medico;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class MedicoDAO {

    // Inserir
    public void inserirMedico(Medico medico) {

        try {

            Connection conn = ConnectionBD.conectar();

            String sql = """
                    INSERT INTO medicos
                    (nome, crm, telefone, email, id_especialidade)
                    VALUES (?, ?, ?, ?, ?)
                    """;

            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setString(1, medico.getNome());
            ps.setString(2, medico.getCrm());
            ps.setString(3, medico.getTel());
            ps.setString(4, medico.getEmail());
            ps.setInt(5, medico.getEspecialidade().getId_especialidade());

            ps.executeUpdate();

            ps.close();
            conn.close();

            System.out.println("Médico cadastrado!");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Listar
    public void listarMedicos() {

        try {

            Connection conn = ConnectionBD.conectar();

            String sql = "SELECT * FROM medicos";

            PreparedStatement ps = conn.prepareStatement(sql);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {

                System.out.println("ID: " + rs.getInt("id_medico"));
                System.out.println("Nome: " + rs.getString("nome"));
                System.out.println("CRM: " + rs.getString("crm"));
                System.out.println("Telefone: " + rs.getString("telefone"));
                System.out.println("Email: " + rs.getString("email"));
                System.out.println("Especialidade: " + rs.getInt("id_especialidade"));

                System.out.println("--------------------------");
            }

            rs.close();
            ps.close();
            conn.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    // Buscar
    public void buscarMedico(int id) {

        try {

            Connection conn = ConnectionBD.conectar();

            String sql = """
                    SELECT * FROM medico
                    WHERE id_medico = ?
                    """;

            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setInt(1, id);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {

                System.out.println("ID: " + rs.getInt("id_medico"));
                System.out.println("Nome: " + rs.getString("nome"));
                System.out.println("CRM: " + rs.getString("crm"));
                System.out.println("Telefone: " + rs.getString("telefone"));
                System.out.println("Email: " + rs.getString("email"));
                System.out.println("Especialidade: " + rs.getInt("id_especialidade"));

            } else {

                System.out.println("Médico não encontrado.");

            }

            rs.close();
            ps.close();
            conn.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    // Atualizar
    public void atualizarMedico(Medico medico) {

        try {

            Connection conn = ConnectionBD.conectar();

            String sql = """
                    UPDATE medico
                    SET nome = ?,
                        crm = ?,
                        telefone = ?,
                        email = ?,
                        id_especialidade = ?
                    WHERE id_medico = ?
                    """;

            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setString(1, medico.getNome());
            ps.setString(2, medico.getCrm());
            ps.setString(3, medico.getTel());
            ps.setString(4, medico.getEmail());
            ps.setInt(5, medico.getEspecialidade().getId_especialidade());
            ps.setInt(6, medico.getId());

            ps.executeUpdate();

            ps.close();
            conn.close();

            System.out.println("Médico atualizado!");

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    // Remover
    public void removerMedico(int id) {

        try {

            Connection conn = ConnectionBD.conectar();

            String sql = """
                    DELETE FROM medico
                    WHERE id_medico = ?
                    """;

            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setInt(1, id);

            ps.executeUpdate();

            ps.close();
            conn.close();

            System.out.println("Médico removido!");

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}