package com.mycompany.appsistemahospitalar.DAO;

import com.mycompany.appsistemahospitalar.BD.ConnectionBD;
import com.mycompany.appsistemahospitalar.entities.Agendamento;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class AgendamentoDAO {

    // Inserir
    public void inserirAgendamento(Agendamento agendamento) {

        try {

            Connection conn = ConnectionBD.conectar();

            String sql = """
                    INSERT INTO agendamento
                    (data_consulta, hora_consulta, status, id_medico, id_paciente)
                    VALUES (?, ?, ?, ?, ?)
                    """;

            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setDate(1,
                    java.sql.Date.valueOf(agendamento.getDataConsulta()));

            ps.setTime(2,
                    java.sql.Time.valueOf(agendamento.getHorarioConsulta()));

            ps.setString(3, agendamento.getStatus());

            ps.setInt(4,
                    agendamento.getMedico().getId());

            ps.setInt(5,
                    agendamento.getPaciente().getId_paciente());

            ps.executeUpdate();

            ps.close();
            conn.close();

            System.out.println("Agendamento realizado!");

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    // Listar
    public void listarAgendamentos() {

        try {

            Connection conn = ConnectionBD.conectar();

            String sql = "SELECT * FROM agendamento";

            PreparedStatement ps = conn.prepareStatement(sql);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {

                System.out.println("ID: " + rs.getInt("id_agendamento"));
                System.out.println("Data: " + rs.getDate("data_consulta"));
                System.out.println("Hora: " + rs.getTime("hora_consulta"));
                System.out.println("Status: " + rs.getString("status"));
                System.out.println("Médico: " + rs.getInt("id_medico"));
                System.out.println("Paciente: " + rs.getInt("id_paciente"));

                System.out.println("-------------------------");
            }

            rs.close();
            ps.close();
            conn.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    // Buscar
    public void buscarAgendamento(int id) {

        try {

            Connection conn = ConnectionBD.conectar();

            String sql = """
                    SELECT * FROM agendamento
                    WHERE id_agendamento = ?
                    """;

            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setInt(1, id);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {

                System.out.println("ID: " + rs.getInt("id_agendamento"));
                System.out.println("Data: " + rs.getDate("data_consulta"));
                System.out.println("Hora: " + rs.getTime("hora_consulta"));
                System.out.println("Status: " + rs.getString("status"));
                System.out.println("Médico: " + rs.getInt("id_medico"));
                System.out.println("Paciente: " + rs.getInt("id_paciente"));

            } else {

                System.out.println("Agendamento não encontrado.");

            }

            rs.close();
            ps.close();
            conn.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    // Atualizar
    public void atualizarAgendamento(Agendamento agendamento) {

        try {

            Connection conn = ConnectionBD.conectar();

            String sql = """
                    UPDATE agendamento
                    SET data_consulta = ?,
                        hora_consulta = ?,
                        status = ?,
                        id_medico = ?,
                        id_paciente = ?
                    WHERE id_agendamento = ?
                    """;

            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setDate(1,
                    java.sql.Date.valueOf(agendamento.getDataConsulta()));

            ps.setTime(2,
                    java.sql.Time.valueOf(agendamento.getHorarioConsulta()));

            ps.setString(3, agendamento.getStatus());

            ps.setInt(4,
                    agendamento.getMedico().getId());

            ps.setInt(5,
                    agendamento.getPaciente().getId_paciente());

            ps.setInt(6, agendamento.getId_agendamento());

            ps.executeUpdate();

            ps.close();
            conn.close();

            System.out.println("Agendamento atualizado!");

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    // Remover
    public void removerAgendamento(int id) {

        try {

            Connection conn = ConnectionBD.conectar();

            String sql = """
                    DELETE FROM agendamento
                    WHERE id_agendamento = ?
                    """;

            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setInt(1, id);

            ps.executeUpdate();

            ps.close();
            conn.close();

            System.out.println("Agendamento removido!");

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}