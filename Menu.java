package org.serratec.trabalho.principal;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

import org.serratec.trabalho.modelos.Aluno;
import org.serratec.trabalho.modelos.Avaliacao;
import org.serratec.trabalho.modelos.Cargo;
import org.serratec.trabalho.modelos.Funcionario;
import org.serratec.trabalho.modelos.Modalidade;
import org.serratec.trabalho.modelos.Personal;
import org.serratec.trabalho.modelos.Pessoa;
import org.serratec.trabalho.modelos.Plano;

public class Menu {
	Scanner sc = new Scanner(System.in);
	List<Aluno> aluno = new ArrayList<>();
	List<Personal> personalList = new ArrayList<>();
	List<Funcionario> funcionario = new ArrayList<>();
	List<Avaliacao> avaliacao = new ArrayList<>();
	List<Modalidade> plano = new ArrayList<>();
	public String senhaValida = null;
	public String tipoUsuario = null;
	public String nomeUsuario = null;
	public String cpf = "1";
	//  AcessoAluno acessoAluno = new AcessoAluno();
	//	AcessoFuncionario acessoFuncionario = new AcessoFuncionario();
	//	AcessoPersonal acessoPersonal = new AcessoPersona();

	public void iniciar() {
		String senha;
		carregarDados1(); // Carregar dados inciais
		System.out.println("==============================================");
		System.out.println("=    Bem vindo a Academia Serratec!          =");
		System.out.println("==============================================");
		System.err.println("         Digite 0 para sair!");
		System.out.println("");
		do {
			System.out.println("Informe seu CPF: ");
			cpf = sc.next();
			verificarUsuario(cpf);
			if(tipoUsuario.equals("ND")) {
				System.out.println("Usuário não cadastrado!");
			} else {
				System.out.println(nomeUsuario + ", Informe sua senha: ");
				senha = sc.next();
				if(senhaValida.equals(senha)) {
					switch (tipoUsuario) {
					case "Aluno" -> acessoAluno();
					case "Personal" -> acessoPersonal();
					case "Funcionario" -> acessoFuncionario();
					}
				} else {
					System.out.println("Senha inválida. Tente novamente!\n");
					iniciar(); 
				}
			}			System.out.println("Informe seu CPF: ");
			cpf = sc.next();
			if (cpf.equals("0")) {
				System.out.println("Aplicação Encerrada.");
				return;
				
			}
		} while (cpf != ("0"));

	}
	public void carregarDados1() {

		
		Aluno aluno1 = new Aluno("Marlos Bianna", "123.456.789-01", "1234", LocalDate.parse("2025-03-25"), Plano.MENSAL_1_MODALIDADE, new Modalidade("Mensal apenas musculação", 50));
        Aluno aluno2 = new Aluno("João Pedro", "123.456.789-02", "1234", LocalDate.parse("2025-02-13"), Plano.MENSAL_1_MODALIDADE, new Modalidade("Mensal apenas musculação", 50));
        Aluno aluno3 = new Aluno("Dandara Lima", "123.456.789-03", "1234", LocalDate.parse("2025-01-10"), Plano.MENSAL_1_MODALIDADE, new Modalidade("Mensal apenas musculação", 50));
		
		aluno.add(aluno1);
		aluno.add(aluno2);
		aluno.add(aluno3);

		Personal personal1 = new Personal("Mateus", "123.456.789-10", "1234", "Pilates", "1245-4");
		Personal personal2 = new Personal("Karen Santos", "123.456.789-20", "1234", "Funcional", "1255-4");
		personalList.add(personal1);
		personalList.add(personal2);

		Funcionario funcionario1 = new Funcionario("Jacqueline", "123.456.789-99", "1234", new Cargo("Gerente", 10000));
		funcionario.add(funcionario1);


		Modalidade modalidade1 = new Modalidade("Musculação", 50);
		Modalidade modalidade2 = new Modalidade("Musculação + Coletivas", 100);
		Modalidade modalidade3 = new Modalidade("Musculação + Coletivas + Funcional", 150);
		plano.add(modalidade1);
		plano.add(modalidade2);
		plano.add(modalidade3);
	}

