package br.edu.poo.marombaAda.alimentacao;

import java.util.ArrayList;
import java.util.List;

public class Refeicao {
    private String nome;
    private String horario;
    private String alimentos;

    public Refeicao(String nome, String horario, String alimentos) {
        this.nome = nome;
        this.horario = horario;
        this.alimentos = alimentos;
    }

    public String getNome() {
        return nome;
    }

    public void exibir() {
        System.out.println("Refeição: " + nome + " || Horário: " + horario + " || Alimentos: " + alimentos);
    }

}
