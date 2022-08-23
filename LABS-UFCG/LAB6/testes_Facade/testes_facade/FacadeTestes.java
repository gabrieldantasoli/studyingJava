package testes_facade;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.NoSuchElementException;

import sapo.Facade;

class FacadeTestes {
	private Facade facade;
	
	@BeforeEach
	void iniciaFacade() {
		this.facade = new Facade();
	}
	 
	//Testes das classes relacionadas a pessoas começam aqui
	
	//Inicio dos testes sobre cadastro de Pessoas
	@Test
	void cadastroPessoa1() {
		String[] habilidades = {"Java Basico", "Web"};
		this.facade.cadastrarPessoa("127.731.394-61", "Gabriel dantas", habilidades);
	}
	
	@Test
	void cadastroPessoa2() {
		String[] habilidades = {"Java Basico", "Web"};
		try {
			this.facade.cadastrarPessoa("111.111.111-11", "", habilidades);
			fail();
		}catch (IllegalArgumentException e) {
			assertEquals("O/A NOME da pessoa não pode ser vazio!", e.getMessage());
		}
	}
	
	@Test
	void cadastroPessoa3() {
		String[] habilidades = {"Java Basico", "Web"};
		try {
			this.facade.cadastrarPessoa("", "Gabriel Dantas", habilidades);
			fail();
		}catch (IllegalArgumentException e) {
			assertEquals("O/A CPF da pessoa não pode ser vazio!", e.getMessage());
		}
	}
	
	@Test
	void cadastroPessoa4() {
		String[] habilidades = {};
		this.facade.cadastrarPessoa("111.111.111-11", "Gabriel Dantas", habilidades);
	}
	
	//Inicio dos testes sobre exibição de Pessoas
	@Test
	void ExibirPessoa1() {
		String[] habilidades = {"Java Basico", "Web"};
		this.facade.cadastrarPessoa("111.111.111-11", "Gabriel Dantas", habilidades);
		assertEquals("Gabriel Dantas - 111.111.111-11\n- Java Basico\n- Web\n", this.facade.exibirPessoa("111.111.111-11"));
	}
	
	@Test
	void ExibirPessoa2() {
		String[] habilidades = {"Java Basico", "Web"};
		this.facade.cadastrarPessoa("111.111.111-11", "Gabriel Dantas", habilidades);
		try {
			this.facade.exibirPessoa("222.222.222-22");
			fail();
		}catch (NoSuchElementException e) {
			assertEquals("Pessoa não encontrada no banco de dados!", e.getMessage());
		}
	}
	
	//Inicio dos testes sobre alterar Nome de Pessoas
	@Test
	void AlterarNomePessoa1() {
		String[] habilidades = {};
		this.facade.cadastrarPessoa("111.111.111-11", "Gabriel Dantas", habilidades);
		this.facade.alterarNomePessoa("111.111.111-11", "Matheus Gaudencio");
		assertEquals("Matheus Gaudencio - 111.111.111-11\n",this.facade.exibirPessoa("111.111.111-11"));
	}
	
	@Test
	void AlterarNomePessoa2() {
		String[] habilidades = {};
		this.facade.cadastrarPessoa("111.111.111-11", "Gabriel Dantas", habilidades);
		try {
			this.facade.alterarNomePessoa("111.111.111-11", "");
			fail();
		}catch (IllegalArgumentException e) {
			assertEquals("O/A NOVO NOME da pessoa não pode ser vazio!", e.getMessage());
		}
	}
	
	@Test
	void AlterarNomePessoa3() {
		String[] habilidades = {};
		this.facade.cadastrarPessoa("111.111.111-11", "Gabriel Dantas", habilidades);
		try {
			this.facade.alterarNomePessoa("", "Matheus Gaudencio");
			fail();
		}catch (NoSuchElementException e) {
			assertEquals("Pessoa não encontrada no banco de dados!", e.getMessage());
		}
	}
	
	//Inicio dos testes sobre alterar Habilidades de Pessoas
	@Test
	void AlterarHabilidadesPessoa1() {
		String[] habilidades1 = {"Java Basico", "Web"};
		String[] habilidades2 = {"React", "Javascript"};
		this.facade.cadastrarPessoa("111.111.111-11", "Gabriel Dantas", habilidades1);
		this.facade.alterarHabilidadesPessoa("111.111.111-11", habilidades2);
	}
	
	@Test
	void AlterarHabilidadesPessoa2() {
		String[] habilidades1 = {"Java Basico", "Web"};
		String[] habilidades2 = {};
		this.facade.cadastrarPessoa("111.111.111-11", "Gabriel Dantas", habilidades1);
		this.facade.alterarHabilidadesPessoa("111.111.111-11", habilidades2);
	}
	
	//Inicio dos testes sobre remover Pessoas
	@Test
	void RemoverPessoa1() {
		String[] habilidades1 = {"Java Basico", "Web"};
		String[] habilidades2 = {};
		this.facade.cadastrarPessoa("111.111.111-11", "Gabriel Dantas", habilidades1);
		this.facade.cadastrarPessoa("111.111.111-11", "Matheus Gaudencio", habilidades2);
		this.facade.removerPessoa("111.111.111-11");
	}
	
	@Test
	void RemoverPessoa2() {
		String[] habilidades1 = {"Java Basico", "Web"};
		String[] habilidades2 = {};
		this.facade.cadastrarPessoa("111.111.111-11", "Gabriel Dantas", habilidades1);
		this.facade.cadastrarPessoa("111.111.111-11", "Matheus Gaudencio", habilidades2);
		try {
			this.facade.removerPessoa("333.333.333-33");
			fail();
		} catch (NoSuchElementException e) {
			assertEquals("Pessoa não encontrada no banco de dados!", e.getMessage());
		}
	} 
	
