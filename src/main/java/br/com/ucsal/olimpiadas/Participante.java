package br.com.ucsal.olimpiadas;



import static br.com.ucsal.olimpiadas.Config.*;

public class Participante {
	private long id;
	private String nome;
	private String email;



	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

    static void cadastrarParticipante() {


        System.out.print("Nome: ");
        var nome = in.nextLine();

        System.out.print("Email (opcional): ");
        var email = in.nextLine();

        if (nome == null || nome.isBlank()) {
            System.out.println("nome inválido");
            return;
        }
        var p = new Participante();
        p.setId(proximoParticipanteId++);
        p.setNome(nome);
        p.setEmail(email);

        participantes.add(p);
        System.out.println("Participante cadastrado: " + p.getId());
    }

}
