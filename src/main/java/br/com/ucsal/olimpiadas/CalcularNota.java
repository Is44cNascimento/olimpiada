package br.com.ucsal.olimpiadas;


//Primeira alteração do App, criar a parte de calcular nota em outra classe.

public class CalcularNota {

    public static int calcularNota(Tentativa tentativa) {
        int acertos = 0;
        for (var r : tentativa.getRespostas()) {
            if (r.isCorreta())
                acertos++;
        }
        return acertos;
    }

}