	@Test
	void RemoverPessoa3() {
		String[] habilidades1 = {"Java Basico", "Web"};
		this.facade.cadastrarPessoa("111.111.111-11", "Gabriel Dantas", habilidades1);
		this.facade.removerPessoa("111.111.111-11");
		try {
			this.facade.exibirPessoa("111.111.111-11");
			fail();
		}catch (NoSuchElementException e) {
			assertEquals("Pessoa não encontrada no banco de dados!", e.getMessage());
		}
	}
	
	//Inicio dos testes sobre adicionar comentários à pessoas
	@Test
	void adicionarComentarioPessoa1() {
		String[] habilidades1 = {"Java Basico", "Web"};
		String[] habilidades2 = {};
		this.facade.cadastrarPessoa("111.111.111-11", "Gabriel Dantas", habilidades1);
		this.facade.cadastrarPessoa("111.111.111-11", "Matheus Gaudencio", habilidades2);
		try {
			this.facade.adicionarComentarioPessoa("111.111.111-11", "Estude JAVA", "222.222.222-22");
			fail();
		}catch (NoSuchElementException e) {
			assertEquals("CPF do autor não encontrada no banco de dados!", e.getMessage());
		}
	}
	
	@Test
	void adicionarComentarioPessoa2() {
		String[] habilidades1 = {"Java Basico", "Web"};
		String[] habilidades2 = {};
		this.facade.cadastrarPessoa("111.111.111-11", "Gabriel Dantas", habilidades1);
		this.facade.cadastrarPessoa("222.222.222-22", "Matheus Gaudencio", habilidades2);
		this.facade.adicionarComentarioPessoa("111.111.111-11", "Estude JAVA", "222.222.222-22");
	}
	
	@Test
	void adicionarComentarioPessoa3() {
		String[] habilidades1 = {"Java Basico", "Web"};
		String[] habilidades2 = {};
		this.facade.cadastrarPessoa("111.111.111-11", "Gabriel Dantas", habilidades1);
		this.facade.cadastrarPessoa("222.222.222-22", "Matheus Gaudencio", habilidades2);
		try {
			this.facade.adicionarComentarioPessoa("", "Estude JAVA", "222.222.222-22");
			fail();
		}catch (NoSuchElementException e) {
			assertEquals("Pessoa não encontrada no banco de dados!", e.getMessage());
		}
	}
	
	@Test
	void adicionarComentarioPessoa4() {
		String[] habilidades1 = {"Java Basico", "Web"};
		String[] habilidades2 = {};
		this.facade.cadastrarPessoa("111.111.111-11", "Gabriel Dantas", habilidades1);
		this.facade.cadastrarPessoa("222.222.222-22", "Matheus Gaudencio", habilidades2);
		try {
			this.facade.adicionarComentarioPessoa("111.111.111-11", "", "222.222.222-22");
			fail();
		}catch (IllegalArgumentException e) {
			assertEquals("O/A COMENTARIO da pessoa não pode ser vazio!", e.getMessage());
		}
	}
	
	//Inicio dos testes sobre listar comentários de pessoas
	@Test
	void ListarComentariosPessoa1() {
		String[] habilidades1 = {"Java Basico", "Web"};
		String[] habilidades2 = {};
		this.facade.cadastrarPessoa("111.111.111-11", "Gabriel Dantas", habilidades1);
		this.facade.cadastrarPessoa("222.222.222-22", "Matheus", habilidades2);
		this.facade.cadastrarPessoa("333.333.333-33", "Pedro", habilidades2);
		this.facade.adicionarComentarioPessoa("111.111.111-11", "a", "222.222.222-22");
		this.facade.adicionarComentarioPessoa("111.111.111-11", "b", "333.333.333-33");
		assertEquals("Gabriel Dantas - 111.111.111-11\nComentários:\n-- b (Pedro)\n-- a (Matheus)\n", this.facade.listarComentariosPessoa("111.111.111-11"));
	}
	
	@Test
	void ListarComentariosPessoa2() {
		String[] habilidades1 = {"Java Basico", "Web"};
		String[] habilidades2 = {};
		this.facade.cadastrarPessoa("111.111.111-11", "Gabriel Dantas", habilidades1);
		this.facade.cadastrarPessoa("222.222.222-22", "Matheus", habilidades2);
		this.facade.cadastrarPessoa("333.333.333-33", "Pedro", habilidades2);
		assertEquals("Gabriel Dantas - 111.111.111-11\nComentários:\n", this.facade.listarComentariosPessoa("111.111.111-11"));
	}
	
	@Test
	void ListarComentariosPessoa3() {
		String[] habilidades1 = {"Java Basico", "Web"};
		String[] habilidades2 = {};
		this.facade.cadastrarPessoa("111.111.111-11", "Gabriel Dantas", habilidades1);
		this.facade.cadastrarPessoa("222.222.222-22", "Matheus", habilidades2);
		this.facade.adicionarComentarioPessoa("111.111.111-11", "a", "222.222.222-22");
		this.facade.removerPessoa("222.222.222-22");
	}
	
	//Testes das classes relacionadas a pessoas terminam aqui
	
	//Testes das classes relacionadas a atividades começam aqui
	
	//Testes reslacionados a cadastrar pessoas começam aqui
	@Test
	void cadastrarAtividade1() {
		try {
			this.facade.cadastrarAtividade("Estudar OO", "Estudar tudo relacionado a OO", "111.111.111-11");
			fail();
		}catch (NoSuchElementException e) {
			assertEquals("Pessoa não encontrada no banco de dados!", e.getMessage());
		}
	}
	
	@Test
	void cadastrarAtividade2() {
		String[] habilidades1 = {"Java Basico", "Web"};
		this.facade.cadastrarPessoa("111.111.111-11", "Gabriel Dantas", habilidades1);
		this.facade.cadastrarAtividade("Estudar OO", "Estudar tudo relacionado a OO", "111.111.111-11");
	}
	
