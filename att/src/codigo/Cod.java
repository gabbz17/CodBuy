package codigo;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Scanner;

import entities.UserData;
import produtos.ProdutoInfo;

public final class Cod {
    public Scanner entrada = new Scanner(System.in);
    ProdutoInfo pd = new ProdutoInfo();
    public ArrayList<ProdutoInfo> info = new ArrayList<>();
    public ArrayList<UserData> data = new ArrayList<>();
    public UserData user = new UserData();



    public void addInfo(ProdutoInfo produto){
        info.add(produto);
    }

    public void listarProdutos(){
        int c = 0;
        for (ProdutoInfo produtoInfo : info) {
            System.out.println("id: " + c++ + "\n" + produtoInfo + "\n");
        }
    }

    public void pegarProduto(int n){
        System.out.println(info.get(n));
    }

    public void addUser(UserData user){
        data.add(user);
    }

    public void alteracoesData(){
        System.out.println("Ultimas atualizações: ");
        for (UserData userData : data) {
            System.out.println(userData + "\n");
        }
    }    

    public int frete(String cep){

        if (cep.equals("41219600")) {
            System.out.println("Valor do frete: R$" + 15);
            return 15;
        } else if (cep.equals("48280000")) {
            System.out.println("Valor do frete: R$" + 20);
            return 20;
        }
        return 0;
    }


    public boolean caso(){
        
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
                UserData user = new UserData(nome, numero, email, ano);
                data.add(user);
                return true;
            }

        } catch(java.time.format.DateTimeParseException e) {
            System.out.println("Preencha os campos corretamente!");
            System.out.println("--------------------");
            return false;
        }
    }

    public void mostrarDados(){
        System.out.println(data.getLast());
    }
}