	private void carregarDados() {
		for (int i = 1; i <= 10; i++) {
			Funcionario funcionario1 = new Funcionario("Funcionario"+ i, "123", "123", new Cargo("Gerente", 5000));
			funcionario.add(funcionario1);
			Personal personal1 = new Personal("Personal" + i, "1-" + i, "123", "musculação", "123456789");
			personalList.add(personal1);
			Aluno aluno1 = new Aluno(
					"Aluno " + i,
					"123.456.789-" + i,
					"senha" + i,
					LocalDate.of(2025, 4, 23),
					Plano.MENSAL_TOTAL,
					new Modalidade("Musculação", 50)
					);

			aluno.add(aluno1);
		}


	}
	public void acessoAluno() {
		System.out.println("Acesso aluno liberado!");
		int opcao;
		do {
			String menu = """
					\n=== Menu do Aluno ===
					1. Visualizar dados pessoais e plano contratado
					2. Contratar personal trainer
					3. Visualizar avaliações físicas
					4. Voltar para o menu principal
					Escolha uma opção, por favor:
					""";
			System.out.println(menu);
			opcao = sc.nextInt();
			sc.nextLine();
			switch(opcao) {
			case 1 -> visualizarDados();
			case 2 -> contratarPersonal();
			case 3 -> visualizarAvaliacao(); 
			case 4 -> iniciar();
			default -> System.out.println("Opção inválida, digite novamente");
			}
		}while(opcao != 4);
	}
	private void visualizarAvaliacao() {
		System.out.println("Avaliações do aluno com CPF " + cpf + ":");
		for (Avaliacao avaliacao : avaliacao) {
			if (avaliacao.aluno.getCpf().equals(cpf)) {
				System.out.println(avaliacao);
			}
		}
		avaliacao.add(0, null);
	}
	public void contratarPersonal() {
		if (personalList.isEmpty()) {
			System.out.println("Nenhum personal trainer disponível para contratação.");
			return;
		}
		System.out.println("=== Personal Trainers Disponíveis ===");
		for (int i = 0; i < personalList.size(); i++) {
			Personal personal = personalList.get(i);
			System.out.println((i + 1) + ". " + personal.getNome() + " - Especialidade: " + personal.getEspecialidade());
		}
		System.out.print("Escolha o número do personal trainer que deseja contratar: ");
		int escolha = sc.nextInt();
		sc.nextLine(); 

		if (escolha < 1 || escolha > personalList.size()) {
			System.out.println("Opção inválida! Nenhum personal trainer foi contratado.");
			return;
		}
		int posicao = -1;
		for (int i = 0; i < aluno.size(); i++) {
			Pessoa pessoa = aluno.get(i);
			if (pessoa.getCpf().equals(cpf)) {
				posicao = i;
				break;
			}
		}
		Personal personalContratado = personalList.get(escolha - 1);
		aluno.get(posicao).adicionarPersonal((Personal) personalList.get(escolha - 1), (Aluno)aluno.get(posicao));
		System.out.println("Personal trainer " + personalContratado.getNome() + " contratado com sucesso!");
	}