	@Test
	void cadastrarAtividade3() {
		String[] habilidades1 = {"Java Basico", "Web"};
		this.facade.cadastrarPessoa("111.111.111-11", "Gabriel Dantas", habilidades1);
		try {
			this.facade.cadastrarAtividade("", "Estudar tudo relacionado a OO", "111.111.111-11");
			fail();
		}catch (IllegalArgumentException e) {
			assertEquals("O/A NOME da atividade não pode ser vazio!", e.getMessage());
		}
	}
	
	@Test
	void cadastrarAtividade4() {
		String[] habilidades1 = {"Java Basico", "Web"};
		this.facade.cadastrarPessoa("111.111.111-11", "Gabriel Dantas", habilidades1);
		try {
			this.facade.cadastrarAtividade("Estudar OO", "", "111.111.111-11");
			fail();
		}catch (IllegalArgumentException e) {
			assertEquals("O/A DESCRIÇÃO da atividade não pode ser vazio!", e.getMessage());
		}
	}
	
	@Test
	void cadastrarAtividade5() {
		String[] habilidades1 = {"Java Basico", "Web"};
		this.facade.cadastrarPessoa("111.111.111-11", "Gabriel Dantas", habilidades1);
		try {
			this.facade.cadastrarAtividade("Estudar OO", "Estudar tudo relacionado a OO", "");
			fail();
		}catch (NoSuchElementException e) {
			assertEquals("Pessoa não encontrada no banco de dados!", e.getMessage());
		}
	}
	
	@Test
	void cadastrarAtividade6() {
		String[] habilidades1 = {"Java Basico", "Web"};
		this.facade.cadastrarPessoa("111.111.111-11", "Gabriel Dantas", habilidades1);
		assertEquals("STD-0", this.facade.cadastrarAtividade("Estudar OO", "Estudar tudo relacionado a OO", "111.111.111-11"));
	}
	
	@Test
	void cadastrarAtividade7() {
		String[] habilidades1 = {"Java Basico", "Web"};
		this.facade.cadastrarPessoa("111.111.111-11", "Gabriel Dantas", habilidades1);
		this.facade.cadastrarAtividade("Estudar OO", "Estudar tudo relacionado a OO", "111.111.111-11");
		assertEquals("LRX-1", this.facade.cadastrarAtividade("Ler 1984", "Ler o livro 1984", "111.111.111-11"));
	}
	
	@Test
	void cadastrarAtividade8() {
		String[] habilidades1 = {"Java Basico", "Web"};
		this.facade.cadastrarPessoa("111.111.111-11", "Gabriel Dantas", habilidades1);
		assertEquals("XXX-0", this.facade.cadastrarAtividade("aieou aeiou", "alfabeto", "111.111.111-11"));
	}
	
	// Testes sobre encerrar , desativar e reabrir atividades começam aqui
	
	@Test 
	void EncerrarAtividade1() {
		String[] habilidades1 = {"Java Basico", "Web"};
		this.facade.cadastrarPessoa("111.111.111-11", "Gabriel Dantas", habilidades1);
		this.facade.cadastrarAtividade("Estudar OO", "Estudar tudo relacionado a OO", "111.111.111-11");
		this.facade.encerrarAtividade("STD-0"); 
	}
	
	@Test
	void EncerrarAtividade2() {
		String[] habilidades1 = {"Java Basico", "Web"};
		this.facade.cadastrarPessoa("111.111.111-11", "Gabriel Dantas", habilidades1);
		this.facade.cadastrarAtividade("Estudar OO", "Estudar tudo relacionado a OO", "111.111.111-11");
		try {
			this.facade.encerrarAtividade("STX-0"); 
			fail();
		}catch (NoSuchElementException e) {
			assertEquals("Atividade não encontrada no banco de dados!", e.getMessage());
		}
	}
	
	@Test 
	void EncerrarAtividade3() {
		String[] habilidades1 = {"Java Basico", "Web"};
		this.facade.cadastrarPessoa("111.111.111-11", "Gabriel Dantas", habilidades1);
		this.facade.cadastrarAtividade("Estudar OO", "Estudar tudo relacionado a OO", "111.111.111-11");
		this.facade.cadastrarTarefa("STD-0", "Estudar herança", habilidades1);
		try {
			this.facade.encerrarAtividade("STD-0");
			fail();
		}catch (IllegalStateException e) {
			assertEquals("A atividade tem tarefas Pendentes!", e.getMessage());
		}
	}
	
	@Test 
	void EncerrarAtividade4() {
		String[] habilidades1 = {"Java Basico", "Web"};
		this.facade.cadastrarPessoa("111.111.111-11", "Gabriel Dantas", habilidades1);
		this.facade.cadastrarAtividade("Estudar OO", "Estudar tudo relacionado a OO", "111.111.111-11");
		this.facade.encerrarAtividade("STD-0");
		try {
			this.facade.encerrarAtividade("STD-0");
			fail();
		}catch (IllegalStateException e) {
			assertEquals("A tarefa não está aberta !", e.getMessage());
		}
	}
	
	@Test 
	void desativarAtividade1() {
		String[] habilidades1 = {"Java Basico", "Web"};
		this.facade.cadastrarPessoa("111.111.111-11", "Gabriel Dantas", habilidades1);
		this.facade.cadastrarAtividade("Estudar OO", "Estudar tudo relacionado a OO", "111.111.111-11");
		this.facade.desativarAtividade("STD-0");
	}
	
	@Test
	void desativarAtividade2() {
		String[] habilidades1 = {"Java Basico", "Web"};
		this.facade.cadastrarPessoa("111.111.111-11", "Gabriel Dantas", habilidades1);
		this.facade.cadastrarAtividade("Estudar OO", "Estudar tudo relacionado a OO", "111.111.111-11");
		try {
			this.facade.desativarAtividade("EEE-0"); 
			fail();
		}catch (NoSuchElementException e) {
			assertEquals("Atividade não encontrada no banco de dados!", e.getMessage());
		}
	}
	
