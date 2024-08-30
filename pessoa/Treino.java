package br.edu.poo.marombaAda.pessoa;

import java.util.ArrayList;
import java.util.List;

public class Treino {
    private List<String> treino;

    public Treino(List<String> treino) {
        this.treino = treino;
    }

    public void adicionarTreino(String exercicio) {
        this.treino.add(exercicio);
        System.out.println("Exercício adicionado: " + treino);
    }

    public void removerTreino(String exercicio) {
        if (this.treino.remove(exercicio)) {
            System.out.println("Exercício removido! ");
            System.out.println("Seu treino agora é: " +  treino);
        } else {
            System.out.println("Exercício não encontrado!");
        }
    }

    public void exibir() {
        if (treino != null) {
            System.out.println("Treino: ");

            for (String treino : treino) {
                System.out.print(" - " + treino + " - ");
            }
            System.out.println();
        } else {
            System.out.println("O usuário ainda não possui treino registrado!");
        }
    }
}
