package br.com.ucsal.olimpiadas;

import java.util.Scanner;

import static br.com.ucsal.olimpiadas.AplicarProva.aplicarProva;
import static br.com.ucsal.olimpiadas.Config.in;
import static br.com.ucsal.olimpiadas.Participante.cadastrarParticipante;
import static br.com.ucsal.olimpiadas.Prova.cadastrarProva;
import static br.com.ucsal.olimpiadas.Questao.cadastrarQuestao;
import static br.com.ucsal.olimpiadas.Seed.seed;
import static br.com.ucsal.olimpiadas.Tentativa.listarTentativas;

public class Menu {

    static void iniciar(){
        seed();



        while (true) {
            System.out.println("\n=== OLIMPÍADA DE QUESTÕES (V25) ===");
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

}