	@Test 
	void DesativarAtividade3() {
		String[] habilidades1 = {"Java Basico", "Web"};
		this.facade.cadastrarPessoa("111.111.111-11", "Gabriel Dantas", habilidades1);
		this.facade.cadastrarAtividade("Estudar OO", "Estudar tudo relacionado a OO", "111.111.111-11");
		this.facade.cadastrarTarefa("STD-0", "Estudar herança", habilidades1);
		try {
			this.facade.desativarAtividade("STD-0");
			fail();
		}catch (IllegalStateException e) {
			assertEquals("A atividade tem tarefas Pendentes!", e.getMessage());
		}
	}
	
	@Test 
	void DesativarAtividade4() {
		String[] habilidades1 = {"Java Basico", "Web"};
		this.facade.cadastrarPessoa("111.111.111-11", "Gabriel Dantas", habilidades1);
		this.facade.cadastrarAtividade("Estudar OO", "Estudar tudo relacionado a OO", "111.111.111-11");
		this.facade.encerrarAtividade("STD-0");
		try {
			this.facade.desativarAtividade("STD-0");
			fail();
		}catch (IllegalStateException e) {
			assertEquals("A tarefa não está aberta !", e.getMessage());
		}
	}
	
	@Test
	void ReabrirAtividade1() {
		String[] habilidades1 = {"Java Basico", "Web"};
		this.facade.cadastrarPessoa("111.111.111-11", "Gabriel Dantas", habilidades1);
		this.facade.cadastrarAtividade("Estudar OO", "Estudar tudo relacionado a OO", "111.111.111-11");
		this.facade.cadastrarTarefa("STD-0", "Estudar herança", habilidades1);
		try {
			this.facade.reabrirAtividade("STD-0");
			fail();
		}catch (IllegalArgumentException e) {
			assertEquals("A tarefa já estava aberta!", e.getMessage());
		}
	}
	
	@Test
	void ReabrirAtividade2() {
		String[] habilidades1 = {"Java Basico", "Web"};
		this.facade.cadastrarPessoa("111.111.111-11", "Gabriel Dantas", habilidades1);
		this.facade.cadastrarAtividade("Estudar OO", "Estudar tudo relacionado a OO", "111.111.111-11");
		this.facade.encerrarAtividade("STD-0");
		this.facade.reabrirAtividade("STD-0");
	}
	
	//Testes sobre alterar descrição e responsável da atividade
	
	@Test
	void alterarDescricaoAtividade1() {
		String[] habilidades1 = {"Java Basico", "Web"};
		this.facade.cadastrarPessoa("111.111.111-11", "Gabriel Dantas", habilidades1);
		this.facade.cadastrarAtividade("Estudar OO", "Estudar tudo relacionado a OO", "111.111.111-11");
		this.facade.alterarDescricaoAtividade("STD-0", "Nova descrição");
	}
	
	@Test
	void alterarDescricaoAtividade2() {
		String[] habilidades1 = {"Java Basico", "Web"};
		this.facade.cadastrarPessoa("111.111.111-11", "Gabriel Dantas", habilidades1);
		this.facade.cadastrarAtividade("Estudar OO", "Estudar tudo relacionado a OO", "111.111.111-11");
		try {
			this.facade.alterarDescricaoAtividade("STD-0", "");
		}catch (IllegalArgumentException e) {
			assertEquals("O/A DESCRIÇÃO da atividade não pode ser vazio!", e.getMessage());
		}
	}
	
	@Test
	void alterarResponsavelAtividade1() {
		String[] habilidades1 = {"Java Basico", "Web"};
		this.facade.cadastrarPessoa("111.111.111-11", "Gabriel Dantas", habilidades1);
		this.facade.cadastrarPessoa("222.222.222-22", "Gabriel Diniz", habilidades1);
		this.facade.cadastrarAtividade("Estudar OO", "Estudar tudo relacionado a OO", "111.111.111-11");
		this.facade.alterarResponsavelAtividade("STD-0", "222.222.222-22");
	}
	
	// Testes sobre exibição de atividades
	
	@Test
	void ExibirAtividade1() {
		String[] habilidades1 = {"Java Basico", "Web"};
		this.facade.cadastrarPessoa("111.111.111-11", "Gabriel Dantas", habilidades1);
		this.facade.cadastrarAtividade("Estudar OO", "Estudar tudo relacionado a OO", "111.111.111-11");
		this.facade.cadastrarTarefa("STD-0", "Revisar Encapsulamento", habilidades1);
		this.facade.cadastrarTarefa("STD-0", "Estudar Herança", habilidades1);
		assertEquals("STD-0: Estudar OO\nResponsável: Gabriel Dantas - 111.111.111-11\n===\nEstudar tudo relacionado a OO\n===\nTarefas: 0/2\n- Estudar Herança - STD-0-1\n- Revisar Encapsulamento - STD-0-0\n", this.facade.exibirAtividade("STD-0"));
	}
	
	@Test
	void ExibirAtividade2() {
		String[] habilidades1 = {"Java Basico", "Web"};
		this.facade.cadastrarPessoa("111.111.111-11", "Gabriel Dantas", habilidades1);
		this.facade.cadastrarAtividade("Estudar OO", "Estudar tudo relacionado a OO", "111.111.111-11");
		this.facade.alterarResponsavelAtividade("STD-0", "");
		this.facade.cadastrarTarefa("STD-0", "a", habilidades1);
		this.facade.cadastrarTarefa("STD-0", "b", habilidades1);
		this.facade.cadastrarTarefa("STD-0", "c", habilidades1);
		this.facade.cadastrarTarefa("STD-0", "d", habilidades1);
		this.facade.concluirTarefa("STD-0-1");
		assertEquals("STD-0: Estudar OO\n===\nEstudar tudo relacionado a OO\n===\nTarefas: 1/4\n- d - STD-0-3\n- c - STD-0-2\n- a - STD-0-0\n", this.facade.exibirAtividade("STD-0"));
	}
	
