package codigo;

import java.util.ArrayList;
import entities.UserData;
import produtos.ProdutoInfo;

public class Cod {
    ProdutoInfo pd = new ProdutoInfo();
    public ArrayList<ProdutoInfo> info = new ArrayList<>();
    public ArrayList<UserData> data = new ArrayList<>();



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
}
