package br.edu.poo.marombaAda.alimentacao;

import java.util.ArrayList;
import java.util.List;

public class Dieta {
    private List<Refeicao> refeicoes;

    public Dieta(List<Refeicao> refeicoes) {
        this.refeicoes = refeicoes;
    }

    public void adicionarRefeicao(Refeicao refeicao) {
        if (refeicao != null) {
            this.refeicoes.add(refeicao);
        } else {
            System.out.println("Refeição não encontrada!");
        }
    }

    public boolean removerRefeicao(Refeicao refeicao) {
        if (this.refeicoes.remove(refeicao)) {
            System.out.println("Refeição removida!");
            return true;
        }
        System.out.println("Refeição não encontrada!");
        return false;
    }

    public List<Refeicao> listarRefeicoes() {
        return new ArrayList<>(this.refeicoes);
    }

    public void exibir() {
        System.out.println("Dieta: ");
        for (Refeicao refeicao : refeicoes) {
            refeicao.exibir();
        }
    }

}
