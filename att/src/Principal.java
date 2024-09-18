import java.util.Scanner;

import produtos.ProdutoInfo;

public class Principal {
    public static Scanner entrada = new Scanner(System.in);
    public static ProdutoInfo produtoInfo = new ProdutoInfo();

    public static void main(String[] args) {
        menu();
    }

    private static void menu() {
        int c;
        System.out.println("-----Bem vindo-----");
        do {
            System.out.print("Informe o tipo do produto: ");
            entrada.nextLine();
            String tipo = entrada.nextLine();
            System.out.print("Nome do produto: ");
            String nome = entrada.nextLine();
            System.out.print("Valor do produto: ");
            double valor = entrada.nextDouble();
            produtoInfo = new ProdutoInfo(tipo, nome, valor);
            System.out.println("Insira 1 para continuar: ");
            c = entrada.nextInt();
        } while (c != 2);
        
    produtoInfo.listarProdutos();

    }
}
