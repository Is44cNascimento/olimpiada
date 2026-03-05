package br.com.ucsal.olimpiadas;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static br.com.ucsal.olimpiadas.AplicarProva.aplicarProva;
import static br.com.ucsal.olimpiadas.CalcularNota.calcularNota;
import static br.com.ucsal.olimpiadas.Participante.cadastrarParticipante;
import static br.com.ucsal.olimpiadas.Prova.cadastrarProva;
import static br.com.ucsal.olimpiadas.Questao.cadastrarQuestao;
import static br.com.ucsal.olimpiadas.Seed.seed;
import static br.com.ucsal.olimpiadas.Tentativa.listarTentativas;

public class App {

	static long proximoParticipanteId = 1;
	static long proximaProvaId = 1;
	static long proximaQuestaoId = 1;
	static long proximaTentativaId = 1;

	static final List<Participante> participantes = new ArrayList<>();
	static final List<Prova> provas = new ArrayList<>();
	static final List<Questao> questoes = new ArrayList<>();
	static final List<Tentativa> tentativas = new ArrayList<>();

	private static final Scanner in = new Scanner(System.in);

	public static void main(String[] args) {
		seed();

        AplicarProva.aplicarProva();

        while (true) {
            System.out.println("\n=== OLIMPÍADA DE QUESTÕES (V1) ===");
            System.out.println("1) Cadastrar participante");
            System.out.println("2) Cadastrar prova");
            System.out.println("3) Cadastrar questão (A–E) em uma prova");
            System.out.println("4) Aplicar prova (selecionar participante + prova)");
            System.out.println("5) Listar tentativas (resumo)");
            System.out.println("0) Sair");
            System.out.print("> ");

            switch (in.nextLine()) {
                case "1" -> cadastrarParticipante();
                case "2" -> cadastrarProva();
                case "3" -> cadastrarQuestao();
                case "4" -> aplicarProva();
                case "5" -> listarTentativas();
                case "0" -> {
                    System.out.println("tchau");
                    return;
                }
                default -> System.out.println("opção inválida");
            }
        }
	}



	static void imprimirTabuleiroFen(String fen) {

		String parteTabuleiro = fen.split(" ")[0];
		String[] ranks = parteTabuleiro.split("/");

		System.out.println();
		System.out.println("    a b c d e f g h");
		System.out.println("   -----------------");

		for (int r = 0; r < 8; r++) {

			String rank = ranks[r];
			System.out.print((8 - r) + " | ");

			for (char c : rank.toCharArray()) {

				if (Character.isDigit(c)) {
					int vazios = c - '0';
					for (int i = 0; i < vazios; i++) {
						System.out.print(". ");
					}
				} else {
					System.out.print(c + " ");
				}
			}

			System.out.println("| " + (8 - r));
		}

		System.out.println("   -----------------");
		System.out.println("    a b c d e f g h");
		System.out.println();
	}

}