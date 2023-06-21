package unicuritiba.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class JogoDao {

	public void inserir(Jogo j) {
		{
			// 1: Definir o comando SQL
			String sql = "INSERT INTO projeto_jogo(nome, tema) VALUES (?, ?)";
			// 2: Abrir uma conexao
			ConnectionFactory factory = new ConnectionFactory();
			try (Connection c = factory.obtemConexao()) {
				// 3: Pre compila o comando
				PreparedStatement ps = c.prepareStatement(sql);
				// 4: Preenche os dados faltantes
				ps.setString(1, j.getNome());
				ps.setString(2, j.getTema());
				// 5: Executa o comando
				ps.execute();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

	}

	public void atualizar(Jogo j) {
		// 1: Definir o comando SQL
		String sql = "UPDATE projeto_jogo SET nome = ?, tema = ? WHERE id = ?";
		// 2: Abrir uma conexao
		ConnectionFactory factory = new ConnectionFactory();
		try (Connection c = factory.obtemConexao()) {
			// 3: Pre compila o comando
			PreparedStatement ps = c.prepareStatement(sql);
			// 4: Preenche os dados faltantes
			ps.setString(1, j.getNome());
			ps.setString(2, j.getTema());
			ps.setInt(3, j.getId());

			// 5: Executa o comando
			ps.execute();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void apagar(int id) {
		// 1: Definir o comando SQL
		String sql = "DELETE FROM projeto_jogo WHERE id = ?";
		// 2: Abrir uma conexao
		ConnectionFactory factory = new ConnectionFactory();
		try (Connection c = factory.obtemConexao()) {
			// 3: Pre compila o comando
			PreparedStatement ps = c.prepareStatement(sql);
			// 4: Preenche os dados faltantes
			ps.setInt(1, id);
			// 5: Executa o comando
			ps.execute();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void listar() {
		// 1: Definir o comando SQL
		String sql = "SELECT * FROM jogo";
		// 2: Abrir uma conexão
		ConnectionFactory factory = new ConnectionFactory();
		try (Connection c = factory.obtemConexao()) {
			// 3: Pré compila o comando
			PreparedStatement ps = c.prepareStatement(sql);
			// 4: Executa o comando e guarda o resultado em um ResultSet
			ResultSet rs = ps.executeQuery();
			// 5: itera sobre o resultado
			while (rs.next()) {
				int id = rs.getInt("id");
				String nome = rs.getString("nome");
				String tema = rs.getString("tema");
				String aux = String.format("ID: %d, Nome: %s, Apelido: %s", id, nome, tema);
				System.out.println(aux);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public Jogo mostraPorId(int id) {
		String sql = "SELECT * FROM jogo WHERE id = ?;";
		String nome = "";
		String tema = "";

		ConnectionFactory factory = new ConnectionFactory();
		try (Connection c = factory.obtemConexao()) {

			PreparedStatement ps = c.prepareStatement(sql);

			ps.setInt(1, id);

			ResultSet rs = ps.executeQuery();
			rs.next();
			nome = rs.getString("nome");
			tema = rs.getString("tema");
		} catch (Exception e) {
			e.printStackTrace();
		}
		Jogo pessoa = new Jogo(nome, tema);
		pessoa.setId(id);
		return pessoa;
	}
}
