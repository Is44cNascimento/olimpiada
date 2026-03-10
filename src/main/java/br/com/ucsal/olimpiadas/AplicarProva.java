package br.com.ucsal.olimpiadas;

import java.util.Scanner;

import static br.com.ucsal.olimpiadas.Config.*;
import static br.com.ucsal.olimpiadas.CalcularNota.calcularNota;
import static br.com.ucsal.olimpiadas.Escolher.escolherProva;
import static br.com.ucsal.olimpiadas.Escolher.escolherParticipante;
import static br.com.ucsal.olimpiadas.Tabuleiro.imprimirTabuleiroFen;

public class AplicarProva {

    static void aplicarProva() {

        Scanner in = new Scanner(System.in);

        if (participantes.isEmpty()) {
            System.out.println("cadastre participantes primeiro");
            return;
        }
        if (provas.isEmpty()) {
            System.out.println("cadastre provas primeiro");
            return;
        }

        var participanteId = escolherParticipante();
        if (participanteId == null)
            return;

        var provaId = escolherProva();
        if (provaId == null)
            return;

        var questoesDaProva = questoes.stream().filter(q -> q.getProvaId() == provaId).toList();

        if (questoesDaProva.isEmpty()) {
            System.out.println("esta prova não possui questões cadastradas");
            return;
        }

        var tentativa = new Tentativa();
        tentativa.setId(proximaTentativaId++);
        tentativa.setParticipanteId(participanteId);
        tentativa.setProvaId(provaId);

        System.out.println("\n--- Início da Prova ---");

        for (var q : questoesDaProva) {
            System.out.println("\nQuestão #" + q.getId());
            System.out.println(q.getEnunciado());

            System.out.println("Posição inicial:");
            imprimirTabuleiroFen(q.getFenInicial());

            for (var alt : q.getAlternativas()) {
                System.out.println(alt);
            }

            System.out.print("Sua resposta (A–E): ");
            char marcada;
            try {
                marcada = Questao.normalizar(in.nextLine().trim().charAt(0));
            } catch (Exception e) {
                System.out.println("resposta inválida (marcando como errada)");
                marcada = 'X';
            }

            var r = new Resposta();
            r.setQuestaoId(q.getId());
            r.setAlternativaMarcada(marcada);
            r.setCorreta(q.isRespostaCorreta(marcada));

            tentativa.getRespostas().add(r);
        }

        tentativas.add(tentativa);

        int nota = calcularNota(tentativa);
        System.out.println("\n--- Fim da Prova ---");
        System.out.println("Nota (acertos): " + nota + " / " + tentativa.getRespostas().size());


    }


}
