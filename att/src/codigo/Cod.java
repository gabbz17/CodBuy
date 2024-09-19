package codigo;
import java.util.ArrayList;
import produtos.ProdutoInfo;
import java.util.Scanner;

public class Cod {
    public static ArrayList<ProdutoInfo> info = new ArrayList<>();
    public static Scanner entrada = new Scanner(System.in);
    public static ProdutoInfo produto = new ProdutoInfo();


    public static void menu(){
        System.out.println("-----Bem vindo-----");
        System.out.println("Digite \n1.Para começar \n2.Para parar");
        int c = entrada.nextInt();
        while (c != 2) {
            System.out.println("-------------------");
            System.out.print("Informe a categoria do produto: ");
            entrada.nextLine();
            String tipo = entrada.nextLine();
            System.out.print("Nome do produto: ");
            String nome = entrada.nextLine();
            System.out.print("Valor do produto: ");
            double valor = entrada.nextDouble();
            produto = new ProdutoInfo(tipo, nome, valor);
            info.add(produto);
            System.out.println(" ");
            System.out.println("Insira 1 para continuar: ");
            c = entrada.nextInt();
        }
        
    }

    public static void listagem(){
        int x = 0;
        for (ProdutoInfo produtoInfo : info) {
            System.out.println("id: " + x++  + "\n" +produtoInfo);
            System.out.println("-------------------");
        }
    }
}
