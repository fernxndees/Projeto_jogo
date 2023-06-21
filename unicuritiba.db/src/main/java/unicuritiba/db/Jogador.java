package unicuritiba.db;

public class Jogador {
		
		private int id;
		private String nome;
		private String apelido;

		public Jogador(String nome, String apelido) {
			this.nome = nome;
			this.apelido = apelido;
		}

		public Jogador() {

		}


		public String getNome() {
			return nome;
		}
		public void setNome(String nome) {
			this.nome = nome;
		}
		public String getApelido() {
			return apelido;
		}
		public void setApelido(String apelido) {
			this.apelido = apelido;
		}

		public int getId() {
			return id;
		}

		public void setId(int id) {
			this.id = id;
		}
	}
	
		

