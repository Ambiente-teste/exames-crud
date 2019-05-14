package br.com.gt.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Admin {

	// Método para criar conexão com o MySQL
	public static Connection getConnection() throws Exception {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			return DriverManager.getConnection(
					"jdbc:mysql://127.0.0.1:3306/exames", "root", "root");
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	// Método para salvar o paciente no banco de dados
	public int registrarPaciente(String nome, int idade, String sexo,
			String email, String telefone, String cpf, String dataNascimento)
			throws Exception {
		int i = 0;
		try {
			String sql = "INSERT INTO paciente VALUES (?,?,?,?,?,?,?)";
			PreparedStatement ps = getConnection().prepareStatement(sql);
			ps.setString(1, nome);
			ps.setInt(2, idade);
			ps.setString(3, sexo);
			ps.setString(4, email);
			ps.setString(5, telefone);
			ps.setString(6, cpf);
			ps.setString(7, dataNascimento);
			i = ps.executeUpdate();
			return i;
		} catch (Exception e) {
			e.printStackTrace();
			return i;
		} finally {
			if (getConnection() != null) {
				getConnection().close();
			}
		}
	}

	// Método para listar todos os pacientes do banco de dados
	public ResultSet listarPacientes() throws SQLException, Exception {
		ResultSet rs = null;
		try {
			String sql = "SELECT nome,idade,sexo,dataNascimento,email,telefone,cpf FROM paciente";
			PreparedStatement ps = getConnection().prepareStatement(sql);
			rs = ps.executeQuery();
			return rs;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		} finally {
			if (getConnection() != null) {
				getConnection().close();
			}
		}
	}

	// Método para listar um paciente por cpf do banco de dados
	public ResultSet obterPacientePorCpf(String cpf) throws SQLException,
			Exception {
		ResultSet rs = null;
		try {
			String sql = "SELECT nome,idade,sexo,dataNascimento,email,telefone,cpf FROM paciente WHERE cpf=?";
			PreparedStatement ps = getConnection().prepareStatement(sql);
			ps.setString(1, cpf);
			rs = ps.executeQuery();
			return rs;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		} finally {
			if (getConnection() != null) {
				getConnection().close();
			}
		}
	}

	// Método para atualizar um paciente por cpf do banco de dados
	public int atualizarPaciente(String nome, int idade, String sexo,
			String dataNascimento, String email, String telefone, String cpf,
			String cpfhidden) throws SQLException, Exception {
		getConnection().setAutoCommit(false);
		int i = 0;
		try {
			String sql = "UPDATE paciente SET nome=?,idade=?,sexo=?,dataNascimento=?,email=?,telefone=?,cpf=? WHERE cpf=?";
			PreparedStatement ps = getConnection().prepareStatement(sql);
			ps.setString(1, nome);
			ps.setInt(2, idade);
			ps.setString(3, sexo);
			ps.setString(4, dataNascimento);
			ps.setString(5, email);
			ps.setString(6, telefone);
			ps.setString(7, cpf);
			ps.setString(8, cpfhidden);
			i = ps.executeUpdate();
			return i;
		} catch (Exception e) {
			e.printStackTrace();
			getConnection().rollback();
			return 0;
		} finally {
			if (getConnection() != null) {
				getConnection().close();
			}
		}
	}

	// Método para Deletar um paciente do banco de dados
	public int removerPaciente(String cpf) throws SQLException, Exception {
		getConnection().setAutoCommit(false);
		int i = 0;
		try {
			String sql = "DELETE FROM paciente WHERE cpf=?";
			PreparedStatement ps = getConnection().prepareStatement(sql);
			ps.setString(1, cpf);
			i = ps.executeUpdate();
			return i;
		} catch (Exception e) {
			e.printStackTrace();
			getConnection().rollback();
			return 0;
		} finally {
			if (getConnection() != null) {
				getConnection().close();
			}
		}
	}
}
