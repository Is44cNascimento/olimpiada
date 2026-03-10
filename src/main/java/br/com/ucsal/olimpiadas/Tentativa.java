package br.com.ucsal.olimpiadas;

import java.util.ArrayList;
import java.util.List;

import static br.com.ucsal.olimpiadas.Config.tentativas;
import static br.com.ucsal.olimpiadas.CalcularNota.calcularNota;

public class Tentativa {
	private long id;
	private long participanteId;
	private long provaId;

	private final List<Resposta> respostas = new ArrayList<>();

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public long getParticipanteId() {
		return participanteId;
	}

	public void setParticipanteId(long participanteId) {
		this.participanteId = participanteId;
	}

	public long getProvaId() {
		return provaId;
	}

	public void setProvaId(long provaId) {
		this.provaId = provaId;
	}

	public List<Resposta> getRespostas() {
		return respostas;
	}



    static void listarTentativas() {
        System.out.println("\n--- Tentativas ---");
        for (var t : tentativas) {
            System.out.printf("#%d | participante=%d | prova=%d | nota=%d/%d%n", t.getId(), t.getParticipanteId(),
                    t.getProvaId(), calcularNota(t), t.getRespostas().size());
        }
    }

}
