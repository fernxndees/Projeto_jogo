package unicuritiba.db;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionFactory {
	private String usuario = "root";
	private String senha = "210205";
	private String host = "localhost";
	private String porta = "3306";
	private String bd = "projeto_jogo";

	public Connection obtemConexao() {
		try {
			Connection c = DriverManager.getConnection(
					"jdbc:mysql://" + host + ":" + porta + "/" + bd
							+ "?autoReconnect=true&serverTimezone=UTC&useSSL=False&allowPublicKeyRetrieval=true",
					usuario, senha);
			return c;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
}