	//Testes das classes relacionadas a atividades terminam aqui
	
	//Testes das classes relacionadas a tarefas começam aqui
	
	// Testes de cadastramento de tarefas
	
	@Test
	void cadastrarTarefa1() {
		String[] habilidades1 = {"Java Basico", "Web"};
		this.facade.cadastrarPessoa("111.111.111-11", "Gabriel Dantas", habilidades1);
		this.facade.cadastrarAtividade("Estudar OO", "Estudar tudo relacionado a OO", "111.111.111-11");
		this.facade.encerrarAtividade("STD-0");
		try {
			this.facade.cadastrarTarefa("STD-0", "Estudar Prova", habilidades1);
			fail();
		}catch (IllegalStateException e) {
			assertEquals("A atividade não está aberta!", e.getMessage());
		}
	}
	
	// Testes de alterar nome de tarefas
	
	@Test
	void alterarNomeTarefa1() {
		String[] habilidades1 = {"Java Basico", "Web"};
		this.facade.cadastrarPessoa("111.111.111-11", "Gabriel Dantas", habilidades1);
		this.facade.cadastrarAtividade("Estudar OO", "Estudar tudo relacionado a OO", "111.111.111-11");
		this.facade.cadastrarTarefa("STD-0", "Estudar Prova", habilidades1);
		this.facade.alterarNomeTarefa("STD-0-0", "Passei"); 
	}
	
	// Testes de alterar nome de tarefas
	
	@Test
	void alterarHabilidadesTarefa1() {
		String[] habilidades1 = {"Java Basico", "Web"};
		String[] habilidades2 = {"Resiliencia"};
		this.facade.cadastrarPessoa("111.111.111-11", "Gabriel Dantas", habilidades1);
		this.facade.cadastrarAtividade("Estudar OO", "Estudar tudo relacionado a OO", "111.111.111-11");
		this.facade.cadastrarTarefa("STD-0", "Estudar Prova", habilidades1);
		this.facade.alterarHabilidadesTarefa("STD-0-0", habilidades2);
	}
	
	// Testes de adicionar e remover horas Tarefa
	
	@Test
	void IncrementarHorasTarefa1() {
		String[] habilidades1 = {"Java Basico", "Web"};
		this.facade.cadastrarPessoa("111.111.111-11", "Gabriel Dantas", habilidades1);
		this.facade.cadastrarAtividade("Estudar OO", "Estudar tudo relacionado a OO", "111.111.111-11");
		this.facade.cadastrarTarefa("STD-0", "Estudar Prova", habilidades1);
		this.facade.adicionarHorasTarefa("STD-0-0", 8);
		this.facade.adicionarHorasTarefa("STD-0-0", 3);
	}
	
	@Test
	void RemoverHorasTarefa2() {
		String[] habilidades1 = {"Java Basico", "Web"};
		this.facade.cadastrarPessoa("111.111.111-11", "Gabriel Dantas", habilidades1);
		this.facade.cadastrarAtividade("Estudar OO", "Estudar tudo relacionado a OO", "111.111.111-11");
		this.facade.cadastrarTarefa("STD-0", "Estudar Prova", habilidades1);
		this.facade.adicionarHorasTarefa("STD-0-0", 8);
		this.facade.removerHorasTarefa("STD-0-0", 8);
	}
	
	@Test
	void RemoverHorasTarefa3() {
		String[] habilidades1 = {"Java Basico", "Web"};
		this.facade.cadastrarPessoa("111.111.111-11", "Gabriel Dantas", habilidades1);
		this.facade.cadastrarAtividade("Estudar OO", "Estudar tudo relacionado a OO", "111.111.111-11");
		this.facade.cadastrarTarefa("STD-0", "Estudar Prova", habilidades1);
		try {
			this.facade.removerHorasTarefa("STD-0-0", 8);
			fail();
		}catch (IllegalArgumentException e) {
			assertEquals("Ação inválida : O tempo passado não pode ser menor que o tempo total da atividade!", e.getMessage());
		}
	}
	
	// Testes de remover tarefa
	
	@Test
	void RemoverTarefa1() {
		String[] habilidades1 = {"Java Basico", "Web"};
		this.facade.cadastrarPessoa("111.111.111-11", "Gabriel Dantas", habilidades1);
		this.facade.cadastrarAtividade("Estudar OO", "Estudar tudo relacionado a OO", "111.111.111-11");
		this.facade.cadastrarTarefa("STD-0", "Estudar Prova", habilidades1);
		this.facade.removerTarefa("STD-0-0");
	}
	
	// Testes de concluir Tarefa
	
	@Test
	void concluirTarefa1() {
		String[] habilidades1 = {"Java Basico", "Web"};
		this.facade.cadastrarPessoa("111.111.111-11", "Gabriel Dantas", habilidades1);
		this.facade.cadastrarAtividade("Estudar OO", "Estudar tudo relacionado a OO", "111.111.111-11");
		this.facade.cadastrarTarefa("STD-0", "Estudar Prova", habilidades1);
		this.facade.concluirTarefa("STD-0-0");
		try {
			this.facade.concluirTarefa("STD-0-0");
			fail();
		}catch (IllegalStateException e) {
			assertEquals("A tarefa já estava concluida!", e.getMessage());
		}
	}
	
	// Testes associar e remover pessoas
	
	@Test
	void associarPessoaTarefa1() {
		String[] habilidades1 = {"Java Basico", "Web"};
		this.facade.cadastrarPessoa("111.111.111-11", "Gabriel Dantas", habilidades1);
		this.facade.cadastrarAtividade("Estudar OO", "Estudar tudo relacionado a OO", "111.111.111-11");
		this.facade.cadastrarTarefa("STD-0", "Estudar Prova", habilidades1);
		this.facade.associarPessoaTarefa("111.111.111-11", "STD-0-0");
		this.facade.removerPessoaTarefa("111.111.111-11", "STD-0-0");
	}
	
	// Testes exibir Tarefa
	
