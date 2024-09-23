import produtos.ProdutoInfo;
import java.util.Scanner;
import codigo.Cod;
import entities.UserData;

public class Principal {
    public static ProdutoInfo pd = new ProdutoInfo();
    public static UserData user = new UserData();
    public static Cod cod = new Cod();
    public static Scanner entrada = new Scanner(System.in);

    public static void main(String[] args) {
        inicio();
    }

    private static void inicio() {
        System.out.println(" ");
        System.out.println("-----Bem vindo-----");
        System.out.println("Vamos inciar seu cadastro em nossa loja!");
        
        if (cod.caso()) {
            menu();
        } else {
            while (!cod.caso()) {
                cod.caso();
            }
            menu();
        } 
    }




    public static void menu() {

        System.out.println(" ");
        System.out.println("-----Bem vindo ao menu-----");
        System.out.println("O que deseja fazer? \n1.Comprar produtos \n2.Cadastrar produtos \n3.Visualizar perfil");
        int c = entrada.nextInt();
        switch (c) {
            case 1:
                compra();
                break;
            case 2:
                cadastro();
                break;
            case 3:
                perfil();
                break;
            default:
                break;
        }
    }

    private static void perfil() {
        System.out.println(" ");
        System.out.println("-----Bem vindo ao menu de perfil-----");
        System.out.println("Indique oque deseja fazer: \n1.Ver informações \n2.Atualizar perfil \n3.Ver histório de alterações");
        int c = entrada.nextInt();
        switch (c) {
            case 1:
                informacoes();
                break;
            case 2:
                modificar();
                break;
            case 3:
                historico();
                break;
        
            default:
                break;
        }
    }

    private static void modificar() {
        System.out.println(" ");
        System.out.println("--------------------");

        if (cod.caso()) {
            sair();
        } else {
            while (!cod.caso()) {
                cod.caso();
            }
            sair();
        } 
    }

    private static void historico() {
        System.out.println(" ");
        System.out.println("--------------------");
        cod.alteracoesData();
    }



    private static void informacoes() {
        System.out.println("--------------------");
        System.out.println(user.toString());
        perfil();
    }


    
    private static void cadastro() {
        System.out.println(" ");
        System.out.println("--------------------");
        System.out.println("Digite \n1.Para começar \n2.Para encerrar");
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

            cod.addInfo(new ProdutoInfo(tipo, nome, valor));
            System.out.println(" ");
            
            System.out.println("Insira 1 para continuar: ");
            c = entrada.nextInt();
        }
        sair();
    }

    private static void compra() {
        System.out.println(" ");
        System.out.println("---------------------");
        cod.listarProdutos();
        System.out.println("---------------------");
        System.out.print("Indique qual produto deseja comprar: ");
        cod.pegarProduto(entrada.nextInt());
        System.out.println("---------------------");
        System.out.print("Informe seu cep para calcular o frete: ");
        cod.frete(entrada.next());
    }




    


    public static void sair(){
        System.out.println(" ");
        System.out.println("---------------------");
        System.out.println("O que deseja fazer agora: \n1.Retornar ao menu \n2.Sair do programa");
        int c = entrada.nextInt();
        switch (c) {
            case 1:
            menu();
                break;
        
            default:
                break;
        }
    }

}
