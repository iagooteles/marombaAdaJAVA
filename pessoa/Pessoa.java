package br.edu.poo.marombaAda.pessoa;

public class Pessoa {
    private String nome;
    private short idade;
    private double peso;
    private double altura;

    public Pessoa(String nome, short idade, double peso, double altura) {
        this.nome = nome;
        this.idade = idade;
        this.peso = peso;
        this.altura = altura;
    }

    public String getNome() {
        return nome;
    }

    public short getIdade() {
        return idade;
    }

    public double getAltura() {
        return altura;
    }

    public void exibir() {
        System.out.println("Nome: " + nome + ", Idade: " + idade + ", Peso: " + peso + ", Altura: " + altura);
    }
}
