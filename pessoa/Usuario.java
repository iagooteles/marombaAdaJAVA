package br.edu.poo.marombaAda.pessoa;

import br.edu.poo.marombaAda.alimentacao.Dieta;

import java.util.ArrayList;

public class Usuario extends Pessoa {
    private String modalidade;
    private Dieta dieta;
    private Treino treino;

    public Usuario(String nome, short idade, double peso, double altura, String modalidade, Dieta dieta, Treino treino) {
        super(nome, idade, peso, altura);
        this.modalidade = modalidade;
        this.dieta = (dieta);
        this.treino = treino;

        if (dieta == null) {
            this.dieta = new Dieta(new ArrayList<>());
        }

        if (treino == null) {
            this.treino = new Treino(new ArrayList<>());
        }

    }

    public String getModalidade() {
        return modalidade;
    }

    public Dieta getDieta() {
        return dieta;
    }

    public Treino getTreino() {
        return treino;
    }

    @Override
    public void exibir() {
        super.exibir();
        System.out.println("Modalidade: " + modalidade);
        dieta.exibir();
        treino.exibir();
    }
}
