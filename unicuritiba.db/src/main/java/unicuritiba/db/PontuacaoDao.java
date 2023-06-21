package unicuritiba.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class PontuacaoDao {

	public void inserir(Pontuação o) {
		// 1: Definir o comando SQL
					String sql = "INSERT INTO projeto_jogo(nome, tema) VALUES (?, ?)";
					// 2: Abrir uma conexao
					ConnectionFactory factory = new ConnectionFactory();
					try (Connection c = factory.obtemConexao()) {
						// 3: Pre compila o comando
						PreparedStatement ps = c.prepareStatement(sql);
						// 4: Preenche os dados faltantes
						ps.setString(1, o.getNome());
						ps.setString(2, o.getPontos());
						// 5: Executa o comando
						ps.execute();
					} catch (Exception e) {
						e.printStackTrace();
					}
				}

	public Pontuação mostraPorId(int id) {
		String sql = "SELECT * FROM pontuação WHERE id = ?;";
		String nome = "";
		String pontos = "";

		ConnectionFactory factory = new ConnectionFactory();
		try (Connection c = factory.obtemConexao()) {

			PreparedStatement ps = c.prepareStatement(sql);

			ps.setInt(1, id);

			ResultSet rs = ps.executeQuery();
			rs.next();
			nome = rs.getString("nome");
			pontos = rs.getString("pontos");
		} catch (Exception e) {
			e.printStackTrace();
		}
		Pontuação pessoa = new Pontuação(nome, pontos);
		pessoa.setId(id);
		return pessoa;
	}
}