	@Test
	void exibirTarefa1() {
		String[] habilidades1 = {"Java Basico", "Web"};
		this.facade.cadastrarPessoa("111.111.111-11", "Gabriel Dantas", habilidades1);
		this.facade.cadastrarPessoa("222.222.222-22", "Pedro", habilidades1);
		this.facade.cadastrarAtividade("Estudar OO", "Estudar tudo relacionado a OO", "111.111.111-11");
		this.facade.cadastrarTarefa("STD-0", "Estudar Prova", habilidades1);
		this.facade.associarPessoaTarefa("111.111.111-11", "STD-0-0");
		this.facade.associarPessoaTarefa("222.222.222-22", "STD-0-0");
		this.facade.adicionarHorasTarefa("STD-0-0", 8);
		assertEquals("Estudar Prova - STD-0-0\n- Estudar OO\nJava Basico, Web\n(8 hora(s) executada(s))\n===\nEquipe:\nGabriel Dantas - 111.111.111-11\nPedro - 222.222.222-22\n", this.facade.exibirTarefa("STD-0-0"));
	}
	
	//Testes das classes relacionadas a tarefas terminam aqui
	
	//Testes das classes relacionadas à Buscas começam aqui
	
	// Testes de buscas de Pessoas
	@Test
	void BuscarPessoa1() {
		String[] habilidades1 = {"Java Basico", "Web"};
		this.facade.cadastrarPessoa("111.111.111-11", "Gabriel Dantas", habilidades1);
		this.facade.cadastrarPessoa("222.222.222-22", "Pedro", habilidades1);
		String[] pessoas = {"gabriel dantas","pedro"};
		assertTrue(Arrays.equals(pessoas, this.facade.exibirPessoas("Web")));
	}
	
	@Test
	void BuscarPessoa2() {
		String[] habilidades1 = {"Java Basico", "Web"};
		String[] habilidades2 = {"Java Basico", "Games"};
		this.facade.cadastrarPessoa("111.111.111-11", "Gabriel Dantas", habilidades1);
		this.facade.cadastrarPessoa("222.222.222-22", "Gabriel Diniz", habilidades2);
		String[] pessoas = {"gabriel dantas"};
		assertTrue(Arrays.equals(pessoas, this.facade.exibirPessoas("111.111.111-11")));
	}
	
	@Test
	void BuscarPessoa3() {
		String[] habilidades1 = {"a", "q", "w", "e"};
		String[] habilidades2 = {"e", "v", "b", "a"};
		String[] habilidades3 = {"i", "c", "a", "u"};
		String[] habilidades4 = {"o", "a", "x", "z"};
		this.facade.cadastrarPessoa("111.111.111-11", "Gabriel Dantas", habilidades1);
		this.facade.cadastrarPessoa("222.222.222-22", "Jose", habilidades2);
		this.facade.cadastrarPessoa("333.333.333-33", "Antonio", habilidades3);
		this.facade.cadastrarPessoa("444.444.444-44", "Anne", habilidades4);
		String[] pessoas = {"anne","antonio","gabriel dantas", "jose"};
		assertTrue(Arrays.equals(pessoas, this.facade.exibirPessoas("a")));
	}
	
	// Testes de buscas de Atividades
	
	@Test 
	void BuscaAtividade1() {
		String[] habilidades1 = {"Java Basico", "Web"};
		this.facade.cadastrarPessoa("111.111.111-11", "Gabriel Dantas", habilidades1);
		this.facade.cadastrarPessoa("222.222.222-22", "Pedro", habilidades1);
		this.facade.cadastrarPessoa("333.333.333-33", "Clarque", habilidades1);
		this.facade.cadastrarAtividade("Estudar OO", "Estudar tudo relacionado a OO", "111.111.111-11");
		this.facade.cadastrarAtividade("Lanchar bem", "Estudar tudo relacionado a OO", "111.111.111-11");
		String[] atividades = {"lnc-1","std-0"};
		assertTrue(Arrays.equals(atividades, this.facade.buscarAtividade("estudar")));
	}
	
	@Test 
	void BuscaAtividade2() {
		String[] habilidades1 = {"Java Basico", "Web"};
		this.facade.cadastrarPessoa("111.111.111-11", "Gabriel Dantas", habilidades1);
		this.facade.cadastrarAtividade("Estudar OO", "Estudar tudo relacionado a OO", "111.111.111-11");
		String[] atividades = {};
		assertTrue(Arrays.equals(atividades, this.facade.buscarAtividade("comer")));
	}
	
	@Test 
	void BuscaAtividade3() {
		String[] habilidades1 = {"Java Basico", "Web"};
		this.facade.cadastrarPessoa("111.111.111-11", "Gabriel Dantas", habilidades1);
		this.facade.cadastrarAtividade("Estudar OO", "Estudar tudo relacionado a OO", "111.111.111-11");
		this.facade.cadastrarAtividade("Estudar-p2", "Revisar e estudar OO", "111.111.111-11");
		String[] atividades = {"std-0","std-1"};
		assertTrue(Arrays.equals(atividades, this.facade.buscarAtividade("estudar")));
	}
	
	@Test 
	void BuscaAtividade4() {
		String[] habilidades1 = {"Java Basico", "Web"};
		this.facade.cadastrarPessoa("111.111.111-11", "Gabriel Dantas", habilidades1);
		this.facade.cadastrarAtividade("Estudar OO", "Estudar tudo relacionado a OO", "111.111.111-11");
		this.facade.cadastrarAtividade("Estudar-p2", "Revisar e estudar OO", "111.111.111-11");
		String[] atividades = {"std-1"};
		assertTrue(Arrays.equals(atividades, this.facade.buscarAtividade("std-1")));
	}
	
	// Testes de buscas de Tarefas
	
