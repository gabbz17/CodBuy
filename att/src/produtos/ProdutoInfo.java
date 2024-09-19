package produtos;


public abstract class ProdutoInfo {
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

    public double getValor(){
        return valor;
    }
    
    @Override
    public String toString() {
            return "Tipo: " + tipo + "\nNome: " + nome  + "\n" + String.format("Valor: %.2f", valor);
    }

}