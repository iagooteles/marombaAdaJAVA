package br.edu.poo.marombaAda.menu;

import br.edu.poo.marombaAda.alimentacao.Refeicao;
import br.edu.poo.marombaAda.pessoa.Usuario;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Menu {
    private static Scanner scanner = new Scanner(System.in);
    private static List<Usuario> usuarios = new ArrayList<>();

    public static void main(String[] args) {
        inicializarUsuarios();

        while (true) {
            System.out.println("_".repeat(40));
            mostrarMenu();
            int opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1:
                    adicionarUsuario();
                    break;
                case 2:
                    listarUsuarios();
                    break;
                case 3:
                    pesquisarTreino();
                    break;
                case 4:
                    pesquisarInformacoes();
                    break;
                case 5:
                    removerUsuario();
                    break;
                case 6:
                    adicionarTreino();
                    break;
                case 7:
                    removerTreino();
                    break;
                case 8:
                    adicionarRefeicao();
                    break;
                case 9:
                    removerRefeicao();
                    break;
                case 0:
                    System.out.println("Treine bem!");
                    scanner.close();
                    System.exit(0);
                    break;
                default:
                    System.out.println("Opção inválida! Tente novamente.");
            }
        }
    }

    private static void mostrarMenu() {
        System.out.println("\n--- Menu da marombaAda ---");
        System.out.println("1 - Adicionar Usuário");
        System.out.println("2 - Listar Usuários");
        System.out.println("3 - Pesquisar Treino");
        System.out.println("4 - Pesquisar Informações de usuário");
        System.out.println("5 - Remover Usuários");

        System.out.println("6 - Adicionar Treino");
        System.out.println("7 - Remover Treino");

        System.out.println("8 - Adicionar refeição");
        System.out.println("9 - Remover refeição");

        System.out.println("0 - Sair");
        System.out.print("Escolha uma opção: ");
    }

    private static void inicializarUsuarios() {
        usuarios.add(new Usuario("Iago", (short) 28, 78.5, 1.80, "Basquete", null, null));
        usuarios.add(new Usuario("Maria", (short) 30, 62.0, 1.65, "Natação", null, null));
        usuarios.add(new Usuario("Pedro", (short) 20, 80.0, 1.80, "CrossFit", null, null));
        usuarios.add(new Usuario("Ana", (short) 28, 55.0, 1.60, "Yoga", null, null));
        usuarios.add(new Usuario("Carlos", (short) 35, 90.0, 1.85, "Musculação", null, null));
        usuarios.add(new Usuario("Juliana", (short) 22, 50.0, 1.58, "Pilates", null, null));
        usuarios.add(new Usuario("Lucas", (short) 27, 70.0, 1.75, "Boxe", null, null));
        usuarios.add(new Usuario("Fernanda", (short) 31, 68.0, 1.70, "Corrida", null, null));
        usuarios.add(new Usuario("Ricardo", (short) 29, 85.0, 1.82, "Musculação", null, null));
    }

    private static void adicionarUsuario() {
        String nome;
        while (true) {
            System.out.print("Digite o nome do usuário: ");
            nome = scanner.nextLine();
            if (!nome.isEmpty()) break;
            System.out.println("Nome não pode ser vazio. Por favor, tente novamente.");
        }

        short idade;
        while (true) {
            System.out.print("Digite a idade do usuário: ");
            try {
                idade = Short.parseShort(scanner.nextLine());
                if (idade > 0) break;
                else System.out.println("A idade deve ser um número positivo. Por favor, tente novamente.");
            } catch (NumberFormatException e) {
                System.out.println("Entrada inválida. Por favor, insira um número válido para a idade.");
            }
        }

        double peso;
        while (true) {
            System.out.print("Digite o peso do usuário: ");
            try {
                peso = Double.parseDouble(scanner.nextLine());
                if (peso > 0) break;
                else System.out.println("O peso deve ser um número positivo. Por favor, tente novamente.");
            } catch (NumberFormatException e) {
                System.out.println("Entrada inválida. Por favor, insira um número válido para o peso.");
            }
        }

        double altura;
        while (true) {
            System.out.print("Digite a altura do usuário: ");
            try {
                altura = Double.parseDouble(scanner.nextLine());
                if (altura > 0) break;
                else System.out.println("A altura deve ser um número positivo. Por favor, tente novamente.");
            } catch (NumberFormatException e) {
                System.out.println("Entrada inválida. Por favor, insira um número válido para a altura.");
            }
        }

        String modalidade;
        while (true) {
            System.out.print("Digite a modalidade do usuário: ");
            modalidade = scanner.nextLine();
            if (!modalidade.isEmpty()) break;
            System.out.println("Modalidade não pode ser vazia. Por favor, tente novamente.");
        }

        Usuario usuario = new Usuario(nome, idade, peso, altura, modalidade, null, null);
        usuarios.add(usuario);
        System.out.println("Usuário adicionado com sucesso!");
    }

    private static void listarUsuarios() {
        if (usuarios.isEmpty()) {
            System.out.println("Nenhum usuário cadastrado.");
        } else {
            System.out.println("\n--- Lista de Usuários ---");
            for (Usuario usuario : usuarios) {
                System.out.println("_".repeat(40));
                usuario.exibir();
                System.out.println("_".repeat(40));
            }
        }
    }

    private static void pesquisarInformacoes() {
        System.out.print("Digite o nome do usuário para pesquisar seu treino: ");
        String nome = scanner.nextLine();
        Usuario usuarioEncontrado = null;

        for (Usuario usuario : usuarios) {
            if (usuario.getNome().equalsIgnoreCase(nome)) {
                usuarioEncontrado = usuario;
                break;
            }
        }
        if (usuarioEncontrado != null) {
            System.out.println("_".repeat(40));
            System.out.println("Usuário: " + usuarioEncontrado.getNome());
            System.out.println("Idade: " + usuarioEncontrado.getIdade());
            System.out.println("Altura: " + usuarioEncontrado.getAltura());
            System.out.println("Modalidade: " + usuarioEncontrado.getModalidade());
            usuarioEncontrado.getDieta().exibir();
            System.out.println("_".repeat(40));

        } else {
            System.out.println("Usuário não encontrado...");
        }
    }

    private static void pesquisarTreino() {
        System.out.print("Digite o nome do usuário para pesquisar seu treino: ");
        String nome = scanner.nextLine();
        Usuario usuarioEncontrado = null;

        for (Usuario usuario : usuarios) {
            if (usuario.getNome().equalsIgnoreCase(nome)) {
                usuarioEncontrado = usuario;
                break;
            }
        }
        if (usuarioEncontrado != null) {
            System.out.println("_".repeat(40));
            System.out.println("Usuário: " + usuarioEncontrado.getNome());
            System.out.println("Modalidade: " + usuarioEncontrado.getModalidade());
            usuarioEncontrado.getTreino().exibir();
            System.out.println("_".repeat(40));

        } else {
            System.out.println("Usuário não encontrado...");
        }
    }

    private static void removerUsuario() {
        System.out.print("Digite o nome do usuário a ser removido: ");
        String nome = scanner.nextLine();
        Usuario usuarioEncontrado = null;

        for (Usuario usuario : usuarios) {
            if (usuario.getNome().equalsIgnoreCase(nome)) {
                usuarioEncontrado = usuario;
                break;
            }
        }
        if (usuarioEncontrado != null) {
            usuarios.remove(usuarioEncontrado);
            System.out.println("Usuário removido com sucesso... (  que pena:/  ) ");
        } else {
            System.out.println("Usuário não encontrado. tente novamente!");
        }
    }

    private static void adicionarTreino() {
        System.out.print("Digite o nome do usuário para adicionar um treino: ");
        String nomeUsuario = scanner.nextLine();

        Usuario usuarioEncontrado = null;

        for (Usuario usuario : usuarios) {
            if (usuario.getNome().equalsIgnoreCase(nomeUsuario)) {
                usuarioEncontrado = usuario;
                break;
            }
        }

        if (usuarioEncontrado == null) {
            System.out.println("Usuário não encontrado. Por favor, verifique o nome e tente novamente.");
            return;
        }

        while (true) {
            System.out.print("Digite o nome do exercício (ou 'sair' para sair do programa): ");
            String nomeExercicio = scanner.nextLine();
            if (nomeExercicio.equalsIgnoreCase("sair")) break;

            usuarioEncontrado.getTreino().adicionarTreino(nomeExercicio);

            System.out.println("Exercício adicionado com sucesso.");
        }

        System.out.println("Treino adicionado ao usuário " + usuarioEncontrado.getNome() + " com sucesso!");
    }

    private static void removerTreino() {
        System.out.print("Digite o nome do usuário para remover um treino: ");
        String nomeUsuario = scanner.nextLine();

        Usuario usuarioEncontrado = null;

        for (Usuario usuario : usuarios) {
            if (usuario.getNome().equalsIgnoreCase(nomeUsuario)) {
                usuarioEncontrado = usuario;
                break;
            }
        }

        if (usuarioEncontrado == null) {
            System.out.println("Usuário não encontrado. Por favor, verifique o nome e tente novamente.");
            return;
        }

        System.out.println("Digite o nome do exercicio que deseja remover: ");
        String nomeTreino = scanner.nextLine();
        usuarioEncontrado.getTreino().removerTreino(nomeTreino);
        System.out.println("Treino removido com sucesso! (que pena)");
    }

    private static void adicionarRefeicao() {
        System.out.print("Digite o nome do usuário para adicionar uma refeição: ");
        String nomeUsuario = scanner.nextLine();

        Usuario usuarioEncontrado = null;

        for (Usuario usuario : usuarios) {
            if (usuario.getNome().equalsIgnoreCase(nomeUsuario)) {
                usuarioEncontrado = usuario;
                break;
            }
        }

        if (usuarioEncontrado == null) {
            System.out.println("Usuário não encontrado. Por favor, verifique o nome e tente novamente.");
            return;
        }

        System.out.print("Digite o nome da refeição: ");
        String nomeRefeicao = scanner.nextLine();

        System.out.print("Digite o horário da refeição: ");
        String horarioRefeicao = scanner.nextLine();

        System.out.print("Digite o nome dos Alimentos: ");
        String nomeAlimentos = scanner.nextLine();

        Refeicao novaRefeicao = new Refeicao(nomeRefeicao, horarioRefeicao, nomeAlimentos);
        usuarioEncontrado.getDieta().adicionarRefeicao(novaRefeicao);

        System.out.println("Refeição adicionada à dieta do usuário " + usuarioEncontrado.getNome() + " com sucesso!");
    }

    private static void removerRefeicao() {
        System.out.print("Digite o nome do usuário para remover uma refeição: ");
        String nomeUsuario = scanner.nextLine();

        Usuario usuarioEncontrado = null;

        for (Usuario usuario : usuarios) {
            if (usuario.getNome().equalsIgnoreCase(nomeUsuario)) {
                usuarioEncontrado = usuario;
                break;
            }
        }

        if (usuarioEncontrado == null) {
            System.out.println("Usuário não encontrado. Por favor, verifique o nome e tente novamente.");
            return;
        }

        if (usuarioEncontrado.getDieta() == null || usuarioEncontrado.getDieta().listarRefeicoes().isEmpty()) {
            System.out.println("O usuário " + usuarioEncontrado.getNome() + " não possui refeições para remover.");
            return;
        }

        System.out.print("Digite o nome do alimento da refeição a ser removida: ");
        String nomeAlimento = scanner.nextLine();

        Refeicao refeicaoParaRemover = null;
        for (Refeicao refeicao : usuarioEncontrado.getDieta().listarRefeicoes()) {
            if (refeicao.getNome().equalsIgnoreCase(nomeAlimento)) {
                refeicaoParaRemover = refeicao;
                break;
            }
        }

        if (refeicaoParaRemover == null) {
            System.out.println("Refeição com o nome " + nomeAlimento + " não encontrada na dieta do usuário " + usuarioEncontrado.getNome() + ".");
            return;
        }

        usuarioEncontrado.getDieta().removerRefeicao(refeicaoParaRemover);
    }

}
