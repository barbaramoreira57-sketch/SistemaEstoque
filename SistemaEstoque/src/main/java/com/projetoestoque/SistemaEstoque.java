package com.projetoestoque;
import java.util.Scanner;
public class SistemaEstoque {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ProdutoDAO dao = new ProdutoDAO();
        Conexao.criarTabela();
        int opcao = 0;
        do {
            System.out.println("\n==========================");
            System.out.println(" SISTEMA DE ESTOQUE");
            System.out.println("==========================");
            System.out.println("1 - Cadastrar produto");
            System.out.println("2 - Listar produtos");
            System.out.println("3 - Sair");
            System.out.print("Escolha uma opção: ");
            String entrada = scanner.nextLine();
            try {
                opcao = Integer.parseInt(entrada);
            } catch (NumberFormatException e) {
                System.out.println("Digite uma opção válida!");
                continue;
            }
            switch (opcao) {
                case 1:
                    System.out.print("Nome do produto: ");
                    String nome = scanner.nextLine();
                    try {
                        System.out.print("Preço: ");
                        double preco = Double.parseDouble(
                            scanner.nextLine().replace(",", ".")
                        );
                        System.out.print("Quantidade: ");
                        int quantidade = Integer.parseInt(
                            scanner.nextLine()
                        );
                        dao.cadastrarProduto(
                            nome, preco, quantidade
                        );
                    } catch (NumberFormatException e) {
                        System.out.println(
                            "Preço ou quantidade inválidos!"
                        );
                    }
                    break;
                case 2:
                    dao.listarProdutos();
                    break;
                case 3:
                    System.out.println(
                        "Encerrando o sistema. Até logo!"
                    );
                    break;
                default:
                    System.out.println("Opção inválida!");
            }
        } while (opcao != 3);
        scanner.close();
    }
}
