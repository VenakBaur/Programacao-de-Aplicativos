package projeto2609;

import javax.swing.JOptionPane;

public class MetodoLeo {

    public static void main(String[] args) {

        String tituloLivro = "";
        String autorLivro = "";
        String numeroISBN = "";
        String anoPublicacao = "";
        String continuar = "sim";
        
        do {

        tituloLivro = JOptionPane.showInputDialog("Insira o titulo do livro");

        autorLivro = JOptionPane.showInputDialog("Insira o autor do livro");

        numeroISBN = JOptionPane.showInputDialog("Insira o numero ISBN");

        anoPublicacao = JOptionPane.showInputDialog("Insira o ano da publicação");
        
        continuar = JOptionPane.showInputDialog("Deseja inserir um novo cadastro?");
        
        } while (continuar.startsWith("s") == true);
        
    }

}