	@Test 
	void BuscaTarefa1() {
		String[] habilidades1 = {"Java Basico", "Web"};
		this.facade.cadastrarPessoa("111.111.111-11", "Gabriel Dantas", habilidades1);
		this.facade.cadastrarAtividade("Estudar OO", "Estudar tudo relacionado a OO", "111.111.111-11");
		this.facade.cadastrarTarefa("STD-0", "Comemorar", habilidades1);
		this.facade.cadastrarTarefa("STD-0", "Passei em FMCC", habilidades1);
		String[] atividades = {"STD-0-1","STD-0-0"};
		assertTrue(Arrays.equals(atividades, this.facade.buscarTarefas("STD-0")));
	}
	
	@Test 
	void BuscaTarefa2() {
		String[] habilidades1 = {"Java Basico", "Web"};
		this.facade.cadastrarPessoa("111.111.111-11", "Gabriel Dantas", habilidades1);
		this.facade.cadastrarAtividade("Estudar OO", "Estudar tudo relacionado a OO", "111.111.111-11");
		this.facade.cadastrarTarefa("STD-0", "Comemorar", habilidades1);
		this.facade.cadastrarTarefa("STD-0", "Passei em FMCC", habilidades1);
		String[] atividades = {};
		assertTrue(Arrays.equals(atividades, this.facade.buscarTarefas("STD-1")));
	}
	
	@Test 
	void BuscaTarefa3() {
		String[] habilidades1 = {"Java Basico", "Web"};
		this.facade.cadastrarPessoa("111.111.111-11", "Gabriel Dantas", habilidades1);
		this.facade.cadastrarAtividade("Estudar OO", "Estudar tudo relacionado a OO", "111.111.111-11");
		this.facade.cadastrarTarefa("STD-0", "Comemorar", habilidades1);
		this.facade.cadastrarTarefa("STD-0", "Passei em FMCC", habilidades1);
		String[] atividades = {"STD-0-1"};
		assertTrue(Arrays.deepEquals(atividades, this.facade.buscarTarefas("STD-0","1")));
	}
	
	// Testes de sugestões de tarefas 
	
	@Test
	void SugestoesTarefas1() {
		String[] habilidades1 = {"a", "b", "c", "d", "e"};
		String[] habilidades2 = {"a", "b", "c", "e"};
		String[] habilidades3 = {"a", "b", "e"};
		String[] habilidades4 = {"a", "b", "c", "d", "e"};
		this.facade.cadastrarPessoa("111.111.111-11", "Gabriel Dantas", habilidades1);
		this.facade.cadastrarAtividade("Estudar OO", "Estudar tudo relacionado a OO", "111.111.111-11");
		this.facade.cadastrarTarefa("STD-0", "um", habilidades2);
		this.facade.cadastrarTarefa("STD-0", "dois", habilidades3);
		this.facade.cadastrarTarefa("STD-0", "tres", habilidades4);
		String[] tarefas = {"STD-0-2","STD-0-0","STD-0-1"};
		assertTrue(Arrays.deepEquals(tarefas, this.facade.sugerirTarefas("111.111.111-11")));
	}
	
	@Test
	void SugestoesTarefas2() {
		String[] habilidades1 = {"a", "b", "c", "d", "e"};
		String[] habilidades2 = {"a", "b", "c", "e"};
		String[] habilidades3 = {"a", "b", "e", "c"};
		String[] habilidades4 = {"a", "b", "c", "d", "e"};
		this.facade.cadastrarPessoa("111.111.111-11", "Gabriel Dantas", habilidades1);
		this.facade.cadastrarAtividade("Estudar OO", "Estudar tudo relacionado a OO", "111.111.111-11");
		this.facade.cadastrarTarefa("STD-0", "um", habilidades2);
		this.facade.associarPessoaTarefa("111.111.111-11", "STD-0-0");
		this.facade.cadastrarTarefa("STD-0", "dois", habilidades3);
		this.facade.associarPessoaTarefa("111.111.111-11", "STD-0-1");
		this.facade.associarPessoaTarefa("111.111.111-11", "STD-0-1");
		this.facade.cadastrarTarefa("STD-0", "tres", habilidades4);
		String[] tarefas = {"STD-0-2","STD-0-1","STD-0-0"};
		assertTrue(Arrays.deepEquals(tarefas, this.facade.sugerirTarefas("111.111.111-11")));
	}
	
	// Testes do Historico de buscas Mais recentes
	
	@Test 
	void buscasRecentes1() {
		String[] habilidades1 = {"Java Basico", "Web"};
		this.facade.cadastrarPessoa("111.111.111-11", "Gabriel Dantas", habilidades1);
		this.facade.cadastrarAtividade("Estudar OO", "Estudar tudo relacionado a OO", "111.111.111-11");
		this.facade.cadastrarTarefa("STD-0", "Comemorar", habilidades1);
		this.facade.cadastrarTarefa("STD-0", "Passei em FMCC", habilidades1);
		this.facade.buscarTarefas("STD-0-1");
		try {
			this.facade.buscasMaisRecentes(-1);
			fail();
		}catch (IllegalArgumentException e) {
			assertEquals("Indice invalido!", e.getMessage());
		}
	}
	
	@Test 
	void buscasRecentes2() {
		String[] habilidades1 = {"Java Basico", "Web"};
		this.facade.cadastrarPessoa("111.111.111-11", "Gabriel Dantas", habilidades1);
		this.facade.cadastrarAtividade("Estudar OO", "Estudar tudo relacionado a OO", "111.111.111-11");
		this.facade.cadastrarTarefa("STD-0", "Comemorar", habilidades1);
		this.facade.cadastrarTarefa("STD-0", "Passei em FMCC", habilidades1);
		this.facade.buscarTarefas("STD-0-1");
		try {
			this.facade.buscasMaisRecentes(3);
			fail();
		}catch (IllegalArgumentException e) {
			assertEquals("Indice invalido!", e.getMessage());
		}
	}
	