	private void visualizarDados() {
		for(Pessoa aluno : aluno) {
			if(aluno.getCpf().equals(cpf)) {
				System.out.println(aluno);
			}
		}
	}
	public void acessoPersonal() {
		int opcao;
		do {
			String menu = """
					\n=== Menu do Personal ===
					1. Visualizar alunos
					2. Registrar avaliações físicas dos alunos
					3. Visualizar lista de avaliações realizadas
					4. Voltar para o menu principal
					Escolha uma opção, por favor:
					""";
			System.out.println(menu);
			opcao = sc.nextInt();
			sc.nextLine();

			switch(opcao) {
			case 1 -> visualizarAlunos();
			case 2 -> registrarAvaliacao();
			case 3 -> visualizarListaAv();
			case 4 -> iniciar();
			default -> System.out.println("Opção inválida, digite novamente");
			}
		}while(opcao != 4);
	}
	private void visualizarListaAv() {
		System.out.println(avaliacao);
	}
	private void registrarAvaliacao() {
		List<Aluno> alunos = visualizarAlunos();
		System.out.println("Escolha o aluno que quer avaliar: ");
		int escolhaAval = sc.nextInt();
		sc.nextLine();
		if (escolhaAval < 1 || escolhaAval > alunos.size()) {
			System.out.println("Opção inválida!");
			return;
		}
		int posicao = -1;
		for (int i = 0; i < personalList.size(); i++) {
			Pessoa personal = personalList.get(i);
			if (personal.getCpf().equals(cpf)) {
				posicao = i;
				break;
			}
		}

		System.out.println("Descrição da avaliação: ");
		String descricao = sc.nextLine();
		Avaliacao avaliacao1 = new Avaliacao(alunos.get(escolhaAval - 1), LocalDate.now(), personalList.get(posicao), descricao);
		avaliacao.add(avaliacao1);
	}
	private List<Aluno> visualizarAlunos() {
		List<Aluno> alunos = new ArrayList<Aluno>();
		System.out.println("Aluno(s): ");
		int i = 0;
		for (Aluno aluno : aluno) {
			if (aluno.getPersonalContratado() != null && aluno.getPersonalContratado().getCpf().equals(cpf)) {
				System.out.println((i + 1) + ". " + aluno.getNome());
				i++;
				alunos.add(aluno);
			}
		}
		return alunos;
	}
	public void acessoFuncionario() {
		int opcao;
		do {
			String menu = """
					\n=== Menu do Funcionario ===
					1. Cadastrar novo plano
					2. Cadastrar novo aluno
					3. Cadastrar novo personal trainer
					4. Emitir relatórios
					5. Valor total a receber no mês
					6. Voltar para o menu principal
					Escolha uma opção, por favor:
					""";
			System.out.println(menu);
			opcao = sc.nextInt();
			sc.nextLine();
			switch(opcao) {
			case 1 -> cadastrarPlano();
			case 2 -> cadastrarAluno();
			case 3 -> cadastrarPersonal();
			case 4 -> relatorios();
			case 5 -> valorTotal(); 
			case 6 -> iniciar();
			default -> System.out.println("Opção inválida, digite novamente");
			}
		}while(opcao != 6);
	}
	private void valorTotal() {
		double valorTotal = 0.0;
		for (Aluno aluno : aluno) {
			if (aluno.getModalidade() != null) {
				valorTotal += aluno.getModalidade().getValor();
			}
		}
		System.out.println("O valor total que a academia irá receber é: R$ " + valorTotal);
	}

	private void cadastrarPersonal() {
		System.out.println("Deseja cadastrar um novo personal? [S/N]");
		String escolhaP = sc.next();
		if(escolhaP.equalsIgnoreCase("S")) {
			System.out.println("Digite o CPF do personal: ");
			String cpf = sc.nextLine();
			tipoUsuario = null;
			verificarUsuario(cpf);
			if(tipoUsuario.equals("ND")) {
				System.out.println("Digite o nome do novo personal: ");
				String nome = sc.nextLine();
				sc.nextLine();
				System.out.println("Digite a senha do personal: ");
				String senha = sc.nextLine();
				System.out.println("Digite o Especialidade do personal: ");
				String especialidade = sc.nextLine();
				System.out.println("Digite o CREF do personal: ");
				String cref = sc.nextLine();
				personalList.add(new Personal(nome, cpf, senha, especialidade, cref));
				System.out.println("Personal novo cadastrado!");
			} else {
				System.out.println("CPF já está no cadastro!");
			}
		}
		return; 
	}

