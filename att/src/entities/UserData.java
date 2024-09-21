package entities;

import java.time.LocalDate;

public class UserData {
    private String nome, numero, email;
    private LocalDate anoNasc;

    

    public UserData(){}

    public UserData(String nome, String numero, String email, LocalDate anoNasc) {
        this.nome = nome;
        this.numero = numero;
        this.email = email;
        this.anoNasc = anoNasc;
    }

    public String getNome() {
        return nome;
    }
    public String getNumero() {
        return numero;
    }
    public String getEmail() {
        return email;
    }
    public LocalDate getAnoNasc() {
        return anoNasc;
    }

    @Override
    public String toString() {
        return "Nome: " + nome + "\nNúmero: " + numero + "\nEmail: " + email + "\nData de nascimento: " + anoNasc;
    }

    
    
}