	@Test 
	void buscasRecentes3() {
		String[] habilidades1 = {"Java Basico", "Web"};
		this.facade.cadastrarPessoa("111.111.111-11", "Gabriel Dantas", habilidades1);
		this.facade.cadastrarAtividade("Estudar OO", "Estudar tudo relacionado a OO", "111.111.111-11");
		this.facade.cadastrarTarefa("STD-0", "Comemorar", habilidades1);
		this.facade.cadastrarTarefa("STD-0", "Passei em FMCC", habilidades1);
		this.facade.buscarTarefas("STD-0-1");
		this.facade.exibirPessoas("111.111.111-11");
		this.facade.buscasMaisRecentes(2);
		String[] buscas = {"PESSOA","TAREFA"};
		assertTrue(Arrays.equals(buscas, this.facade.buscasMaisRecentes(2)));
	}
	
	@Test 
	void buscasRecentes4() {
		String[] habilidades1 = {"Java Basico", "Web"};
		this.facade.cadastrarPessoa("111.111.111-11", "Gabriel Dantas", habilidades1);
		this.facade.cadastrarAtividade("Estudar OO", "Estudar tudo relacionado a OO", "111.111.111-11");
		this.facade.cadastrarTarefa("STD-0", "Comemorar", habilidades1);
		this.facade.cadastrarTarefa("STD-0", "Passei em FMCC", habilidades1);
		this.facade.buscarTarefas("STD-0-1");
		this.facade.exibirPessoas("111.111.111-11");
		this.facade.buscasMaisRecentes(2);
		String[] buscas = {};
		assertTrue(Arrays.equals(buscas, this.facade.buscasMaisRecentes(0)));
	}
	
	@Test 
	void buscasRecentes5() {
		String[] habilidades1 = {"Java Basico", "Web"};
		this.facade.cadastrarPessoa("111.111.111-11", "Gabriel Dantas", habilidades1);
		this.facade.cadastrarAtividade("Estudar OO", "Estudar tudo relacionado a OO", "111.111.111-11");
		this.facade.cadastrarTarefa("STD-0", "Comemorar", habilidades1);
		this.facade.cadastrarTarefa("STD-0", "Passei em FMCC", habilidades1);
		this.facade.buscarTarefas("STD-0-1");
		this.facade.exibirPessoas("111.111.111-11");
		this.facade.buscarAtividade("STD");
		this.facade.buscasMaisRecentes(2);
		String[] buscas = {"ATIVIDADE","PESSOA","TAREFA"};
		assertTrue(Arrays.equals(buscas, this.facade.buscasMaisRecentes(3)));
	}
	
	// Testes do Historico de buscas por posição
	
		@Test 
		void historicoBuscas1() {
			String[] habilidades1 = {"Java Basico", "Web"};
			this.facade.cadastrarPessoa("111.111.111-11", "Gabriel Dantas", habilidades1);
			this.facade.cadastrarAtividade("Estudar OO", "Estudar tudo relacionado a OO", "111.111.111-11");
			this.facade.cadastrarTarefa("STD-0", "Comemorar", habilidades1);
			this.facade.cadastrarTarefa("STD-0", "Passei em FMCC", habilidades1);
			this.facade.buscarTarefas("STD-0-1");
			try {
				this.facade.exibirHistóricoBusca(0);
				fail();
			}catch (IllegalArgumentException e) {
				assertEquals("Indice não encontrado!", e.getMessage());
			}
		}
		
		@Test 
		void historicoBuscas2() {
			String[] habilidades1 = {"Java Basico", "Web"};
			this.facade.cadastrarPessoa("111.111.111-11", "Gabriel Dantas", habilidades1);
			this.facade.cadastrarAtividade("Estudar OO", "Estudar tudo relacionado a OO", "111.111.111-11");
			this.facade.cadastrarTarefa("STD-0", "Comemorar", habilidades1);
			this.facade.cadastrarTarefa("STD-0", "Passei em FMCC", habilidades1);
			this.facade.buscarTarefas("STD-0-1");
			try {
				this.facade.exibirHistóricoBusca(3);
				fail();
			}catch (IllegalArgumentException e) {
				assertEquals("Indice não encontrado!", e.getMessage());
			}
		}
		
		@Test 
		void historicoBuscas3() {
			String[] habilidades1 = {"Java Basico", "Web"};
			this.facade.cadastrarPessoa("111.111.111-11", "Gabriel Dantas", habilidades1);
			this.facade.cadastrarAtividade("Estudar OO", "Estudar tudo relacionado a OO", "111.111.111-11");
			this.facade.cadastrarTarefa("STD-0", "Comemorar", habilidades1);
			this.facade.cadastrarTarefa("STD-0", "Passei em FMCC", habilidades1);
			this.facade.buscarTarefas("STD-0-1");
			this.facade.exibirPessoas("111.111.111-11");
			this.facade.buscarAtividade("STD");
			this.facade.buscasMaisRecentes(2);
			String[] maisRecente = {"PESSOA","gabriel dantas"};
			assertTrue(Arrays.equals(maisRecente, this.facade.exibirHistóricoBusca(2)));
		}
		
		@Test 
		void historicoBuscas4() {
			String[] habilidades1 = {"Java Basico", "Web"};
			this.facade.cadastrarPessoa("111.111.111-11", "Gabriel Dantas", habilidades1);
			this.facade.cadastrarAtividade("Estudar OO", "Estudar tudo relacionado a OO", "111.111.111-11");
			this.facade.cadastrarTarefa("STD-0", "Comemorar", habilidades1);
			this.facade.cadastrarTarefa("STD-0", "Passei em FMCC", habilidades1);
			this.facade.buscarTarefas("comemorar");
			this.facade.exibirPessoas("111.111.111-11");
			this.facade.buscarAtividade("STD-0");
			String[] maisRecente = {"ATIVIDADE","std-0"};
			assertTrue(Arrays.equals(maisRecente, this.facade.exibirHistóricoBusca(1)));
		}
	
	//Testes das classes relacionadas à Buscas terminam aqui
		
	

}
