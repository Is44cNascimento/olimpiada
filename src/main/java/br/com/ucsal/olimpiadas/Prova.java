package br.com.ucsal.olimpiadas;

import java.util.Scanner;

import static br.com.ucsal.olimpiadas.App.provas;
import static br.com.ucsal.olimpiadas.App.proximaProvaId;
import static java.lang.System.in;

public class Prova {

	private long id;
	private String titulo;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}


    static void cadastrarProva() {
        Scanner in = new Scanner(System.in);


        System.out.print("Título da prova: ");
        var titulo = in.nextLine();

        if (titulo == null || titulo.isBlank()) {
            System.out.println("título inválido");
            return;
        }

        var prova = new Prova();
        prova.setId(proximaProvaId++);
        prova.setTitulo(titulo);

        provas.add(prova);
        System.out.println("Prova criada: " + prova.getId());
    }


}
