import produtos.ProdutoInfo;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
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
        
        if (caso()) {
            menu();
        } else {
            while (!caso()) {
                caso();
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

        if (caso()) {
            sair();
        } else {
            while (!caso()) {
                caso();
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
        System.out.println("Nome: " + user.getNome());
        System.out.println("Data de nascimento: " + user.getAnoNasc());
        System.out.println("Número de telefone: " + user.getNumero());
        System.out.println("E-mail: " + user.getEmail());
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

    private static boolean caso(){
        
        try{
            entrada.nextLine();
            System.out.print("Nome e sobrenome: ");
            String nome = entrada.nextLine();
            System.out.print("Email: ");
            String email = entrada.nextLine();
            System.out.print("Número para contato: ");
            String numero = entrada.nextLine();
            System.out.print("Data de nascimento (dd/mm/aaaa): ");
            LocalDate ano = LocalDate.parse(entrada.nextLine(), DateTimeFormatter.ofPattern("dd/MM/yyyy"));
    
            if (nome.equals("") || email.equals("") || numero.equals("")) {
                System.out.println("Preencha os campos corretamente!");
                System.out.println("--------------------");
                return false;
            } else {
                cod.addUser(new UserData(nome, numero, email, ano));
                return true;
            }

        } catch(java.time.format.DateTimeParseException e) {
            System.out.println("Preencha os campos corretamente!");
            System.out.println("--------------------");
            return false;
        }

    }
}
