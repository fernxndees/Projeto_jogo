package unicuritiba.db;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

public class Principal {
	public static void main(String[] args) {
		JogadorDao cadastro1 = new JogadorDao();
		String menu = "1 - Cadastrar o jogador \n2 - Atualizar dados de um jogador\n3 - Deletar um jogador\n4 - Mostrar lista de jogadores\n5 - Mostrar determinado jogador\n6 - Cadastrar o jogo\n7 - Atualizar dados de um jogo\n8 - Deletar um jogo"
				+ "\n9 - Mostrar lista de jogos\n10 - Mostrar determinado jogo";
			
		int op;
		do {
			op = Integer.parseInt(JOptionPane.showInputDialog(menu));
			switch (op) {
			case 1: {
				String nome = JOptionPane.showInputDialog("Nome?");
				String apelido = JOptionPane.showInputDialog("Apelido?");
				Jogador p = new Jogador(nome, apelido);
				cadastro1.inserir(p);
				break;
			}
			case 2: {
				String nome = JOptionPane.showInputDialog("Qual seu novo nome?");
				String apelido = JOptionPane.showInputDialog("Qual seu novo apelido?");
				int id = Integer.parseInt(JOptionPane.showInputDialog("ID?"));
				Jogador p = new Jogador(nome, apelido);
				p.setNome(nome);
				p.setApelido(apelido);
				p.setId(id);
				cadastro1.atualizar(p);
				break;
			}
			case 3: {
				int id = Integer.parseInt(JOptionPane.showInputDialog("ID"));
				cadastro1.apagar(id);
				break;
			}
			case 4: {
				List<Jogador> pessoas = new ArrayList<>();
				cadastro1.listar();
				for (int index = 0; index < pessoas.size(); index++) {
					System.out.println(pessoas.get(index).toString());
				}
				break;
			}
			case 5: {
				int id = Integer.parseInt(JOptionPane.showInputDialog("ID?"));
				Jogador p = new Jogador();
				p = cadastro1.mostraPorId(id);
				if (!p.getNome().equals("")) {
					System.out.println(p);
				}
				break;
			}
			case 0:
				break;
			default:
				JOptionPane.showMessageDialog(null, "Opção inválida");
			}

		} while (op != 0);
	}

	JogoDao cadastroJogo1 = new JogoDao();
	String menu = "6 - Cadastrar o jogo" + "\n7 - Atualizar dados de um jogo" + "\n8 - Deletar um jogo"
			+ "\n9 - Mostrar lista de jogos" + "\n10 - Mostrar determinado jogo";
	int op;
	{
		do {
			op = Integer.parseInt(JOptionPane.showInputDialog(menu));
			switch (op) {
			case 6: {
				String nome = JOptionPane.showInputDialog("Nome?");
				String tema = JOptionPane.showInputDialog("Tema?");
				Jogo j = new Jogo(nome, tema);
				cadastroJogo1.inserir(j);
				break;
			}
			case 7: {
				String nome = JOptionPane.showInputDialog("Qual seu novo nome?");
				String tema = JOptionPane.showInputDialog("Qual o novo tema?");
				int id = Integer.parseInt(JOptionPane.showInputDialog("ID?"));
				Jogo j = new Jogo(nome, tema);
				j.setNome(nome);
				j.setTema(tema);
				j.setId(id);
				cadastroJogo1.atualizar(j);
				break;
			}
			case 8: {
				int id = Integer.parseInt(JOptionPane.showInputDialog("ID"));
				cadastroJogo1.apagar(id);
				break;
			}
			case 9: {
				List<Jogo> pessoas = new ArrayList<>();
				cadastroJogo1.listar();
				for (int index = 0; index < pessoas.size(); index++) {
					System.out.println(pessoas.get(index).toString());
				}
				break;
			}
			case 10: {
				int id = Integer.parseInt(JOptionPane.showInputDialog("ID?"));
				Jogo j = new Jogo(menu, menu);
				j = cadastroJogo1.mostraPorId(id);
				if (!j.getNome().equals("")) {
					System.out.println(j);
				}
				break;
			}
			case 0:
				break;
			default:
				JOptionPane.showMessageDialog(null, "Opção inválida");
			}
		} while (op != 0);
	}

	PontuacaoDao cadastroP = new PontuacaoDao();
	String menu1 = "11- Cadastrar pontuação inicial de um jogador\n12- Mostrar a pontuação de um jogador";
	int op1;
	{
		op = Integer.parseInt(JOptionPane.showInputDialog(menu));
		switch (op) {
		case 11:
			String nome = JOptionPane.showInputDialog("Nome?");
			String pontos = JOptionPane.showInputDialog("Qual é a pontuação inicial?");
			Pontuação pontuacao = new Pontuação(nome, pontos);
			cadastroP.inserir(pontuacao);
			break;
		case 12:
			int id = Integer.parseInt(JOptionPane.showInputDialog("ID?"));
			Pontuação pontuacaoBuscada = cadastroP.mostraPorId(id);
			if (!pontuacaoBuscada.getNome().equals("")) {
				System.out.println(pontuacaoBuscada);
			}
			break;
		case 0:
			break;
		default:
			JOptionPane.showMessageDialog(null, "Opção inválida");
			while(op!=0); 
		}
	}}

