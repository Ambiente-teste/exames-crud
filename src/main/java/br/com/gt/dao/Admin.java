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
			return DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/db_clinica", "root", "root");
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	// Método para salvar o exame no banco de dados
	public int registrarExame(String nome, int idade, String sexo, String telefone, String cpf, String dataNascimento,
			String nomeDoExame, String dataDoExame, String horaDoExame) throws Exception {
		int i = 0;
		try {
			String sql = "INSERT INTO exame VALUES (?,?,?,?,?,?,?,?,?)";
			PreparedStatement ps = getConnection().prepareStatement(sql);
			ps.setString(1, nome);
			ps.setInt(2, idade);
			ps.setString(3, sexo);
			ps.setString(4, telefone);
			ps.setString(5, cpf);
			ps.setString(6, dataNascimento);
			ps.setString(7, nomeDoExame);
			ps.setString(8, dataDoExame);
			ps.setString(9, horaDoExame);
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

	// Método para listar todos os exames do banco de dados
	public ResultSet listarExames() throws SQLException, Exception {
		ResultSet rs = null;
		try {
			String sql = "SELECT nome,idade,sexo,dataNascimento,telefone,cpf,nomeDoExame,dataDoExame,horaDoExame FROM exame";
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

	// Método para listar um exame por cpf do banco de dados
	public ResultSet obterExamePorCpf(String cpf) throws SQLException, Exception {
		ResultSet rs = null;
		try {
			String sql = "SELECT nome,idade,sexo,dataNascimento,telefone,cpf,nomeDoExame,dataDoExame,horaDoExame FROM exame WHERE cpf=?";
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

	// Método para atualizar um exame por cpf do banco de dados
	public int atualizarExame(String nome, int idade, String sexo, String dataNascimento, String telefone,
			String cpf, String cpfhidden, String nomeDoExame, String dataDoExame, String horaDoExame) throws SQLException, Exception {
		getConnection().setAutoCommit(false);
		int i = 0;
		try {
			String sql = "UPDATE exame SET nome=?,idade=?,sexo=?,dataNascimento=?,telefone=?,cpf=?,nomeDoExame=?,dataDoExame=?,horaDoExame=? WHERE cpf=?";
			PreparedStatement ps = getConnection().prepareStatement(sql);
			ps.setString(1, nome);
			ps.setInt(2, idade);
			ps.setString(3, sexo);
			ps.setString(4, dataNascimento);
			ps.setString(5, telefone);
			ps.setString(6, cpf);
			ps.setString(7, nomeDoExame);
			ps.setString(8, dataDoExame);
			ps.setString(9, horaDoExame);
			ps.setString(10, cpfhidden);
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

	// Método para Deletar um exame do banco de dados
	public int removerExame(String cpf) throws SQLException, Exception {
		getConnection().setAutoCommit(false);
		int i = 0;
		try {
			String sql = "DELETE FROM exame WHERE cpf=?";
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