	private void cadastrarAluno() {
		Scanner sc1 = new Scanner(System.in);
		System.out.println("Deseja cadastrar um novo aluno? [S/N]");
		String escolhaA = sc.next();

		if(escolhaA.equalsIgnoreCase("S")) {
			System.out.println("Digite o CPF do aluno: ");
			String cpf = sc1.nextLine();
			tipoUsuario = null;
			verificarUsuario(cpf);
			if(tipoUsuario.equals("ND")) {
				//sc1.next();
				System.out.println("Digite o nome do novo aluno: ");
				String nome = sc1.nextLine();
				//sc1.next();
				System.out.println("Digite a senha do aluno: ");
				String senha = sc1.nextLine();
				//sc1.next();
				for(Plano opcao : Plano.values()) {
					System.out.println(opcao);
				}
				System.out.println("Escolha um plano: ");
				String plano = sc1.nextLine().toUpperCase();
				Plano entrada = null;
				try {
					entrada = Plano.valueOf(plano); 
					System.out.println("Você escolheu o plano: " + entrada);
				} catch (IllegalArgumentException e) {
					System.out.println("Plano inválido! Tente novamente."); 
				}
				System.out.println("Descrição da modalidade: ");
				String descricao;
				double valor;
	
				if (entrada == Plano.MENSAL_TOTAL) {
					descricao = "Musculação";
					valor = 50;
					aluno.add(new Aluno(nome, cpf, senha, LocalDate.now(), entrada, new Modalidade(descricao,valor)));
				} if (entrada == Plano.MENSAL_1_MODALIDADE) {
					descricao = "Musculação + Coletivas";
					valor = 100;
					aluno.add(new Aluno(nome, cpf, senha, LocalDate.now(), entrada, new Modalidade(descricao,valor)));
				} if (entrada == Plano.MENSAL_2_MODALIDADE) {
					descricao = "Musculação + Coletivas + Funcional";
					valor = 150;	
					aluno.add(new Aluno(nome, cpf, senha, LocalDate.now(), entrada, new Modalidade(descricao,valor)));
				}
	
				//					String descricao = sc1.nextLine();
				//					System.out.println("Valor da modalidade: ");
				//					Double valor = sc1.nextDouble();
				//					aluno.add(new Aluno(nome, cpf, senha, LocalDate.now(), entrada, new Modalidade(descricao, valor)));
				System.out.println("Aluno novo cadastrado!");
			} else {
				System.out.println("CPF já está no cadastro!");
			}
		}
		return;
	}
		private void cadastrarPlano() {
			int i = 1;
			System.out.println("Planos: ");
			for(Plano opcao : Plano.values()) {
				System.out.println(i + ". " + opcao);
				i++;
			}
			int cont = 1;
			for (Modalidade plano : plano) {
				System.out.println(cont + ". " + plano);
				cont++;
			}
			String alternativa;
			System.out.println("Deseja cadastrar um novo plano? [S/N]");
			alternativa = sc.nextLine();
			if(alternativa.equals("S") || alternativa.equals("s")) {
				System.out.print("Digite a descrição do novo plano: ");
				String descricao = sc.nextLine();
				
				System.out.print("Digite o valor do novo plano: ");
				double valor = sc.nextDouble();
				 
				System.out.println("Novo plano adicionado com sucesso!");
				plano.add(new Modalidade(descricao, valor));
			}
			return;
		}
		public void relatorios() {
			int opcao;
			do {
				String menu = """
						\n=== Menu dos Relatórios ===
						1. Planos 
						2. Pessoas (Alunos, Funcionários e Personal Trainers)
						3. Avaliações físicas por período
						4. Todos os relatórios em arquivo
						5. Voltar para o menu Funcionários
						Escolha uma opção, por favor:
						""";
				System.out.println(menu);
				opcao = sc.nextInt();
				sc.nextLine();
				switch(opcao) {
				case 1 -> gerarRelatorioPlanos(); 
				case 2 -> gerarRelatorioPessoas();
				case 3 -> gerarRelatorioAvaliacoes(); 
				case 4 -> gerarTodosRelatorios(); 
				case 5 -> acessoFuncionario();
				default -> System.out.println("Opção inválida, digite novamente");
				}
			}while(opcao != 5);
		}

