package br.com.ucsal.olimpiadas;

import java.util.Arrays;


import static br.com.ucsal.olimpiadas.App.*;
import static br.com.ucsal.olimpiadas.Config.*;
import static br.com.ucsal.olimpiadas.Escolher.escolherProva;

public class Questao {

	private long id;
	private long provaId;

	private String enunciado;
	private String[] alternativas = new String[5];
	private char alternativaCorreta;

	private String fenInicial;

	public String getFenInicial() {
		return fenInicial;
	}

	public void setFenInicial(String fenInicial) {
		this.fenInicial = fenInicial;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public long getProvaId() {
		return provaId;
	}

	public void setProvaId(long provaId) {
		this.provaId = provaId;
	}

	public String getEnunciado() {
		return enunciado;
	}

	public void setEnunciado(String enunciado) {
		this.enunciado = enunciado;
	}


    static void cadastrarQuestao() {
        if (Config.provas.isEmpty()) {
            System.out.println("não há provas cadastradas");
            return;
        }



        var provaId = escolherProva();
        if (provaId == null)
            return;

        System.out.println("Enunciado:");
        var enunciado = in.nextLine();

        var alternativas = new String[5];
        for (int i = 0; i < 5; i++) {
            char letra = (char) ('A' + i);
            System.out.print("Alternativa " + letra + ": ");
            alternativas[i] = letra + ") " + in.nextLine();
        }

        System.out.print("Alternativa correta (A–E): ");
        char correta;
        try {
            correta = Questao.normalizar(in.nextLine().trim().charAt(0));
        } catch (Exception e) {
            System.out.println("alternativa inválida");
            return;
        }

        var q = new Questao();
        q.setId(proximaQuestaoId++);
        q.setProvaId(provaId);
        q.setEnunciado(enunciado);
        q.setAlternativas(alternativas);
        q.setAlternativaCorreta(correta);

        questoes.add(q);

        System.out.println("Questão cadastrada: " + q.getId() + " (na prova " + provaId + ")");
    }



    public String[] getAlternativas() {
		return alternativas;
	}

	public void setAlternativas(String[] alternativas) {
		if (alternativas == null || alternativas.length != 5) {
			throw new IllegalArgumentException("A questão deve possuir exatamente 5 alternativas.");
		}
		this.alternativas = Arrays.copyOf(alternativas, 5);
	}

	public char getAlternativaCorreta() {
		return alternativaCorreta;
	}

	public void setAlternativaCorreta(char alternativaCorreta) {
		this.alternativaCorreta = normalizar(alternativaCorreta);
	}

	public boolean isRespostaCorreta(char marcada) {
		return normalizar(marcada) == alternativaCorreta;
	}

	public static char normalizar(char c) {
		char up = Character.toUpperCase(c);
		if (up < 'A' || up > 'E') {
			throw new IllegalArgumentException("Alternativa deve estar entre A e E.");
		}
		return up;
	}



}
