package abstracao;

import javax.swing.JOptionPane;

public class Pessoa {

    //atributos
    String nome;
    int idade;
    boolean estaVivo;

    //construtores
    Pessoa() {
    }

    Pessoa(String nomePessoa, int idadePessoa) {
        this.nome = nomePessoa;
        this.idade = idadePessoa;
    }

    Pessoa(boolean vivoOuMorto) {
        this.estaVivo = vivoOuMorto;
    }

    Pessoa(boolean vivoMorto, int idadeDoIndividuo) {
        this.estaVivo = vivoMorto;
        this.idade = idadeDoIndividuo;
    }

    //metodos
    public void declararStatus(boolean statusVida) {
        this.estaVivo = statusVida;
        JOptionPane.showMessageDialog(null, "O " + this.nome + "Está: " + this.estaVivo);
    }

    //metodos
    public void cadastrar(String nomeUsuario, int idadeUsuario) {
        this.nome = nomeUsuario;
        this.idade = idadeUsuario;
        JOptionPane.showMessageDialog(null, "Nome: " + this.nome + "\nidade: " + this.idade);
    }

    //metodos
    public String realizarProvaDeVida(String nome, int idade, boolean estaVivo) {
        this.estaVivo = estaVivo;
        this.nome = nome;
        this.idade = idade;

        String vida;
        if (this.estaVivo == true) {
            vida = "Vivo";
        } else {
            vida = "Morto";
        }

        return "O " + this.nome + ""
                + "\ntem a idade de: " + this.idade + ""
                + "\ne está: " + vida;
    }

    //metodos
    public void toPrint() {
        JOptionPane.showMessageDialog(null, this.nome + ""
                + "\ntem a idade de " + this.idade + " "
                + "\ne seu status de vida é: " + this.estaVivo);
    }

    public static void main(String[] args) {
        //primeiro Objeto
        Pessoa ind1 = new Pessoa();
        ind1.estaVivo = true;
        ind1.idade = 16;
        ind1.nome = "Nicolas";
        ind1.toPrint();
        System.out.println(ind1.realizarProvaDeVida("Joana", 20, true));

        //segundo Objeto
        Pessoa ind2 = new Pessoa(true);

        //terceiro Objeto
        Pessoa ind3 = new Pessoa("Bruno", 20);

        //quarto Objeto
        Pessoa ind4 = new Pessoa(false, 80);

    }

}