		private void gerarTodosRelatorios() {
			Path path = Paths.get("relatorioGeral.txt");

			try (BufferedWriter writer = Files.newBufferedWriter(path)) {
				// Alunos
				writer.write("--- Alunos: ");
				writer.newLine();
				Set<Aluno> alunosSet = new HashSet<>(aluno); // Remove duplicatas
				for (Aluno al : alunosSet) {
					writer.write(al.toString());
					writer.newLine();
				}

				writer.newLine();
				// Personal
				writer.write("--- Personal: ");
				writer.newLine();
				Set<Personal> personalSet = new HashSet<>(personalList); // Remove duplicatas
				for (Personal pe : personalSet) {
					writer.write(pe.toString());
					writer.newLine();
				}
				writer.newLine();
				// Funcionarios
				writer.write("--- Funcionarios: ");
				writer.newLine();
				Set<Funcionario> funcionariosSet = new HashSet<>(funcionario); // Remove duplicatas
				for (Funcionario fu : funcionariosSet) {
					writer.write(fu.toString());
					writer.newLine();
				}

				// Planos
				writer.write("--- Planos: ");
				writer.newLine();
				Set<Modalidade> planosSet = new HashSet<>(plano); // Remove duplicatas
				for (Modalidade pl : planosSet) {
					writer.write(pl.toString());
					writer.newLine();
				}

				// Avaliações
				writer.write("--- Avaliações: ");
				writer.newLine();
				Set<Avaliacao> avaliacoesSet = new HashSet<>(avaliacao); // Remove duplicatas
				for (Avaliacao av : avaliacoesSet) {
					writer.write(av.toString());
					writer.newLine();
				}

				System.out.println("Arquivo gerado com sucesso!");

			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		private void gerarRelatorioAvaliacoes() {
			System.out.println(avaliacao);
		}
		public void gerarRelatorioPessoas() {
			System.out.println("*** Relatório Pessoas ***");
			System.out.println(" ");
			System.out.println("Funcionário(s)");
			System.out.println("============================================");
			System.out.println(funcionario);
			System.out.println(" ");
			System.out.println("Personal(is)");
			System.out.println("============================================\n");
			System.out.println(personalList);
			System.out.println(" ");
			System.out.println("Aluno(s)");
			System.out.println("============================================\n");
			System.out.println(aluno);
			System.out.println(" ");
		}
		private void gerarRelatorioPlanos() {
			System.out.println(plano);
		}
		public void verificarUsuario(String cpf) {
			if (cpf.equals("0")) {
				System.out.println("Aplicação Encerrada.");
				System.exit(0);
			}

			tipoUsuario = "ND";
			if (aluno.isEmpty() && personalList.isEmpty() && funcionario.isEmpty()) {
				return;
			}

			for (Pessoa pessoa : aluno) {
				if(pessoa.getCpf().equals(cpf)) {
					tipoUsuario = "Aluno";
					if (tipoUsuario.equals("Aluno")) {
						senhaValida = pessoa.getSenha();
						nomeUsuario = pessoa.getNome();
					}
				}
			}
			for (Pessoa pessoa : personalList) {
				if(pessoa.getCpf().equals(cpf)) {
					tipoUsuario = "Personal";
					if (tipoUsuario.equals("Personal")) {
						senhaValida = pessoa.getSenha();
						nomeUsuario = pessoa.getNome();
					}		
				}
			}
			for (Pessoa pessoa : funcionario) {
				if(pessoa.getCpf().equals(cpf)) {
					tipoUsuario = "Funcionario";
					if (tipoUsuario.equals("Funcionario")) {
						senhaValida = pessoa.getSenha();
						nomeUsuario = pessoa.getNome();
					}
				}
			}
		}
	}
