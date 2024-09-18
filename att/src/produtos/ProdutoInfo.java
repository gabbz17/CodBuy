package produtos;

import java.util.ArrayList;

public class ProdutoInfo {
    ArrayList<ProdutoInfo> info = new ArrayList<>();
    private String nome, tipo;
    private double valor;

    public ProdutoInfo(){}
    public ProdutoInfo(String tipo, String nome, double valor){
        this.tipo = tipo;
        this.nome = nome;
        this.valor = valor;
    }

    
    public String getTipo(){
        return tipo;
    }

    public String getNome(){
        return nome;
    }

    @Override
    public String toString() {
            return "ProdutoInfo = "+ "\n nome=" + nome + "\n tipo=" + tipo + "\n" + String.format("Valor= %.2f", valor);
    }
    public double getValor(){
        return valor;
    }

    public void infoProduto(ProdutoInfo produto){
        info.add(produto);
    }

    public void listarProdutos(){
        for (ProdutoInfo produtoInfo : info) {
            System.out.println(produtoInfo);
        }
    } 


    public void pegarProdutos(int n){
        System.out.println(info.get(n));
    } 
    
}
